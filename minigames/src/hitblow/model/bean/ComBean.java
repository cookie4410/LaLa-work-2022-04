package hitblow.model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import hitblow.model.manager.PoolManager;

public class ComBean implements Serializable {
	private String level;
	private List<Integer> atkPool;
	private List<Integer> secPool;
	
	public ComBean(){}
	public ComBean(String level){
		this.level = level;
		secPool = PoolManager.gen();
		atkPool = new ArrayList<>(secPool);
	}

	public List<Integer> getAtkPool() {
		return atkPool;
	}

	public void setAtkPool(List<Integer> atkPool) {
		this.atkPool = atkPool;
	}

	public List<Integer> getSecPool() {
		return secPool;
	}

	public void setSecPool(List<Integer> secPool) {
		this.secPool = secPool;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
}
