package class_1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A003_Login_to_web_Site {

	
	@Test
	public void LoginToWebSite() {

		System.setProperty("webdriver.chrome.driver",
				".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://codefios.com/ebilling/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("demo@codefios.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[@id='login_submit']")).click();
		

	}

}
