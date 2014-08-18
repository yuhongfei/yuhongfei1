package loginregister.libs;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BaseMethod {
	WebDriver driver = null;

    // 通过url打开相应的页面
    public void openBrowser(String url)
    {
       driver.get(url);
    }

	//关闭相应的页面
	public void closeBrowser()
	{
	   driver.quit();
	}
	
	/** 查找到某一元素并且给予相应的值
                  一般用在对文本输入框元素的定位和输入相应值
     **/
	public void sendKey1(By by,String value)
	{
	   driver.findElement(by).sendKeys(value);
	}

    // 查找到某元素并点击
    public void elementClick1(By by) 
    {
       driver.findElement(by).click();
    }

     /*
     ***  先定位到相应的选择框
     ***  再定位到详细的待选项
     ***  一般用在定位下拉选择框中的某一个元素
     */
    public void selectElement1(By by,String text)
	{
    	Select select = new Select(driver.findElement(by));
    	select.selectByVisibleText(text);
	}

    // 获取链接元素的url值
    public String getLinkUrl1(By by)
    {
    	return driver.findElement(by).getAttribute("href");
    }

    // 判断某个元素是否存在
	public boolean isElementExist1(By by)
	{
		try
		{
		  Boolean bool = driver.findElement(by).isDisplayed();
		  return bool;
	    }
         catch(NoSuchElementException e){
            return false;
        }
     }

    // 获得某元素的文本描述信息
    public String getWebText1(By by)
    {
		try {
		     return driver.findElement(by).getText();
		    }
         catch (NoSuchElementException e){
             return "Text does not exist!";
            }
    }

    // 查找到某一元素并且给予相应的值
    // 一般用在对文本输入框元素的定位和输入相应值
     public void sendKey(By by,String value)
     {
         driver.findElement(by).sendKeys(value);
     }

    // 查找到某元素并点击
    public void elementClick(By by) 
    {
        driver.findElement(by).click();
    }

     /*
     ***  先定位到相应的选择框
     ***  再定位到详细的待选项
     ***  一般用在定位下拉选择框中的某一个元素
     */
    public void selectElement(By by,String text)
    {
		Select select = new Select(driver.findElement(by));
		select.selectByVisibleText(text);
	}

    // 获取链接元素的url值
    public String getLinkUrl(By by)
    {
       return driver.findElement(by).getAttribute("href");
    }

    // 判断某个元素是否存在
	public boolean isElementExist(By by)
	{
	   try{
	       Boolean bool = driver.findElement(by).isDisplayed();
	       return bool;
	      }
			catch(NoSuchElementException e){
			return false;
		  }
     }

    // 获得某元素的文本描述信息
    public String getWebText(By by)
    {
      try {
            return driver.findElement(by).getText();
          }
           catch (NoSuchElementException e){
            return "Text does not exist!";
           }
     }
}
