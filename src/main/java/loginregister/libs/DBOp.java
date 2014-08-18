package loginregister.libs;


import java.sql.*;



public class DBOp {
	
	private Statement stat = null;
	private ResultSet rsq   = null;
	private String tablename = null;
	
	public DBOp(String tablename){
		this.tablename = tablename;
	}
    
	public void conn(){
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:"+System.getProperty("user.dir")+"\\tool\\mylocator.sqlite");
			stat = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String  getLocatorXpath(String locatorname){
		String xpath = null;
		try {
			rsq =stat.executeQuery("select * from "+tablename+" where WebElement = '"+locatorname+"';");
			while (rsq.next()) { 
				xpath = rsq.getString("Xpath");
				}
				rsq.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xpath;
	}
	
	
	public String getLocatorCSS(String locatorname){
		String css = null;
		try {
			rsq =stat.executeQuery("select * from "+tablename+" where WebElement = '"+locatorname+"';");
			while (rsq.next()) { 	
				css=rsq.getString("Css");
				}
				rsq.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return css;
	}
	
	public static void main(String[] args) {
		DBOp test = new DBOp("logindb2");
		test.conn();
		System.out.println(test.getLocatorCSS( "LoginButton"));
		//System.out.print(test.getLocatorCSS( "Password"));
	}
}
