import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Alter
{

	public static void main(String[] args) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded...");
			
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empsystem","root","root");
			System.out.println("Connection Established....");
			
			
			String sql = "alter table emp8 add deptn varchar(10) not null";
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Table altered...");
			
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


