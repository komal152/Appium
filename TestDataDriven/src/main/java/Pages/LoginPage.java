package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	    /**

	     * All WebElements are identified by @FindBy annotation

	     */

	    WebDriver driver;

	    @FindBy(name="username")
	    WebElement localWebUserName;

	    @FindBy(name="password")
	    WebElement localWebPassword;    

	    @FindBy(xpath="//h2[text()='Login Page']")
	    WebElement loginTitleTxt;

	    @FindBy(xpath="//*[text()=' Login']")
	    WebElement login;

	    public LoginPage(WebDriver driver){
	        this.driver = driver;
	        //This initElements method will create all WebElements
	        PageFactory.initElements(driver, this);

	    }

	    //Set user name in textbox
	    public void setUserName(String strUserName){
	    	localWebUserName.sendKeys(strUserName);     
	    }

	    //Set password in password textbox
	    public void setPassword(String strPassword){
	    	localWebPassword.sendKeys(strPassword);
	    }

	    //Click on login button
	    public void clickLogin(){
	            login.click();
	    }  

	    //Get the title of Login Page
	    public String getLoginTitle(){
	     return    loginTitleTxt.getText();
	    }

	    /**

	     * This POM method will be exposed in test case to login in the application
	     * @param strUserName
	     * @param strPasword
	     * @return
	     */

	    public void loginToWeb(String strUserName,String strPasword){
	        //Fill user name
	        this.setUserName(strUserName);
	        //Fill password
	        this.setPassword(strPasword);
	        //Click Login button
	        this.clickLogin();           
	    }
}
	


