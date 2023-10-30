

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update
{

	public static void main(String[] args) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded...");
			
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empsystem","root","root");
			System.out.println("Connection Established....");
			
			String sql = "UPDATE emp8 SET deptn = 'Marketing' WHERE ename = 'Girish'";
			
			Statement statement = connection.createStatement();
			
			int rowsUpdate = statement.executeUpdate(sql);
			
		
			
			if (rowsUpdate > 0) 
			{
				System.out.println("Record updated....");
			}
			else
			{
				System.out.println("Record not found or not updated....");
			}
				connection.close();
			}
		catch(ClassNotFoundException e)
		{
			System.out.println("Driver not found...");
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		
		
	}
}
