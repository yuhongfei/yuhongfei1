package loginregister.libs;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import loginregister.data.LoginPageMessage;
import loginregister.loginpage.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.jna.Native.ffi_callback;
import com.thoughtworks.selenium.Wait;



public class Login {

	
	
	public void islogin(FirefoxDriver ff)  {
	//	FirefoxDriver ffwait;
	//	ff = new FirefoxDriver();
		ff.get("http://www.xigua365.com");
		 
	
		     ff.findElement(By.xpath("//a[text()='登录']")).click();
			 
			 ff.findElement(By.xpath("//input[@name='account_name']")).sendKeys("chinaface66@163.com");
		     ff.findElement(By.xpath("//input[@name='passwd']")).sendKeys("111111"); 
		     ff.findElement(By.xpath("//button[text()='登录']")).click();
	}
		
	
//	public void quitFf(){
//		ffwb.quit();
		
//	
//public static void main(String[] args) {
//	
//	 FirefoxDriver ff1 = null;
//	Login login = new Login();
//	login.islogin(ff1);
//	System.out.print("FF has been Open!");
//	
//
//}
}


	



