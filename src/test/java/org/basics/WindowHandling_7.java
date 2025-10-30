package org.basics;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling_7 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.flipkart.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		driver.findElement(By.xpath("//span[text()='Mobiles & Tablets']")).click();

		WebElement nothingPhone = driver.findElement(By
				.xpath("//img[@src='https://rukminim2.flixcart.com/fk-p-flap/50/50/image/3af5e430581d482c.jpg?q=50']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true)", nothingPhone);
		executor.executeScript("arguments[0].click()", nothingPhone);

		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Place Order']")));
		driver.navigate().back();
		System.out.println("done");

		driver.findElement(By.xpath("//span[text()='TVs & Appliances']")).click();
		Actions actions = new Actions(driver);
		WebElement samsung = driver.findElement(By.xpath("//a[@title='Samsung']"));
		actions.moveToElement(samsung).perform();
		actions.click(samsung).perform();

		driver.findElement(By.xpath(
				"//div[text()='Samsung 80 cm (32 inch) HD Ready LED Smart Tizen TV 2025 Edition with Voice Assistance Remote Control ...']"))
				.click();

		String parentwindow = driver.getWindowHandle();
		System.out.println(parentwindow);

		Set<String> allWindow = driver.getWindowHandles();
		System.out.println(allWindow);

		boolean foundnew = false;
		for (String totalwindows : allWindow) {

			if (!totalwindows.equals(parentwindow)) {
				driver.switchTo().window(totalwindows);
				System.out.println("switch window" + totalwindows);
				foundnew = true;
			}
		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add to cart']"))).click();

		driver.switchTo().window(parentwindow);
		driver.findElement(By.xpath("//div[text()='SONY']")).click();
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[text()='Samsung Crystal 4K Infinity Vision 138 cm (55 inch) Ultra HD (4K) LED Smart Tizen TV 2025 Edition with...']")))
				.click();

		Set<String> windowHandles = driver.getWindowHandles();

		List<String> list = new ArrayList<String>();
		list.addAll(windowHandles);
		System.out.println(windowHandles);

		driver.switchTo().window(list.get(2));
		driver.switchTo().window(parentwindow);
		driver.close();
	}
}