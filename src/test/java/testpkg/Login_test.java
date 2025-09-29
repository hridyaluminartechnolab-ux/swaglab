package testpkg;


import org.testng.annotations.Test;

import basepkg.Base_class;
import pagepkg.Login_page;

public class Login_test extends Base_class {
	
	@Test
	public void set() throws InterruptedException
	{
	Login_page ob = new Login_page(driver);
	ob.setvalue("standard_user", "secret_sauce");
	ob.login_button();
	
	}

	
	

}