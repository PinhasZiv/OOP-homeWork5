package homeWork6;

//Nir Avisror 311499958  Pinhas Ziv 315709139

public class Protein extends Ingredient {

	private boolean isReplacement;

	public Protein() throws IllegalArgumentException {
		this("protein", 100, "gram", true);
	}

	public Protein(String name, int quantity, String units, boolean isReplacement) throws IllegalArgumentException {
		super(name, 3, units);
		setReplacement(isReplacement);
	}

	public boolean isReplacement() {
		return isReplacement;
	}

	protected void setReplacement(boolean isReplacement) throws IllegalArgumentException {
		this.isReplacement = isReplacement;
	}

	// A function that prints the component preparation
	@Override
	public void action() {
		System.out.println("cook the " + this.getName());
	}

	// A function that prints the amount of protein added to the recipe instructions
	// Depending on the type of protein (replacement or not)
	@Override
	public void add() {
		if (this.isReplacement)
			System.out.println(this.getQuantity() + " " + this.getUnits() + " of replacement " + this.getName());
		else
			System.out.println(this.getQuantity() + " " + this.getUnits() + " of " + this.getName());
	}

	@Override
	public String toString() {
		return super.toString() + " replacement: " + this.isReplacement;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Protein))
			return false;
		if (!(super.equals(obj)))
			return false;
		Protein other = (Protein) obj;
		return (this.isReplacement == other.isReplacement);
	}
}
