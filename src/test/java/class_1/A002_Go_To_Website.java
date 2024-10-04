package class_1;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A002_Go_To_Website {
	
	
	@Test
	public void GotoWebsite(){
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ayman\\eclipse-workspace\\PRACTISE\\Class_1\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://codefios.com/ebilling/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
	}

}
