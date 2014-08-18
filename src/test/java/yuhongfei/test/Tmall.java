package yuhongfei.test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class Tmall {
	public static void main(String[] args) {
		//System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		WebDriver ff = new FirefoxDriver();
		String url = "http://login.tmall.com/";
		ff.get(url);
		System.out.println("初始化完毕");
	//	ff.findElement(By.xpath("//a[text()='请登录']")).click();
		ff.findElement(By.xpath("//a[@id='forget-pw-safe']")).
		WebElement e=ff.findElement(By.xpath("//a[@id='forget-pw-safe']"));
		System.out.println(e.getText());
	//	ff.findElement(By.xpath("//input[@class='login-text J_UserName']")).sendKeys("yuchenghongfei");
	//	ff.findElement(By.xpath("//span[@class='password-edit']")).sendKeys("Passw0rd");
	//	ff.findElement(By.xpath("//button[@id='J_SubmitStatic']")).click();
//		ff.findElement(By.xpath("//a[text()='积分聚乐部']")).click();
	//	ff.findElement(By.xpath("//a[text()='签到赢积分']")).click();
		
	//	ff.findElement(By.xpath("//input[@name='TPL_username']")).sendKeys("yuchenghongfei");
		
	//	ff.findElement(By.xpath("//button[@id='J_SubmitStatic']")).click();
	//	ff.findElement(By.xpath("//div[@class='mui-dialog-lottery-btn J_LotteryBtn']")).click();
		
	
	}
	


}
