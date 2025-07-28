package rahulshettyacademy.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import namratadata.SeleniumFrameworkDesign.ExtentExample;

public class Listeners extends BaseTest implements ITestListener {
	// ITestListener is a interface provide by testNG
	ExtentTest test;
	// it is created because we need to test variable in different method
	ExtentReports extent = ExtentExample.config();
	// for life of extent we need to declare class.method

	@Override
	public void onTestStart(ITestResult result) {
		// path = here we need to declare testname where we want to apply
		// result = So basically this variable holds the information about the test
		// which is going to get executed,
		// path = result.getMethod().getMethodName());

		test = extent.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// you can log in information like this.If it reaches this block you can tell,
		// hey status is pass by default.
		// Obviously it's shows us a pass until unless it fails.
		// And you can write any description like test is pass
		test.log(Status.PASS, "Test is pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//this method is use to want message why it's happen
		//it's gives the message why it's fails
		test.fail(result.getThrowable());
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		}
		 catch (Exception e) {
			e.printStackTrace();
		}
		String filePath = null;
		//after the fail we want to take Screenshot & Attach to Report
		try {
			filePath = getScreenShot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
		//before excepting path we need to take Screenshot//Screenshot code is written in BaseTest//that's why we need to extend baseTest//first argument, what it is expecting is//give the path where your screenshot is stored
		//Once that file path is taken, we are sending that to this method.So this method takes the path from your local system and attach to your extent report.
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		//this is excute after the test complete so here, we give the information to extent test is over and flush is important

	}
	

}
