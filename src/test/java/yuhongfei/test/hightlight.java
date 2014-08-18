package yuhongfei.test;

import org.openqa.selenium.By;  
import org.openqa.selenium.JavascriptExecutor;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;  
import org.openqa.selenium.firefox.FirefoxDriver;  
import org.openqa.selenium.support.ui.ExpectedCondition;  
import org.openqa.selenium.support.ui.WebDriverWait;  
  
public class hightlight {  
  
    public static void main(String[] args) {  
        WebDriver driver = new FirefoxDriver();  
        String url = "file:///C:/Users/Admin/Desktop/test.html";  
        driver.get(url);  
  
        WebDriverWait wait = new WebDriverWait(driver, 10);  
  
        driver.findElement(By.id("b")).click();  
  
        WebElement wl = wait.until(new ExpectedCondition<WebElement>() {  
  
           
            public WebElement apply(WebDriver d) {  
                return d.findElement(By.cssSelector(".red_box"));  
            }  
        });  
       
  
        ((JavascriptExecutor) driver).executeScript(  
                "arguments[0].style.border='5px solid yellow'", wl);  
  
    }  
  
}