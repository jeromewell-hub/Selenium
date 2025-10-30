package org.basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExicutor_6 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://letcode.in/edit");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		// scrolldown
		WebElement element = driver.findElement(By.xpath("//p[text()=' © 2025 LetCode | Created by ']"));
		executor.executeScript("arguments[0].scrollIntoView(true);", element);

		Thread.sleep(2000);
		WebElement element2 = driver.findElement(By.xpath("//label[text()='Enter your full Name']"));
		executor.executeScript("arguments[0].scrollIntoView(false)", element2);

		// sendkeys

		WebElement name = driver.findElement(By.id("fullName"));
		executor.executeScript("arguments[0].setAttribute('value','jerome')", name);
		Object executeScript = executor.executeScript("return arguments[0].getAttribute('value')", name);
		System.out.println(executeScript);

		WebElement click = driver.findElement(By.xpath("//button[text()='Watch tutorial']"));
		executor.executeScript("arguments[0].click()", click);
	}

}