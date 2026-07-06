package com.coforge.day5.jdbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.*;
public class JdbsInsertTest {

	public static void main(String[] args) throws Exception {
		List<String> enames = new ArrayList<>();
		List<Integer> eids = new ArrayList<>();
		List<Integer> salary = new ArrayList<>();
		List<Integer> dnos = new ArrayList<>();
		
		enames.add("satvika"); 
		eids.add(101);
		salary.add(42000);
		dnos.add(10);
		// step 1 ; load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// step 2; connection with db
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/c", "root", "");
				
		// step 3 ; creating statement
		String sql = "insert into tbl_employee values (?,?,?,?)"; // creating query template using preparedStatement
		PreparedStatement statement = connection.prepareStatement(sql);
		
		// step 4 ;  executing the query
		for(int i=0;i<enames.size();i++) {
		statement.setInt(1,eids.get(i));
		statement.setString(2, enames.get(i));
		statement.setInt(3, salary.get(i));
		statement.setInt(4, dnos.get(i));
		}
		int n = statement.executeUpdate(); // method for insert, delete and update query, it tells how many rows are updated
		if(n==1) System.out.println("Employee details saved");
		else System.out.println("Employee details not saved");
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
