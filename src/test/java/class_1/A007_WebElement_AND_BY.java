package class_1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A007_WebElement_AND_BY {
	
	WebDriver driver;
	
	By USERNAME= By.xpath("//input[@id='user_name']");
	By PASSWORD= By.xpath("//input[@id='password']");
	By LOGINBUTTON= By.xpath("//button[@id='login_submit']");
	
	@Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://codefios.com/ebilling/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void Login() {
		
		driver.findElement(USERNAME).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD).sendKeys("abc123");
		driver.findElement(LOGINBUTTON).click();
	}

	
	@After
	public void teardown() {
		
		driver.close();
		driver.quit();
	}
}
