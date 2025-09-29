package com.at.webutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtilityForAT {

	public void maximizeScreen(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	public void MoveToElementUsingMouse(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void switchToAnotherTab(WebDriver driver, String partialUrl) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while (it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			String title = driver.getCurrentUrl();
			if (title.contains(partialUrl)) {
				break;
			}
		}

	}

	public void dropdownElement(WebElement ele, String value) {
		Select dropdown = new Select(ele);
		dropdown.selectByValue(value);
	}

	public void explicitWait(WebDriver driver, WebElement ele) {
		WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(10));
		wdw.until(ExpectedConditions.elementToBeClickable(ele));
	}
}
