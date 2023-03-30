package trustwallet;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Driver;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import pages_or_screens.TrustWallet_SignUp_Screen;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import io.appium.java_client.clipboard.HasClipboard;

public class TrustWallet_TC_001_OpenApp extends BaseTest {
		
	
			@BeforeTest
			public void killAllNodes() throws InterruptedException, IOException {
				Runtime.getRuntime().exec("taskkill /F /IM node.exe");
				Thread.sleep(6000);
			}

			@Test(groups = {"Smoke"})
			public void openTheApp () throws IOException, InterruptedException {
			
			FileReader reader= new FileReader(System.getProperty("user.dir") + File.separator + "Config.properties");
			Properties p=new Properties();  
			p.load(reader); 
			
			//Page objects
			
			TrustWallet_SignUp_Screen signUpScreen = new TrustWallet_SignUp_Screen();
			
			// Test case steps
			
			signUpScreen.verifyFirstSlideElements();
			signUpScreen.swipeRightToLeft();
			signUpScreen.verifySecondSlideElements();
			signUpScreen.swipeRightToLeft();
			signUpScreen.verifyThirdSlideElements();
			signUpScreen.swipeRightToLeft();
			signUpScreen.verifyFourthSlideElements();
			signUpScreen.verifyLegalElements();
			signUpScreen.verifyPrivacyPopUpElements();
			signUpScreen.termsOfServicePopUpElements();
			signUpScreen.acceptAndContinue();
			signUpScreen.createPasscode();
			signUpScreen.confirmPasscode();
			signUpScreen.secretPhraseAndManullyBackUp();
			signUpScreen.provideConsent();
			signUpScreen.captureSecretPhraseAndContinue();
			signUpScreen.verifySecretPhraseAndDone();
			
	        
			/*
			 * Thread.sleep(10000); String elementHierarchy = driver.getPageSource();
			 * 
			 * System.out.
			 * println("Page source: ******************************************************************************************** "
			 * + elementHierarchy);
			 */
			//Thread.sleep(5000);
			}
			
			
				
	}