package tempPack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class testabc101 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		testabc101 ob = new testabc101();
		ob.readExcel("C:\\Users\\MauPatel\\eclipse-workspace-301\\TestDataDriven","Book1.xlsx","Sheet1");
		
	}
	
	 public void readExcel(String filePath,String fileName,String sheetName) throws IOException{

		 HashMap<String, String> testHashMap1 = new HashMap<String, String>();
	        //Create an object of File class to open xlsx file

	        File file =    new File(filePath+"\\"+fileName);

	        //Create an object of FileInputStream class to read excel file

	        FileInputStream inputStream = new FileInputStream(file);

	        Workbook guru99Workbook = null;

	        //Find the file extension by splitting file name in substring  and getting only extension name

	        String fileExtensionName = fileName.substring(fileName.indexOf("."));

	        //Check condition if the file is xlsx file

	        if(fileExtensionName.equals(".xlsx")){

	        //If it is xlsx file then create object of XSSFWorkbook class

	        guru99Workbook = new XSSFWorkbook(inputStream);

	        }

	        //Check condition if the file is xls file

	        else if(fileExtensionName.equals(".xls")){

	            //If it is xls file then create object of HSSFWorkbook class

	            guru99Workbook = new HSSFWorkbook(inputStream);

	        }

	        //Read sheet inside the workbook by its name

	        Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);

	        //Find number of rows in excel file

	        int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();

	        //Create a loop over all the rows of excel file to read it
        	
	        for (int i = 0; i < rowCount+1; i++) {

	            Row row = guru99Sheet.getRow(i);
	         	String key1 = row.getCell(0).getStringCellValue();
	            String value1 = row.getCell(1).getStringCellValue();
	            //Create a loop to print cell values in a row

	           // for (int j = 0; j < row.getLastCellNum(); j++) {

	           
	                //Print Excel data in console
	                //System.out.print(row.getCell(j).getStringCellValue()+"|| ");

	            //}
	            
            	testHashMap1.put(key1, value1);
                 }
			//System.out.println(testHashMap1);
			System.out.println(testHashMap1.get("username"));
			System.out.println(testHashMap1.get("password"));
		}  

}
