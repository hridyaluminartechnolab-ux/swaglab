package testpkg;


import java.io.IOException;

import org.testng.annotations.Test;



import basepkg.Base_class;
import basepkg.Reporterclass;
import pagepkg.Login_page;
import utilitiespkg.Utilities;


public class Login_test extends Base_class {
	@Test
	public void set() throws InterruptedException, IOException
	{
	test=extent.createTest("login test");
	Login_page log=new Login_page(driver); 	
	String xl = "C:\\Users\\lumin\\OneDrive\\Desktop\\Selenium Automation\\demo.xlsx";
	String Sheet ="Sheet1";
	int rowCount = Utilities.getRowCount(xl,Sheet);
	System.out.println(rowCount);
	
	for (int i = 0; i <= rowCount; i++) //0<=4 i=1
	{
		int cellCount = Utilities.getCellCount(xl, Sheet, i);
		System.out.println("Cell Count: " + cellCount);
		for (int j = 0; j < cellCount; j += 2)//0<=2 j=0
		{
			String userName = Utilities.getCellValue(xl, Sheet, i, j); 
			System.out.println("UserName = " + userName);

			String pswd = Utilities.getCellValue(xl, Sheet, i, j + 1); 
			System.out.println("Password = " + pswd);


			log.setvalue(userName, pswd);
			log.login_button();
		
			Thread.sleep(1000);
			
			if(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) 
			{
				System.out.println("Logged in successfully");
				test.pass("pass");			
			}
			else
			{
				String path = Reporterclass.screenshotMethod(driver, "LoginSuccess_" + userName);
	            test.addScreenCaptureFromPath(path);
			
		Thread.sleep(2000);
		driver.get("https://www.saucedemo.com/");
        	test.fail("fail");
			}
		}
	}
}
}
