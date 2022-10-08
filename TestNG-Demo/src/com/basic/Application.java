package com.basic;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Application {
	
	private static String url = "http://localhost:4200";

	WebDriver webdriver = null;

	
	@BeforeTest
	public void start() {
		System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver_win32\\chromedriver.exe");
		webdriver = new ChromeDriver();
	}
	
	@Test(priority=0)
	public void signupform() throws InterruptedException {
		String route = "signup";
		webdriver.get(url + "/" + route);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webdriver.findElement(By.xpath("/html/body/app-root/div/div[2]/div/app-signup/form/p[2]/input")).sendKeys("Raavan Asura");		
		System.out.println("fullname Enter successfully");
		Thread.sleep(2000);
		webdriver.findElement(By.xpath("/html/body/app-root/div/div[2]/div/app-signup/form/p[3]/input")).sendKeys("rakshasraj@gmail.com");	
		System.out.println("Email enter successfully");
		Thread.sleep(2000);
		webdriver.findElement(By.xpath("/html/body/app-root/div/div[2]/div/app-signup/form/p[4]/input")).sendKeys("lanka@123");
		System.out.println("Password enter successfully");
		Thread.sleep(2000);
		webdriver.findElement(By.xpath("/html/body/app-root/div/div[2]/div/app-signup/form/p[5]/input")).sendKeys("lanka@123");
		System.out.println("Password enter successfully");
		Thread.sleep(2000);
		webdriver.findElement(By.xpath("/html/body/app-root/div/div[2]/div/app-signup/form/div/button")).click();
		Thread.sleep(2000);
		System.out.println("Signup successfully");

	}
	
	@Test(priority=1)
	public void Login() throws InterruptedException {
		String route = "login";
		webdriver.get(url + "/" + route);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webdriver.findElement(By.name("email")).sendKeys("rakshasraj@gmail.com");
		System.out.println("Email field is filled");
		Thread.sleep(2000);
		webdriver.findElement(By.name("password")).sendKeys("lanka@123");
		System.out.println("Password field is filled");
		Thread.sleep(2000);
		webdriver.findElement(By.xpath("/html/body/app-root/div/div[2]/div/app-login/form/p[3]/button")).click();
		Thread.sleep(3000);
		System.out.println("Login successfully");
	}
	
	@Test(priority=2)
	public void Addtocart() throws InterruptedException {

		String route = "products";
		webdriver.get(url + "/" + route);
		Thread.sleep(3000);
		webdriver.findElement(By.xpath("/html/body/app-root/div/div[2]/div/app-products/input")).sendKeys("Laptop");
		webdriver.findElement(By.xpath("/html/body/app-root/div/div[2]/div/app-products/button")).click();
		System.out.println("Add button is clicked");
		System.out.println("Product is added to cart");
	}
	
	
	@AfterSuite
	public void end() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webdriver.close();
		System.out.println("Testing Ended successfully");
	}

}