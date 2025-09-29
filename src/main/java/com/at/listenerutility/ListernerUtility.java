package com.at.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.at.baseclass.BaseclassForAT;
import com.at.webutility.UtilityClassObject;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListernerUtility implements ITestListener, ISuiteListener {

	public ExtentReports report;
	public ExtentTest test;

	public void onStart(ISuite res) {

		System.out.println("Report Configauration");
		ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentReports/report.html");
		spark.config().setDocumentTitle("automationTesting/report");
		spark.config().setReportName("ErrorFile");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "Windows-11");
		report.setSystemInfo("Browser", "Chrome-100");

	}

	public void onTestStart(ITestResult res) {

		System.out.println("=========> " + res.getMethod().getMethodName() + "==> START");
		test = report.createTest(res.getName());
		test.log(Status.INFO, res.getMethod().getMethodName() + " STARTED ");
		UtilityClassObject.setTest(test);

	}

	public void onTestSuccess(ITestResult res) {

		System.out.println(res.getMethod().getMethodName() + " End");
		test.log(Status.PASS, res.getMethod().getMethodName() + " PASSED ");
	}

	public void onTestFailure(ITestResult res) {

		String testname = res.getMethod().getMethodName();
		System.out.println(res.getMethod().getMethodName() + " Failed ");
		TakesScreenshot ts = (TakesScreenshot) BaseclassForAT.edriver;
		String srcfile = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", " ");
		test.addScreenCaptureFromBase64String(srcfile, testname + " " + time);
		test.log(Status.FAIL, res.getMethod().getMethodName() + " FAILED");
		test.log(Status.FAIL, res.getThrowable() + " " + res.getMethod().getMethodName());
	}

	public void onFinish(ISuite res) {

		System.out.println("Report backup " + report);
		report.flush();
	}

}
