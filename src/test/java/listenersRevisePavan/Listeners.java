package listenersRevisePavan;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter {

	public void onTestStart(ITestResult tr)
	{
		System.out.println("method started");
	}
	public void onTestSuccess(ITestResult tr)
	{
		System.out.println("method passed");
	}

	public void onTestFailure(ITestResult tr)
	{System.out.println("method failed");

	}
	public void onTestSkipped(ITestResult tr)
	{
		System.out.println("method skipped");
	}
}
