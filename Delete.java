import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete
{
	private static final String eno = null;

	public static void main(String[] args)
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded...");
			
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empsystem","root","root");
			System.out.println("Connection Established....");
			
			String sql = "delete from emp8 where eno = "+eno+" ";
			Statement statement = connection.createStatement();
			
			if(statement.executeUpdate(sql)>0)
			{
				System.out.println("Record deleted...");
			}
			else
			{
				System.out.println("Record not found...");
				
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


