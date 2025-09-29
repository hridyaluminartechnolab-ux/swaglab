package testpkg;

import org.testng.annotations.Test;

import basepkg.Base_class;
import pagepkg.Login_page;
import pagepkg.Product_page;

public class Product_test extends Base_class{
	
		
		@Test
		public void additemstocart() throws InterruptedException {
			Login_page log=new Login_page(driver);
			Product_page pdt=new Product_page(driver);
			log.setvalue("standard_user", "secret_sauce");
			log.login_button();
			pdt.additems();
		}

	}


