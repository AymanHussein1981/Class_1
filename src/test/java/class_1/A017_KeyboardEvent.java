package class_1;


import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class A017_KeyboardEvent {
	
	
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
	public void keyboard() throws InterruptedException {
		
		driver.findElement(USERNAME).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD).sendKeys("abc123");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
	
	}
}
