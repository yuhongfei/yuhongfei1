package loginregister.testcase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import loginregister.data.LoginPageMessage;
import loginregister.libs.ParseProperties;
import loginregister.libs.Test_ShotScreen;
import loginregister.libs.Wait;
import loginregister.loginpage.LoginPage;

public class DongTaiLoginCase {
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
	
	@Test
	public void clickDongtai(){
		   ffwb.get("http://www.xigua365.com");
		   ffwb.findElement(By.xpath("//span[text()='动态']")).click();
		   ffwb.findElement(By.xpath("//input[@name='account']")).sendKeys("chinaface66@163.com");
		   ffwb.findElement(By.xpath("//input[@name='password']")).sendKeys("111111"); 
		   ffwb.findElement(By.xpath("//button[text()='登录']")).click(); 
		   
		   wa.waitFor(5000);
	}
	
	@AfterClass
	public void quitFf(){
		ffwb.quit();
		
	}
}
