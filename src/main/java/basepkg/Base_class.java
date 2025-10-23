package basepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Base_class {
	public static ExtentReports extent;//generate report
	public static ExtentTest test;
	public static WebDriver driver;
	public String url="https://www.saucedemo.com/";
	
	@BeforeTest
	public void browser_launch() {
		extent=Reporterclass.sam();
		
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

}
	@AfterTest
	public void teardown()
	{
		extent.flush();
	}
}