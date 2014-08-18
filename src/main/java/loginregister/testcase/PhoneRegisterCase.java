package loginregister.testcase;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import loginregister.data.LoginPageMessage;
import loginregister.libs.MysqlDBO;
import loginregister.libs.ParseProperties;
import loginregister.libs.Test_ShotScreen;
import loginregister.libs.Wait;
import loginregister.loginpage.LoginPage;
import loginregister.registerpage.RegisterPage;
/**
 * 点击喜瓜首页注册，使用手机注册，检查手机注册相关的用例
 * @author Kevin
 * 
 */
public class PhoneRegisterCase {
	private  static WebDriver ffwb;
	private FirefoxProfile firefoxprofile;
	private String projectpath = System.getProperty("user.dir");		
	private ParseProperties data = new ParseProperties(System.getProperty("user.dir")+"\\tool\\test.properties"); 
	private Wait wa;
	Test_ShotScreen testscreen = null;
	MysqlDBO test = null;
	
	
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
				test = new MysqlDBO("register_verify");
				testscreen = new Test_ShotScreen();
				ffwb = new FirefoxDriver(firefoxprofile);
				ffwb.manage().window().maximize();
				ffwb.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				wa = new Wait(ffwb);
		   } catch (IOException e){
			e.printStackTrace();
		}		
	}
	

	@Test
	public void openHomePage(){
		RegisterPage registerpage = new RegisterPage(ffwb);
		registerpage.navigate(LoginPageMessage.URL);
		wa.waitForElementIsEnable(registerpage.getRegisterButton());
		testscreen.highlightElement(ffwb, registerpage.getRegisterButton());
		try{
	         testscreen.takeScreenShot(ffwb,"喜瓜首页注册按钮显示，无破图");
	       }catch(Exception e){
	        	e.printStackTrace();
	       }
		Assert.assertEquals(registerpage.getRegisterButton().isDisplayed(),true);
	}

	
	@Test
	public void openRegisterPage(){
		RegisterPage registerpage = new RegisterPage(ffwb);
		registerpage.navigate("http://www.xigua365.com");
		registerpage.clickRegisterButton();
		testscreen.highlightElement(ffwb, registerpage.getRegisterLoginButton());
		try{
	         testscreen.takeScreenShot(ffwb,"点击注册按钮打开注册页面");
	       }catch(Exception e){
	        	e.printStackTrace();
	       }
		wa.waitForElementIsEnable(registerpage.getRegisterLoginButton());
		Assert.assertEquals(registerpage.getRegisterLoginButton().isDisplayed(),true);
	}
	
	@Test
	public void userNameDefault(){
		RegisterPage registerpage = new RegisterPage(ffwb);
		registerpage.navigate("http://www.xigua365.com");
		registerpage.clickRegisterButton();
		testscreen.highlightElement(ffwb, registerpage.getUserNameDefault());
		try{
	         testscreen.takeScreenShot(ffwb,"用户名输入框的默认值为“电子邮箱或手机号”");
	       }catch(Exception e){
	        	e.printStackTrace();
	       }
		wa.waitForElementIsEnable(registerpage.getUserNameDefault());
		Assert.assertEquals(registerpage.getUserNameString("placeholder"),"电子邮箱或手机号");
	}
	
	@Test
	public void userNameNull(){
		RegisterPage registerpage = new RegisterPage(ffwb);
		registerpage.navigate("http://www.xigua365.com");
		registerpage.clickRegisterButton();
		registerpage.setUserName(" ");
		registerpage.clickRegisteButton();
		wa.waitForElementIsEnable(registerpage.getUserNameDefault());
		testscreen.highlightElement(ffwb, registerpage.getUserNameNull());
		try{
	         testscreen.takeScreenShot(ffwb,"用户名输入为空");
	       }catch(Exception e){
	        	e.printStackTrace();
	       }
		Assert.assertEquals(registerpage.getUserNameNull().isDisplayed(),true);
	}
	
	@Test
	public void userNamePhoneError(){
		RegisterPage registerpage = new RegisterPage(ffwb);
		String phone = "139229"+testscreen.getPhone();
		registerpage.navigate("http://www.xigua365.com");
		registerpage.clickRegisterButton();
		registerpage.setUserName(phone);
		registerpage.clickRegisteButton();
		wa.waitForElementIsEnable(registerpage.getUserNamePhoneError());
		testscreen.highlightElement(ffwb, registerpage.getUserNamePhoneError());
		try{
	         testscreen.takeScreenShot(ffwb,"输入的手机号小于11位");
	       }catch(Exception e){
	        	e.printStackTrace();
	       }
		Assert.assertEquals(registerpage.getUserNamePhoneError().isDisplayed(),true);
	}
	
	@Test
	public void userNamePhoneErrorEglish(){
		RegisterPage registerpage = new RegisterPage(ffwb);
		registerpage.navigate("http://www.xigua365.com");
		registerpage.clickRegisterButton();
		registerpage.setUserName("138yeweuweu");
		registerpage.clickRegisteButton();
		wa.waitForElementIsEnable(registerpage.getUserNamePhoneError());
		testscreen.highlightElement(ffwb, registerpage.getUserNamePhoneError());
		try{
	         testscreen.takeScreenShot(ffwb,"输入的为英文的手机号");
	       }catch(Exception e){
	        	e.printStackTrace();
	       }
		Assert.assertEquals(registerpage.getUserNamePhoneError().isDisplayed(),true);
	}
	
	@Test
	public void userNamePhoneErrorChinese(){
		RegisterPage registerpage = new RegisterPage(ffwb);
		registerpage.navigate("http://www.xigua365.com");
		registerpage.clickRegisterButton();
		registerpage.setUserName("138中国");
		registerpage.clickRegisteButton();
		wa.waitForElementIsEnable(registerpage.getUserNamePhoneError());
		testscreen.highlightElement(ffwb, registerpage.getUserNamePhoneError());
		try{
	         testscreen.takeScreenShot(ffwb,"输入的手机号与中文混合");
	       }catch(Exception e){
	        	e.printStackTrace();
	       }
		Assert.assertEquals(registerpage.getUserNamePhoneError().isDisplayed(),true);
	}
	
	@Test
	public void userNamePhoneErrorHtml(){
		RegisterPage registerpage = new RegisterPage(ffwb);
		registerpage.navigate("http://www.xigua365.com");
		registerpage.clickRegisterButton();
		registerpage.setUserName("<body bgcolor=#rrggbb>");
		registerpage.clickRegisteButton();
		wa.waitForElementIsEnable(registerpage.getUserNamePhoneError());
		testscreen.highlightElement(ffwb, registerpage.getUserNamePhoneError());
		try{
	         testscreen.takeScreenShot(ffwb,"输入的手机号为html代码");
	       }catch(Exception e){
	        	e.printStackTrace();
	       }
		Assert.assertEquals(registerpage.getUserNamePhoneError().isDisplayed(),true);
	}
	
	@Test
	public void userNamePhoneErrorJscript(){
		RegisterPage registerpage = new RegisterPage(ffwb);
		registerpage.navigate("http://www.xigua365.com");
		registerpage.clickRegisterButton();
		registerpage.setUserName("<a href=\"javascript:self.close();\">关闭窗口</a>");
		registerpage.clickRegisteButton();
		wa.waitForElementIsEnable(registerpage.getUserNamePhoneError());
		testscreen.highlightElement(ffwb, registerpage.getUserNamePhoneError());
		try{
	         testscreen.takeScreenShot(ffwb,"输入的手机号为Jscript代码");
	       }catch(Exception e){
	        	e.printStackTrace();
	       }
		Assert.assertEquals(registerpage.getUserNamePhoneError().isDisplayed(),true);
	}
	
	@Test
	public void userNameErrorSpecialChar(){
		RegisterPage registerpage = new RegisterPage(ffwb);
		registerpage.navigate("http://www.xigua365.com");
		registerpage.clickRegisterButton();
		registerpage.setUserName("#@&1388");
		registerpage.clickRegisteButton();
		wa.waitForElementIsEnable(registerpage.getUserNamePhoneError());
		testscreen.highlightElement(ffwb, registerpage.getUserNamePhoneError());
		try{
	         testscreen.takeScreenShot(ffwb,"输入的手机号为#@&的特殊字符");
	       }catch(Exception e){
	        	e.printStackTrace();
	       }
		Assert.assertEquals(registerpage.getUserNamePhoneError().isDisplayed(),true);
	}
 
	@Test
	public void getErrorPhoneExiste(){
		RegisterPage registerpage = new RegisterPage(ffwb);
		registerpage.navigate("http://www.xigua365.com");
		registerpage.clickRegisterButton();
		registerpage.setUserName("13346985460");
		registerpage.clickRegisteButton();
		wa.waitForElementIsEnable(registerpage.getUserPhoneExistError());
		testscreen.highlightElement(ffwb, registerpage.getUserPhoneExistError());
		try{
	         testscreen.takeScreenShot(ffwb,"输入的已经存在的手机号，点注册报手机已经存在的错误");
	       }catch(Exception e){
	        	e.printStackTrace();
	       }
		Assert.assertEquals(registerpage.getUserPhoneExistError().isDisplayed(),true);
	}
	

	@Test
	public void userNamePhoneTrue(){
		RegisterPage registerpage = new RegisterPage(ffwb);
		String phone = "1392293"+testscreen.getPhone();
		registerpage.navigate("http://www.xigua365.com");
		registerpage.clickRegisterButton();
		registerpage.setUserName(phone);
		registerpage.setPassword("");;
		//registerpage.clickRegisteButton();
		wa.waitForElementIsEnable(registerpage.getUserPhoneTrue());
		testscreen.highlightElement(ffwb, registerpage.getUserPhoneTrue());
		try{
	         testscreen.takeScreenShot(ffwb,"输入的已经存在的手机号，点注册报手机已经存在的错误");
	       }catch(Exception e){
	        	e.printStackTrace();
	       }
		Assert.assertEquals(registerpage.getUserPhoneTrue().isDisplayed(),true);
	}
	
	@Test
	public void userNamePhoneClickCodeDefault(){
		RegisterPage registerpage = new RegisterPage(ffwb);
		String phone = "1392293"+testscreen.getPhone();
		registerpage.navigate("http://www.xigua365.com");
		registerpage.clickRegisterButton();
		registerpage.setUserName(phone);
		registerpage.setPassword("168816");
		wa.waitForElementIsEnable(registerpage.getUserPhoneTrueVeryfyCode());
		
		//registerpage.clickRegisteButton();
		testscreen.highlightElement(ffwb, registerpage.getUserPhoneTrueVeryfyCode());
		try{
	         testscreen.takeScreenShot(ffwb,"输入的正确的手机号，点击获取验证码，出现验证码的输入框默认值为“验证码”");
	       }catch(Exception e){
	        	e.printStackTrace();
	       }
		Assert.assertEquals(registerpage.getUserPhoneTrueVeryfyCode().getAttribute("placeholder"),"验证码");
	}
	
	@Test
	public void userNamePhoneClickCode(){
		RegisterPage registerpage = new RegisterPage(ffwb);
		String phone = "1392293"+testscreen.getPhone();
		registerpage.navigate("http://www.xigua365.com");
		registerpage.clickRegisterButton();
		registerpage.setUserName(phone);
		registerpage.setPassword("168816");
		registerpage.getClickPhoneVeryfyCode();
		wa.waitForElementIsEnable(registerpage.getUserPhoneTrueVeryfyCode());
		String code = test.selectPhoneVeryfyCode(phone);
		//System.out.println(code);
		//registerpage.setClickPhoneVeryfyCode(code);
		
		//registerpage.clickRegisteButton();
		testscreen.highlightElement(ffwb, registerpage.getUserPhoneTrueVeryfyCode());
		try{
	         testscreen.takeScreenShot(ffwb,"输入的正确的手机号，点击获取验证码，出现验证码的输入框");
	       }catch(Exception e){
	        	e.printStackTrace();
	       }
		Assert.assertEquals(registerpage.getUserPhoneTrueVeryfyCode().isEnabled(),true);
		test.deletePhoneVeryfyCode(phone);
	}
	
	@Test
	public void passwordDefault(){
		RegisterPage registerpage = new RegisterPage(ffwb);
		registerpage.navigate("http://www.xigua365.com");
		registerpage.clickRegisterButton();
		testscreen.highlightElement(ffwb, registerpage.getPasswordDefault());
		try{
	         testscreen.takeScreenShot(ffwb,"密码输入框的默认值为“6~16位数字/字母/符号”");
	       }catch(Exception e){
	        	e.printStackTrace();
	       }
		wa.waitForElementIsEnable(registerpage.getPasswordDefault());
		Assert.assertEquals(registerpage.getPasswordString("placeholder"),"6~16位数字/字母/符号");
	}

	
	@Test
	public void userNamePhoneClickCodeNull(){
		RegisterPage registerpage = new RegisterPage(ffwb);
		String phone = "1392293"+testscreen.getPhone();
		registerpage.navigate("http://www.xigua365.com");
		registerpage.clickRegisterButton();
		registerpage.setUserName(phone);
		registerpage.setPassword("168816");
		wa.waitForElementIsEnable(registerpage.getUserPhoneTrueVeryfyCode());
		registerpage.setClickPhoneVeryfyCode("");
		
		registerpage.clickRegisteButton();
		testscreen.highlightElement(ffwb, registerpage.getUserPhoneTrueVeryfyCodeNull());
		try{
	         testscreen.takeScreenShot(ffwb,"输入的正确的手机号，点击获取验证码，出现验证码的输入框输入验证码为空点击注册按钮");
	       }catch(Exception e){
	        	e.printStackTrace();
	       }
		Assert.assertEquals(registerpage.getUserPhoneTrueVeryfyCodeNull().isDisplayed(),true);
	}
	
	@Test
	public void userNamePhoneClickCodeerror(){
		RegisterPage registerpage = new RegisterPage(ffwb);
		String phone = "1392293"+testscreen.getPhone();
		registerpage.navigate("http://www.xigua365.com");
		registerpage.clickRegisterButton();
		registerpage.setUserName(phone);
		registerpage.setPassword("168816");
		registerpage.getClickPhoneVeryfyCode();
		wa.waitForElementIsEnable(registerpage.getUserPhoneTrueVeryfyCode());
		//String code = test.selectPhoneVeryfyCode("18645347386");
		//System.out.println(code);
		registerpage.setClickPhoneVeryfyCode("987654");
		
		registerpage.clickRegisteButton();
		testscreen.highlightElement(ffwb, registerpage.getUserPhoneTrueVeryfyCodeError());
		try{
	         testscreen.takeScreenShot(ffwb,"输入的正确的手机号，点击获取验证码，出现验证码的输入框输入验证码为错误的后点击注册按钮");
	       }catch(Exception e){
	        	e.printStackTrace();
	       }
		Assert.assertEquals(registerpage.getUserPhoneTrueVeryfyCodeError().isDisplayed(),true);
	}

	
	@Test
	public void userNamePhoneClickCodeFive(){
		RegisterPage registerpage = new RegisterPage(ffwb);
		String phone = "1392293"+testscreen.getPhone();
		registerpage.navigate("http://www.xigua365.com");
		registerpage.clickRegisterButton();
		registerpage.setUserName(phone);
		registerpage.setPassword("168816");
		for(int i = 0;i < 5;i++){
		   registerpage.getClickPhoneVeryfyCode();
		   wa.waitForElementIsEnable(registerpage.getUserPhoneTrue());    
		}
		registerpage.getClickPhoneVeryfyCode();
		testscreen.highlightElement(ffwb, registerpage.getUserPhoneFiveCode());
		try{
	         testscreen.takeScreenShot(ffwb,"输入的正确的手机号，点击获取5次验证码，再次点击第6次时提示“每天最多发送5次验证码”");
	       }catch(Exception e){
	        	e.printStackTrace();
	       }
		Assert.assertEquals(registerpage.getUserPhoneFiveCode().isDisplayed(),true);
	}

		
	@Test
	public void passwordTestDefault(){
		RegisterPage registerpage = new RegisterPage(ffwb);
		registerpage.navigate("http://www.xigua365.com");
		registerpage.clickRegisterButton();
		testscreen.highlightElement(ffwb, registerpage.getPasswordDefault());
		try{
	         testscreen.takeScreenShot(ffwb,"密码输入框的默认值为“6~16位数字/字母/符号”");
	       }catch(Exception e){
	        	e.printStackTrace();
	       }
		wa.waitForElementIsEnable(registerpage.getPasswordDefault());
		Assert.assertEquals(registerpage.getPasswordString("placeholder"),"6~16位数字/字母/符号");
	}

	@Test
	public void registerSuccessful(){
		RegisterPage registerpage = new RegisterPage(ffwb);
		registerpage.navigate("http://www.xigua365.com");
		registerpage.clickRegisterButton();
		String phone = "1392293"+testscreen.getPhone();
		registerpage.setUserName(phone);
		registerpage.setPassword("168816");
		registerpage.getClickPhoneVeryfyCode();
		String code = test.selectPhoneVeryfyCode(phone);
		registerpage.setClickPhoneVeryfyCode(code);
		registerpage.setNickName("hu"+testscreen.getCurrentTime());
		registerpage.clickRegisteButton();
		wa.waitForElementIsEnable(registerpage.getUserRegisterSuccess());
		try{
	         testscreen.takeScreenShot(ffwb,"手机号注册，注册成功的用例”");
	       }catch(Exception e){
	        	e.printStackTrace();
	       }
		Assert.assertEquals(registerpage.getUserRegisterSuccess().isDisplayed(),true);
	}


	@AfterClass
	public void quitFf(){
		ffwb.quit();
		
	}
}
