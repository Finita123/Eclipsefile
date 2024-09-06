package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	WebDriver driver;
	
	@FindBy(id="user-name")
	WebElement loginId;
	@FindBy(id="password")
	WebElement loginPwd;
	@FindBy(name="login-button")
	WebElement loginBtn;
	
	public Loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Passing values
	public void setValues(String un , String pwd)
	{
		loginId.clear();
		loginId.sendKeys(un);
		loginPwd.clear();
		loginPwd.sendKeys(pwd);
	}
	//Login using the credentials
	public void loginClick()
	{
		loginBtn.submit();
	}
}
