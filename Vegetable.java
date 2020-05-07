package homeWork6;

//Nir Avisror 311499958  Pinhas Ziv 315709139

public class Vegetable extends Ingredient {
	
	private boolean isOrganic;

	// Default constructor
	public Vegetable() throws IllegalArgumentException {
		this("tomato", 4, "units", true);
	}

	// Fields constructor
	public Vegetable(String name, int quantity, String units, boolean isOrganic) throws IllegalArgumentException{
		super(name, quantity, units);
		setOrganic(isOrganic);
	}
	
	public boolean isOrganic() {
		return isOrganic;
	}

	protected void setOrganic(boolean isOrganic) throws IllegalArgumentException {
		this.isOrganic = isOrganic;
	}

	// A function that prints the component preparation
	@Override
	public void action() {
		System.out.println("Chop the " + this.getName() + "s");
	}

	// A function that prints the amount of vegetables added to the recipe instructions
	// Depending on the type of vegetable (organic or not)
	@Override
	public void add() {
		if(this.isOrganic) {
			System.out.println(this.getQuantity() + " " + this.getUnits() + " of organic " + this.getName());
		} else {
			System.out.println(this.getQuantity() + " " + this.getUnits() + " of " + this.getName());
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + ", organic: " + this.isOrganic;
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
		return (this.isOrganic == other.isOrganic);
	}
}
