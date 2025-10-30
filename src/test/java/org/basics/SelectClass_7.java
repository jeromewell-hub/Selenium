package org.basics;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClass_7 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://letcode.in/dropdowns");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement fruits = driver.findElement(By.cssSelector("#fruits"));
		Select fruitsselect = new Select(fruits);
		boolean multiple = fruitsselect.isMultiple();
		System.out.println("Fruits select is multiple or not " + multiple);
		fruitsselect.selectByVisibleText("Apple");
		List<WebElement> allSelectedOptions = fruitsselect.getAllSelectedOptions();
		for (WebElement webElement : allSelectedOptions) {
			String text = webElement.getText();
			System.out.println(text);
		}

		WebElement superHeros = driver.findElement(By.cssSelector("#superheros"));
		Select selectsuperHeros = new Select(superHeros);
		System.out.println(selectsuperHeros.isMultiple());
		selectsuperHeros.selectByIndex(2);
		selectsuperHeros.selectByValue("bt");
		selectsuperHeros.selectByVisibleText("Black Panther");

		System.out.println(selectsuperHeros.getFirstSelectedOption());
		List<WebElement> allSelectedOptions2 = selectsuperHeros.getAllSelectedOptions();
		for (WebElement webElement1 : allSelectedOptions2) {
			String text = webElement1.getText();
			System.out.println(text);

		}

		List<WebElement> options = selectsuperHeros.getOptions();

		for (int i = 0; i < options.size(); i++) {
			WebElement webElement = options.get(i);
			String text = webElement.getText();
			System.out.println(text);
		}

	}
}
