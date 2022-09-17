package com.android.app;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class EcommerceBaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void configureAppium() throws MalformedURLException, InterruptedException {

		String path = System.getProperty("user.dir");
		System.out.println(path);

		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\chandan.rai\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("chandanemulator");
		options.setChromedriverExecutable("D:\\MobileAutomation\\MobileApp\\driver\\chromedriver.exe");
		options.setApp(path + "/app/General-Store.apk");
		URL url = new URL("http://127.0.0.1:4723");
		driver = new AndroidDriver(url, options);
		
		Thread.sleep(3000);

	}
	
	public void longPressAction(WebElement ele)
	{
		
		((JavascriptExecutor) driver).executeScript("mobile:longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	
		
	}
	
	public void scrollToEndAction()
	{
		boolean canScrollMore;
		do
		{
		
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 300, "top", 200, "width", 400, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));
		}while(canScrollMore);
		
		
	}
	
	
	
	
	public void swipeAction(WebElement ele,String direction)
	{
		

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) ele).getId(), "direction", direction, "percent", 0.75));
		
		
		
	}
	
	
	
	
	public Double getFormattedAmount(String amount)
	{
		
		Double price=Double.parseDouble(amount.substring(1));
		return price;
		
	}
	
	

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();

	}

}
