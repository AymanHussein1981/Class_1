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

public class A010_Poppup {
	
	
	WebDriver driver;
	
	By USERNAME_FIELD = By.xpath("//input[@id='user_name']");
	By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
	By LOGIN_BUTTON = By.xpath("//*[@id=\"login_submit\"]");
	By CUSTOMERS_TAB = By.xpath("/html/body/div[1]/aside[1]/div/nav/ul[2]/li[2]/a/span");
	By ADD_CUSTOMERS = By.xpath("//*[@id=\"customers\"]/li[2]/a/span");
	By FULLNAME_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[1]/div/input");
	By COMPANY_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[2]/div/select");
	By EMAIL_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[3]/div/input");
	By PHONE_NUMBER_FIELD = By.xpath("//*[@id=\"phone\"]");
	By COUNTRY_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[8]/div[1]/select");
	By SAVE_BUTTON = By.xpath("//*[@id=\"save_btn\"]");
	
	
	@Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://codefios.com/ebilling/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	
	@Test
	public void Popup() throws InterruptedException {
	
		driver.findElement(LOGIN_BUTTON).click();
		String error_message = driver.switchTo().alert().getText();
		System.out.println(error_message);
		Assert.assertEquals("user name field empty", "Please enter your user name", error_message);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
	}
	
	
	@Test
	public void Popup1() throws InterruptedException {
		
		driver.findElement(USERNAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(LOGIN_BUTTON).click();
		String error_message = driver.switchTo().alert().getText();
		System.out.println(error_message);
		Assert.assertEquals("password field empty", "Please enter your password", error_message);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
	}
	
	@Test
	public void Popup2() throws InterruptedException {
		driver.findElement(USERNAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(LOGIN_BUTTON).click();
		String error_message=driver.switchTo().alert().getText();
		System.out.println(error_message);
		Assert.assertEquals("user name field empty", "Please enter your user name", error_message);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
	}

	
	@Test
	public void login() throws InterruptedException {
		
		driver.findElement(USERNAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(LOGIN_BUTTON).click();
		Thread.sleep(5000);
	}
	
	@Test
	public void DropDown() throws InterruptedException {
		
		driver.findElement(USERNAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(LOGIN_BUTTON).click();
		Assert.assertEquals("Page not found!!!", "Codefios", driver.getTitle());
		driver.findElement(CUSTOMERS_TAB).click();
		driver.findElement(ADD_CUSTOMERS).click();
		driver.findElement(FULLNAME_FIELD).sendKeys("UBA");
		Select sel = new Select (driver.findElement(COMPANY_FIELD));
		sel.selectByVisibleText("0629Adnan");
		driver.findElement(EMAIL_FIELD).sendKeys("uba@gmail.com");
		driver.findElement(PHONE_NUMBER_FIELD).sendKeys("2144691234");
		Select sel1 = new Select (driver.findElement(COUNTRY_FIELD));
		sel1.selectByVisibleText("Australia");
		driver.findElement(SAVE_BUTTON).click();
		Thread.sleep(5000);
	}
	
	@After
	public void teardown() {
		driver.close();
		driver.quit();
	}

}
