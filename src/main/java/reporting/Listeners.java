package reporting;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Listeners extends TestListenerAdapter

{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	
	
	public void onStart(ITestResult tr)
	{
		
	}

	public void onTestSuccess(ITestResult tr)
	{
		System.out.println("Test method passed");
	}

	public void onTestFailure(ITestResult tr)
	{
		System.out.println("Test method failed");
	}

	public void onTestSkipped(ITestResult tr)
	{
		System.out.println("Test method skipped");
	}
	
	
	
}
