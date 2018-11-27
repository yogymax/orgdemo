package orgAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orange.util.BrowserUtil;
import com.orange.util.AppConstant.BrowserTypes;
import com.orange.web.po.DashboardPageObject;
import com.orange.web.po.LoginPageObject;

public class LoginPageTest {

	@Test
	public void verifyUserLogin(){
		LoginPageObject loginPage = BrowserUtil.getWebDriverInstance(BrowserTypes.CHROME);
		loginPage.enterUserName("Admin");
		loginPage.enterPassword("admin123");
		DashboardPageObject dashboard = loginPage.clickOnloginSuccess();
		Assert.assertEquals(dashboard.getWelcomeText(), "Welcome Admin");
	}
	
	@Test(dataProvider="") //excelsheet
	public void checkUserCredentailsInvalidScenarios(){
		LoginPageObject loginPage = BrowserUtil.getWebDriverInstance(BrowserTypes.CHROME);
		loginPage.enterUserName("Admin");
		loginPage.enterPassword("admin123");
		DashboardPageObject dashboard = loginPage.clickOnloginSuccess();
		Assert.assertEquals(dashboard.getWelcomeText(), "Welcome Admin");
	}
	
}
