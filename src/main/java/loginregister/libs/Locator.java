package loginregister.libs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Locator {

	private WebDriver driver = null;
	private DBOp dbsession = null;
	public Locator(WebDriver driver,DBOp dbsession){
		this.driver = driver;
		this.dbsession = dbsession;
	}
	
	public WebElement getLocator(String locator){
		WebElement we = null;
		//ocator = locator.replace("%var%", newChar);
		if(dbsession.getLocatorCSS(locator)!=null||!dbsession.getLocatorCSS(locator).equals(""))
			we = driver.findElement(By.cssSelector(dbsession.getLocatorCSS(locator)));    	  
		else 
			we = driver.findElement(By.xpath(dbsession.getLocatorXpath(locator)));
		return we;
	}
	
	public WebElement getLocator1(String locator,String newChar){
		WebElement we = null;
		locator = locator.replace("%var%", newChar);
		if(dbsession.getLocatorCSS(locator)!=null||!dbsession.getLocatorCSS(locator).equals(""))
			we = driver.findElement(By.cssSelector(dbsession.getLocatorCSS(locator)));    	  
		else 
			we = driver.findElement(By.xpath(dbsession.getLocatorXpath(locator)));
		return we;
		
	}
	
	/**
	 * new Actions(iewb).moveToElement(iewb.findElement(By.xpath("//li[@class='menu-reg']//a"))).build().perform();
    	iewb.findElement(By.xpath("//li[@class='menu-reg']//a")).sendKeys("\n");
	 * @param element
	 */
	 public void moveto(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
         
      }
	
}
