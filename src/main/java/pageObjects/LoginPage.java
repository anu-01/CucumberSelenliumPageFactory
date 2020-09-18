
package pageObjects;
 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.support.FindBy;
 
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
 
public class LoginPage {
 
	 public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	 
 @FindBy(how = How.ID, using = "login-link")
 
 public WebElement lnk_Login;
 
 @FindBy(how = How.ID, using = "Email")
 
 public WebElement txtbx_UserName;
 
 @FindBy(how = How.ID, using = "Password")
 
 public WebElement txtbx_Password;
 
 @FindBy(how = How.XPATH, using = "//input[@value='Login'and @type='submit']")
 
 public WebElement btn_Login ;
 
 @FindBy(how = How.ID, using ="profile-link")
 
 public WebElement lnk_profile ;
 

public void Login(String email, String password) {
	lnk_Login.click();
	txtbx_UserName.sendKeys(email);
	txtbx_Password.sendKeys(password);
	btn_Login.click();
}
 
}