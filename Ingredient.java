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

	public void action() {
		System.out.println("Add the " + this.name);
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
