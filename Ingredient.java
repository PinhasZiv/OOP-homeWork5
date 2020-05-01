package homeWork5;

// Abstract class of general product in recipe
public abstract class Ingredient {

	private String name;
	private String units;

	// Default constructor
	public Ingredient() {
		this("oil", "cup");
	}

	// Fields constructor
	public Ingredient(String name, String units) {
		setName(name);
		setUnits(units);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	@Override
	public String toString() {
		return "name: " + this.name + ", units: " + this.units;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Ingredient))
			return false;
		Ingredient other = (Ingredient) obj;
		return (this.name == other.name && this.units == other.units);
	}

}
