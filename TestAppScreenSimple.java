package com.test.sample.page_object;

import io.appium.java_client.MobileElement;

import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.pagefactory.AndroidFindBys;


/**
 * Here is the common sample shows how to use
 * Appium annotations against iOS. It is perfectly similar
 * as {@link ApiDemosListViewScreenSimple}, {@link ApiDemosListViewScreenChaided}
 * and {@link ApiDemosListViewScreenByAllPossible}
 * 
 * About Page Object design pattern read here:
 * https://code.google.com/p/selenium/wiki/PageObjects
 *
 */
public class TestAppScreenSimple {

	/**
	 * Page Object best practice is to describe interactions with target 
	 * elements by methods. This methods describe business logic of the page/screen.
	 * Here lazy instantiated elements are public.
	 * It was done so just for obviousness
	 */
	
	@FindBy(className = "UIAButton")
	public List<WebElement> uiButtons;

	@FindBy(className = "UIAButton")
	public List<WebElement> iosUIButtons;

	
	@AndroidFindBy(className = "android.widget.TextView")
	public List<WebElement> androidOriOsTextViews;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/text1\")")
	public List<WebElement> androidUIAutomatorViews;

	public List<MobileElement> mobileButtons;

	@FindBy(className = "UIAButton")
	public List<MobileElement> mobiletFindBy_Buttons;

	public List<RemoteWebElement> remoteElementViews;

	@AndroidFindBys({
		@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/list\")"),
		@AndroidFindBy(className = "android.widget.TextView")
		})
	public List<WebElement> chainElementViews;

	@FindBy(className = "UIAButton")
	public WebElement uiButton;
	
	@AndroidFindBy(className = "android.widget.TextView")
	public WebElement androidOriOsTextView;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/text1\")")
	public WebElement androidUIAutomatorView;

	@FindBy(className = "UIAButton")
	public MobileElement mobiletFindBy_Button;

	@AndroidFindBys({
		@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/list\")"),
		@AndroidFindBy(className = "android.widget.TextView")
		})
	public WebElement chainElementView;
	
	public List<WebElement> findAllElements;

}
