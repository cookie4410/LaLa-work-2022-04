package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeeDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public List<Employee> findAll(){
		List<Employee> empList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT id, name, age FROM employee";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				Employee employee = new Employee(id, name, age);
				empList.add(employee);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;
	}
	
	public boolean remove(String id) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "DELETE FROM employee WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, id);
			int result = pStmt.executeUpdate();
			
			return (result == 1) ? true : false;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
