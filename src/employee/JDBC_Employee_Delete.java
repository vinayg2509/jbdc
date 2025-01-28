package employee;
import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
class JDBC_Employee_Delete 
{

	public static void main(String[] args) 
	{
		Connection conn=null;
		try 
	{
//		Driver driver=new com.mysql.cj.jdbc.Driver();
//		DriverManager.registerDriver(driver);
			
		Class.forName("com.mysql.cj.jdbc.Driver");

		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_employeedb?user=root&password=Ka14@6484");
		
		Statement st=conn.createStatement();
		
		boolean res=st.execute("delete  from employee where employeeid=1203");
//		boolean res=st.execute("delete from employee");
		
		if(res)
		{
			System.out.println( "No Data Deleted");
		}
		else
		{
			System.out.println(" Data Deleted");
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if(conn!=null)
				try
			{
					//6.Close Connection
					conn.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}

	}

}
