package org.basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablePractice_9 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://letcode.in/table");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement table = driver.findElement(By.xpath("//table[@id='simpletable']"));
		List<WebElement> eachRow = table.findElements(By.tagName("tr"));
		for (int i = 0; i < eachRow.size(); i++) {
			WebElement column = eachRow.get(i);
			List<WebElement> eachData = column.findElements(By.tagName("td"));
			if (eachData.size() > 1) {
				String firstname = eachData.get(0).getText().trim();
				String lastname = eachData.get(1).getText().trim();
				if (firstname.equalsIgnoreCase("Yashwanth") && lastname.equalsIgnoreCase("Raj")) {
					WebElement checkBox = driver.findElement(By.id("second"));
					if (!checkBox.isSelected()) {
						checkBox.click();
					}
					break;
				}
			}
		}
	}
}
