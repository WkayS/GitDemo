package KSWOO.Tutorial25;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	ExtentReports extent;
	//Declares extent reports object in global level so it can be used across methods.

	@BeforeTest
	public void config()
	{
		//user.dir will direct to project directory
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Web Automation Results");
		// this will set the title of your automation extent report
		reporter.config().setDocumentTitle("Test Results");
		//this sets the title
		extent = new ExtentReports(); 
		//responsible to drive all reporting execution, create & consolidate test execution
		extent.attachReporter(reporter);
		//now the main class has the config
		extent.setSystemInfo("Tester", "KS");
		//test branch develop

	}
	
	
	@Test
	public void initateDriver()
	{
		ExtentTest test = extent.createTest("Test Case 1");
		//extent report will need this to initiate a listening mode to monitor if this particular testing is failed or pass to generate the extent report 
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println("Test Branch");
		extent.flush();
		//this will stop the listening of the extent report

	}


}
