package namratadata.SeleniumFrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import namrataSingh.abstarctClass.AbstractCLass;

public class PaymentPage extends AbstractCLass {

	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (css = "input[placeholder='Select Country']")
	WebElement SelectCountry;
	
	@FindBy (xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement selectplace;
	@FindBy (css = ".btnn.action__submit")
	WebElement orderplace;
	@FindBy (css = ".hero-primary")
	WebElement text;
	By waitDropDown = By.cssSelector(".ta-results");
	By Scroll = By.cssSelector(".btnn.action__submit");
	
	public void selectCountry() throws InterruptedException {
		Actions a = new Actions(driver);
		a.sendKeys((SelectCountry),"india").build().perform();
		VisibilityOfElement(waitDropDown);
		selectplace.click();
		
	}
	public void placeOrder() throws InterruptedException {
		
		//Thread.sleep(2000);
		orderplace.click();
	}
	
	public String grabText() {
		String line = text.getText();
		return line;
	}

	
}
