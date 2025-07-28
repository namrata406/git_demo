package namratadata.SeleniumFrameworkDesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import namrataSingh.abstarctClass.AbstractCLass;

public class LandingPage extends AbstractCLass{
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "userEmail")
	WebElement email;
	@FindBy(id = "userPassword")
	WebElement password;
	@FindBy(id = "login")
	WebElement submit;
	@FindBy(css = ".toast-error")
	WebElement error;

	public void goToWebsite() {
		
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	}
	public ProductCatalogue loginWithinPage(String Email,String Password) {
		email.sendKeys(Email);
		password.sendKeys(Password);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;

	}
	//class="ng-tns-c4-43 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error"
	public String loginError() {
		VisibilityOfWebElement(error);		
		return error.getText();
		
	}


	

}
