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
	
	public List<Employee> findAll(int skip, int perPage){
		List<Employee> empList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT id, name, age FROM employee"
					 + " LIMIT ?, ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, skip);
			pStmt.setInt(2, perPage);
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
	
	public boolean create (Employee emp) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "INSERT INTO employee (id, name, age) VALUES" +
						"(?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, emp.getId());
			pStmt.setString(2, emp.getName());
			pStmt.setInt(3, emp.getAge());
			int result = pStmt.executeUpdate();
			return (result == 1);
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean remove(String id) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "DELETE FROM employee WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, id);
			int result = pStmt.executeUpdate();
			
			return (result == 1);
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(Employee emp) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "UPDATE employee SET name=?, age=?"
					+ " WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, emp.getName());
			pStmt.setInt(2, emp.getAge());
			pStmt.setString(3, emp.getId());
			int result = pStmt.executeUpdate();
			
			return (result == 1);
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Employee findEmpById(String _id) {
		Employee emp = null;
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT id, name, age FROM employee WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, _id);
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				emp = new Employee(id, name, age);
			}
			return emp;
		} catch(SQLException e) {
			e.printStackTrace();
			return emp;
		}
	}
	
	public List<Employee> findEmpByName(String _name){
		List<Employee> empList = new ArrayList<Employee>();
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT id, name, age FROM employee WHERE name LIKE ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, "%" + _name + "%");
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				empList.add(new Employee(id, name, age));
			}
			
			return empList;
		} catch(SQLException e) {
			e.printStackTrace();
			return empList;
		}
	}
	
	public int getSize() {
		int count = 0;
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT COUNT(*) FROM employee";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			rs.next();
			count = rs.getInt(1);
			return count;
		} catch(SQLException e) {
			e.printStackTrace();
			return count;
		}
	}
}
