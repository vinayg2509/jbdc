package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;
 
class JDBC_Employee_Insert 
{

	public static void main(String[] args) 

	{
		Connection conn=null;
		try 
		{

			//1.Load & Register Driver
			Driver driver=new com.mysql.cj.jdbc.Driver();

			DriverManager.registerDriver(driver);

			//2.Establish Connection

			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_employeedb?user=root&password=Ka14@6484");

			//3.Create Statement
			Statement st=conn.createStatement();

			//Execute Query

			boolean res=st.execute("insert into employee values"
					+ "(1200,'Vinay','vinay@gmail.com',15000,'Bhadravathi'),"
					+ "(1201,'Vikas','vikas@gmail.com',13000,'Shivamogga'),"
					+ "(1202,'Jerry','jerry@gmail.com',12000,'Shivamogga'),"
					+ "(1203,'Tom','tom@gmail.com',4321,'Bangalore')");
			
			//5.Processing Result
			if(res)
			
			{
				System.out.println(" NO Data Added ");
			}
			else
			{
				System.out.println("Data Added Succesfully");
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
