package com.at.baseclass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.at.genericUtility.FileUtility;
import com.at.webutility.WebDriverUtilityForAT;

public class BaseclassForAT {

	FileUtility fileutility = new FileUtility();
	WebDriverUtilityForAT webutility = new WebDriverUtilityForAT();

	public WebDriver driver = null;

	public static WebDriver edriver = null;

	@Parameters("Browser")
	@BeforeClass
	public void launchBrowser(@Optional("chrome") String Browser) throws IOException {

		// get the URL from property file
		String url = fileutility.getDataFromPropertyFile("url");

		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}
		webutility.waitForPageLoad(driver);
		webutility.maximizeScreen(driver);
		driver.get(url);
		edriver = driver;

	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(3)).until(d -> false);
		} catch (Exception e) {
			System.out.println("Takes time for 5 sec to close the browser");
		}
		driver.quit();
	}

}
