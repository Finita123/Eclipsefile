package testpkg;

import java.time.Duration;

import org.testng.annotations.Test;

import basepkg.Baseclasswebdriver;
import pagepkg.Addtocartpage;
import pagepkg.Aftercheckoutpage;
import pagepkg.Loginpage;
import utilitiespkg.Excelutility;

public class Testlogin extends Baseclasswebdriver{
	
	@Test(priority = 1)
	public void loginUsingCredentials()
	{
		Loginpage lp = new Loginpage(driver);
		
		String xl = "C:\\Users\\LENOVO\\Documents\\Finita_Docs\\Luminar\\datadriven\\datasample.xlsx";
		String sheet = "Saucelogin";
		
		int rowCount = Excelutility.getRowCount(xl, sheet);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		for(int i = 1; i<=rowCount; i++)
		{
			String userName = Excelutility.getCellValue(xl, sheet, i, 0);
			System.out.println("Username = "+ userName);
			String passWord = Excelutility.getCellValue(xl, sheet, i, 1);
			System.out.println("Password = "+ passWord);
			lp.setValues(userName, passWord);
			lp.loginClick();
			driver.navigate().refresh();
		}
	}
	
	@Test(priority = 2)
	public void resultToCart() throws InterruptedException
	{
		Addtocartpage acp = new Addtocartpage(driver);
		acp.addToCart();
	}
	
	@Test(priority = 3)
	public void checkOut() throws InterruptedException
	{
		Addtocartpage acp1 = new Addtocartpage(driver);
		acp1.checkoutCart();
	}
	
	@Test(priority = 4)
	public void completeCheckout() throws InterruptedException
	{
		Aftercheckoutpage checkout = new Aftercheckoutpage(driver);
		checkout.continueCheckout("Finita", "Joe", "678");
		checkout.finishCheckout();
		checkout.backHome();
		checkout.logOut();
	}
}
