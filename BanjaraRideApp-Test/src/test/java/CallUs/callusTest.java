package CallUs;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import banjaraRideCapability.BRCapability;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


//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

public class callusTest {
	
		AndroidDriver<AndroidElement> driver;
	 @BeforeTest
	 public void setup() throws IOException, InterruptedException {
		 BRCapability.startAppium().start();
		 BRCapability.startEmulator();
		
		 
	 }
	 
	 @BeforeMethod
	 public void  beforetest() throws IOException, InterruptedException {
		 driver = BRCapability.capability();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 }
	 
	 @Test(enabled=true,priority = 0)
	 public void test() throws InterruptedException {
		 
//		 driver.findElement(By.xpath("//input[@text='ENGLISH']")).click();
//		 driver.findElement(MobileBy.AndroidUIAutomator("text(\"ENGLISH\")")).click();
//		 driver.findElement(MobileBy.AndroidUIAutomator("class(\"android.widget.LinearLayout\")")).click();
//		 driver.findElement(MobileBy.AndroidUIAutomator("text(\"Enter your mobile number\")")).sendKeys("8726795981");
		 
		 
		 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Call Us\"))")).click();

		 Thread.sleep(3000);
		 driver.navigate().back();
		 Thread.sleep(3000);
		 driver.navigate().back();
		 
		 
//		 driver.findElement(By.xpath("(//*[@class='android.widget.LinearLayout'])[5]")).click();
//		 driver.findElement(MobileBy.id("com.forbinary.banjararide:id/card_text")).click();
		 
//		 driver.findElement(MobileBy.AndroidUIAutomator("id(\"com.forbinary.banjararide:id/edtInput1\")")).sendKeys("OTP");
			
		
	}
	 
	 @Test(enabled=false,priority = 1)
 public void test02() throws InterruptedException {
		 

		 driver.findElement(MobileBy.AccessibilityId("Open")).click();
		 Thread.sleep(2000);
		 driver.findElement(MobileBy.AndroidUIAutomator("text(\"Information Center\")")).click();
//		 driver.findElement(MobileBy.id("btnOkay")).click();
//		 driver.findElement(MobileBy.id("info_center_grid_list")).click();

		 driver.findElement(By.xpath("//*[@text='Terms & Conditions']")).click();
		 driver.findElement(MobileBy.id("infocenterlib_page_name")).click();
		 driver.findElement(MobileBy.id("llFileLinearLayout")).click();
		 driver.findElement(By.xpath("//*[@text='OK']")).click();
//		 driver.findElement(By.xpath("//*[@text='ALLOW']")).click();
		 driver.findElement(MobileBy.AccessibilityId("More options")).click();
		 
		 driver.findElement(By.xpath("//*[@text='Download']")).click();
		 
//		 Thread.sleep(3000);
		 
		 
		 
//		 driver.findElement(By.xpath("//input[@text='ENGLISH']")).click();
//		 driver.findElement(MobileBy.AndroidUIAutomator("text(\"ENGLISH\")")).click();
//		 driver.findElement(MobileBy.AndroidUIAutomator("class(\"android.widget.LinearLayout\")")).click();
		
//		 driver.findElement(MobileBy.AndroidUIAutomator("text(\"Enter your mobile number\")")).sendKeys("8726795981");
//		 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Call Us\"))")).click();
//		 driver.findElement(MobileBy.xpath("(//android.widget.ImageButton[@content-desc='Open']")).click();
//		 driver.findElement(MobileBy.id("info_center_grid_list")).click();
//		 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Terms & Conditions\"))")).click();
		 //		 driver.findElement(MobileBy.AndroidUIAutomator("text(\"Terms & Conditions\")")).click();
//		 driver.findElement(MobileBy.AndroidUIAutomator("class(\"FrameLayout\")")).click();
//		 driver.findElement(By.xpath("(//*[@class='android.widget.FrameLayout'])[0]")).click();
//		 driver.findElement(MobileBy.id("com.forbinary.banjararide:id/card_text")).click();
		 
			
//		 android.widget.FrameLayout
//		 Thread.sleep(3000);
//		 driver.navigate().back();
//		 Thread.sleep(3000);
//		 driver.navigate().back();
//		 driver.findElement(MobileBy.AndroidUIAutomator("id(\"com.forbinary.banjararide:id/edtInput1\")")).sendKeys("OTP");
			
		
	}
	
	 
	 @AfterTest
	 public void close() throws IOException {
		 Runtime.getRuntime().exec("adb -e emu kill");
		 Runtime.getRuntime().exec("taskkill /F /IM node.exe");

	}

}
