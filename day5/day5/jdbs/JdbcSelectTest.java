package com.coforge.day5.jdbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcSelectTest {

	public static void main(String[] args) throws Exception {
		
		// step 1 ; load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// step 2; connection with db
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/c", "root", "");
				
		// step 3 ; creating statement
		String sql = "select * from tbl_employee"; // creating query template using preparedStatement
		PreparedStatement statement = connection.prepareStatement(sql);
		
		// step 4 ;  executing the query
//		
		
		ResultSet result = statement.executeQuery() ;
		while(result.next()) {
			System.out.println(result.getInt("eid")+" "+result.getString("ename")+" "+ result.getInt("esalary")+" "+result.getInt("dno"));
		}
//		
		// step 5;  closing
		result.close();
		statement.close();
		connection.close();

	}
	

}
