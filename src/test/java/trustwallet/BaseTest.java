package trustwallet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

//import EcommerceApp.AppiumServiceBuilder;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public static AndroidDriver<AndroidElement> driver;
	public static AppiumDriverLocalService service;
	
	@BeforeClass(alwaysRun = true)
	public static void capabilities() throws IOException, InterruptedException {
		
		service=startServer();
		//Implementing properties concept
		System.getProperty("user.dir");
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("user.home"));
		
		//FileReader reader=new FileReader(System.getProperty("user.dir")+"\\Config.properties");  
		
		FileReader reader = new FileReader(System.getProperty("user.dir") + File.separator + "Config.properties");


		Properties p=new Properties();  
		p.load(reader);  
		System.out.println(p.getProperty("App"));
		System.out.println(p.getProperty("device"));
		
		//File appDir = new File("src\\APKS\\");
		
		File appDir = new File("src" + File.separator + "APKS" + File.separator);

		File app = new File(appDir, p.getProperty("App"));    //Getting app name from properties file
		DesiredCapabilities  DC = new DesiredCapabilities();
		
		startEmulator();
		DC.setCapability(MobileCapabilityType.DEVICE_NAME, p.getProperty("device")); //Getting device name from properties file
		
		DC.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		DC.setCapability("appPackage", "com.wallet.crypto.trustapp"); 
	    DC.setCapability("appActivity","com.wallet.crypto.trustapp.ui.start.activity.RootHostActivity");
	    //DC.setCapability("noReset", true);
	    //DC.setCapability("autoGrantPermissions",true);
	   // DC.setCapability("appWaitActivity","com.wallet.crypto.trustapp.ui.addwallet.activity.AddWalletActivity");
	    //DC.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "com.wallet.*");
		//UI Automator -> Android Apps
		// uiautomator2
		
		DC.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),DC);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//return driver;

	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
		service.stop();
	}

	public static AppiumDriverLocalService startServer()  {

		boolean flag = CheckIfServerIsRunning(4723);

		if (!flag) {
			
			// With Hardcoded path
			/*
			 * service = AppiumDriverLocalService.buildService(new
			 * AppiumServiceBuilder().withAppiumJS //(new
			 * File("C:\\Windows\\System32\\node_modules\\appium\\build\\lib\\main.js")));
			 * (new File(
			 * "C:\\Users\\paart\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"
			 * )));
			 */
			
			// Without Hard coded path
			
			String appiumJsPath = System.getProperty("user.home") + File.separator + "AppData" + File.separator + "Roaming" + File.separator + "npm" + File.separator + "node_modules" + File.separator + "appium" + File.separator + "build" + File.separator + "lib" + File.separator + "main.js";
			File appiumJsFile = new File(appiumJsPath);

			service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().withAppiumJS(appiumJsFile));

			service.start();
		}
		return service;   
	}
	
	public static void startEmulator() throws IOException, InterruptedException {
		//Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\Utilities\\startEmulator.bat");
		Runtime.getRuntime().exec(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Utilities" + File.separator + "startEmulator.bat");
		Thread.sleep(6000);
	}
	
	public static boolean CheckIfServerIsRunning(int port) {

		boolean isServerRunning=false;
		ServerSocket serverSocket;
		try {
			serverSocket=new ServerSocket(port);
			serverSocket.close();
		}
		catch(IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		}
		finally {
			serverSocket=null;
		} return isServerRunning;
	}
	
	public static String getScreenshot (String testCaseName) throws IOException {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String destinationFile = System.getProperty("user.dir") + "//Reports//Screenshots//" +testCaseName +".png";
		String destinationFile = System.getProperty("user.dir") + File.separator + "Reports" + File.separator + "Screenshots" + File.separator + testCaseName + ".png";
		FileUtils.copyFile(src,new File(destinationFile));
		return destinationFile;
		
		}
		 
		

}
