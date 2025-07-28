package namratadata.SeleniumFrameworkDesign;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentExample {
	ExtentReports extent;
	//create Local Variable 

	@BeforeTest
	public static ExtentReports config() {
		//ExtentReports,ExtentSparkReporter
		//here we declearing static the method because we want to access method without even declaring object of this class
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path); 
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test result");
		
		ExtentReports extent = new ExtentReports();
		//here doesn't need to define class if we define here it gives error this.ExtentReports is NULL
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Rahul Shetty");
		return extent;
		}
	
		/*
		 * @Test public void ExtentClass(){ 
		 * extent.createTest("ExtentClass"); 
		 *here we need to define variable because extent have no no life without declaration local variable
		 * WebDriver driver = new ChromeDriver();
		 *  
		 * driver.get("https://rahulshettyacademy.com/");
		 * System.out.println(driver.getTitle()); 
		 * extent.flush(); }
		 */

}
