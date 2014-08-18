package loginregister.testcase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import loginregister.libs.ParseProperties;
import loginregister.libs.Wait;
import loginregister.loginpage.LoginPage;

public class ThirdLogin {
	private  static WebDriver ffwb = null;
	private Wait wa = null;
	
	@BeforeClass
	public void loadFf(){
		        ffwb = new FirefoxDriver();
				ffwb.manage().window().maximize();
				ffwb.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				wa = new Wait(ffwb);
	}


   //第3方登陆出现问题，等第3方登陆好后再测试
	@Test
	public void loginPageTx(){
          ffwb.get("http://www.xigua365.com");
          ffwb.findElement(By.xpath("//a[text()='注册']")).click();
          //获取元素属性值
          //<input id="moui_1392273655093" class="m-inp" type="text" autocomplete="off" tabindex="0" data-role="account" name="account_name" placeholder="电子邮箱或手机号"/>
          String el = ffwb.findElement(By.xpath("//input[@placeholder='电子邮箱或手机号']")).getAttribute("placeholder");
          System.out.println(el);
	} 
	
	
	@AfterClass
	public void quitFf(){
		ffwb.quit();
		
	}

}
