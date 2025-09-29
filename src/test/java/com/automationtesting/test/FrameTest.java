package com.automationtesting.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.at.baseclass.BaseclassForAT;
import com.objectresourceutility.HomePage;


public class FrameTest extends BaseclassForAT {

	@Test
	public void TestinFrame() {

		HomePage home = new HomePage(driver);
		home.getChooseIframe().click();
		WebElement firstFrame = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(firstFrame);
		driver.switchTo().frame(0);
		WebElement textInput = driver.findElement(By.xpath("//input[@type='text']"));
		textInput.sendKeys("Souvik");

	}

}
