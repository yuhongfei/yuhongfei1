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

public class LoginEmailCase {
	private  static WebDriver ffwb = null;
	private FirefoxProfile firefoxprofile;
	private String projectpath = System.getProperty("user.dir");		
	private ParseProperties data = new ParseProperties(System.getProperty("user.dir")+"\\tool\\test.properties"); 
	private Wait wa;
	private LoginPage loginpage = null;
	LoginPageMessage lgMessage = null;
	Test_ShotScreen testscreen = null;
	
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
				testscreen = new Test_ShotScreen();
				ffwb = new FirefoxDriver(firefoxprofile);
				ffwb.manage().window().maximize();
				ffwb.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				wa = new Wait(ffwb);
		   } catch (IOException e){
			e.printStackTrace();
		}		
	}
	
	
   /**第3方登陆出现问题，等第3方登陆好后再测试
	@Test
	public void loginPagexinlang(){
		loginPage loginpage = new loginPage(ffwb);	
		loginpage.navigate("http://www.xigua365.com");
		loginpage.loginButton();
		loginpage.qqLoginClick();
        loginpage.LoginToQqClick();
	} **/
	
	
	//缺少@
	@Test
	public void loginPage2(){
		if(ffwb == null)
			System.out.println("----------------ffwb is null-----------");
		loginpage = new LoginPage(ffwb);
		//loginpage.navigate("http://www.xigua365.com");
		loginpage.navigate(lgMessage.URL);
		loginpage.loginButton();
		try{
	           testscreen.takeScreenShot(ffwb,"缺少@用例");
	       }catch(Exception e){
	        	e.printStackTrace();
	       }
		loginpage.sendUserNameKey("hunanmen@");
		loginpage.sendUserPasswdKey("");
		loginpage.loginClick();
		Assert.assertEquals(loginpage.PhoneError.isDisplayed(), false);
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
		
    //多个以上的@
		@Test
		public void loginPage4(){
			loginpage = new LoginPage(ffwb);
			loginpage.navigate("http://www.xigua365.com");
			loginpage.loginButton();
			loginpage.sendUserNameKey("hunanmen@@126.com");
			loginpage.sendUserPasswdKey("");
			loginpage.loginClick();
			Assert.assertEquals(loginpage.PhoneError.isDisplayed(), true);
		}
		
	    //输入中文邮箱
			@Test
			public void loginPage5(){
				loginpage = new LoginPage(ffwb);
				loginpage.navigate("http://www.xigua365.com");
				loginpage.loginButton();
				loginpage.sendUserNameKey("中国@@126.com");
				loginpage.sendUserPasswdKey("");
				loginpage.loginClick();
				Assert.assertEquals(loginpage.PhoneError.isDisplayed(), true);
			}
			
		    //输入正确的邮箱
				@Test
				public void loginPage6(){
					loginpage = new LoginPage(ffwb);
					loginpage.navigate("http://www.xigua365.com");
					loginpage.loginButton();
					loginpage.sendUserNameKey("hunanmen@126.com");
					loginpage.sendUserPasswdKey("");
					loginpage.loginClick();
					Assert.assertEquals(loginpage.PhoneTrue.isDisplayed(), true);
				}
				
			    //输入不存在正确的邮箱，跳转到密码错误中间页
					@Test
					public void loginPage7(){
						loginpage = new LoginPage(ffwb);
						loginpage.navigate("http://www.xigua365.com");
						loginpage.loginButton();
						loginpage.sendUserNameKey("hunanmen0987@126.com");
						loginpage.sendUserPasswdKey("168816");
						loginpage.loginClick();
						Assert.assertEquals(loginpage.Login.isDisplayed(), true);
					}
					
				//密码输入长度小于6
					@Test
					public void loginPage8(){
						loginpage = new LoginPage(ffwb);
						loginpage.navigate("http://www.xigua365.com");
						loginpage.loginButton();
						loginpage.sendUserNameKey("hunanmen0987@126.com");
						loginpage.sendUserPasswdKey("16881");
						loginpage.loginClick();
						Assert.assertEquals(loginpage.PasswdLengthSix.isDisplayed(), true);
					}
					
					//密码输入长度大于16
					@Test
					public void loginPage9(){
						loginpage = new LoginPage(ffwb);
						loginpage.navigate("http://www.xigua365.com");
						loginpage.loginButton();
						loginpage.sendUserNameKey("hunanmen0987@126.com");
						loginpage.sendUserPasswdKey("16881423456789056");
						loginpage.loginClick();
						Assert.assertEquals(loginpage.PasswdLengthSix.isDisplayed(), true);
					}
					
					//密码输入特殊符号@&等
					@Test
					public void loginPage10(){
						loginpage = new LoginPage(ffwb);
						loginpage.navigate("http://www.xigua365.com");
						loginpage.loginButton();
						loginpage.sendUserNameKey("hunanmen0987@126.com");
						loginpage.sendUserPasswdKey("168814@#&");
						loginpage.loginClick();
						Assert.assertEquals(loginpage.PasswdLengthSix.isDisplayed(), true);
					}
					
				    //输入存在正确的邮箱错误的密码，跳转到密码错误中间页
					@Test
					public void loginPage11(){
						loginpage = new LoginPage(ffwb);
						loginpage.navigate("http://www.xigua365.com");
						loginpage.loginButton();
						loginpage.sendUserNameKey("yeweiwei@126.com");
						loginpage.sendUserPasswdKey("yewei16881623");
						loginpage.loginClick();
						Assert.assertEquals(loginpage.Login.isDisplayed(), true);
					}
					//14天登陆复选框是否选中
					@Test 
					public void loginPage12(){
						loginpage.loginButton();
						Assert.assertEquals(loginpage.Checkbox14Day.isEnabled(), true);
					}
					//14天登陆复选框选中后是否被选中
					@Test
					public void loginPage13(){
						loginpage.loginButton();
						loginpage.checkbox14DayClick();
						Assert.assertEquals(loginpage.Checkbox14Day.isSelected(), true);
					}
					
					 //输入错误密码3次出现验证码
					@Test
					public void loginPage14(){
						loginpage = new LoginPage(ffwb);
						loginpage.navigate("http://www.xigua365.com");
						loginpage.loginButton();
						for(int i=1;i<4;i++){
							loginpage.sendUserNameKey("yeweiwei@126.com");
							loginpage.sendUserPasswdKey("yewei168816");
							loginpage.loginClick();
							wa.waitFor(2000);
						}
						Assert.assertEquals(loginpage.MCode.isDisplayed(), true);
					}
	
	@AfterClass
	public void quitFf(){
		ffwb.quit();
		
	}

}
