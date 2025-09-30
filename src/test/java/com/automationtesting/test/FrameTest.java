
package com.automationtesting.test;

import java.io.IOException;

import org.testng.annotations.Test;
import com.at.baseclass.BaseclassForAT;
import com.at.genericUtility.FileUtility;
import com.at.webutility.WebDriverUtilityForAT;
import com.objectresourceutility.HomePage;

public class FrameTest extends BaseclassForAT {

	/**
	 * Author: Souvik Guria
	 * Description: verifies frames and send the values inside nested frames.
	 */
	@Test
	public void TestinFrame() throws IOException {

		HomePage home = new HomePage(driver);
		WebDriverUtilityForAT webutility = new WebDriverUtilityForAT();
		FileUtility file = new FileUtility();
		home.getChooseIframe().click();
		webutility.switchToFrameByElement(driver, home.getFramesrc());
		webutility.switchToFrameByIdnex(driver, 0);

		// get data from property file
		String name = file.getDataFromPropertyFile("name");
		// send the values inside a nested frame
		home.getInput().sendKeys(name);

	}

}
