package loginregister.libs;
import org.openqa.selenium.WebDriver;
/**
 * 
 * Description :switch to specific window.
 * @author ：Kevin
 * @see : 
 * @param :partial Title Name of a window.
 * @return : void
 * @create ：2013-12-1
 * @exception :
 * @version ：1.0
 */

public class Alert {
   private WebDriver driver;
   private String currentwindow;
   
	public Alert(WebDriver driver){
		this.driver = driver;	
		currentwindow = driver.getWindowHandle();
		//PageFactory .initElements(driver, this);		
	}
	
	public void toAlertWindow(WebDriver dr){
        org.openqa.selenium.Alert prompt = dr.switchTo().alert();   
	}
	
	/**
	 * 
	 * Description : back to parent window but dont close the source window.
	 * @author ：Terry
	 * @see : 
	 * @param :
	 * @return : void
	 * @create ：2013-8-1
	 * @exception :
	 * @version ：1.0
	 */
	public void backToCurrentWindow(){
		driver.switchTo().window(currentwindow);
	}
	
	
	
	
}
