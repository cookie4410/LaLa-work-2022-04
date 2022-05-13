package util;

import javax.servlet.http.HttpServletRequest;

import model.Employee;

public class GetParam {
	/**
	 * 
	 * @param request
	 * @return Employee
	 */
	public static Employee recive(HttpServletRequest request) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		return new Employee(id, name, age);
	}
}
