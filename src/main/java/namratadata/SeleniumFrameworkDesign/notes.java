package namratadata.SeleniumFrameworkDesign;

public class notes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*✅ 3. Forgot to Use "Implement Methods" Shortcut
		In Eclipse:
		Right-click on the class name → Source → Override/Implement Methods*/
		/*✅ IRetryAnalyzer in TestNG — Full Explanation
		IRetryAnalyzer is an interface in TestNG that allows you to automatically retry failed tests a certain number of times.

		🔧 Why Use IRetryAnalyzer?
		Some tests fail due to temporary glitches — like:

		Slow network

		Timing issues

		Stale element exceptions

		You can use IRetryAnalyzer to rerun such failed tests automatically, reducing false negatives in your test report.
		Important: Thread Safety
		When using concurrency:

		Avoid shared WebDriver instances

		Make your tests thread-safe

		Use ThreadLocal<WebDriver> for parallel browser handling
*/
		/*
		 * 👨‍💻 In Java (General Concurrency) Java provides concurrency via:
		 * 
		 * Thread
		 * 
		 * ExecutorService
		 * 
		 * synchronized, volatile
		 * 
		 * Locks, Futures, CompletableFuture
		 * 
		 * If you're asking about concurrency in Java code (not just testing), I can
		 * show thread examples too.
		 * 
		 * 📌 Summary (TestNG concurrency): Feature Use parallel="methods" Run test
		 * methods in parallel thread-count Number of threads to run in parallel
		 * 
		 * @Test(threadPoolSize=...) Run multiple invocations in parallel
		 * ThreadLocal<WebDriver> Safe WebDriver for parallel Selenium
		 */
	}

}
