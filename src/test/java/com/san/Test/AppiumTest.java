package com.san.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AppiumTest {
	//create instance of appium driver
	//SETUP:
	/*
	 * a. setup android SDK
	 * b. setup Appium server, it has node in-built, if not nodejs too
	 * c. set-up simulator or real device 
	 * d. dnld apk file or ios file to test
	 * e. configure the setting in appium and desiredcapabilites for specific device
	 * f. create maven based , testng project in java
	 * g. run and see the appium server itereating with mobile device 
	 */
	
	AndroidDriver driver;
	
	@BeforeClass
	public void Setup() throws MalformedURLException, InterruptedException{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME,"");
		cap.setCapability("deviceName", "9889a4484137465333");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appPackage", "io.selendroid.testapp");
		cap.setCapability("appActivity", ".HomeScreenActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	 
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc='my_text_fieldCD']")).sendKeys("Mukesh Selenium Appium");	  
		// click on registration button                                    
		driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration")).click();
		// Wait for 10 second
		Thread.sleep(10000);
		// close the application
		 driver.quit();	 
	}
	
	@Test
	void openMobileBrowser(){
		Assert.assertTrue(true);
		
	}

}
