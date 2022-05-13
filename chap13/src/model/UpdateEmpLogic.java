package model;

import dao.EmployeeDAO;

public class UpdateEmpLogic {
	public boolean execute(Employee emp) {
		return new EmployeeDAO().update(emp);
	}
}
