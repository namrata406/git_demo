package namratadata.SeleniumFrameworkDesign;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import namrataSingh.abstarctClass.AbstractCLass;

public class ProductCatalogue extends AbstractCLass {
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	@FindBy (xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartLogo;
	By addCart = By.cssSelector(".card-body button:last-of-type");
	By FindBy = By.cssSelector("div[aria-label='Product Added To Cart']");

	public List<WebElement> getListOfpage() {
		return products;
	}

	public WebElement getProductName(String ProductName) {
		WebElement prod = getListOfpage().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst()
				.orElse(null);
		return prod;
	}

	public void addToCart(String ProductName) throws InterruptedException {

		getProductName(ProductName).findElement(addCart).click();
		VisibilityOfElement(FindBy);
		waitForElementToDisappear();

	}
	public CartPage gotoCartPage() {
		cartLogo.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;


	}

}
