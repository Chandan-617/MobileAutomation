package com.android.app;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest {

	@Test
	public void browserTest() throws InterruptedException {

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");

		String title = driver.getTitle();
		System.out.println("The title of the page is : " + title);

		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
		
		Thread.sleep(3000);

		String text = driver.findElement(By.cssSelector("a[href*='products/3']")).getText();

		Assert.assertEquals(text, "Devops");

	}

}
