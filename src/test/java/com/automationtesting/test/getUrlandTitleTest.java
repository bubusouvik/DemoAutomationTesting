
package com.automationtesting.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.at.baseclass.BaseclassForAT;
import com.at.genericUtility.FileUtility;
import com.at.webutility.WebDriverUtilityForAT;
import com.objectresourceutility.HomePage;

public class getUrlandTitleTest extends BaseclassForAT {

	/**
	 * Author: Souvik Guria 
	 * Description: verifies url and title from child page.
	 */
	@Test
	public void getURLandTitleFromChildPage() throws IOException {

		HomePage home = new HomePage(driver);
		WebDriverUtilityForAT webutility = new WebDriverUtilityForAT();
		FileUtility file = new FileUtility();
		webutility.MoveToElementUsingMouse(driver, home.getSwitchTo());

		home.getWindows().click();
		home.getNewSeparateWindow().click();
		home.getclickBtn().click();

		// get data from property file
		String actualpartialTitle = file.getTitleAndURLFromPropertyFile("title");
		String actualurl = file.getTitleAndURLFromPropertyFile("url");

		webutility.switchToAnotherTab(driver, actualpartialTitle);
		String expectedtitle = driver.getTitle();
		String expectedurl = driver.getCurrentUrl();

		// Assertion verification for title from child page
		Assert.assertEquals(actualpartialTitle, expectedtitle);
		// Assertion verification for title from child page
		Assert.assertEquals(actualurl, expectedurl);

		if (actualpartialTitle.equals(expectedtitle) && actualurl.equals(expectedurl)) {
			System.out.println("Title is " + expectedtitle + " and url is " + expectedurl + " is passed.");
		}
	}
}
