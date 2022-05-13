import java.util.List;

import dao.EmployeeDAO;
import model.Employee;

public class SelectEmployeeSample {

	public static void main(String[] args) {
		EmployeeDAO empDAO = new EmployeeDAO();
		boolean result = empDAO.remove("EMP001");
		System.out.println("result: " + result);
		List<Employee> empList = empDAO.findAll();
		
		for(Employee emp : empList) {
			System.out.println("id: " + emp.getId());
			System.out.println("name: " + emp.getName());
			System.out.println("age: " + emp.getAge() + "\n");
		}
	}

}
