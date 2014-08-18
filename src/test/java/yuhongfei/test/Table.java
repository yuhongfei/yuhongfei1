package yuhongfei.test;

import java.util.List;  

import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;  
import org.openqa.selenium.firefox.FirefoxDriver;  
  
public class Table {  
  
    /** 
     * @author gongjf 
     */  
    private WebDriver driver;  
    Table(WebDriver driver){  
        this.driver = driver;  
    }  
      
    /** 从一个table的单元格中得到文本值. 参数tableCellAddress的格式为 
    row.column, 行列从0开始. 
    @param by  用于得到table对象 
    @param tableCellAddress 一个单元格地址, 如. "1.4" 
    @return 从一个table的单元格中得到文本值 
    */  
    public String getCellText(By by,String tableCellAddress) {  
        //得到table元素对象  
        WebElement table = driver.findElement(by);  
        //对所要查找的单元格位置字符串进行分解，得到其对应行、列。  
        int index = tableCellAddress.trim().indexOf('.');  
        System.out.println(index);
        int row =  Integer.parseInt(tableCellAddress.substring(0, index));  
        System.out.println(row);
        int cell = Integer.parseInt(tableCellAddress.substring(index+1));  
        System.out.println(cell);
        //得到table表中所有行对象，并得到所要查询的行对象。  
         List<WebElement> rows = table.findElements(By.tagName("tr"));  
         WebElement theRow = rows.get(row);  
       
         //调用getCell方法得到对应的列对象，然后得到要查询的文本。  
         String text = getCell(theRow, cell).getText();  
         return text;  
    }  
    private WebElement getCell(WebElement Row,int cell){  
         List<WebElement> cells;  
         WebElement target = null;  
         //列里面有"<th>"、"<td>"两种标签，所以分开处理。  
         if(Row.findElements(By.tagName("th")).size()>0){  
            cells = Row.findElements(By.tagName("th"));  
            target = cells.get(cell);  
           }  
         if(Row.findElements(By.tagName("td")).size()>0){  
          cells = Row.findElements(By.tagName("td"));  
           target = cells.get(cell);  
           
           }  
        return target;  
           
    }  
      
      
    public static void main(String[] args) {  
    	 WebDriver driver = new FirefoxDriver();  
         String url = "file:///C:/Users/Admin/Desktop/test.html";  
         driver.get(url);  
      
         Table table = new Table(driver);  
         By by = By.id("myTable");  
         String address = "1.2";  
       
         System.out.println(table.getCellText(by, address));  
         driver.quit();
          
          
    }  
  
}  