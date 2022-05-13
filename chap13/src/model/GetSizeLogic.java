package model;

import dao.EmployeeDAO;

public class GetSizeLogic {
	public int execute() {
		return new EmployeeDAO().getSize();
	}
}
