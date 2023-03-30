package com.wallet.crypto.trustapp.Utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.wallet.crypto.trustapp.testscripts.trustwallet.*;

public class Listeners extends BaseTest implements ITestListener {

	ExtentReports extent = ExtentReporterNG.getReporterObject();
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		//ExtentTest test = extent.createTest(result.getClass().getName());
		//ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.fail(result.getThrowable());
		
		// Screenshot
		
		try {
			test.addScreenCaptureFromPath(getScreenshot(result.getMethod().getMethodName()),result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * String s = result.getName(); try { base.getScreenshot(s); } catch
		 * (IOException e) { e.printStackTrace(); }
		 */
		
		/* ITestListener.super.onTestFailure(result); */
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		//ITestListener.super.onFinish(context);
	}

}
