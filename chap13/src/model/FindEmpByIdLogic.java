package model;

import dao.EmployeeDAO;

public class FindEmpByIdLogic {
	public Employee execute(String id) {
		return new EmployeeDAO().findEmpById(id);
	}
}
