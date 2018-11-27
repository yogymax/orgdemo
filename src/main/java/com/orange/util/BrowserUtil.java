package com.orange.util;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.orange.util.AppConstant.BrowserTypes;
import com.orange.web.po.LoginPageObject;

public class BrowserUtil {

	public static WebDriver driver = null;
	
	public static LoginPageObject getWebDriverInstance(BrowserTypes browser){
		switch (browser) {
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", "E:\\MySofts\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case CHROME:
			System.setProperty("webdriver.chrome.driver", "E:\\MySofts\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
			break;
		case SAFARI:
			break;
		case OPERA:
			break;
		case IE: //win<=9 
			break;
		case EDGE: // win -- IE -- edge
			break;
		default:
			Assert.fail("Specified Browser support is not present " +browser);
			break;
		}
		driver.get(AppConstant.ORANGEHRM_LOGIN_URL);
		
		return PageFactory.initElements(driver,LoginPageObject.class);
	}

	public static boolean isElementPresent(WebElement element) {
		try{
			return element.isDisplayed();
		}catch(NoSuchElementException e){
			return false;
		}
	}
	
	
}
