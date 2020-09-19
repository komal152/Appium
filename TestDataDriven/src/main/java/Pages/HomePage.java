package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
	    WebDriver driver;
	    
	    @FindBy(xpath="//h2[contains(text(),'Secure Area')]")
	    WebElement loggedIn;    

	    public HomePage(WebDriver driver){
	        this.driver = driver;
	        //This initElements method will create all WebElements
	        PageFactory.initElements(driver, this);

	    }   

	    //Get the User name from Home Page
	        public String getHomePageDashboardTxt(){
	         return    loggedIn.getText();

	        }
}
