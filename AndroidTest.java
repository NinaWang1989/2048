package com.test.sample;

import com.xamarin.testcloud.appium.EnhancedIOSDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.URL;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import com.test.sample.page_object.TestAppScreenSimple;

import com.xamarin.testcloud.appium.Factory;
import com.xamarin.testcloud.appium.EnhancedAndroidDriver;
import org.junit.rules.TestWatcher;
import org.junit.Rule;

public class AndroidTest {
	
	private static EnhancedAndroidDriver<MobileElement> driver;

	private TestAppScreenSimple uiTestApp;
    @Rule
    public TestWatcher watcher = Factory.createWatcher();
	
	@Before
	public void setUp() throws Exception {
        File appDir = new File("D:\\Users\\v-tuchen\\Desktop\\react-native\\AndroidReact1\\android\\app\\build\\outputs\\apk");
        File app = new File(appDir, "app-debug.apk");
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
	    capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.6");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "VisualStudio_android-23_x86_phone");
	    capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	    
	    uiTestApp = new TestAppScreenSimple();
	    //driver = new EnhancedIOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver = Factory.createAndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		System.out.println(driver.getPageSource());
		PageFactory.initElements(new AppiumFieldDecorator(driver), uiTestApp);
	}

	@After
	public void tearDown() throws Exception {
        driver.label("Stopping App");
		driver.quit();
	}
	
	/**
	 * Page Object best practice is to describe interactions with target 
	 * elements by methods. These methods describe business logic of the page/screen.
	 * Here test interacts with lazy instantiated elements directly.
	 * It was done so just for obviousness
	 */

	@Test
	public void findByElementsTest() {
        driver.label("text");
		//Assert.assertNotEquals(0, uiTestApp.uiButtons.size());
	}
	
}