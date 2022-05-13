package model;

public class HealthCheckLogic {
	/**
	 * BMI指数を算出して、体型を判定する。
	 * 
	 * @param health -- JavaBeans。healthインスタンスへの参照。
	 * @return なし。
	 */
	public void execute(Health health) {
		double weight = health.getWeight();
		double height = health.getHeight() / 100.0;
		double bmi = weight / (height * height);
		health.setBmi(bmi);

		String bodyType;
		if (bmi < 18.5) {
			bodyType = "痩せ型";
		} else if (bmi < 25) {
			bodyType = "普通";
		} else {
			bodyType = "肥満";
		}
		health.setBodyType(bodyType);
	}
}
