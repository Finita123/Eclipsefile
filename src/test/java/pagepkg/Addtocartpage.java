package pagepkg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Addtocartpage {

	WebDriver driver;
	
	@FindBy(xpath="//*[@class=\"btn btn_primary btn_small btn_inventory \"]")
	List<WebElement> resultCart;
	
	@FindBy(id="shopping_cart_container")
	WebElement cartBtn;
	
	@FindBy(id="checkout")
	WebElement checkoutBtn;
	
	public Addtocartpage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addToCart() throws InterruptedException
	{
		System.out.println("entered");
		if (resultCart.size() > 0) {
			int rsSize = resultCart.size();
			System.out.println(rsSize);
			System.out.println("entered1");
			
			for(WebElement cartElements:resultCart) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait.until(ExpectedConditions.visibilityOf(cartElements));
				cartElements.click();
				System.out.println("pppp");
			}

        } else {
            System.out.println("No products found");
            return;
        }
		 
	}
	
	public void checkoutCart() throws InterruptedException
	{
		 Thread.sleep(3000);
		 System.out.println("entered2");
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shopping_cart_container\"]/a"))).click();
		 checkoutBtn.click();
	}
}
