package homeWork5;

import java.util.Scanner;

public class RecipeRunner {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int numOfIngredients;
		
		do {
			System.out.println("How many ingredients are in the recipe?");
			numOfIngredients = sc.nextInt();
			if(numOfIngredients < 1)
			System.out.println("Minimum Products: 1. Please try again:\n");
		} while (numOfIngredients < 1);

		Ingredient recipe[] = new Ingredient[numOfIngredients];

		for (int i = 0; i < recipe.length; i++) {
			System.out.println("Hello.\n" + "What would you like to add to the salad?\n" + "Vegetable - press 1\n"
					+ "Spice - prees 2\n" + "Protein - press 3");
			int userCoice = sc.nextInt();
			String tempName, tempUnits;
			int tempQuantity;

			System.out.println("What is the product name?");
			tempName = sc.next();
			System.out.println("What units of measure to use?");
			tempUnits = sc.next();
			System.out.println("How much to add from this product?");
			tempQuantity = sc.nextInt();

			switch (userCoice) {
			case 1:
				recipe[i] = new Vegetable(tempName, tempQuantity, tempUnits, false);
				System.out.println("Is the vegetable organic? (0 = yes, else = no)");
				((Vegetable)recipe[i]).setOrganic(userChoice(sc.nextInt()));
				break;
			case 2:
				recipe[i] = new Spice(tempName, tempQuantity, tempUnits, false);
				System.out.println("Is the spice spicy? (0 = yes, else = no)");
				((Spice)recipe[i]).setSpicy(userChoice(sc.nextInt()));
				break;
			case 3:
				recipe[i] = new Protein(tempName, tempQuantity, tempUnits, false);
				System.out.println("Is the protein is replacement? (0 = yes, else = no)");
				((Protein)recipe[i]).setReplacement(userChoice(sc.nextInt()));
				break;
			}
		}
		
		for (Ingredient ing: recipe) {
			if(ing instanceof Vegetable)
				((Vegetable) ing).add();
			if(ing instanceof Spice)
				((Spice) ing).add();
			if(ing instanceof Protein)
				((Protein) ing).add();
		}
		
		System.out.println();
		
		for (Ingredient ing: recipe) {
			if(ing instanceof Vegetable)
				((Vegetable) ing).action();
			if(ing instanceof Spice)
				((Spice) ing).action();
			if(ing instanceof Protein)
				((Protein) ing).action();
		}
	}
	
	public static boolean userChoice(int choice) {
		if(choice == 0) {
			return true;
		} else {
			return false;
		}
	}
}
