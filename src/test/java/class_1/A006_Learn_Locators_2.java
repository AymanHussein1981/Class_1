package class_1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A006_Learn_Locators_2 {
	
	WebDriver driver;
	
	@Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://objectspy.space/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void LearnLocators() {
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Ayman");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Hussein");
		driver.findElement(By.xpath("//input[@id='sex-0']")).click();
		driver.findElement(By.xpath("//input[@id='exp-4']")).click();
		driver.findElement(By.xpath("//input[@id='photo']")).sendKeys("C:\\TECHFIOS\\API\\API_Session_001.pdf");
		driver.findElement(By.xpath("//strong[text()='Link Test : New Page']")).click();
		
	}
	
	
	public void Teardown() {
		
	}

}
