package com.orange.web.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.orange.util.BrowserUtil;

public class DashboardPageObject {
	
	@FindBy(id="welcome")
	WebElement welcomeMsg;
	
	@FindBy(className="menu")
	WebElement menus;
	

	public String getWelcomeText(){
		if(BrowserUtil.isElementPresent(welcomeMsg)){
			return welcomeMsg.getText();
		}
		return null;
	}
	
	
}
