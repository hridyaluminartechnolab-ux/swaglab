package basepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;


public class Base_class {
	
	public static WebDriver driver;
	public String url="https://www.saucedemo.com/";
	
	@BeforeMethod
	public void browser_launch() {
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

}
}