package class_1;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A019_Window_Handle_Yahoo {
	
	WebDriver driver;
	
	By SEARCH_BAR_FIELD=By.xpath("//*[@id=\"ybar-sbq\"]");
	By SEARCH_BUTTON_FIELD=By.xpath("//*[@id=\"ybar-search\"]");
	By SELENIUM_DEV_LINK_FIELD=By.xpath("//*[@id=\"web\"]/ol/li[1]/div/div[1]/h3/a");
	
	@Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.yahoo.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
	
	
	
	@Test
	public void WindowHandle() throws InterruptedException {
		
		
		driver.findElement(SEARCH_BAR_FIELD).sendKeys("selenium");
		driver.findElement(SEARCH_BUTTON_FIELD).click();
		Thread.sleep(2000);
		Set<String>handels=driver.getWindowHandles();
		for(String str:handels) {
			System.out.println(str);
			driver.switchTo().window(str);	
	
		}
	driver.findElement(SELENIUM_DEV_LINK_FIELD).click();
	}
	
	
	

}
