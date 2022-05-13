package model;

import dao.EmployeeDAO;

public class InsertEmpLogic {
	public boolean execute(Employee emp) {
		return new EmployeeDAO().create(emp);
	}
}
