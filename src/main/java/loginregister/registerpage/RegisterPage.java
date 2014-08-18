package loginregister.registerpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import loginregister.libs.Switch;

public class RegisterPage {
   private WebDriver driver = null;
   public Switch switchW = null;
   
   public RegisterPage(WebDriver driver){
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
   }
   
   public void navigate(String url){
	   this.driver.get(url);
   }
   
   @FindBy(xpath = "//a[text()='注册']")
   private WebElement registerButton;
   public WebElement getRegisterButton(){
	   return this.registerButton;
   }
   public void clickRegisterButton(){
	   this.registerButton.click();
   }
   
   @FindBy(xpath = "")
   private WebElement usernametext;
   
 
   @FindBy(xpath = "//a[text()='直接登录']")
   private WebElement registerLoginButton;
   public WebElement getRegisterLoginButton(){
	   return this.registerLoginButton;
   }

   /**
    *String el = ffwb.findElement(By.xpath("//input[@placeholder='电子邮箱或手机号']")).getAttribute("placeholder");
     System.out.println(el);
    */
   //输入用户名的用例
   @FindBy(xpath = "//input[@name='account_name']")
   private WebElement  usernamestring;
   //获取用户名输入框的默认属性值“电子邮箱或手机号”
   public WebElement getUserNameDefault(){
	   return this.usernamestring;
   }
   public String getUserNameString(String s){
	   return this.usernamestring.getAttribute(s);
   }
   public void setUserName(String username){
	   this.usernamestring.clear();
	   this.usernamestring.sendKeys(username);
   }
   
   //密码输入框的用例
   @FindBy(xpath = "//input[@name='password']")
   private WebElement passwdstring;
   //获取密码输入框中的默认字符placeholder="6~16位数字/字母/符号"
   public WebElement getPasswordDefault(){
	   return this.passwdstring;
   }
   public String getPasswordString(String s){
	   return this.passwdstring.getAttribute(s);
   }
   public void setPassword(String password){
	   this.passwdstring.clear();
	   this.passwdstring.sendKeys(password);
   }
   
   //注册页面的注册按钮
   @FindBy(xpath = "//button[text()='注册']")
   private WebElement registerPageButton;
   public WebElement getRegisterPageButton(){
	   return this.registerButton;
   }
   public void clickRegisteButton(){
	   this.registerPageButton.click();
   }
   
   //用户名输入为空后点击注册返回的错误
   @FindBy(xpath = "//span[text()='账号不能为空']")
   private WebElement usernameull;
   public WebElement getUserNameNull(){
	   return this.usernameull;
   }
   
   //用户名输入为空后点击注册返回的错误
   @FindBy(xpath = "//span[text()='邮箱或手机号格式不正确,请检查']")
   private WebElement usernamephoneerror;
   public WebElement getUserNamePhoneError(){
	   return this.usernamephoneerror;
   }
   
   //输入已经存在的手机号
   @FindBy(xpath = "//span[text()='手机已存在，请换一个试试']")
   private WebElement userphoneexisterror;
   public WebElement getUserPhoneExistError(){
	   return this.userphoneexisterror;
   }
   
   //输入正确的手机号焦点移开后注册页面显示
   @FindBy(xpath = "//button[text()='免费获取短信验证码']")
   private WebElement userphonetrue;
   public WebElement getUserPhoneTrue(){
	   return this.userphonetrue;
   }
   public void getClickPhoneVeryfyCode(){
	   this.userphonetrue.click();
   }
   
   //同一个手机号码点击免费获取短信验证码5次后
   @FindBy(xpath = "//span[text()='每天最多发送5次验证码']")
   private WebElement userphoneFivecode;
   public WebElement getUserPhoneFiveCode(){
	   return this.userphoneFivecode;
   }
   //点击验证码发送按钮后出现的验证码输入框
   @FindBy(xpath = "//input[@placeholder='验证码']")
   private WebElement userphonetrueveryfycode;
   public WebElement getUserPhoneTrueVeryfyCode(){
	   return this.userphonetrueveryfycode;
   }
   public void setClickPhoneVeryfyCode(String code){
	   this.userphonetrueveryfycode.clear();
	   this.userphonetrueveryfycode.sendKeys(code);;
   }
   
   //验证码为空的时候，点击提交注册按钮
   @FindBy(xpath = "//span[text()='验证码不能为空']")
   private WebElement userphonetrueveryfycodenull;
   public WebElement getUserPhoneTrueVeryfyCodeNull(){
	   return this.userphonetrueveryfycodenull;
   }
   
   //输入错误的验证码时候，点击提交注册按钮
   @FindBy(xpath = "//span[text()='手机验证失败']")
   private WebElement userphonetrueveryfycodeerror;
   public WebElement getUserPhoneTrueVeryfyCodeError(){
	   return this.userphonetrueveryfycodeerror;
   }
   //注册页面信息都输入成功后点击注册按钮，成功注册后出现的item 
   @FindBy(xpath = "//input[@id='nickname']")
   private WebElement userregistersuccess;
   public WebElement getUserRegisterSuccess(){
	   return this.userregistersuccess;
   }
   //注册成功后点退出
   @FindBy(xpath = "//a[text()='退出']")
   private WebElement tuichulogin; 
   public WebElement logoutElement(){
	  return this.tuichulogin;
   }
   public void clickLoginout(){
	   this.tuichulogin.click();
   }
   //注册页面的用户昵称输入框
   @FindBy(xpath = "//input[@id='nickname']")
   private WebElement nickname;
   public WebElement getNickName(){
	   return this.nickname;
   }
   public void setNickName(String nicknamer){
	   this.nickname.clear();
	   this.nickname.sendKeys(nicknamer);
   }
   
      
}
