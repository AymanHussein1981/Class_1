package class_1;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class A013_Mouse_Hover {
	
	WebDriver driver;
	
	
	@Before
	public void Setup() {
		
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.dell.com/en-us");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void MouseHover() {
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"unified-masthead-navigation\"]/nav/ul/li[3]/button"))).build().perform();
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"unified-masthead-navigation\"]/nav/ul/li[3]/ul/li[8]/button"))).build().perform();
		driver.findElement(By.xpath("//*[@id=\"unified-masthead-navigation\"]/nav/ul/li[3]/ul/li[8]/ul/li[3]/a")).click();
		
		
	}

}
