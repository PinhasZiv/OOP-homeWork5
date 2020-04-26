package homeWork5;

public class Protein extends Ingredient {

	private int quantity;
	private boolean isReplacement;

	public Protein() {
		this("protein", 100, "gram", true);
	}
	public Protein(String name, int quantity, String units, boolean isReplacement) {
		super(name, units);
		setQuantity(quantity);
		setReplacement(isReplacement);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isReplacement() {
		return isReplacement;
	}

	public void setReplacement(boolean isReplacement) {
		this.isReplacement = isReplacement;
	}

	// TODO
	// add toString, equals, action, add.
}
