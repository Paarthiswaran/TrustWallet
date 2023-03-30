package com.wallet.crypto.trustapp.pages_or_screens;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.clipboard.HasClipboard;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import com.wallet.crypto.trustapp.*;
import com.wallet.crypto.trustapp.testscripts.trustwallet.*;

public class TrustWallet_SignUp_Screen extends BaseTest {
	

	//***************Sign-Up Screen Element's xpath *************************
	
	public String privateAndSecureImageXpath = "com.wallet.crypto.trustapp:id/img";
	public String privateAndSecureTextXpath = "//android.widget.TextView[@text='Private and secure']";
	public String privateKeysTextXpath = "//android.widget.TextView[@text='Private keys never leave your device.']";
	public String fourDotsXpath = "com.wallet.crypto.trustapp:id/pageIndicatorView";
	public String createNewWalletButtonXpath = "//android.widget.Button[@text='CREATE A NEW WALLET']";
	public String alreadyHaveWalletXpath = "//android.widget.TextView[@text='I already have a wallet']"; 
	
	public String secondSlideImageXpath = "com.wallet.crypto.trustapp:id/img";
	public String allAssetsTextXpath = "//android.widget.TextView[@text='All assets in one place']";
	public String viewAndStoreTextXpath = "//android.widget.TextView[@text='View and store your assets seamlessly.']";
	
	public String thirdSlideImageXpath = "com.wallet.crypto.trustapp:id/img";
	public String tradeAssetsTextXpath = "//android.widget.TextView[@text='Trade assets']";
	public String tradeTextXpath = "//android.widget.TextView[@text='Trade your assets anonymously.']";
	
	public String fourthSlideImageXpath = "com.wallet.crypto.trustapp:id/img";
	public String exploreTextXpath = "//android.widget.TextView[@text='Explore decentralized apps']";
	public String earnTextXpath = "//android.widget.TextView[@text='Earn, explore, utilize, spend, trade, and more.']";
	
	//***************Legal Pop-up Elements xpath *************************
	
	public String legalTitleXpath = "//android.widget.TextView[@text='Legal']";
	public String reviewTextXpath = "//android.widget.TextView[@text='Please review the Trust Wallet Terms of Service and Privacy Policy.']";
	public String privacyPolicyXpath = "//android.widget.TextView[@text='Privacy Policy']";
	public String termsOfServiceXpath = "//android.widget.TextView[@text='Terms of Service']";
	public String acceptCheckboxTextXpath = "//android.widget.CheckBox[@text='I've read and accept the Terms of Service and Privacy Policy.']";
	public String acceptCheckboxButtonXpath = "com.wallet.crypto.trustapp:id/acceptCheckBox";
	public String continueButtonXpath = "com.wallet.crypto.trustapp:id/next";
	
	//***************Privacy Pop-up Elements xpath *************************
	
	public String privacyDocTitleXpath = "//android.view.View[@text='Trust Wallet Privacy and Policy']";
	public String closeButtonXpath = "com.wallet.crypto.trustapp:id/action_hide";
	
	//***************Terms of Serive Pop-up Elements xpath *************************
	
	public String termsOfServiceTitleXpath = "//android.view.View[@text='Terms Of Service']";
	//public String closeButtonXpath = "com.wallet.crypto.trustapp:id/action_hide";
	
	//***************Create passcode xpath *************************
	public String clickNumber1Xpath = "//android.widget.TextView[@text='1']";
	
	//***************Secret Phase Screen xpath *************************
	
	public String secretPhraseTitleXpath = "//android.widget.TextView[@text='Secret phrase backup']";
	public String secretPhraseMsgXpath = "//android.widget.TextView[@text='Your secret phrase is the master key to your wallet, and anyone that has it can access your crypto. Never share it!']";
	public String backUpGDriveXpath = "//android.widget.TextView[@text='Back up to Google Drive']";
	public String backUpManuallyXpath = "//android.widget.TextView[@text='Back up manually']";
	
	
	//***************Secret Phase Screen xpath *************************
	
	public String backUpTitleXpath = "//android.widget.TextView[@text='Back up your wallet now!']";
	public String backUpMsgXpath = "//android.widget.TextView[@text='In the next step you will see Secret Phrase (12 words) that allows you to recover a wallet.']";
	public String consent1Xpath = "//android.widget.TextView[@text='If I lose my secret phrase, my funds will be lost forever.']";
	public String consent2Xpath = "//android.widget.TextView[@text='If I expose or share my secret phrase to anybody, my funds can get stolen.']";
	public String consent3Xpath = "//android.widget.TextView[@text='Trust Wallet support will NEVER reach out to ask for it']";
	
		
		
	//***************Verify Sign-up Screen Elements Method*************************
	
		public void verifyFirstSlideElements () throws InterruptedException {

			driver.findElement(By.id(privateAndSecureImageXpath)).isDisplayed();
			driver.findElementByXPath(privateAndSecureTextXpath).isDisplayed();
			driver.findElementByXPath(privateKeysTextXpath).isDisplayed();
			driver.findElement(By.id(fourDotsXpath)).isDisplayed();
			driver.findElementByXPath(createNewWalletButtonXpath).isDisplayed();
			driver.findElementByXPath(alreadyHaveWalletXpath).isDisplayed();
			//driver.findElementByXPath(createNewWalletButtonXpath).click();
			Thread.sleep(3000);		

		}
		
		public void verifySecondSlideElements () throws InterruptedException {

			driver.findElement(By.id(secondSlideImageXpath)).isDisplayed();
			driver.findElementByXPath(allAssetsTextXpath).isDisplayed();
			driver.findElementByXPath(viewAndStoreTextXpath).isDisplayed();
			
			Thread.sleep(3000);		

		}
		
