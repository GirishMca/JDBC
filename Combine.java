import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Combine {
	Connection connection;
	PreparedStatement pstatement;
	Statement statement;
	ResultSet resultset;
	String ename, dept, sql;
	int eno;
	int salary;
	static Scanner sc=new Scanner(System.in);
	
	public Combine() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeelist","root","root");
	}
	
	public void addRecord() throws SQLException{

		System.out.println("Enter Employee number: ");
		eno = sc.nextInt();
		
		System.out.println("Enter Employee's name: ");
		ename = sc.next();
		
		System.out.println("Enter Employee's salary: ");
		salary = sc.nextInt();
		
		System.out.println("Enter Employee's Department: ");
		dept = sc.next();
		
		sql="insert into emp12 values(?, ?, ?, ?)";
		pstatement=connection.prepareStatement(sql);
		
		pstatement.setInt(1, eno);
		pstatement.setString(2, ename);
		pstatement.setInt(3, salary);
		pstatement.setString(4, dept);
			
		pstatement.executeUpdate();
		System.out.println("Record Added....");
	}
	
	public void deleteRecord() throws SQLException{
		sql="delete from emp12 where eno=?";
		pstatement=connection.prepareStatement(sql);
		
		pstatement.setInt(1, eno);	
		
		pstatement.executeUpdate();
		System.out.println("Record Deleted....");
	}
	
	public void updateRecord() throws SQLException{
		System.out.println("Enter Employee number: ");
		eno = sc.nextInt();

		System.out.println("Enter Employee's salary: ");
		salary = sc.nextInt();
		
		sql="update emp12 set salary=? where eno=?";
		pstatement=connection.prepareStatement(sql);
		
		pstatement.setInt(2, eno);
		pstatement.setInt(1, salary);
		
		if(pstatement.executeUpdate()>0) {
			System.out.println("Record Updated....");
		}
		else {	
			System.out.println("Employee not Found....");
		}
	}
	
	public void findRecordbyId() throws SQLException{
		System.out.println("Enter Employee number: ");
		eno = sc.nextInt();
		
		sql="select * from emp12 where eno=?";
		pstatement=connection.prepareStatement(sql);
		pstatement.setInt(1,  eno);
		resultset=pstatement.executeQuery(sql);
		
		if(resultset.next()) {
			System.out.println("Eno\tEname\tSalary\tDept");
			System.out.println("-----------------------------------------------------------------------------------");
				System.out.println(resultset.getInt(1)+"\t"+resultset.getString(2)+"\t"+resultset.getInt(3)+"\t"+resultset.getString(4));
		}
		else {	
			System.out.println("Table is empty....");
		}
	}
	
	public static void main(String a[]) {
		int choice=0;
		System.out.println("---------Employee Operations------");
		System.out.println("-----------------------------------");
		System.out.println("1, Add Record");
		System.out.println("2, Delete Record");
		System.out.println("3, Update Record");
		System.out.println("4, Find Record by Id Record");
		System.out.println("5, Exit");
		
		while(choice!=5) {
		System.out.println("Enter Operation no: ");
		choice=sc.nextInt();
			try {
				Combine c=new Combine();
				switch(choice) {
					case 1:c.addRecord();
						    break;
					case 2:c.deleteRecord();
					   		break;	
					case 3:c.updateRecord();
					   		break;
					case 4:c.findRecordbyId();
					   		break;
					case 5:System.out.println("Exit your operation");
					   		System.exit(0);
					default: System.out.println("Invalid choice...");
				}
			}
			catch(ClassNotFoundException e) {
				System.out.println(e);
			}
			catch(SQLException e) {
				System.out.println(e);
			}
		}
	}
}






