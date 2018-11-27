package com.orange.web.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orange.util.BrowserUtil;

public class LoginPageObject {

	@FindBy(id="txtUsername")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginBtn;
	
	@FindBy(id="spanMessage")
	WebElement errorMessage;
	
	public void enterUserName(String uname){
		this.username.clear();
		this.username.sendKeys(uname);
	}
	
	public void enterPassword(String pwd){
		this.password.clear();
		this.password.sendKeys(pwd);
	}
	
	public DashboardPageObject clickOnloginSuccess(){
		this.loginBtn.click();
		return PageFactory.initElements(BrowserUtil.driver,DashboardPageObject.class);
	}
	
	public void clickOnlogin(){
		this.loginBtn.click();
	}
	
	public String getErrorMessage(){
		if(BrowserUtil.isElementPresent(errorMessage)){
			return errorMessage.getText();
		}
		return null;
	}
	
}
