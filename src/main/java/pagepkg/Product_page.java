package pagepkg;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_page {

		WebDriver driver;
		
		@FindBy(xpath="//button[text()=\"Add to cart\"]")
		List<WebElement>cartbutton;
		
		public Product_page(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
		
		public void additems() throws InterruptedException {
			for(WebElement items:cartbutton) {
				Thread.sleep(3000);
				items.click();
			}
		}
		

	}
