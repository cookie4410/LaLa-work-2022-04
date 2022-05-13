package test;

import java.util.List;

import dao.MutterDAO;
import model.Mutter;

public class MutterDAOTest {

	public static void main(String[] args) {
		MutterDAO dao = new MutterDAO();
		List<Mutter> mutterList = dao.findAll();
		for(Mutter mutter : mutterList) {
			System.out.println("id: " + mutter.getId());
			System.out.println("name: " + mutter.getUserName());
			System.out.println("text: " + mutter.getText());
		}
	}

}
