package yuhongfei.test;

import java.util.Set;  
  
import org.openqa.selenium.Cookie;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.firefox.FirefoxDriver;  
  
public class cookietest {  
  
  
    public static void main(String[] args) {  
        System.setProperty("webdriver.firefox.bin","C://Program Files (x86)\\Mozilla Firefox\\firefox.exe");    
        WebDriver dr = new FirefoxDriver();  
        dr.get("http://www.xigua365.com");  
           
//        Cookie cookie = new Cookie("name", "value");  
//        dr.manage().addCookie(cookie);  
          
        //得到当前页面下所有的cookies，并且输出它们的所在域、name、value、有效日期和路径  
        Set<Cookie> cookies = dr.manage().getCookies();  
        System.out.println(String.format("Domain -> name -> value -> expiry -> path"));  
        for(Cookie c : cookies)  
            System.out.println(String.format("%s -> %s -> %s -> %s -> %s",  
                    c.getDomain(), c.getName(), c.getValue(),c.getExpiry(),c.getPath()));  
          
          
        //删除cookie有三种方法  
          
        //第一种通过cookie的name  
//        dr.manage().deleteCookieNamed("CookieName");  
//        //第二种通过Cookie对象   
//        dr.manage().deleteCookie(cookie);  
//        //第三种全部删除  
//        dr.manage().deleteAllCookies();  
    } 
}