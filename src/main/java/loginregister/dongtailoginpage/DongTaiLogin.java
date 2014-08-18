package loginregister.dongtailoginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import loginregister.libs.Switch;

public class DongTaiLogin {
    private WebDriver driver = null;
    public Switch switchW = null;
    
    /**
     *       //点击第一个按钮，输出对话框上面的文字，然后叉掉   
        dr.findElement(By.id("alert")).click();   
        Alert alert = dr.switchTo().alert();   
        String text = alert.getText();   
        System.out.println(text);   
        alert.dismiss();   
           
        //点击第二个按钮，输出对话框上面的文字，然后点击确认   
        dr.findElement(By.id("confirm")).click();   
        Alert confirm = dr.switchTo().alert();   
        String text1 = confirm.getText();   
        System.out.println(text1);   
        confirm.accept();   
           
        //点击第三个按钮，输入你的名字，然后点击确认，最后   
        dr.findElement(By.id("prompt")).click();   
        Alert prompt = dr.switchTo().alert();   
        String text2 = prompt.getText();   
        System.out.println(text2);   
        prompt.sendKeys("jarvi");   
        prompt.accept();   
     */
    public DongTaiLogin(WebDriver driver){
 	   this.driver = driver;
 	   PageFactory.initElements(driver, this);
    }
    
    public void navigate(String url){
 	   this.driver.get(url);
    }
    
    @FindBy(xpath = "//span[text()='动态']")
    private WebElement dongTaiButton;
    public WebElement getRegisterButton(){
 	   return this.dongTaiButton;
    }
    public void clickRegisterButton(){
 	   this.dongTaiButton.click();
    }
}
