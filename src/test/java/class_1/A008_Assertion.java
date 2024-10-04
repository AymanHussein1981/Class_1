package class_1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class A008_Assertion {
	
	WebDriver driver;
	
	By USERNAME = By.xpath("//input[@id='user_name']");
	By PASSWORD = By.xpath("//input[@id='password']");
	By LOGINBUTTON = By.xpath("//button[@id='login_submit']");
	By HEADERTEXT = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/header/div/strong");
	
	
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
	public void loginplusAssertion() {
		
		driver.findElement(USERNAME).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD).sendKeys("abc123");
		driver.findElement(LOGINBUTTON).click();
		
		
		
	Assert.assertEquals("Page not Found!!!", "Codefios", driver.getTitle());
	//	Assert.assertEquals("Page not Found!!!", "Dashboard", driver.findElement(HEADERTEXT).getText());
		
		
		
		
	}
	
	
	@After
	public void Teardown() {
		driver.close();
	}

}
