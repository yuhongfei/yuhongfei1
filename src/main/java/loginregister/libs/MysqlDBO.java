package loginregister.libs;


import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
  
public class MysqlDBO {  
	private Statement stat = null;
	private ResultSet rsq   = null;
	private String tablename = null;
	private Connection conn  = null;
	
	public MysqlDBO(String tablename){
		this.tablename = tablename;
	}  
 
    /* 查询数据库，输出符合要求的记录的情况*/  
	public String  selectPhoneVeryfyCode(String phonenumber){
		conn();
		String code = null;
		try {
			rsq =stat.executeQuery("select regist_code from "+tablename+" where receive_code = '"+phonenumber+"'");
			while (rsq.next()) { 
				code = rsq.getString("regist_code");
				break;
				}
				rsq.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return code;
	}
	
    /* 查询数据库，输出符合要求的记录的情况*/  
	public void  deletePhoneVeryfyCode(String phonenumber){
		conn();
		String code = null;
		try {
			//rsq =stat.executeQuery("delete from "+tablename+" where receive_code = '"+phonenumber+"'");
			stat.executeUpdate("delete from "+tablename+" where receive_code = '"+phonenumber+"'");
//			while (rsq.next()) { 
//				code = rsq.getString("regist_code");
//				break;
//				}
//				rsq.close();
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	private void close() {
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public void conn(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://172.16.12.51:3306/customer", "writeuser", "parkland100");
			stat = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		MysqlDBO test = new MysqlDBO("register_verify");
		//test.conn();
		//System.out.println(test.selectPhoneVeryfyCode("18645347886"));
		test.deletePhoneVeryfyCode("13522939122");
		//System.out.print(test.getLocatorCSS( "Password"));
		
	}
	
   
}  