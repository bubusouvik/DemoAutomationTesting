
package com.automationtesting.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.at.baseclass.BaseclassForAT;
import com.at.genericUtility.FileUtility;
import com.at.webutility.WebDriverUtilityForAT;
import com.objectresourceutility.HomePage;

public class DatepickerTest extends BaseclassForAT {

	/**
	 * Author: Souvik Guria Description: Choose DatePicker for disabled start date
	 * and enabled end date.
	 */

	@Test
	public void chooseDatePicker() throws IOException {

		HomePage home = new HomePage(driver);
		WebDriverUtilityForAT webutility = new WebDriverUtilityForAT();
		FileUtility file = new FileUtility();

		webutility.MoveToElementUsingMouse(driver, home.getWidgets());
		home.getDatePicker().click();
		home.getDisbaledDatepicker().click();

		// get the date from property file
		String startMonth = file.getDateFromPropertyFile("startMonth");
		String endMonth = file.getDateFromPropertyFile("endMonth");
		String startdate = file.getDateFromPropertyFile("startDate");
		String enddate = file.getDateFromPropertyFile("endDate");

		// check the dates according to property file
		for (;;) {
			try {
				driver.findElement(By.xpath("//span[text()='" + startMonth
						+ "']/following-sibling::span[.='2025']/ancestor::div[@id='ui-datepicker-div']/descendant::a[text()='"
						+ startdate + "']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[.='Next']")).click();
			}
		}
		home.getEnabledDatePicker().click();
		webutility.explicitWait(driver, home.getChangeTheMonth());
		webutility.dropdownElement(home.getChangeTheMonth(), "12/2025");
		driver.findElement(By.xpath("//a[@title='Select Tuesday, " + endMonth + " " + enddate + ", 2025']")).click();

	}

}
