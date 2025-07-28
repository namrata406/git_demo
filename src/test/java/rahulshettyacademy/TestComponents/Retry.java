package rahulshettyacademy.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	//it's use after test is fail 
	//this interface is use for how many times we want to rerun the test,so that we find actual error 
	int count = 0;
	int maxTry = 1;

	@Override
	//here boolean is true when it fail is complete the execution
	public boolean retry(ITestResult result) {
		if(count<maxTry) {
			count++;
		return true;
	}
		// TODO Auto-generated method stub
		return false;
	}
	

}
