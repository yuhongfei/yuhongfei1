package loginregister.testcase;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.accessibility.internal.resources.accessibility;

import loginregister.libs.ActionDriverHelper;
import loginregister.libs.Wait;
import loginregister.libs.Login;

public class send {
	
	private Wait wa ;
	public FirefoxDriver ffwb;
	
	@BeforeClass
	public void Login(){
		
		//FirefoxProfile profile = new FirefoxProfile(new File("C:\\Users\\Admin\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\birfpo08.default")); 
		ffwb =new FirefoxDriver();
		wa = new Wait(ffwb);
	    ffwb.manage().window().maximize();
		ffwb.get("http://www.xigua365.com/index.php/auth/login");
		wa.waitForElementPresent("//button[text()='登录']");
	//	wa.click("//a[text()='登录']");
		wa.typeKeys("//input[@name='account_name']","chinaface11@163.com");
		wa.typeKeys("//input[@name='passwd']", "111111");
		wa.click("//button[text()='登录']");
			
}

    @Test
	public void Sendimg(){
    wa.waitForElementIsEnable("//span[text()='发现']");
	ffwb.get("http://www.xigua365.com/index.php/ucenter/publish");
	wa.waitForElementPresent("//i[@class='m-icon i-publish-m']");
	ffwb.findElement(By.xpath("//i[@class='m-icon i-publish-m']")).click();

	//ffwb.findElement(By.xpath("//a[@class='h-icon i-shopcart']")).click();
	//Assert.assertEquals(ffwb.findElement(By.xpath("//span[text()='桔色']")).isEnabled(), true);
}



	@AfterClass
	public void quitFf(){
      //  ffwb.quit();
		System.out.println(" after test");
	}
}
