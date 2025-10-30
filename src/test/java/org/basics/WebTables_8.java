package org.basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables_8 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://letcode.in/advancedtable");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement tableElement = driver.findElement(By.xpath("//table[@id='advancedtable']"));

		List<WebElement> tableRow = tableElement.findElements(By.tagName("tr"));
		for (int i = 0; i < tableRow.size(); i++) {
			WebElement eachRow = tableRow.get(i);

			List<WebElement> tableHeader = eachRow.findElements(By.tagName("th"));

			for (int j = 0; j < tableHeader.size(); j++) {
				WebElement eachHeader = tableHeader.get(i);
				System.out.println(eachHeader);
			}

			List<WebElement> tableData = eachRow.findElements(By.tagName("td"));
			for (WebElement eachData : tableData) {
				String text = eachData.getText();
				System.out.println(text);

			}
		}
	}
}
