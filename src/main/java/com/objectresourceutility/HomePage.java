package com.objectresourceutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "(//a[@data-toggle='dropdown'])[1]")
	private WebElement switchTo;

	@FindBy(xpath = "//a[text()='Windows']")
	private WebElement windows;

	@FindBy(xpath = "(//a[@class='analystic'])[2]")
	private WebElement newSeparateWindow;

	@FindBy(xpath = "//button[.='click']")
	private WebElement clickBtn;

	@FindBy(xpath = "//a[contains(text(),'Widgets')]")
	private WebElement widgets;

	@FindBy(xpath = "//a[contains(text(),'Datepicker')]")
	private WebElement Datepicker;

	@FindBy(xpath = "//input[@id='datepicker1']")
	private WebElement disbaleddatepicker;

	@FindBy(xpath = "//input[@id='datepicker2']")
	private WebElement enableddatepicker;

	@FindBy(xpath = "//a[text()='Iframe with in an Iframe']")
	private WebElement chooseiframe;

	@FindBy(xpath = "//select[@title='Change the month']")
	private WebElement changeTheMonth;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement input;

	@FindBy(xpath = "//iframe[@src='MultipleFrames.html']")
	private WebElement framesSrc;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSwitchTo() {
		return switchTo;
	}

	public WebElement getNewSeparateWindow() {
		return newSeparateWindow;
	}

	public WebElement getWindows() {
		return windows;
	}

	public WebElement getclickBtn() {
		return clickBtn;
	}

	public WebElement getDatePicker() {
		return Datepicker;
	}

	public WebElement getWidgets() {
		return widgets;
	}

	public WebElement getDisbaledDatepicker() {
		return disbaleddatepicker;
	}

	public WebElement getEnabledDatePicker() {
		return enableddatepicker;
	}

	public WebElement getChangeTheMonth() {
		return changeTheMonth;
	}

	public WebElement getChooseIframe() {
		return chooseiframe;
	}

	public WebElement getInput() {
		return input;
	}

	public WebElement getFramesrc() {
		return framesSrc;
	}
}
