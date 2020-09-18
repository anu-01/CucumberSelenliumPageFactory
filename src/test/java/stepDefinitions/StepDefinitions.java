package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductListingPage;

public class StepDefinitions {

	 WebDriver driver;
	 HomePage home;
	 LoginPage login;
	 ProductListingPage productListingPage;
	 CheckoutPage checkout;
	 
	 @Before
	 public void setup() {
		 System.getProperty("webdriver.chrome.driver", 
				 System.setProperty("webdriver.chrome.driver","bin/chromedriver.exe"));
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	 }
	 
	 @Given("user is on home page")
	 public void user_is_on_home_page() {		
		 driver.get("https://pul-ai-anu.azurewebsites.net/");
		 driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	 }

	 @When("I click on login link")
	 public void i_click_on_login_link() {
		 login = new LoginPage(driver);
		 login.lnk_Login.click();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 }
	 @When("I enter username {string}")
	 public void i_enter_username(String email) {
		 login = new LoginPage(driver);
		 login.txtbx_UserName.sendKeys(email);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 }
	 @When("I enter password {string}")
	 public void i_enter_password(String password) {
		 login = new LoginPage(driver);
		 login.txtbx_Password.sendKeys(password);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 }
	 @When("I click on login button")
	 public void i_click_on_login_button() {
		 login = new LoginPage(driver);
		 login.btn_Login.click();
		 driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	 }
	 @Then("I verify the login is successful")
	 public void i_verify_the_login_is_successful() {
		 login = new LoginPage(driver);
		 assert(login.lnk_profile.isEnabled());
	 }
	 
	 @When("user search for {string}")
	 public void user_search_for(String product) {
	     home = new HomePage(driver);
	     home.perform_Search(product);
	 }
	 
	 @Given("I login using email {string} and password {string}")
	 public void i_login_using_email_and_password(String email, String password) {
	     login = new LoginPage(driver);
	     login.Login(email, password);
	 }
	 
	 @When("chose to buy the first item")
	 public void chose_to_buy_the_first_item() {
		    productListingPage = new ProductListingPage(driver);
			productListingPage.select_Product(0);
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			productListingPage.clickOn_AddToCart();	
	 }
	
	 @When("continues to checkout")
	 public void continues_to_checkout() {
		 checkout = new CheckoutPage(driver);
		 checkout.lnk_checkout.click();
		 driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	 }
	 
	 @When("enter personal details on checkout page")
	 public void enter_personal_details_on_checkout_page() {
		 checkout = new CheckoutPage(driver);
		 checkout.fill_PersonalDetails();
	 }
	 
	 @When("submits the order")
	 public void submits_the_order() {
		 checkout = new CheckoutPage(driver);
		 checkout.submitOrder();
		 }
	 
	 @Then("verify the order is placed")
	 public void verify_the_order_is_placed() {
		 checkout = new CheckoutPage(driver);
		 assert(checkout.section_CompletePage.isDisplayed());
	 }
	 
	 @After
	    public void cleanUp() {		 
	            driver.close();
	            driver.quit();
	 }
}
