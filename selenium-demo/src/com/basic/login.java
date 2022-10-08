package com.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
public class login{
	
	public static void main(String[] args)
    {
  
        System.setProperty(
            "webdriver.chrome.driver",
            "C:\\tools\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
  
        driver.get("https://www.facebook.com/");

        driver.manage().window().maximize();

        driver.findElement(By.id("email"))
            .sendKeys("ggrm@gmail.com");

        driver.findElement(By.id("pass"))
            .sendKeys("g0rge@123");
  
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")).click();
    }
}