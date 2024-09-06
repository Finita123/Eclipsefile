package pagepkg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Aftercheckoutpage {

	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"first-name\"]")
	WebElement fname;
	@FindBy(xpath="//*[@id=\"last-name\"]")
	WebElement lname;
	@FindBy(xpath="//*[@id=\"postal-code\"]")
	WebElement pCode;
	
	@FindBy(id="continue")
	WebElement contCheckout;
	
	@FindBy(xpath="//*[@id=\"finish\"]")
	WebElement finishCheckout;
	@FindBy(xpath="//*[@id=\"back-to-products\"]")
	WebElement backHome;
	@FindBy(xpath="//*[@id=\"react-burger-menu-btn\"]")
	WebElement hamburgerMenu;
	@FindBy(xpath="//*[@id=\"logout_sidebar_link\"]")
	WebElement logOutBtn;
	
	public Aftercheckoutpage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void continueCheckout(String frst, String last, String postCode) throws InterruptedException
	{
		fname.sendKeys(frst);
		lname.sendKeys(last);
		pCode.sendKeys(postCode);
		contCheckout.click();
	}
	
	public void finishCheckout()
	{
		finishCheckout.click();
	}
	
	public void backHome()
	{
		backHome.click();
	}
	
	public void logOut()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		hamburgerMenu.click();
		logOutBtn.click();
	}
}
