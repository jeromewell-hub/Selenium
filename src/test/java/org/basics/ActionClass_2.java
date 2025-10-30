package org.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClass_2 {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);
		WebElement source = driver.findElement(By.xpath("//a[text()=' BANK ']"));
		WebElement destination = driver.findElement(By.xpath("(//li[@class='placeholder'])[1]"));
		actions.dragAndDrop(source, destination).perform();
		
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		WebElement clickel = driver.findElement(By.xpath("//span[text()='Mobiles & Tablets']"));
		actions.click().perform();
		Thread.sleep(3000);

		WebElement moveel = driver.findElement(By.xpath("//span[text()='Electronics']"));
		actions.moveToElement(moveel).perform();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()='Apple']")).click();
		
	
	

	}
}
