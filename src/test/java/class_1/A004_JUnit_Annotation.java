package class_1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A004_JUnit_Annotation {
	
	WebDriver driver;
	
	@Before
	public void Setup() {
		
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://codefios.com/ebilling/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void Login() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("demo@codefios.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[@id='login_submit']")).click();
		Thread.sleep(5000);
	}
	
	@After
	public void Teardown() {
		driver.close();
		driver.quit();
	}

}
