
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Demo 
{
	

	public static void main(String[] args) 
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded...");
			
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empsystem","root","root");
			System.out.println("Connection Established....");
			
			
			String sql ="create table emp8(eno int,ename varchar(20))";
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Table created...");
			
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
