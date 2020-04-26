package homeWork5;

public class Vegetable extends Ingredient {

	private int quantity;
	private boolean isOrganic;

	public Vegetable() {
		this("tomato", 5, "units", true);
	}

	public Vegetable(String name, int quantity, String units, boolean isOrganic) {
		super(name, units);
		setQuantity(quantity);
		setOrganic(isOrganic);
	}

	public void action() {
		System.out.println("Chop the " + this.getName() + "s");
	}

	public void add() {
		if (isOrganic())
			System.out.println(this.getQuantity() + " " + this.getUnits() + " of organic " + this.getName());
		else
			System.out.println(this.getQuantity() + " " + this.getUnits() + " of " + this.getName());
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isOrganic() {
		return isOrganic;
	}

	public void setOrganic(boolean isOrganic) {
		this.isOrganic = isOrganic;
	}

	@Override
	public String toString() {
		return "name: " + this.getName() + ", quantity: " + this.getQuantity() + " " + this.getUnits() + " organic: " + isOrganic();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Vegetable))
			return false;
		if (!(super.equals(obj)))
			return false;
		Vegetable other = (Vegetable) obj;
		return (this.quantity == other.getQuantity() && this.isOrganic == other.isOrganic());
	}

}
