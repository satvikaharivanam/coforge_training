package com.coforge.day5.jdbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcUpdateTest {

	public static void main(String[] args) throws Exception {
		
		// step 1 ; load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// step 2; connection with db
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/c", "root", "");
				
		// step 3 ; creating statement
		String sql = "update tbl_employee set ename = ?, esalary = ? where eid = ?"; // creating query template using preparedStatement
		PreparedStatement statement = connection.prepareStatement(sql);
		
		// step 4 ;  executing the query
//		statement.setInt(1,"satvika");
		statement.setString(1, "neha");
		statement.setInt(2, 42000);
		statement.setInt(3, 101);
		int n = statement.executeUpdate(); // method for insert, delete and update query, it tells how many rows are updated
		if(n==1) System.out.println("Employee details updated");
		else System.out.println("Employee details not updated");
//		ResultSet rs = statement.executeQuery();
//		
//		if(rs.next()) {
//			System.out.println(rs.getInt("eid") + " "+ rs.getString("ename") + " " + ("esalary") + " " + ("dno"));
// 		}
		// step 5;  closing
		statement.close();
		connection.close();

	}
	

}