		public void verifyThirdSlideElements () throws InterruptedException {

			driver.findElement(By.id(fourthSlideImageXpath)).isDisplayed();
			driver.findElementByXPath(tradeAssetsTextXpath).isDisplayed();
			driver.findElementByXPath(tradeTextXpath).isDisplayed();
			
			Thread.sleep(3000);		

		}
		public void verifyFourthSlideElements () throws InterruptedException {

			driver.findElement(By.id(secondSlideImageXpath)).isDisplayed();
			driver.findElementByXPath(exploreTextXpath).isDisplayed();
			driver.findElementByXPath(earnTextXpath).isDisplayed();
			driver.findElementByXPath(createNewWalletButtonXpath).click();
			Thread.sleep(3000);		

		}
		
		public void verifyLegalElements () throws InterruptedException {
			
			driver.findElementByXPath(legalTitleXpath).isDisplayed();
			driver.findElementByXPath(reviewTextXpath).isDisplayed();
			driver.findElementByXPath(privacyPolicyXpath).isDisplayed();
			driver.findElementByXPath(termsOfServiceXpath).isDisplayed();
			driver.findElement(By.id(acceptCheckboxButtonXpath)).isDisplayed();
			Thread.sleep(3000);
		}
		
		public void verifyPrivacyPopUpElements () throws InterruptedException {
			
			driver.findElementByXPath(privacyPolicyXpath).click();
			driver.findElementByXPath(privacyDocTitleXpath).isDisplayed();
			driver.findElement(By.id(closeButtonXpath)).click();
			Thread.sleep(3000);
		}

		public void termsOfServicePopUpElements () throws InterruptedException {

			driver.findElementByXPath(termsOfServiceXpath).click();
			driver.findElementByXPath(termsOfServiceTitleXpath).isDisplayed();
			driver.findElement(By.id(closeButtonXpath)).click();
			Thread.sleep(3000);
		}
		
		public void acceptAndContinue () throws InterruptedException {

			driver.findElement(By.id(acceptCheckboxButtonXpath)).click();
			driver.findElement(By.id(continueButtonXpath)).click();
			Thread.sleep(3000);
		}
		
		public void createPasscode() throws InterruptedException {
			
			  for (int i = 0; i < 6; i++) {
			  driver.findElementByXPath(clickNumber1Xpath).click(); 
			  }
			 
		}
		
		public void confirmPasscode() throws InterruptedException {

			  for (int i = 0; i < 6; i++) {
			  driver.findElementByXPath(clickNumber1Xpath).click(); 
			  }
		}
		
		public void secretPhraseAndManullyBackUp() throws InterruptedException {
			
			driver.findElementByXPath(secretPhraseTitleXpath).isDisplayed();
			driver.findElementByXPath(secretPhraseMsgXpath).isDisplayed();
			driver.findElementByXPath(backUpGDriveXpath).isDisplayed();
			driver.findElementByXPath(backUpManuallyXpath).click();
			
		}
		
		public void provideConsent() throws InterruptedException {
			
			driver.findElementByXPath(backUpTitleXpath).isDisplayed();
			driver.findElementByXPath(backUpMsgXpath).isDisplayed();
			driver.findElementByXPath(consent1Xpath).click();
			driver.findElementByXPath(consent2Xpath).click();
			driver.findElementByXPath(consent3Xpath).click();
			Thread.sleep(3000);
			driver.findElement(By.id(continueButtonXpath)).click();
			
		}
		
		public void captureSecretPhraseAndContinue() throws InterruptedException {

			driver.findElement(By.id("com.wallet.crypto.trustapp:id/action_copy")).click();
			Thread.sleep(1500);
			driver.findElement(By.id("com.wallet.crypto.trustapp:id/action_verify")).click();
			
		}
		
		public void verifySecretPhraseAndDone() throws InterruptedException {
			
			HasClipboard clipboardDriver = (HasClipboard) driver;
	        String clipboardData = clipboardDriver.getClipboardText();
	        System.out.println("Clipboard data: " + clipboardData);
	        
	        String[] correctOrderPhraseArray = clipboardData.split(" ");
	        System.out.println(Arrays.toString(correctOrderPhraseArray));
	        
	        for (int i = 0; i < correctOrderPhraseArray.length; i++) {
	            String phrase = correctOrderPhraseArray[i];
	            driver.findElementByXPath("//android.widget.TextView[@text=\"" + phrase + "\"]").click();
	        }
	        
			Thread.sleep(1500);
			driver.findElement(By.id("com.wallet.crypto.trustapp:id/action_done")).click();
			Thread.sleep(5000);

			
		}
		
		//***************Reusable swipe right to left Method*************************
		
		public void swipeRightToLeft() throws InterruptedException {
		    // create a TouchAction object
		    TouchAction touchAction = new TouchAction(driver);

		    // get the dimensions of the screen
		    Dimension screenSize = driver.manage().window().getSize();
		    int screenWidth = screenSize.getWidth();
		    int screenHeight = screenSize.getHeight();

		    // define the start and end coordinates for the swipe gesture
		    int startX = (int) (screenWidth * 0.9); // 80% of screen width
		    int endX = (int) (screenWidth * 0.1); // 20% of screen width
		    int y = (int) (screenHeight * 0.5); // middle of screen height

		    // perform the swipe gesture
		    touchAction.press(PointOption.point(startX, y)).moveTo(PointOption.point(endX, y)).release().perform();
		    Thread.sleep(3000);
		}
		
		
}
