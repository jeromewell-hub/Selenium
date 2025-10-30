package org.basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames_4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://letcode.in/frame");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.switchTo().frame("firstFr");

		driver.findElement(By.name("fname")).sendKeys("jerome");
		WebElement element = driver.findElement(By.name("lname"));
		element.sendKeys("welll");

		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys("Wellingston");

		driver.switchTo().parentFrame();

		element.clear();

		driver.switchTo().defaultContent();

		String text = driver.findElement(By.xpath("//li[text()='Target Locator']")).getText();
		System.out.println(text);

	}
}
