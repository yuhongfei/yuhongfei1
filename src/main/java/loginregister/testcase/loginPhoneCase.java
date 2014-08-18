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

import loginregister.libs.ParseProperties;
import loginregister.libs.Wait;
import loginregister.loginpage.LoginPage;

public class loginPhoneCase {
	private  static WebDriver ffwb;
	private FirefoxProfile firefoxprofile;
	private String projectpath = System.getProperty("user.dir");		
	private ParseProperties data = new ParseProperties(System.getProperty("user.dir")+"\\tool\\test.properties"); 
	private Wait wa;
	
	@BeforeClass
	public void loadFf(){
		File firebug = new File(projectpath+"/tool/firebug-1.12.1-fx.xpi");
		File firepath = new File(projectpath+"/tool/firepath-0.9.7-fx.xpi");
		File sqlitemgr = new File(projectpath+"/tool/sqlite_manager-0.8.1-fx+tb+sm.xpi");
		firefoxprofile =  new FirefoxProfile();
		try{
				firefoxprofile.addExtension(firebug);
				firefoxprofile.addExtension(firepath);
				firefoxprofile.addExtension(sqlitemgr);
				firefoxprofile.setPreference("webdriver.accept.untrusted.certs", "true"); 
				firefoxprofile.setPreference("extensions.firebug.currentVersion", "1.12.1");
				
				ffwb = new FirefoxDriver(firefoxprofile);
				ffwb.manage().window().maximize();
				ffwb.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				wa = new Wait(ffwb);
		   } catch (IOException e){
			e.printStackTrace();
		}		
	}

	@Test
	public void openLoginPage(){
		LoginPage loginpage = new LoginPage(ffwb);
		loginpage.navigate("http://www.xigua365.com");
		wa.waitFor(5000);
		Assert.assertEquals(loginpage.LoginButton.isDisplayed(),true);
	}
	
	@Test
	public void loginPage(){
		LoginPage loginpage = new LoginPage(ffwb);	
		loginpage.navigate("http://www.xigua365.com");
		loginpage.loginButton();
		Assert.assertEquals(loginpage.Login.isDisplayed(), true);
	}
	
	@Test
	public void loginPageq(){
		LoginPage loginpage = new LoginPage(ffwb);	
		loginpage.navigate("http://www.xigua365.com");
		loginpage.loginButton();
		loginpage.qqLoginClick();
		Assert.assertEquals(loginpage.QqTile.isDisplayed(), true);
	}
	/**
   //第3方登陆出现问题，等第3方登陆好后再测试
	@Test
	public void loginPageTx(){
		loginPage loginpage = new loginPage(ffwb);	
		loginpage.navigate("http://www.xigua365.com");
		loginpage.loginButton();
		loginpage.qqLoginClick();
        loginpage.LoginToQqClick();
	} **/
	
	//输入用户名与密码为空的用例
	@Test
	public void loginPage1(){
		LoginPage loginpage = new LoginPage(ffwb);	
		loginpage.navigate("http://www.xigua365.com");
		loginpage.loginButton();
		loginpage.sendUserNameKey("");
		loginpage.sendUserPasswdKey("");
		loginpage.loginClick();
		Assert.assertEquals(loginpage.Error.isDisplayed(), true);
	}
	
	//输入手机号小于11位
	@Test
	public void loginPage2(){
		LoginPage loginpage = new LoginPage(ffwb);	
		loginpage.navigate("http://www.xigua365.com");
		loginpage.loginButton();
		loginpage.sendUserNameKey("13");
		loginpage.loginClick();
		Assert.assertEquals(loginpage.PhoneError.isDisplayed(), true);
	}
	
	//输入手机号大于11位
    @Test
	public void loginPage3(){
    	    LoginPage loginpage = new LoginPage(ffwb);	
			loginpage.navigate("http://www.xigua365.com");
			loginpage.loginButton();
			loginpage.sendUserNameKey("138740041345");
			loginpage.loginClick();
			Assert.assertEquals(loginpage.PhoneError.isDisplayed(), true);
		}
	
	//输入手机号输入英文
    @Test
	public void loginPage4(){
    	    LoginPage loginpage = new LoginPage(ffwb);	
			loginpage.navigate("http://www.xigua365.com");
			loginpage.loginButton();
			loginpage.sendUserNameKey("abc");
			loginpage.loginClick();
			Assert.assertEquals(loginpage.PhoneError.isDisplayed(), true);
		}
	
	//输入手机号输入中文
       @Test
	   public void loginPage5(){
    	    LoginPage loginpage = new LoginPage(ffwb);	
			loginpage.navigate("http://www.xigua365.com");
			loginpage.loginButton();
			loginpage.sendUserNameKey("abc");
			loginpage.loginClick();
			Assert.assertEquals(loginpage.PhoneError.isDisplayed(), true);
		}
    //
  //输入手机号输入html
    @Test
	public void loginPage6(){
    	    LoginPage loginpage = new LoginPage(ffwb);	
			loginpage.navigate("http://www.xigua365.com");
			loginpage.loginButton();
			loginpage.sendUserNameKey("<html></html>");
			loginpage.loginClick();
			Assert.assertEquals(loginpage.PhoneError.isDisplayed(), true);
		}
    //输入手机号输入xss
    @Test
	public void loginPage7(){
    	    LoginPage loginpage = new LoginPage(ffwb);	
			loginpage.navigate("http://www.xigua365.com");
			loginpage.loginButton();
			loginpage.sendUserNameKey("<script>alert('abc')</script>");
			loginpage.loginClick();
			Assert.assertEquals(loginpage.PhoneError.isDisplayed(), true);
		}
    
    //输入手机号输入xss
    @Test
	public void loginPage8(){
    	    LoginPage loginpage = new LoginPage(ffwb);	
			loginpage.navigate("http://www.xigua365.com");
			loginpage.loginButton();
			loginpage.sendUserNameKey("#@￥%……&*");
			loginpage.loginClick();
			Assert.assertEquals(loginpage.PhoneError.isDisplayed(), true);
		}
    
    //输入手机号输入xss
    @Test
	public void loginPage9(){
    	    LoginPage loginpage = new LoginPage(ffwb);	
			loginpage.navigate("http://www.xigua365.com");
			loginpage.loginButton();
			loginpage.sendUserNameKey("13522939122");
			loginpage.sendUserPasswdKey("");
			Assert.assertEquals(loginpage.PhoneTrue.isDisplayed(), true);
		} 
   //输入不存在的手机号，提示错误“邮箱或手机号格式不正确,请检查”
	@Test
    public void loginPage10(){
		LoginPage loginpage = new LoginPage(ffwb);	
		loginpage.navigate("http://www.xigua365.com");
		loginpage.loginButton();
		loginpage.sendUserNameKey("19923456789");
		loginpage.loginClick();
		Assert.assertEquals(loginpage.PhoneError.isDisplayed(), true);
	}
	
	@AfterClass
	public void quitFf(){
		ffwb.quit();
		
	}

}
