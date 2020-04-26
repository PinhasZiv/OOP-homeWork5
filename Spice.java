package homeWork5;

public class Spice extends Ingredient {

	private int quantity;
	private boolean isSpicy;

	public Spice() {
		this("chili", 2, "cup", false);
	}

	// TODO
	// check if we need to generate
	// the quantity field in Ingredient class.
	public Spice(String name, int quantity, String units, boolean isSpicy) {
		super(name, units);
		setQuantity(quantity);
		setSpicy(isSpicy);
	}

	public void action() {
		System.out.println("Add the " + this.getName());
	}

	public void add() {
		if (isSpicy())
			System.out.println(this.getQuantity() + " " + this.getUnits() + " of spicy " + this.getName());
		else
			System.out.println(this.getQuantity() + " " + this.getUnits() + " of " + this.getName());
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isSpicy() {
		return isSpicy;
	}

	public void setSpicy(boolean isSpicy) {
		this.isSpicy = isSpicy;
	}

	
	@Override
	public String toString() {
		return "name: " + this.getName() + ", quantity: " + this.getQuantity() + " " + this.getUnits() + " organic: " + isSpicy();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Spice))
			return false;
		if (!(super.equals(obj)))
			return false;
		Spice other = (Spice) obj;
		return (this.getQuantity() == other.getQuantity()
				&& this.isSpicy() == other.isSpicy());
	}

	
}
