package employee;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
class JDBC_Employee_Update 
{

	public static void main(String[] args) 
	{
		Connection conn=null;

		try
		{
		Driver driver= new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_employeedb?user=root&password=Ka14@6484");
		
		Statement st=conn.createStatement();
		
		boolean res=st.execute("update employee set employeesalary=128634 where employeeId=1200||employeeID=1201 ");
		st.execute("update employee set  employeeaddress='Bangalore' where employeeid=1202");
		st.execute("update employee set employeeaddress='Hospet'where employeename='jerry'");
		if(res)
		{
			System.out.println("No Data Updated");
		}
		
		else
		{
			System.out.println("Data Updated");
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
