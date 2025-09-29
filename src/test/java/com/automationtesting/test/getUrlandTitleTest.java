package com.automationtesting.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.at.baseclass.BaseclassForAT;
import com.at.webutility.WebDriverUtilityForAT;
import com.objectresourceutility.HomePage;


public class getUrlandTitleTest extends BaseclassForAT {
	
	@Test
	public void getURLandTitleFromChildPage() {
		HomePage home = new HomePage(driver);
		WebDriverUtilityForAT webutility = new WebDriverUtilityForAT();
		webutility.MoveToElementUsingMouse(driver, home.getSwitchTo());
		home.getWindows().click();
		home.getNewSeparateWindow().click();
		home.getclickBtn().click();
		String actualpartialTitle = "Selenium";
		String actualurl = "https://www.selenium.dev/";
		webutility.switchToAnotherTab(driver, actualpartialTitle);
		String expectedtitle = driver.getTitle();
		String expectedurl = driver.getCurrentUrl();
		if (actualpartialTitle.equals(expectedtitle) && actualurl.equals(expectedurl)) {
			System.out.println("Title is " + expectedtitle + " and url is" + expectedurl + " is passed.");
		}
	}
}
