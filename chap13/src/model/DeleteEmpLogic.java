package model;

import dao.EmployeeDAO;

public class DeleteEmpLogic {
	public boolean execute(String id) {
		return new EmployeeDAO().remove(id);
	}
}
