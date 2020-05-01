package homeWork5;

public class Vegetable extends Ingredient {

	private int quantity;
	private boolean isOrganic;

	// Default constructor
	public Vegetable() {
		this("tomato", 4, "units", true);
	}

	// Fields constructor
	public Vegetable(String name, int quantity, String units, boolean isOrganic) {
		super(name, units);
		setQuantity(quantity);
		setOrganic(isOrganic);
	}

	public int getQuantity() {
		return quantity;
	}

	// Defines the quantity field (quantity > 0. default = 1)
	public void setQuantity(int quantity) {
		if(quantity < 1) {
			System.out.println("Quantity set to 1");
			this.quantity = 1;
		} else{
			this.quantity = quantity;
		}
	}
	
	public boolean isOrganic() {
		return isOrganic;
	}

	public void setOrganic(boolean isOrganic) {
		this.isOrganic = isOrganic;
	}

	// A function that prints the component preparation
	public void action() {
		System.out.println("Chop the " + this.getName() + "s");
	}

	// A function that prints the amount of vegetables added to the recipe instructions
	// Depending on the type of vegetable (organic or not)
	public void add() {
		if(this.isOrganic) {
			System.out.println(this.getQuantity() + " " + this.getUnits() + " of organic " + this.getName());
		} else {
			System.out.println(this.getQuantity() + " " + this.getUnits() + " of " + this.getName());
		}
	}
	
	@Override
	public String toString() {
		return super.toString()+ ", quantity: " + this.quantity + ", organic: " + this.isOrganic;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Vegetable))
			return false;
		Vegetable other = (Vegetable) obj;
		return (this.quantity == other.quantity 
				&& this.isOrganic == other.isOrganic);
	}
	
}
