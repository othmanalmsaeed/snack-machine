package snackmachine;

public enum SnackType {

	GUM("Gum", 25), CHIPS("Chips", 75), CHOCKLATE("Chockolate", 100);
	private String name;
	private int price;

	private SnackType(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public long getPrice() {
		return price;
	}
}
	