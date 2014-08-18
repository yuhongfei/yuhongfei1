package loginregister.libs;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class Test_ShotScreen {
	public static  WebDriver dr =  null;
	
	@Test
	public void getPhoneTest(){
		Test_ShotScreen testscreen = new Test_ShotScreen();
		String phone = testscreen.getPhone();
		
		System.out.println(phone);
	}
	@Test
	public void loginPage2(){
		Test_ShotScreen testscreen = new Test_ShotScreen();
		String url = "http://www.baidu.com";
		//打开chrome
	    dr = new FirefoxDriver();
        dr.get(url); 
        dr.manage().window().maximize();
        //这里等待页面加载完成
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        /**
        //下面代码是得到截图并保存在D盘下
        File screenShotFile = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(screenShotFile, new File("D:/test.png"));  
        FileUtils.copyFile(screenShotFile, new File("E:\\AutoScreenCapture\\" + getCurrentDateTime()+ ".jpg")); 
        **/  
        try{
           testscreen.takeScreenShot(dr,"首页");
        }catch(Exception e){
        	e.printStackTrace();
        }
            dr.quit();
        }
	
	    public  String getCurrentTime(){
		SimpleDateFormat df = new SimpleDateFormat("HHmmss");//设置日期格式
		//System.out.println(df.format(new Date()));
		   return df.format(new Date());
		}
	    
		public String getPhone(){
			Random r = new Random();
			int nextInt = r.nextInt(10000);
			String valueOf = String.valueOf(nextInt);
			return valueOf;
		}
	
		public  String getCurrentDateTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");//设置日期格式
		//System.out.println(df.format(new Date()));
		return df.format(new Date());
		}
		public  void takeScreenShot(WebDriver dr,String name){  
			 try {  
	                File scrFile = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);  
	                FileUtils.copyFile(scrFile, new File("E:\\AutoScreenCapture\\" + getCurrentDateTime() + name + ".jpg"));  
	          /**      FileOutputStream fileout = new FileOutputStream("E:\\AutoScreenCapture\\" + getCurrentDateTime()+ ".jpg");
	                FileInputStream filein = new FileInputStream(scrFile);
	                byte[] buff = new byte[1024];
	                while(filein.read(buff) != -1) {
	                	fileout.write(buff, 0, buff.length);
	                	//filein.read(buff);
	                }
	                fileout.flush();
	                fileout.close();
	                filein.close();**/
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	     }  
		//高亮当前测试元素，用红框显示
		public void highlightElement(WebDriver driver, WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("element = arguments[0];" +
	             "original_style = element.getAttribute('style');" +
	                 "element.setAttribute('style', original_style + \";" +
	             "background: yellow; border: 2px solid red;\");" +
	             "setTimeout(function(){element.setAttribute('style', original_style);}, 1000);", element);
	}
	
}
