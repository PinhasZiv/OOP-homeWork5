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
		if (quantity <= 0) {
			System.out.println("Quantity set to 1");
			this.quantity = 1;
		} else {
			this.quantity = quantity;
		}
	}
	
	public boolean isReplacement() {
		return isReplacement;
	}

	public void setReplacement(boolean isReplacement) {
		this.isReplacement = isReplacement;
	}
	
	public void action() {
		System.out.println("cook the " + this.getName());
	}

	public void add() {
		if (this.isReplacement)
			System.out.println(this.getQuantity() + " " + this.getUnits() + " of replacement " + this.getName());
		else
			System.out.println(this.getQuantity() + " " + this.getUnits() + " of " + this.getName());
	}
	
	@Override
	public String toString() {
		return super.toString() + ", quantity: " + this.quantity + " replacement: " + this.isReplacement; 
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(!(obj instanceof Protein))
			return false;
		if(!(super.equals(obj)))
			return false;
		Protein other = (Protein) obj;
		return (this.quantity == other.quantity && this.isReplacement == other.isReplacement);
	}

	
	// TODO
	// add action, add.
}
