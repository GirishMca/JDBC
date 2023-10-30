import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Insert
{
	

	public static void main(String[] args) 
	{
		int eno;
		String name,deptn;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter emp no : ");
		eno = scanner.nextInt();
		System.out.println("Enter emp name : ");
		name = scanner.next();
		System.out.println("Enter emp dept : ");
		deptn = scanner.next();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded...");
			
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empsystem","root","root");
			System.out.println("Connection Established....");
			
			String sql ="insert into emp8 values("+eno+",'"+name+"','"+deptn+"')";
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Table inserted...");
			
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


