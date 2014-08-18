package loginregister.libs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	private WebDriver driver;	
	private int timeout =10;
	
	public Wait(WebDriver driver){
		this.driver = driver;	
        PageFactory .initElements(driver, this);		
	}
	
	 public void click(String locator) {  
         driver.findElement(By.xpath(locator)).click();  
     }
	
	 public void doubleClick(String locator){  
         new Actions(driver).doubleClick(driver.findElement(By.xpath(locator))).perform();  
     }  
	 public void typeKeys(String locator, String key) {  
         driver.findElement(By.xpath(locator)).sendKeys(key);  
     } 
	 
	public void waitForElementPresent(String locator){
		(new WebDriverWait(driver, 10000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}
	
	public void waitForElementIsEnable(String locator){
		(new WebDriverWait(driver, 10000)).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}
	
	public void waitForElementIsEnable(WebElement locator){
		(new WebDriverWait(driver, 10000)).until(ExpectedConditions.visibilityOf(locator));
	}
	
	public void waitFor(long timeout){
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void waitForElementDisappear(String locator){
		(new WebDriverWait(driver, 10000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
	}
	
	public void waitForElementPresent(WebElement locator){

		for(int i =0;i<timeout;i++){
		 try{
           if(locator.isDisplayed())
        	   break;
           else
        	   this.waitFor(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
		}
	}
}
