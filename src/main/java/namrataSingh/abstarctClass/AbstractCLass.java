package namrataSingh.abstarctClass;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractCLass {
	WebDriver driver;
	public AbstractCLass (WebDriver driver) {
		this.driver = driver;
	}
	public void VisibilityOfElement(By FindBy) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(FindBy));

	}
	public void VisibilityOfWebElement(WebElement FindBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions
				.visibilityOf(FindBy));

		}


	public void waitForElementToDisappear() throws InterruptedException {
		Thread.sleep(1000);
	}
	public void waitPlusScroll(By FindBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(FindBy));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
		button.click();

	}

}
