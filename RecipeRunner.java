package homeWork5;

import java.util.Scanner;

// TODO
// add comments here.
// check about using new class for quantity and add+action functions.
public class RecipeRunner {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int numOfIngredients;
		int ingChoice;
		do {
			System.out.println("How many ingredients are in the recipe?");
			numOfIngredients = sc.nextInt();
			if (numOfIngredients < 1)
				System.out.println("Minimum Products: 1. Please try again:\n");
		} while (numOfIngredients < 1);

		Ingredient recipe[] = new Ingredient[numOfIngredients];

		for (int i = 0; i < recipe.length; i++) {
			do {
				System.out.println("Hello.\n" + "What would you like to add to the salad?\n" + "Vegetable - press 1\n"
						+ "Spice - prees 2\n" + "Protein - press 3");
				ingChoice = sc.nextInt();
				if (ingChoice < 1 || ingChoice > 3)
					System.out.println("Choose a number between 1 and 3\n");
			} while (ingChoice < 1 || ingChoice > 3);
			
			String tempName, tempUnits;
			int tempQuantity;

			System.out.println("What is the product name?");
			tempName = sc.next();
			System.out.println("What units of measure to use?");
			tempUnits = sc.next();
			System.out.println("How much to add from this product?");
			tempQuantity = sc.nextInt();

			switch (ingChoice) {
			case 1:
				Vegetable tempVeg = new Vegetable(tempName, tempQuantity, tempUnits, false);
				System.out.println("Is the vegetable organic? (0 = yes, else = no)");
				tempVeg.setOrganic(validUserChoice(sc.nextInt()));
				recipe[i] = tempVeg;
				break;
			case 2:
				Spice tempSip = new Spice(tempName, tempQuantity, tempUnits, false);
				System.out.println("Is the spice spicy? (0 = yes, else = no)");
				tempSip.setSpicy(validUserChoice(sc.nextInt()));
				recipe[i] = tempSip;
				break;
			case 3:
				Protein tempPro = new Protein(tempName, tempQuantity, tempUnits, false);
				System.out.println("Is the protein is replacement? (0 = yes, else = no)");
				tempPro.setReplacement(validUserChoice(sc.nextInt()));
				recipe[i] = tempPro;
				break;
			}
		}

		for (Ingredient ing : recipe) {
			if (ing instanceof Vegetable)
				((Vegetable) ing).add();
			if (ing instanceof Spice)
				((Spice) ing).add();
			if (ing instanceof Protein)
				((Protein) ing).add();
		}

		System.out.println();

		for (Ingredient ing : recipe) {
			if (ing instanceof Vegetable)
				((Vegetable) ing).action();
			if (ing instanceof Spice)
				((Spice) ing).action();
			if (ing instanceof Protein)
				((Protein) ing).action();
		}
		sc.close();
	}

	public static boolean validUserChoice(int choice) {
		if (choice == 0) {
			return true;
		} else {
			return false;
		}
	}
}
