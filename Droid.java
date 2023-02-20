public class Droid {
	String name;
	int batteryLevel;

	public Droid(String droidName) {
		name = droidName;
		batteryLevel = 100;
	}

	public String toString() {
		return "Hello, I’m the droid: " + name;
	}

	public void performTask(String task) {
		System.out.println(name + " is performing task" + task);
		batteryLevel = batteryLevel - 10;
	}

	public void energyReport() {
		System.out.println(batteryLevel);
	}

	public static void main(String[] args) {
		Droid Codey = new Droid("SKM");
		System.out.println(Codey);
		System.out.println(Codey.batteryLevel);
		Codey.performTask("dancing");
		Codey.performTask("singing");
		Codey.energyReport();
		Droid margot = new Droid("IW");
		System.out.println(margot);
		margot.energyReport();
	}
}