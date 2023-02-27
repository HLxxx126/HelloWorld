public class VarParameterExercise {
	public static void main(String[] args) {
		HspMethod hp = new HspMethod();
		System.out.println(hp.showScore("Tim", 83.2, 76.5, 99.6));
	}
}

class HspMethod {
	public String showScore(String name, double... scores) {
		double totalScore = 0;
		for (int i = 0; i < scores.length; i++) {
			totalScore += scores[i];
		}
		return name + scores.length + "门课的成绩总分为" + totalScore;
	}
}