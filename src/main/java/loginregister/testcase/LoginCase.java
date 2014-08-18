package loginregister.testcase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import loginregister.data.LoginPageMessage;
import loginregister.libs.ParseProperties;
import loginregister.libs.Test_ShotScreen;
import loginregister.libs.Wait;
import loginregister.loginpage.LoginPage;
import loginregister.loginpage.LoginPageObject;

public class LoginCase {
	private  static WebDriver ffwb = null;
	private FirefoxProfile firefoxprofile;
	private String projectpath = System.getProperty("user.dir");		
	private ParseProperties data = new ParseProperties(System.getProperty("user.dir")+"\\tool\\test.properties"); 
	private Wait wa;
	private LoginPageObject lc ;
	private LoginPage loginpage = null;
	LoginPageMessage lgMessage = null;
	Test_ShotScreen testscreen = null;
	
	
	
	@BeforeClass
	public void loadFf(){
		ffwb =new FirefoxDriver();
		ffwb.manage().window().maximize();
		ffwb.get("http://www.xigua365.com/index.php/auth/login");
	
		
	    
		}		
	//缺少。
	public void login1() {
		wa.typeKeys("//input[@name='account_name']","chinaface66@163com");
		wa.typeKeys("//input[@name='passwd']", "111111");
		wa.click("//button[text()='登录']");
	//	Assert.assertEquals(lc, expected);
	}
	
	
	//缺少.
		@Test(description="Navigates to the admin page")  
		public void loginPage3(){
			loginpage = new LoginPage(ffwb);
			loginpage.navigate("http://www.xigua365.com");
			loginpage.loginButton();
			loginpage.sendUserNameKey("hunanmen@126com");
			loginpage.sendUserPasswdKey("");
			loginpage.loginClick();
			Assert.assertEquals(loginpage.PhoneError.isDisplayed(), true);
		}
		
  
	
	@AfterClass
	public void quitFf(){
		ffwb.quit();
		
	}

}
