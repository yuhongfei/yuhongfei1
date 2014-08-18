package yuhongfei.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

//public class FFOpen {
//
//	public static void main(String[] args) {
//		WebDriver driver =new FirefoxDriver();
//		driver.get("http://www.google.com.hk");
//		WebElement element =driver.findElement(By.name("q"));
//		element.sendKeys("hello Selenium!");
//		element.submit();
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.print("Page title is:"+driver.getTitle());
//		driver.quit();
//
//	}
//
//}
/************************启动浏览器 ***********************/
public class FFOpen {

	public static void main(String[] args) {
		
	//	System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe"); 
		WebDriver driver =new FirefoxDriver();
		String url = "http://www.tmall.com";
		driver.get(url);
		//driver.navigate().to(url);
		System.out.print("FF has been Open!");
		driver.quit();

	}

}