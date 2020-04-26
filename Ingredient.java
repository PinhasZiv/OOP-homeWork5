package homeWork5;

public class Ingredient {

	private String name;
	private String units;

	public Ingredient() {
		this("oil", "cup");
	}

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
		return "name: " + this.name + ", units: " + units;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Ingredient))
			return false;
		Ingredient other = (Ingredient) obj;
		return (this.name == other.getName() && this.units == other.units);
	}

}
