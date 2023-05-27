package Extest;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.reporters.XMLStringBuffer;

import banjaraRideCapability.BRCapability;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import static io.appium.java_client.touch.offset.PointOption.point;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import static io.appium.java_client.touch.WaitOptions.waitOptions;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class TestClass {
	AndroidDriver<AndroidElement> driver;
	WebDriverWait wait;
	TouchAction action;
 @BeforeTest
 public void setup() throws IOException, InterruptedException{
	 BRCapability.startAppium().start();
	 BRCapability.startEmulator();
 }
 @BeforeMethod
 public void launch() throws IOException, InterruptedException {
	 driver = BRCapability.capability();
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	wait = new WebDriverWait(driver, 20);
	 action = new TouchAction(driver);
	
}
 @Test(enabled = true,priority = 0)
 public void test01() throws InterruptedException {
//	 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"BOOK NOW\"))")).click();
	 driver.findElementByAccessibilityId("Open").click();
//	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Bookings']"))).click();
	 driver.findElement(By.xpath("//*[@text='Bookings']")).click();
	 driver.findElement(By.id("com.forbinary.banjararide:id/search_button")).click();
	 driver.findElement(By.id("com.forbinary.banjararide:id/search_src_text")).sendKeys("activa");
	 AndroidElement ele = driver.findElement(By.id("com.forbinary.banjararide:id/search_close_btn"));
	 action.tap(tapOptions().withElement(element(ele))).release().perform().waitAction(waitOptions(Duration.ofSeconds(3)));
	 driver.hideKeyboard();
	 driver.pressKey(new KeyEvent(AndroidKey.BACK));
	 
}
 @Test(enabled = true,priority = 1)
 public void test02() throws InterruptedException {
	 driver.findElementByAccessibilityId("Open").click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//*[@text='Profile']")).click();
	 driver.findElement(By.id("com.forbinary.banjararide:id/action_edit")).click();
	 Thread.sleep(3000);
	 AndroidElement text =driver.findElement(By.id("com.forbinary.banjararide:id/edtInputProfile"));
	 text.click();
	 driver.pressKey(new KeyEvent(AndroidKey.DEL));
	 text.sendKeys("k");
	 Thread.sleep(1000);
	 driver.findElement(By.id("com.forbinary.banjararide:id/action_save")).click();
	 driver.hideKeyboard();
	 
}
 @Test(enabled = true,priority = 2)
 public void test03() throws InterruptedException {
	 driver.findElement(By.xpath("//*[@text='About Us']")).click();
//	waitOptions(Duration.ofSeconds(3));
	 driver.findElement(By.xpath("//*[@text='About Company!']")).click();
	 String desc = driver.findElement(By.id("com.forbinary.banjararide:id/infocenterlib_page_description")).getText();
	 Assert.assertTrue(desc.contains("Bhopal"));
	 driver.pressKey(new KeyEvent(AndroidKey.BACK));
	 waitOptions(Duration.ofSeconds(5));
	 driver.pressKey(new KeyEvent(AndroidKey.BACK));
 }
 @Test(enabled = true,priority = 3)
 public void test04() throws InterruptedException {
	 driver.findElementByAccessibilityId("Open").click();
	 driver.findElement(By.xpath("//*[@text='Information Center']")).click();
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//*[@text='About Us']")).click();
	 driver.findElement(By.xpath("//*[@text='Address And Contact Number.']")).click();
	 driver.pressKey(new KeyEvent(AndroidKey.BACK));
	 waitOptions(Duration.ofSeconds(5));
	 driver.pressKey(new KeyEvent(AndroidKey.BACK));
}
 @Test(enabled = false,priority = 4)
 public void contextSwitch() throws InterruptedException {
	 System.out.println(driver.getContext());
	 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Rate Us On Google\"))")).click();
	 Thread.sleep(3000);
	 System.out.println(driver.getContext());
	 driver.context("WEBVIEW_chrome");
//	 Assert.assertEquals(driver.findElement(By.id("headingText")).getText(), "Sign in");
	 driver.findElementByAccessibilityId("Close tab").click();
	 driver.context("NATIVE_APP");
	 Boolean dis = driver.findElement(By.xpath("//*[@text='BanjaraRide']")).isDisplayed();
	 Assert.assertTrue(dis);
//	 ["NATIVE_APP","WEBVIEW_chrome"]
 }
 
 @Test(enabled = true,priority = 5)
 public void changeLang() throws InterruptedException {
	 driver.findElementByAccessibilityId("Open").click();
	 driver.findElement(By.xpath("//*[@text='Change Language']")).click();
	 driver.findElement(By.xpath("//*[@text='हिंदी']")).click();
	 Thread.sleep(3000);
	 driver.findElementByAccessibilityId("Open").click();
	 driver.findElement(By.xpath("//*[@text='भाषा बदलो']")).click();
	 driver.findElement(By.xpath("//*[@text='ENGLISH']")).click();
}
 @Test(enabled = true,priority = 6)
 public void closeSwipeApp() throws InterruptedException {
	 driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
	 Thread.sleep(3000);
	driver.findElementByAccessibilityId("Dismiss BanjaraRide.").click();
	 
//	AppSwitch
}
 @AfterTest
 public void close() throws IOException {
	 Runtime.getRuntime().exec("adb -e emu kill");
	 Runtime.getRuntime().exec("taskkill /F /IM node.exe");

}
}
