package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CRUDoperation 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is registered");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ABC","root", "ashwini2001");
		System.out.println("the connection is established successufully");

		
		Statement st = con.createStatement();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter an Option:");
		System.out.println("1.Insert 2.Update 3.View Data 4.View All 5.Delete 6.Delete All");
		
		int option = sc.nextInt();
		switch(option)
		{
			case 1:
			{
				PreparedStatement ps = con.prepareStatement("insert into emp(id, name, age)values(?,?,?)");
				Scanner sc1 = new Scanner(System.in);
				System.out.println("enter id");
				int id = sc1.nextInt();
				System.out.println("Enter Name");
				String name = sc1.next();
				System.out.println("enter age");
				int age = sc1.nextInt();
				
				
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setInt(3, age);

				ps.execute();
				System.out.println("value inserted");
				
				break;
			}
//------------------------------------------------------------------------------------------------------------------------
			case 2:
			{
				PreparedStatement ps1 = con.prepareStatement("update emp set name=? where id=?" );
				Scanner sc2 = new Scanner(System.in);
				
				System.out.println("enter id to update");
				int id1=sc2.nextInt();
				
				System.out.println("enter new name");
				String name1 = sc2.next();
				
				ps1.setString(1, name1);
				ps1.setInt(2, id1);
						
				ps1.execute();
				System.out.println("values updated");
				
				break;
			}
//------------------------------------------------------------------------------------------------------------------------

			case 3:
			{
				PreparedStatement ps2 = con.prepareStatement("select emp * from where id=?");
				Scanner sc1= new Scanner(System.in);
				int id3=sc1.nextInt();
				
				ps2.setInt(1, id3);
				ResultSet rs = ps2.executeQuery();
				rs.next();
				
				
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));

				
				break;
			}
//------------------------------------------------------------------------------------------------------------------------

			case 4:
			{
				PreparedStatement ps4= con.prepareStatement("select *from emp");
				Scanner sc4 =new Scanner(System.in);
				
				ResultSet rs4= ps4.executeQuery();
				while(rs4.next())
				{
					System.out.println(rs4.getInt(1));
					System.out.println(rs4.getString(2));
					System.out.println(rs4.getInt(3));

				}
				break;
			}
//------------------------------------------------------------------------------------------------------------------------

			case 5:
			{
				PreparedStatement ps5 = con.prepareStatement("delete from emp where id=?");
				Scanner sc5 = new Scanner(System.in);
				
				System.out.println("enter id to delete that Data");
				System.out.println("enter id to delete");
				int id5=sc5.nextInt();
				ps5.setInt(1, id5);
				ps5.execute();
				System.out.println("values deleted successfully");
				break;
			}
//------------------------------------------------------------------------------------------------------------------------

			case 6:
			{
				PreparedStatement ps11 = con.prepareStatement("delete from emp");
				Scanner sc6 = new Scanner(System.in);
				System.out.println("enter id to delete");
				int id6 = sc6.nextInt();
				ps11.setInt(1, id6);
				ps11.execute();
				System.out.println("values deleted successfully");
				break;
			}
//------------------------------------------------------------------------------------------------------------------------

			default: 
			{
				System.out.println("enter a correct option");
			}
			}
			}
		
		}
		
		
		
		
		
		
	

	
