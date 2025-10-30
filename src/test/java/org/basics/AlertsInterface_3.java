package org.basics;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsInterface_3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://letcode.in/alert");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// simple alert--accept();

		driver.findElement(By.id("accept")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		;
		// confirm alert -- accept(), dismiss();
		driver.findElement(By.id("confirm")).click();
		Alert alert2 = driver.switchTo().alert();
		alert2.dismiss();

		// prompt alert-->Accept(),dismiss(),sendkeys();
		driver.findElement(By.xpath("//button[@id='prompt']")).click();
		Alert prompt = driver.switchTo().alert();
		prompt.sendKeys("This is prompt alert");
		prompt.accept();
		
	}

}
