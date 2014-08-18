package yuhongfei.test;

import java.util.concurrent.TimeUnit;
import java.util.Iterator;  
import java.util.Set; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.java.swing.plaf.windows.resources.windows;
import com.thoughtworks.selenium.Wait;

public class NewWindows {  
	  
    
    

	public static void main(String[] args) { 
    WebDriver driver =new FirefoxDriver();
    driver.get("http://www.xigua365.com/index.php/auth/login");
    driver.findElement(By.name("account_name")).sendKeys("chinaface66@163.com");
    driver.findElement(By.name("passwd")).sendKeys("111111");
    driver.findElement(By.xpath("//button[text()='登录']")).click(); 
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.findElement(By.linkText("热门")).click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    String currentWindow = driver.getWindowHandle();
    Set<String> handles =driver.getWindowHandles();
    Iterator<String> iterator =handles.iterator();
    while(iterator.hasNext()){
    	String handle =iterator.next();
    	if(currentWindow.equals(handle)) continue;
    	WebDriver window = driver.switchTo().window(handle);
    	System.out.println("title,url = "+window.getTitle()+","+window.getCurrentUrl());
    	 
    }
    WebDriver windowto = driver.switchTo().window(currentWindow);
    System.out.print(windowto.getTitle()+windowto.getCurrentUrl());
    }
  }
