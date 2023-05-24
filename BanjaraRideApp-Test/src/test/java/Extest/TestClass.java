package Extest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import banjaraRideCapability.BRCapability;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TestClass {
	AndroidDriver<AndroidElement> driver;
 @BeforeTest
 public void setup() throws IOException, InterruptedException {
	 BRCapability.startAppium().start();
	 driver = BRCapability.capability();
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 
 }
 @Test
 public void test() {
	
}
 @AfterTest
 public void close() throws IOException {
	 Runtime.getRuntime().exec("adb -e emu kill");
	 Runtime.getRuntime().exec("taskkill /F /IM node.exe");

}
}
