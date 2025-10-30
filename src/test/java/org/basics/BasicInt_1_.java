package org.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicInt_1_ {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		driver.manage().window().maximize();

		System.out.println(driver.getCurrentUrl());

		System.out.println(driver.getPageSource());

		System.out.println(driver.getTitle());

		System.out.println(driver.getWindowHandle());

		System.out.println(driver.getWindowHandle());

		WebElement text = driver.findElement(
				By.xpath("//h2[text()='Facebook helps you connect and share with the people in your life.']"));
		String text2 = text.getText();
		System.out.println(text2);

		driver.findElement(By.xpath("//a[text()='Create new account']")).click();

		driver.navigate().back();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.navigate().refresh();		
		driver.close();
		
		

	}

}
