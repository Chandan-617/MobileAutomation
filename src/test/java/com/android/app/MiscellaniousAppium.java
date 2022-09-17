package com.android.app;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MiscellaniousAppium extends BaseTest {

	@Test
	public void miscellinous() throws MalformedURLException {
		
		
		
		//For Mac/Linux:

		/*
		 * adb shell dumpsys window | grep -E 'mCurrentFocus' For Windows:
		 * 
		 * adb shell dumpsys window | find "mCurrentFocus"
		 */

		Activity activity=new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");

		driver.startActivity(activity);
		
		//driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		//driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();

		driver.findElement(By.id("android:id/checkbox")).click();
		
		DeviceRotation landscape=new DeviceRotation(0,0,90);
		
		driver.rotate(landscape);
		
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		String text=driver.findElement(By.id("android:id/alertTitle")).getText();
		
		System.out.println(text);
		Assert.assertEquals(text, "WiFi settings");
		
		driver.setClipboardText("chandan wifi");
		
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
	}

}
