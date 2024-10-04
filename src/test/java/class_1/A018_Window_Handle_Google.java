package class_1;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class A018_Window_Handle_Google {
	
	
WebDriver driver;
	
	
	
	@Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void WindowHandle() {
		
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("selenium");
		Actions action = new Actions (driver);
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div/div/div/div/div/div[1]/div/span")).click();
		
	}
	

}
