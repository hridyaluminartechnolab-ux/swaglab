package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {
	//object repository and action methods
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='user-name']")
	WebElement username;
	
	@FindBy(id="password")
	WebElement pass;
	
	@FindBy(name="login-button")
	WebElement login;
	
	
	
	public Login_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	public void setvalue(String user,String pwd) throws InterruptedException {
		username.sendKeys(user);
		pass.sendKeys(pwd);
		
	}
	
	public void login_button() {
		login.click();
	}
	
	

}