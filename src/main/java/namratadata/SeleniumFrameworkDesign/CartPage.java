package namratadata.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import namrataSingh.abstarctClass.AbstractCLass;

public class CartPage extends AbstractCLass{
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css = ".cartSection h3")
	List<WebElement> cartProducts;
	
	public List<WebElement> itemsInCart() {
		
		return cartProducts;
	}
	
	public boolean matchOfProduct(String productName) throws InterruptedException {
		boolean match = itemsInCart().stream().anyMatch(s -> s.getText().equalsIgnoreCase(productName));
		return match;
		
	}
	public PaymentPage CheckOutButton(){
		By spinner = By.cssSelector("ngx-spinner"); 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));
		WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".totalRow button")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutButton);
		try {
		    checkoutButton.click();
		} catch (ElementClickInterceptedException e) {
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkoutButton);
		}
		PaymentPage payment = new PaymentPage(driver);
		return payment;

	}
		
}
