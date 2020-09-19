package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;


public class POMTest {

	    String driverPath = "C:\\Users\\MauPatel\\Downloads\\chromedriver_win32\\chromedriver.exe";
	    WebDriver driver;
	    LoginPage objLogin;
        HomePage objHomePage; 

	    @BeforeTest
	    public void setup(){

	    	System.setProperty("webdriver.chrome.driver", driverPath);
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get("http://localhost:7080/login");

	    }


	    @Test(dataProvider="LoginCredentials")
	    public void test_Home_Page_Appear_Correct(Map<Object, Object> map){

	        //Create Login Page object
	    objLogin = new LoginPage(driver);

	    //Verify login page title
	    String loginPageTitle = objLogin.getLoginTitle();

	    //Assert.assertTrue(loginPageTitle.toLowerCase().contains("Login Page"));
	    Assert.assertTrue(loginPageTitle.contains("Login Page"));
	    //login to application
	    
	    String username = (String) map.get("UserName");
	    String password = (String) map.get("PassWord");

	    objLogin.loginToWeb(username, password);
	    
	    // go the next page
	    objHomePage = new HomePage(driver);
	    //Verify home page
	    //Assert.assertTrue(objHomePage.getHomePageDashboardTxt().toLowerCase().contains("Secure Area"));
	    Assert.assertTrue(objHomePage.getHomePageDashboardTxt().contains("Secure Area"));
	    }
	    
	    @AfterTest
	    public void tearDown() throws InterruptedException {
	    	Thread.sleep(2000);
	    	driver.quit();
	    }
	    
	    @DataProvider(name="LoginCredentials")
	    public Object[][] readExcel() throws IOException{
	    	String filePath = "C:\\Users\\MauPatel\\eclipse-workspace-301\\TestDataDriven\\TestData";
	    	String fileName = "TestData1.xlsx";
	    	String sheetName = "Sheet1";
	        //Create an object of File class to open xlsx file

	        File file =    new File(filePath+"\\"+fileName);

	        //Create an object of FileInputStream class to read excel file

	        FileInputStream inputStream = new FileInputStream(file);

	        Workbook Workbook101 = null;

	        //Find the file extension by splitting file name in substring  and getting only extension name

	        String fileExtensionName = fileName.substring(fileName.indexOf("."));

	        //Check condition if the file is xlsx file

	        if(fileExtensionName.equals(".xlsx")){

	        //If it is xlsx file then create object of XSSFWorkbook class

	        Workbook101 = new XSSFWorkbook(inputStream);

	        }

	        //Check condition if the file is xls file

	        else if(fileExtensionName.equals(".xls")){

	            //If it is xls file then create object of HSSFWorkbook class

	            Workbook101 = new HSSFWorkbook(inputStream);

	        }

	        //Read sheet inside the workbook by its name

	        Sheet Sheet101 = Workbook101.getSheet(sheetName);

	        //Find number of rows in excel file
	        
	        int lastRowNum = Sheet101.getLastRowNum() ;
	        int lastCellNum = Sheet101.getRow(0).getLastCellNum();
	        Object[][] obj = new Object[lastRowNum][1];

	        for (int i = 0; i < lastRowNum; i++) {
	          Map<Object, Object> datamap = new HashMap<>();
	          for (int j = 0; j < lastCellNum; j++) {
	            datamap.put(Sheet101.getRow(0).getCell(j).toString(), Sheet101.getRow(i+1).getCell(j).toString());
	          }
	          obj[i][0] = datamap;

	        }
	        return  obj;
	        }  
}
