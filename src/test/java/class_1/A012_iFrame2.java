package class_1;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class A012_iFrame2 {
	
	WebDriver driver;
	
	
	By USERNAME_FIELD = By.xpath("//input[@id='user_name']");
	By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
	By LOGIN_BUTTON = By.xpath("//*[@id=\"login_submit\"]");
	By REALESTATE_BUTTON = By.xpath("//*[@id=\"ad_three\"]/a/img");
	By STUDENT_LOGIN_BUTTON = By.xpath("//*[@id=\"portal_three\"]/div");
	By GROUP_NAME_FIELD = By.xpath("//*[@id=\"customer_groupName\"]");
	
	@Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://codefios.com/ebilling/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void iFrame() {
		
		driver.findElement(USERNAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(LOGIN_BUTTON).click();
		Assert.assertEquals("Page not found!!!", "Codefios", driver.getTitle());
		driver.switchTo().frame("advertisement");
		driver.findElement(REALESTATE_BUTTON).click();
		driver.switchTo().frame("portals");
		driver.findElement(STUDENT_LOGIN_BUTTON).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("customer_groupaddframe");
		driver.findElement(GROUP_NAME_FIELD).sendKeys("Ayman Hussein");
		
		
		
	
		
	
		
		
	}
}
