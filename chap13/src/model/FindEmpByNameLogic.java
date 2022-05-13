package model;

import java.util.List;

import dao.EmployeeDAO;

public class FindEmpByNameLogic {
	public List<Employee> execute(String name) {
		return new EmployeeDAO().findEmpByName(name);
	}
}
