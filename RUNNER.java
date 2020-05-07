package homeWork6;

import java.io.IOException;
import java.util.InputMismatchException;

//Nir Avisror 311499958  Pinhas Ziv 315709139

import java.util.Scanner;

public class RUNNER {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException, InputMismatchException {
		int numOfIngredients = 0;
		int ingChoice = 0;
		boolean validRecipeSize = false;

		// ************************ 2 ***********************
		while (!validRecipeSize) {
			System.out.println("How many ingredients are in the recipe?");
			try {
				numOfIngredients = sc.nextInt();
				if (numOfIngredients < 2 || numOfIngredients > 5)
					throw new IOException(
							"Recipe size should be 2-5. but " + numOfIngredients + " was entered. Please try again");
				else
					validRecipeSize = true;
			} catch (IOException | InputMismatchException e) {
				System.out.println(e.getMessage());
			} // TODO Check if we need to catch the super class of Exception
		}
		// ************************ 3 ***********************

		Ingredient recipe[] = new Ingredient[numOfIngredients];

		// ************************ 4 ***********************
		boolean isHealthy = false;

		while (!isHealthy) {
			for (int i = 0; i < recipe.length; i++) {
				boolean validUserChoice = false;
				while (!validUserChoice) {
					printMessage();
					try {
						ingChoice = sc.nextInt();
						if (ingChoice < 1 || ingChoice > 3)
							throw new IOException("You must select a number between 1-3. but " + ingChoice
									+ " was entered. Please try again");
						else
							validUserChoice = true;
					} catch (IOException | InputMismatchException e) {
						System.out.println(e.getMessage());
					}
					// TODO Check if we need to catch the super class of Exception
				}

				String tempName = null, tempUnits = null;
				int tempQuantity = 0;
				validUserChoice = false;

				while (!validUserChoice) {

					try {
						System.out.println("What is the product name?");
						tempName = sc.next();
						System.out.println("What units of measure to use?");
						tempUnits = sc.next();
						System.out.println("How much to add from this product?");
						tempQuantity = sc.nextInt();

						if (tempQuantity < 1)
							throw new IOException("You can't enter less then 1 ingredient");

						switch (ingChoice) {
						case 1:
							Vegetable tempVeg = new Vegetable(tempName, tempQuantity, tempUnits, false);
							System.out.println("Is the vegetable organic? (0 = yes, else = no)");
							tempVeg.setOrganic(userChoice(sc.nextInt()));
							recipe[i] = tempVeg;
							break;
						case 2:
							Spice tempSip = new Spice(tempName, tempQuantity, tempUnits, false);
							System.out.println("Is the spice spicy? (0 = yes, else = no)");
							tempSip.setSpicy(userChoice(sc.nextInt()));
							recipe[i] = tempSip;
							break;
						case 3:
							Protein tempPro = new Protein(tempName, tempQuantity, tempUnits, false);
							System.out.println("Is the protein is replacement? (0 = yes, else = no)");
							tempPro.setReplacement(userChoice(sc.nextInt()));
							recipe[i] = tempPro;
							break;
						}
						// Now we make sure that all fields was entered are valid.
						validUserChoice = true;
						int leftIngredient = (recipe.length - 1) - i;
						if (leftIngredient != 0)
						System.out.println(leftIngredient + " ingredient left to choose");
					} catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
						System.out.println("Please try again");
						i--;
					} catch (InputMismatchException e) {
						System.out.println("You have to enter an integer. please try again");
					} catch (NullPointerException | IOException e) {
						System.out.println(e.getMessage());
						System.out.println("Please try again");
					}
					sc.nextLine();
				}
			}
			try {
				isHealthy = checkHealthiness(recipe);
			} catch (UnhealthyException e) {
				System.out.println(e.getMessage());
				System.out.println("you have to make new recipe");
			}
		}
		// ************************** 5 *********************

		for (Ingredient ing : recipe) {

			ing.add();

		}

		System.out.println();

		// ************************** 6 *********************

		for (Ingredient ing : recipe) {
			ing.action();
		}
		sc.close();
	}

	private static void printMessage() {
		System.out.println("Hello.\n" + "What would you like to add to the salad?\n" + "Vegetable - press 1\n"
				+ "Spice - prees 2\n" + "Protein - press 3");
	}

	private static boolean checkHealthiness(Ingredient[] ing) throws UnhealthyException {
		boolean veg = false, pro = false;
		for (int i = 0; i < ing.length; i++) {
			if (ing[i] instanceof Vegetable)
				veg = true;
			if (ing[i] instanceof Protein)
				pro = true;
			if (veg && pro)
				break;
		}
		if (veg && pro)
			return true;
		else {
			throw new UnhealthyException("This recipe is unhealthy");
		}
	}

	// Auxiliary function that returns true or false
	// depending on user choice (0 = true, else = false)
	private static boolean userChoice(int choice) {
		if (choice == 0) {
			return true;
		} else {
			return false;
		}
	}
}
