package hitblow.model.bean;

import java.util.ArrayList;
import java.util.List;

public class LogBean {
	private List<String> numLog;
	private List<String> hitLog;
	private List<String> blowLog;
	
	public LogBean() {
		numLog = new ArrayList<>();
		hitLog = new ArrayList<>();
		blowLog = new ArrayList<>();
	}

	public List<String> getNumLog() {
		return numLog;
	}

	public void setNumLog(List<String> numLog) {
		this.numLog = numLog;
	}

	public List<String> getHitLog() {
		return hitLog;
	}

	public void setHitLog(List<String> hitLog) {
		this.hitLog = hitLog;
	}

	public List<String> getBlowLog() {
		return blowLog;
	}

	public void setBlowLog(List<String> blowLog) {
		this.blowLog = blowLog;
	}

}
