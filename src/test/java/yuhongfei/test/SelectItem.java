package yuhongfei.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.jws.WebMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.seleniumemulation.GetAlert;
import org.openqa.selenium.support.ui.*; 
public class SelectItem {  
	  
    


	public static void main(String[] args) { 
    WebDriver driver =new FirefoxDriver();
    driver.get("http://www.xigua365.com/index.php/auth/login");
    driver.findElement(By.name("account_name")).sendKeys("chinaface66@163.com");
    driver.findElement(By.name("passwd")).sendKeys("111111");
    driver.findElement(By.xpath("//button[text()='登录']")).click(); 
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  
    driver.get("http://www.xigua365.com/index.php/myspace/setuser");
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  //  WebElement first = driver.findElement(By.className("team"));
  
    WebElement Province = driver.findElements(By.xpath("//label[text()='所在城市：']/following-sibling::div//a[@class='select-arrow']")).get(0); 
    Province.click();
    WebElement proselect = Province.findElement(By.xpath("//div[@class='bd']"));
    proselect.findElement(By.xpath("//a[text()='河北省']")).click();
    
    WebElement city = driver.findElements(By.xpath("//label[text()='所在城市：']/following::div//a[@class='select-arrow']")).get(1);
    city.click();
    WebElement selectcity = city.findElement(By.xpath("//div[@class='bd']"));
    selectcity.findElement(By.xpath("//a[text()='保定市']")).click();
    
//    second.findElement(By.xpath("//a[@class='select-arrow']")).click();
//    WebElement w = driver.findElement(By.className("team"));
//    System.out.println(w.getTagName());
//  
 
//    System.out.println(wl.getAttribute("value"));
//    System.out.println(wl.getTagName());
//   
  }
}

          
      
          
       
    
  