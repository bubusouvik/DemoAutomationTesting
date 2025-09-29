package com.automationtesting.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.at.baseclass.BaseclassForAT;
import com.at.webutility.WebDriverUtilityForAT;
import com.objectresourceutility.HomePage;


public class DatepickerTest extends BaseclassForAT {

	@Test
	public void chooseDatePicker() {

		HomePage home = new HomePage(driver);
		WebDriverUtilityForAT webutility = new WebDriverUtilityForAT();

		webutility.MoveToElementUsingMouse(driver, home.getWidgets());
		home.getDatePicker().click();
		home.getDisbaledDatepicker().click();
		String startMonth = "October";
		String endMonth = "Dec";
		String startdate = "10";
		String enddate = "16";
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
