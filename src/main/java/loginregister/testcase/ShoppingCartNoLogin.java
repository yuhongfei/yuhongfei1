package loginregister.testcase;



import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import loginregister.libs.Wait;
import loginregister.libs.Login;


public class ShoppingCartNoLogin {
	private Wait wa ;
    FirefoxDriver ffwb;
	@BeforeClass
	
    public void FF(){
		ffwb = new FirefoxDriver();
		wa = new Wait(ffwb);
		//ffwb.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		ffwb.manage().window().maximize();
	}

	@Test


	public void Addshoppingcart(){
		
		ffwb.get("http://www.xigua365.com/product/show/100-2311");
		wa.waitForElementIsEnable("//span[text()='L']");
		ffwb.findElement(By.xpath("//span[text()='L']")).click();
       
		wa.waitForElementIsEnable("//span[@title='桔色']");
		ffwb.findElement(By.xpath("//span[@title='桔色']")).click();
		ffwb.findElement(By.xpath("//input[@data-role='cartinput']")).sendKeys("2");
		ffwb.findElement(By.xpath("//button[text()='添加到购物车']")).click();
		wa.waitForElementIsEnable("//button[text()='登录']");
		ffwb.findElement(By.xpath("//input[@name='account']")).sendKeys("chinaface66@163.com");
	    ffwb.findElement(By.xpath("//input[@name='password']")).sendKeys("111111"); 
	    ffwb.findElement(By.xpath("//button[text()='登录']")).click();
	    Assert.assertEquals(ffwb.findElement(By.xpath("//span[text()='桔色']")).isEnabled(), true);
	    
	}


	@AfterClass
	public void quitFf(){
		System.out.println(" End test");
		//ffwb.quit();
		
	}
}
