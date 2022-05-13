package model;

import java.util.List;

import dao.EmployeeDAO;

public class GetEmpListLogic {
	public List<Employee> execute(int skip, int perPage){
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> empList = dao.findAll(skip, perPage);
		return empList;
	}

}
