package model;

import java.util.List;

import dao.MutterDAO;

public class GetMutterLogic {
	public List<Mutter> execute(){
		MutterDAO dao = new MutterDAO();
		List<Mutter> mutterList = dao.findAll();
		return mutterList;
	}
}
