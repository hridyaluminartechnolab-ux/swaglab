package testpkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pagepkg.loginpage;


public class logintest {
	
	WebDriver driver;
	
	@BeforeTest
	public void Main()
	{
		driver=new ChromeDriver();
		driver.get("https://keralaproperty.in/member/login/");
	}

	@Test
	public void Fb()
	{
		loginpage ob = new loginpage(driver);
		ob.start("abc@gmail.com","1234");
		ob.login();
	}
}  