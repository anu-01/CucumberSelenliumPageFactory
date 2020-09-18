package pageObjects;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
 
public class HomePage {
 WebDriver driver;
 
 public HomePage(WebDriver driver) {
 this.driver = driver;
 PageFactory.initElements(driver, this);
 }
 
 public void perform_Search(String search) {
 driver.navigate().to("https://pul-ai-anu.azurewebsites.net/search?q=" + search);
 }
 
 public void navigateTo_HomePage() {
 driver.get("https://pul-ai-anu.azurewebsites.net/");
 }
 
 public void addsFirstItem() {
	 
 }
 
}