package jd1test;

import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import banjaraRideCapability.BRCapability;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class jdTestClass {
	AndroidDriver<AndroidElement> driver;
 @BeforeTest
 public void setup() throws IOException, InterruptedException {
	 BRCapability.startAppium().start();
	 BRCapability.startEmulator();
	 driver = BRCapability.capability();
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 
 }
 
 @Test(priority=0)
 public void test() throws InterruptedException {
	 AndroidElement booknow= driver.findElement(By.id("com.forbinary.banjararide:id/link_2")); 
  	TouchAction  taction=new TouchAction(driver);
  	taction.tap(TapOptions.tapOptions().withElement(element(booknow))).perform();
  	AndroidElement hirebike= driver.findElement(By.xpath("//*[@text='Hire Bike']"));
   	taction.tap(TapOptions.tapOptions().withElement(element(hirebike))).perform();
   	AndroidElement CBHornet160R= driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"CB Hornet 160R\"))"));
   	taction.tap(TapOptions.tapOptions().withElement(element(CBHornet160R))).perform();
   	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Price\"))"));                      
 
         
   	List<AndroidElement> elements = driver.findElements(MobileBy.AndroidUIAutomator("new UiSelector().resourceIdMatches(\"com.forbinary.banjararide:id/tvDuration\")"));
    System.out.println("elements size: " + elements.size());
    TapOptions tapOptions;
    tapOptions = new TapOptions().withElement(ElementOption.element(elements.get(6))); // first 'button1' button
    new TouchAction(driver).tap(tapOptions).perform();
     Thread.sleep(3000);
    
   	//AndroidElement booknow1= driver.findElement(By.xpath("//*[@text='Book Now']"));
   	//taction.tap(TapOptions.tapOptions().withElement(element(booknow1))).perform();
   	AndroidElement booknow1= driver.findElement(By.xpath("//*[@text='Book Now']"));
   	taction.tap(TapOptions.tapOptions().withElement(element(booknow1))).perform();
  // 	AndroidElement clickcal= driver.findElement(By.xpath("//*[@text='25-05-2023']"));
	AndroidElement clickcal= driver.findElement(By.id("com.forbinary.banjararide:id/tvDate"));
   	taction.tap(TapOptions.tapOptions().withElement(element(clickcal))).perform();
   	AndroidElement cd= driver.findElement(By.xpath("//*[@text='31']"));
   	taction.tap(TapOptions.tapOptions().withElement(element(cd))).perform();
	AndroidElement cok= driver.findElement(By.id("android:id/button1"));
   	taction.tap(TapOptions.tapOptions().withElement(element(cok))).perform();
   	 driver.navigate().back();
   	Thread.sleep(3000);
   	driver.navigate().back();
   	Thread.sleep(3000);
   	driver.navigate().back();
   	Thread.sleep(3000);
   	driver.navigate().back();
   	Thread.sleep(3000);
}
  @Test(priority=1)
  public void test1() throws InterruptedException {
	  driver.findElement(MobileBy.AccessibilityId("Open")).click();
	  driver.findElement(By.xpath("//*[@text='Share']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@text='Gmail']")).click();
	  Thread.sleep(10000);
	  driver.findElement(By.className("android.widget.EditText")).sendKeys("pj34837@gmail.com");
	  Thread.sleep(9000);
	  driver.findElement(By.xpath("//*[@text='pj34837@gmail.com']")).click();
	  Thread.sleep(9000);
	  driver.findElement(By.className("android.widget.RelativeLayout")).click();
	  driver.findElement(By.xpath("//*[@text='Subject']")).sendKeys("jd1");
	  Thread.sleep(9000);
	  //driver.findElement(By.xpath("//*[@bounds='[44,751][1039,869]']")).sendKeys("hello everyone,how are you?");
	  
	  driver.findElement(By.id("com.google.android.gm:id/send")).click();
	  Thread.sleep(9000);
  }
 @AfterTest
 public void close() throws IOException {
	 Runtime.getRuntime().exec("adb -e emu kill");
	 Runtime.getRuntime().exec("taskkill /F /IM node.exe");

}
}
