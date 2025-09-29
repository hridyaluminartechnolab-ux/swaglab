package testpkg;

import org.testng.annotations.Test;

import basepkg.Base_class;
import pagepkg.Checkout_page;
import pagepkg.Login_page;
import pagepkg.Product_page;

public class Checkout_test extends Base_class {

		@Test
		public void iconclick() throws InterruptedException {
			Login_page log=new Login_page(driver);
			Product_page pdt=new Product_page(driver);
			Checkout_page checkout=new Checkout_page(driver);
			log.setvalue("standard_user", "secret_sauce");
			log.login_button();
			pdt.additems();
			checkout.cartclick();
		}
		
	}

