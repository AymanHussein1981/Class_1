package class_1;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class A009_Drop_Down {
	
	// see video 03/31 part1 at 1:13:00 to 1:21:00 VERY IMPORTANT
	// see video 03/31 part1 at 1:13:00 to 1:21:00 VERY IMPORTANT
	// see video 03/31 part1 at 1:13:00 to 1:21:00 VERY IMPORTANT 
	// see video 03/31 part1 at 1:13:00 to 1:21:00 VERY IMPORTANT
	
	WebDriver driver;
	
	By USERNAME = By.xpath("//*[@id=\"user_name\"]");
	By PASSWORD = By.xpath("//*[@id=\"password\"]");
	By LOGINBUTTON = By.xpath("//*[@id=\"login_submit\"]");
	By CUSTOMERBUTTON = By.xpath("//span[text()='Customers']");
	By ADDCUSTOMER = By.xpath("//span[text()='Add Customer']");
	By CUSTOMER_NAME_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[1]/div/input");
	By COMPANY_NAME_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[2]/div/select");
	By EMAIL_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[3]/div/input");
	By PHONE_NUMBER_FIELD = By.xpath("//*[@id=\"phone\"]");
	By COUNTRY_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[8]/div[1]/select");
	By SAVE_BUTTON_FIELD = By.xpath("//*[@id=\"save_btn\"]");
	
	
	@Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://codefios.com/ebilling/login");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void dropdown() throws InterruptedException {
		
		driver.findElement(USERNAME).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD).sendKeys("abc123");
		driver.findElement(LOGINBUTTON).click();
		Assert.assertEquals("Page not found!!!", "Codefios", driver.getTitle());
		driver.findElement(CUSTOMERBUTTON).click();
		driver.findElement(ADDCUSTOMER).click();
		driver.findElement(CUSTOMER_NAME_FIELD).sendKeys("Travel One");
		Select sel = new Select(driver.findElement(COMPANY_NAME_FIELD));
		sel.selectByVisibleText("ACMcompany");
		driver.findElement(EMAIL_FIELD).sendKeys("travelone@gmail.com");
		driver.findElement(PHONE_NUMBER_FIELD).sendKeys("4696542145");
		Select sel2 = new Select (driver.findElement(COUNTRY_FIELD));
		sel2.selectByVisibleText("Canada");
		driver.findElement(SAVE_BUTTON_FIELD).click();
		Thread.sleep(5000);
	}
	
	
	//@After
	public void teardown() {
		driver.close();
		driver.quit();
	}

}
