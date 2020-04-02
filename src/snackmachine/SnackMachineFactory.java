package snackmachine;

public class SnackMachineFactory {
	public static SnacksMachine createSnacksMachine() {
		return new SnackMachineImpl();
	}
}
