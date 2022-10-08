package com.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class application {
	
	private static String path = "C:\\tools\\chromedriver_win32\\chromedriver.exe";

	public static void main(String[] args) {

		String url = "https://www.facebook.com/r.php?locale=en_GB&display=page";
		System.setProperty("webdriver.chrome.driver", path);

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		String title = driver.getTitle();
		System.out.println(title);

		WebElement firstname = driver.findElement(By.name("firstname"));
		firstname.sendKeys("Gorge");
		System.out.println(firstname.getAttribute("name"));

		WebElement lastname = driver.findElement(By.name("lastname"));
		lastname.sendKeys("RR Martin");
		System.out.println(lastname.getAttribute("name"));

		WebElement email = driver.findElement(By.name("reg_email__"));
		email.sendKeys("ggrm@gmail.com");
		System.out.println(email.getAttribute("name"));
		
		WebElement emailconfirmation = driver.findElement(By.name("reg_email_confirmation__"));
		emailconfirmation.sendKeys("ggrm@gmail.com");
		System.out.println(emailconfirmation.getAttribute("name"));

		WebElement pass = driver.findElement(By.id("password_step_input"));
		pass.sendKeys("g0rge@123");
		System.out.println(pass.getAttribute("name"));

		WebElement day = driver.findElement(By.id("day"));
		day.sendKeys("20");
		System.out.println(day.getAttribute("name"));

		WebElement month = driver.findElement(By.id("month"));
		month.sendKeys("September");
		System.out.println(month.getAttribute("name"));

		WebElement year = driver.findElement(By.id("year"));
		year.sendKeys("1948");
		System.out.println(year.getAttribute("name"));

		WebElement gender = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[2]"));
		gender.click();
		System.out.println(gender.getAttribute("name"));

		WebElement signUp = driver.findElement(By.name("websubmit"));
		signUp.click();
		System.out.println(signUp.getAttribute("name"));

		System.out.println("registered successfully");

	}


}