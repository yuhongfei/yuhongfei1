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

public class ShoppingcartLogin {
	
	private Wait wa ;
	public FirefoxDriver ffwb;
	
	@BeforeClass
	public void LoginPage1(){
		
		//FirefoxProfile profile = new FirefoxProfile(new File("C:\\Users\\Admin\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\birfpo08.default")); 
		ffwb =new FirefoxDriver();
		wa = new Wait(ffwb);
	    ffwb.manage().window().maximize();
		ffwb.get("http://www.xigua365.com");
		wa.waitForElementPresent("//a[text()='登录']");
		wa.click("//a[text()='登录']");
		wa.typeKeys("//input[@name='account_name']","chinaface66@163.com");
		wa.typeKeys("//input[@name='passwd']", "111111");
		wa.click("//button[text()='登录']");
			
}

    @Test
	public void Addshoppingcart(){
  
	ffwb.get("http://www.xigua365.com/product/show/100-2311");
	wa.waitForElementIsEnable("//span[text()='L']");
	ffwb.findElement(By.xpath("//span[text()='L']")).click();
	wa.waitForElementIsEnable("//span[@title='桔色']");
	ffwb.findElement(By.xpath("//span[@title='桔色']")).click();
//	ffwb.findElement(By.xpath("//input[@data-role='cartinput']")).clear();
//	ffwb.findElement(By.xpath("//input[@data-role='cartinput']")).sendKeys("2");
	wa.doubleClick("//i[text()='+']");
	ffwb.findElement(By.xpath("//button[text()='添加到购物车']")).click();
	ffwb.findElement(By.xpath("//a[@class='h-icon i-shopcart']")).click();
	Assert.assertEquals(ffwb.findElement(By.xpath("//span[text()='桔色']")).isEnabled(), true);
}



	@AfterClass
	public void quitFf(){
      //  ffwb.quit();
		System.out.println(" after test");
	}
}
