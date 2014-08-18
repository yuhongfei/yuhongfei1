package yuhongfei.test;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ElementFind {  
	  
    
    public static void main(String[] args) {  
         WebDriver driver = new FirefoxDriver();  
        driver.get("http://www.xigua365.com/index.php/auth/login");  
        /***************根据classname定位***********/
         WebElement element1 = driver.findElement(By.className("team"));  
         System.out.println(element1.getTagName());  
         /******************根据name属性名定位 ******************/
         WebElement element2 = driver.findElement(By.name("account_name"));
         System.out.println(element2.getAttribute("placeholder"));
         
//         WebElement element3 = driver.findElement(By.cssSelector("account_name"));
//         System.out.println(element3.getAttribute("placeholder"));
         /*******************定位多个元素************************/
         List<WebElement> element = driver.findElements(By.tagName("input"));
         for(WebElement e : element){
        	 System.out.println(e.getAttribute("id"));
         }
         
         /**********************定位层级元素***********************/
         WebElement element4 =driver.findElement(By.className("muc-bd"));
         List<WebElement> element5 =element4.findElements(By.tagName("label"));
         for(WebElement e :element5){
        	 System.out.println(e.getText());
         }
         
         /*******************frame定位***************/
//         dr.findElement(By.id("id1"));  
//         
//         //此时，没有进入到id="frame"的frame中时，以下两句会报错  
//         dr.findElement(By.id("div1"));//报错  
//         dr.findElement(By.id("input1"));//报错  
//           
//         //进入id="frame"的frame中，定位id="div1"的div和id="input1"的输入框。  
//         dr.switchTo().frame("frame");     
//         dr.findElement(By.id("div1"));  
//         dr.findElement(By.id("input1"));  
//           
//         //此时，没有跳出frame，如果定位default content中的元素也会报错。  
//         dr.findElement(By.id("id1"));//报错  
//           
//         //跳出frame,进入default content;重新定位id="id1"的div  
//         dr.switchTo().defaultContent();  
//         dr.findElement(By.id("id1")); 
         
         
//        driver.quit();
    }
	
//	  public static void main(String[] args) {           
//	        WebDriver dr = new FirefoxDriver();  
//	        dr.get("http://www.51.com");         
//	        WebElement element = dr.findElement(By.id("passport_51_user")); 
//	        WebElement e1 = dr.findElement(By.cssSelector("#passport_51_user")); 
//	        System.out.println(e1.getAttribute("title"));  
//	    }  
	
	
} 