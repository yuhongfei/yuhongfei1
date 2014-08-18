package loginregister.loginpage;

import loginregister.data.LoingPageXpath;
import loginregister.libs.Switch;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	public Switch switchW = null;
	public LoginPage(WebDriver driver){
	    this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void navigate(String url){
		driver.get(url);
	}
	
	@FindBy(xpath=LoingPageXpath.HOMELOGINBUTTON)
	public WebElement LoginButton;
	public void loginButton(){
   	this.LoginButton.click();
   }
	
	
	@FindBy(xpath="//input[@name='account_name']")
	private WebElement UserName;
	
	public void sendUserNameKey(String value)
	{
	   this.UserName.sendKeys(value);
	}
	
	@FindBy(xpath="//input[@name='passwd']")
	private WebElement Passwd;
	public void sendUserPasswdKey(String passwd){
		this.Passwd.sendKeys(passwd);
	}
	
	@FindBy(xpath="//button[@class='btn-r']")
	public WebElement Login;
   public void loginClick(){
   	this.Login.click();
   }
   
   /***********************************用户名与密码为空******************************/   
	@FindBy(xpath="//span[text()='账号不能为空']")
	public WebElement Error;
   
   /***********************************用户名与密码为空******************************/
   /***********************************手机号输入小于11位与大于11位******************************/   
		@FindBy(xpath="//span[text()='邮箱或手机号格式不正确,请检查']")
		public WebElement PhoneError;
   /***********************************手机号输入小于11位与大于11位******************************/
   /***********************************输入正确的手机号，验证手机号是否输入正确******************************/
		@FindBy(xpath="//span[@class='fixed-ok']")
		public WebElement PhoneTrue;
   /***********************************输入正确的手机号，验证手机号是否输入正确*******************************/
   /***********************************用户名与密码为空******************************/
  /***********************************登陆成功后******************************/
   @FindBy(xpath="//a[@class='user']")
	public WebElement UserCenter;
   /***********************************登陆成功后******************************/
   /*****密码长度为6-16位，且不包含特殊字符*****************************************/
    @FindBy(xpath="//span[text()='密码长度为6-16位，且不包含特殊字符']")
  	public WebElement PasswdLengthSix;
   /*****密码长度为6-16位，且不包含特殊字符*****************************************/
    /************14天复选框******************/
    @FindBy(xpath="//input[@class='checkbox']")
  	public WebElement Checkbox14Day;
    public void checkbox14DayClick(){
       	this.Checkbox14Day.click();
       }
    /************14天复选框************************/
    /************输入错误密码三次后出现验证码**************/
    @FindBy(xpath="//div[@class='m-code']")
  	public WebElement MCode;

    /************输入错误密码三次后出现验证码**************/
   /*************************qq第3方登陆相关的***************************/
 
   @FindBy(xpath="//a[@class='login-type type-qq']")
   public WebElement QqLogin;
   public void qqLoginClick(){
	   	this.QqLogin.click();
	   }
   
   @FindBy(xpath="//a[@title='腾讯微博']")
   public WebElement QqTile;
   
   
   
   @FindBy(xpath=".//*[@id='img_out_277140307']")
   public WebElement QqLoginClick;
   public void LoginToQqClick(){
	    switchW = new Switch(driver);
	    //QqTile.getText();
		switchW.toSpecificWindow( QqTile.getText());
	   	this.QqLoginClick.click();
	   }
   
   @FindBy(xpath="//img[@class='userAvatar']")
   public WebElement logimg;
   
   /*************************qq第3方登陆相关的***************************/
   

}
