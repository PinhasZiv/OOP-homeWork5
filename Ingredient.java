package homeWork6;

//Nir Avisror 311499958  Pinhas Ziv 315709139

// Abstract class of general product in recipe
public abstract class Ingredient {

	private String name;
	private int quantity;
	private String units;

	// Default constructor
	public Ingredient() throws IllegalArgumentException {
		this("oil", 3, "cup");
	}

	// Fields constructor
	public Ingredient(String name, int quantity, String units) throws IllegalArgumentException {
		setName(name);
		setQuantity(quantity);
		setUnits(units);
	}

	//TODO
	// check if need to remove getters.
	public String getName() {
		return name;
	}

	protected void setName(String name) throws NullPointerException {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	protected void setQuantity(int quantity) throws IllegalArgumentException {
		if (quantity <= 0) {
			throw new IllegalArgumentException("quantity must be greater than 0");
		} else {
			this.quantity = quantity;
		}
	}

	public String getUnits() {
		return units;
	}

	protected void setUnits(String units) throws NullPointerException {
		this.units = units;
	}

	public abstract void action();

	public abstract void add();

	@Override
	public String toString() {
		return "name: " + this.name + ", quantity" + this.quantity + ", units: " + this.units;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Ingredient))
			return false;
		Ingredient other = (Ingredient) obj;
		return (this.name == other.name && this.quantity == other.quantity && this.units == other.units);
	}

}
