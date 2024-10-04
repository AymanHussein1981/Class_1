package class_1;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A005_Learn_Locators {

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://objectspy.space/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void testLocators() {

		

		driver.findElement(By.name("firstname")).sendKeys("Ayman");
		driver.findElement(By.id("sex-1")).click();

		driver.findElement(By.id("photo")).sendKeys("C:\\TECHFIOS\\Selenium\\Documents\\PPT\\Session 1.pptx");

		driver.findElement(By.partialLinkText("TF-API Product Backend")).click();

	}
}
