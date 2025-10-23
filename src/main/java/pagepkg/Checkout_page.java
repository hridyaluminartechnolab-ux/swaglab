package pagepkg;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_page {
	

		WebDriver driver;
		@FindBy(xpath="//div[@id='shopping_cart_container']")
		WebElement carticon;
		
		@FindBy(id="checkout")
		WebElement checkout;
		
		public Checkout_page(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		public void cartclick() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,500);");
			carticon.click();
			
			
			checkout.click();
		}
		
	}


