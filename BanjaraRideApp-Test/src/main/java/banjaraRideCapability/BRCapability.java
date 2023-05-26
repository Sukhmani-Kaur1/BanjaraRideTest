package banjaraRideCapability;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BRCapability {
	public static String deviceName;
	public static String platformName;
	public static String appPackage;
	public static String appActivity;
	public static Process rt;
	public static AppiumDriverLocalService service;
	
	public static AppiumDriverLocalService startAppium() {
	service= AppiumDriverLocalService.buildDefaultService();
	return service;
	}
	
	@SuppressWarnings("deprecation")
	public static void startEmulator() throws IOException, InterruptedException {
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\emulator.bat");

		Thread.sleep(6000);
	}
public static AndroidDriver<AndroidElement> capability() throws IOException, InterruptedException {

	FileReader fReader = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
	Properties ps = new Properties();
	ps.load(fReader);
	deviceName = ps.getProperty("deviceName");
	platformName = ps.getProperty("platformName");
	appPackage = ps.getProperty("appPackage");
	appActivity = ps.getProperty("appActivity");
	
	
	DesiredCapabilities dc = new DesiredCapabilities();
	dc.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
	dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
	dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
	dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
	dc.setCapability("additionalWebviewBundleIds", "process-awesomeAppDebug");
	dc.setCapability(MobileCapabilityType.NO_RESET, true);
	dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, System.getProperty("user.dir")+"\\chromedriver.exe");
	AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
	return driver;
}
}
