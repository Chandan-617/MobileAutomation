package com.android.app;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Ecommerce_TC_1 extends EcommerceBaseTest {

	@Test
	public void fillForm() throws InterruptedException {

		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Lovely");

		driver.hideKeyboard();

		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();

		driver.findElement(By.id("android:id/text1")).click();

		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		Thread.sleep(3000);

		String toastmessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");

		Assert.assertEquals(toastmessage, "Please enter your name");

	}

}
