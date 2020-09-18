package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import static io.github.seleniumquery.SeleniumQuery.$;

public class CheckoutPage {

	public CheckoutPage(WebDriver driver) {
	     PageFactory.initElements(driver, this);
	 }
	
	 @FindBy(how = How.CSS, using = "a[class$='checkout']")
	public WebElement lnk_checkout;
	 
	 @FindBy(how = How.ID, using = "Name") 
	 private WebElement txtbx_Name;
	 	 	 
	 @FindBy(how = How.ID, using = "Phone") 
	 private WebElement txtbx_Phone;
	 
	 @FindBy(how = How.ID, using = "Address") 
	 private WebElement txtbx_Address;
	 
	 @FindBy(how = How.ID, using = "City") 
	 private WebElement txtbx_City;
	 
	 @FindBy(how = How.ID, using = "State") 
	 private WebElement txtbx_State;
	 
	 @FindBy(how = How.ID, using = "PostalCode") 
	 private WebElement txtbx_PostalCode;	
	 
	 @FindBy(how = How.ID, using = "Country") 
	 private WebElement txtbx_Country;
	 
	 @FindBy(how = How.ID, using = "PromoCode") 
	 private WebElement txtbx_PromoCode;
	 
	 @FindBy(how = How.XPATH, using = "//input[@value='Submit Order']") 
	 private WebElement btn_SubmitOrder;
	 
	 @FindBy(how = How.ID, using = "complete-page") 
	 public WebElement section_CompletePage;	 
	 
	 
	 public void enterText(WebElement element, String name) {
		 element.sendKeys(name);
		 }

	 
	 public void fill_PersonalDetails() {
		 enterText(txtbx_Name, "Automation");
		 enterText(txtbx_Phone, "9765563621");
		 enterText(txtbx_Address, "Western Avenue");
		 enterText(txtbx_City, "Chennai");
		 enterText(txtbx_State, "Tamil Nadu");
		 enterText(txtbx_PostalCode, "500100");
		 enterText(txtbx_Country, "India");
		 enterText(txtbx_PromoCode, "FREE");		 
		 }
	 
	 public void submitOrder() {
		 // jQuery for element selectors
		// $(".input").click();
		// $(":submit").click();
		 btn_SubmitOrder.click(); 
	 }
	 
}
