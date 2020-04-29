package homeWork5;

public class Spice extends Ingredient {

	private int quantity;
	private boolean isSpicy;

	public Spice() {
		this("chili", 2, "cup", false);
	}

	public Spice(String name, int quantity, String units, boolean isSpicy) {
		super(name, units);
		setQuantity(quantity);
		setSpicy(isSpicy);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (quantity <= 0) {
			System.out.println("Quantity set to 1");
			this.quantity = 1;
		} else {
			this.quantity = quantity;
		}
	}

	public boolean isSpicy() {
		return isSpicy;
	}

	public void setSpicy(boolean isSpicy) {
		this.isSpicy = isSpicy;
	}

	public void action() {
		System.out.println("Add the " + this.getName());
	}

	public void add() {
		if (this.isSpicy)
			System.out.println(this.getQuantity() + " " + this.getUnits() + " of spicy " + this.getName());
		else
			System.out.println(this.getQuantity() + " " + this.getUnits() + " of " + this.getName());
	}

	@Override
	public String toString() {
		return super.toString() + ", quanntity: " + this.quantity + " spicy: " + this.isSpicy;
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
		return (this.quantity == other.quantity && this.isSpicy == other.isSpicy);
	}

}
