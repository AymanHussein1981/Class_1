package class_1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class A014_Rivision {
	
	WebDriver driver;
		
	By USERNAME_FIELD = By.xpath("//*[@id=\"user_name\"]");
	By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
	By LOGIN_BUTTON = By.xpath("//*[@id=\"login_submit\"]");
	By CUSTOMERBUTTON = By.xpath("//span[text()='Customers']");
	By ADDCUSTOMER = By.xpath("//span[text()='Add Customer']");
	By CUSTOMER_NAME_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[1]/div/input");
	By COMPANY_NAME_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[2]/div/select");
	By EMAIL_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[3]/div/input");
	By PHONE_NUMBER_FIELD = By.xpath("//*[@id=\"phone\"]");
	By COUNTRY_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[8]/div[1]/select");
	By SAVE_BUTTON_FIELD = By.xpath("//*[@id=\"save_btn\"]");
	By REALESTATE_BUTTON = By.xpath("//*[@id=\"ad_three\"]/a/img");
	By STUDENT_LOGIN_BUTTON = By.xpath("//*[@id=\"portal_three\"]/div");
	By GROUP_NAME_FIELD = By.xpath("//*[@id=\"customer_groupName\"]");
	
	@Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://codefios.com/ebilling/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	
	@Test
	public void popup_NoUserName() throws InterruptedException {
		
				driver.findElement(LOGIN_BUTTON).click();
				Assert.assertEquals("Wrong Message", "Please enter your user name", driver.switchTo().alert().getText());
				Thread.sleep(5000);
				driver.switchTo().alert().accept();
				Thread.sleep(5000);
				
				
	}
	
	
	@Test
	public void popup_NoPassword() throws InterruptedException{
		
		driver.findElement(USERNAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(LOGIN_BUTTON).click();
		Assert.assertEquals("Wrong Message", "Please enter your password", driver.switchTo().alert().getText());
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		
		
		
	}
	
	
	@Test
	public void DropDown() throws InterruptedException {
		
		driver.findElement(USERNAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(LOGIN_BUTTON).click();
		Assert.assertEquals("Page not found!!", "Dashboard", driver.findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div/div/header/div/strong")).getText());
		driver.findElement(CUSTOMERBUTTON).click();
		driver.findElement(ADDCUSTOMER).click();
		driver.findElement(CUSTOMER_NAME_FIELD).sendKeys("BCN");
		Select sel = new Select (driver.findElement(COMPANY_NAME_FIELD));
		sel.selectByVisibleText("aaaa111");
		driver.findElement(EMAIL_FIELD).sendKeys("bcn@gmail.com");
		driver.findElement(PHONE_NUMBER_FIELD).sendKeys("7774412964");
		Select sel1 = new Select (driver.findElement(COUNTRY_FIELD));
		sel1.selectByVisibleText("United States of America");
		driver.findElement(SAVE_BUTTON_FIELD).click();
		Thread.sleep(5000);
		
	}
	
	
	@Test
	public void iFrame() throws InterruptedException {
		
		driver.findElement(USERNAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(LOGIN_BUTTON).click();
		Assert.assertEquals("Page not found!!", "Dashboard", driver.findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div/div/header/div/strong")).getText());
		driver.switchTo().frame("advertisement");
		driver.findElement(REALESTATE_BUTTON).click();
		driver.switchTo().frame("portals");
		driver.findElement(STUDENT_LOGIN_BUTTON).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("customer_groupaddframe");
		driver.findElement(GROUP_NAME_FIELD).sendKeys("Ayman Hussein");
		Thread.sleep(5000);
		
		
	}
	
	
	@After
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
