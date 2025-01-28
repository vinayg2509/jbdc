package employee;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


class JDBC_Employee_Select 
{

	public static void main(String[] args) 
	{
		Connection conn=null;

		try
		{
			Driver driver=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_employeedb?user=root&password=Ka14@6484");
			
			Statement st=conn.createStatement();
			
			st.execute("Select * from employee");
			
			ResultSet rs=st.getResultSet();
			System.out.println("employeeId\temployeeName\temployeeEmail\t\temployeeSalary\temployeeAddress");
			while(rs.next())
			{
				System.out.print(rs.getInt(1)+"\t\t");
				System.out.print(rs.getString("employeeName")+"\t\t");
				System.out.print(rs.getString(3)+"\t\t");
				System.out.print(rs.getInt("employeeSalary")+"\t\t");
				System.out.print(rs.getString(5)+"\t\t");
				System.out.println();
			}
			
			conn.close();
			
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
