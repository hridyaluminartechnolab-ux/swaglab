package basepkg;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporterclass {
	
	public static WebDriver driver;
	public static ExtentSparkReporter reporter;//set path and configuration
	public static ExtentReports extent;//generate report
	public  static ExtentTest test;//log prepare
	
	@BeforeTest
	public static ExtentReports sam()
	{
		reporter=new ExtentSparkReporter("C:\\Users\\lumin\\OneDrive\\Desktop\\my projects\\Swaglabs\\Reports\\swaglabreport.html");//set path
		reporter.config().setDocumentTitle("Automation report");
		reporter.config().setReportName("Functional test");
		reporter.config().setTheme(Theme.DARK);
		
	    extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("hostname","localhost");
		extent.setSystemInfo("os","windows11");
		extent.setSystemInfo("tester name","hridya");
		extent.setSystemInfo("browsername","chrome");
		driver=new ChromeDriver();
		return extent;

	}
	
	@AfterMethod
	public void brrowserclose(ITestResult result) throws IOException //interface that represents the result of a test method execution
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "test case failed is "+result.getName());
			test.log(Status.FAIL, "test case failed is"+result.getThrowable());
			
			//  String screenshotpath = screenshotMethod(driver, result.getName());
		        //test.addScreenCaptureFromPath(screenshotpath);
		   }

		    else if (result.getStatus() == ITestResult.SKIP) {
		        test.log(Status.SKIP, "test case skipped is " + result.getName());
		    }

		    else if (result.getStatus() == ITestResult.SUCCESS) {
		        test.log(Status.PASS, "test case Passed is " + result.getName());
		    }
		}

		public static String screenshotMethod(WebDriver driver, String screenshotname) throws IOException {
			
		    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		    String destination = "C:\\Users\\lumin\\OneDrive\\Desktop\\my projects\\Swaglabs\\Reports\\" + screenshotname + ".png";
		    FileHandler.copy(src, new File(destination));

		    return destination;
		
		}

	
	
	
		}


