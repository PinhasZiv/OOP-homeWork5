package homeWork6;

//Nir Avisror 311499958  Pinhas Ziv 315709139

public class Spice extends Ingredient {

	private boolean isSpicy;

	// Default constructor
	public Spice() throws IllegalArgumentException{
		this("chili", 2, "cup", false);
	}

	// Fields constructor
	public Spice(String name, int quantity, String units, boolean isSpicy) throws IllegalArgumentException {
		super(name, quantity, units);
		setSpicy(isSpicy);
	}

	public boolean isSpicy() {
		return isSpicy;
	}

	protected void setSpicy(boolean isSpicy) throws IllegalArgumentException {
		this.isSpicy = isSpicy;
	}

	// A function that prints the component preparation
	@Override
	public void action() {
		System.out.println("Add the " + this.getName());
	}

	// A function that prints the amount of spice added to the recipe instructions
	// Depending on the type of spice (spicy or not)
	@Override
	public void add() {
		if (this.isSpicy)
			System.out.println(this.getQuantity() + " " + this.getUnits() + " of spicy " + this.getName());
		else
			System.out.println(this.getQuantity() + " " + this.getUnits() + " of " + this.getName());
	}

	@Override
	public String toString() {
		return super.toString() + " spicy: " + this.isSpicy;
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
		return (this.isSpicy == other.isSpicy);
	}

}
