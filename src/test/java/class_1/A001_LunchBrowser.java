package class_1;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A001_LunchBrowser {
	
	@Test
	public void lunchbrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ayman\\eclipse-workspace\\PRACTISE\\Class_1\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	}
	
	

}
