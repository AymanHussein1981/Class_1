package class_1;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A016_Scroll_Up_Down {
	
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
	public void loginTest() throws InterruptedException  {
		
		
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("scroll(0,5000)");
	Thread.sleep(2000);
	js.executeScript("scroll(0,0)");
		
	
	}	
	

}
