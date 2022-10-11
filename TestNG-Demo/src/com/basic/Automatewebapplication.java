package com.basic;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

@Test
public class Automatewebapplication {

	WebDriver driver ;
	
	@BeforeClass
	public void startBrowser(){

		System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

//		System.setProperty("webdriver.edge.driver", "C:\\tools\\edgedriver_win64\\msedgedriver.exe");
//		webdriver = new EdgeDriver();
		
//		System.setProperty("webdriver.gecko.driver", "C:\\tools\\geckodriver-v0.31.0-win64\\geckodriver.exe");
//		webdriver = new FirefoxDriver();
		
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();

	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		driver.close();
	}
	@Test(priority = 1)
	public void loadtime() {
		long lt = System.currentTimeMillis();
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/button")));
		long ct = System.currentTimeMillis();
		long at = ct - lt;

	}
	
	@Test(priority = 2)
	public void search() {
		//step1: Search
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")).sendKeys(Keys.ESCAPE);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")).sendKeys("iPhone 13");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div[2]/form/div/button")).sendKeys(Keys.ENTER);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			//step2: image loading
			boolean image = driver.findElement(By.xpath("//img[contains(@src, 'https://rukminim1.flixcart.com/image/312/312/ktketu80/mobile/a/m/7/iphone-13-mlpj3hn-a-apple-original-imag6vpyk3w4zarg.jpeg?q=70')]")).isDisplayed(); 

		} catch (org.openqa.selenium.NoSuchElementException e) {
		}

	}
	//step3: scroll test
	@Test(priority = 3)
	public void scroll() {

		String JS_ELEMENT_IS_SCROLLABLE = "return arguments[0].scrollHeight > arguments[0].offsetHeight;";

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		WebElement container = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div[6]/div"));
		Boolean canbescrolled = (Boolean) jse.executeScript(JS_ELEMENT_IS_SCROLLABLE, container);
		
		if (canbescrolled == true) {
			System.out.println("Can be Scrolled");
		} 
		else {
			System.out.println("Cannot Be Scrolled");
		}
		
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class);
		WebElement webelement = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.cssSelector("._396cs4._3exPp9"));
			}
		});

		WebElement element = driver.findElement(By.xpath("//img[contains(@src, 'https://rukminim1.flixcart.com/image/312/312/ktketu80/mobile/a/m/7/iphone-13-mlpj3hn-a-apple-original-imag6vpyk3w4zarg.jpeg?q=70')]"));
		boolean Beforescroll = element.isDisplayed();
		System.out.println("Before Scrolling:");
		if (Beforescroll == true) {
		System.out.println("Imageloaded.");
		}
		else {
			System.out.println("Image not loaded.");
		}
		System.out.println("After Scrolling:");
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
		boolean Afterscroll = element.isDisplayed();
		
		if (Afterscroll == true) {
			System.out.println("Image loaded");
		}
		else {
			System.out.println("Image not loaded");
		}
		//step4: scroll to bottom of page
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}