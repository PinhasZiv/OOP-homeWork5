package homeWork6;

import java.io.IOException;
import java.util.InputMismatchException;

//Nir Avisror 311499958  Pinhas Ziv 315709139

import java.util.Scanner;

public class RUNNER {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException, InputMismatchException, Exception {

		// TODO
		// add comments.

		boolean isHealthy = false;
		// TODO
		// check if OK to initialize the array to null.
		Ingredient[] recipe = null;

		while (!isHealthy) {
			recipe = makeRecipe();

			try {
				isHealthy = checkHealthiness(recipe);
				isHealthy = true;
			} catch (UnhealthyException e) {
				System.out.println(e.getMessage());
				System.out.println("you have to make a new recipe\n" + "*******************************\n");
			}
		}

		runTasks(recipe);

		sc.close();
	}

	private static Ingredient[] makeRecipe() {
		int numOfIngredients = 0;
		int ingChoice = 0;
		boolean validRecipeSize = false;

		while (!validRecipeSize) {
			System.out.println("How many ingredients are in the recipe?");
			try {
				numOfIngredients = sc.nextInt();
				if (numOfIngredients < 2 || numOfIngredients > 5)
					throw new IOException(
							"Recipe size should be 2-5. but " + numOfIngredients + " was entered. Please try again");
				else
					validRecipeSize = true;
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println("You have to enter an integer. Please try again.");
			} catch (Exception e) {
				System.out.println("General exception: " + e.getMessage());
			}
			sc.nextLine();
		}

		Ingredient recipe[] = new Ingredient[numOfIngredients];

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
				} catch (IOException e) {
					System.out.println(e.getMessage());
				} catch (InputMismatchException e) {
					System.out.println("You have to enter an integer. Please try again.");
				} catch (Exception e) {
					System.out.println("General exception: " + e.getMessage());
				}
				sc.nextLine();
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

					// TODO
					// check if need to move this to setQuantity.
					if (tempQuantity < 1)
						throw new IOException("You can't enter less then 1 ingredient");

					// TODO
					// need to check about the boolean
					// (we used nextInt to get from user. maybe we need to use: next()).
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
					i--;
				} catch (NullPointerException | IOException e) {
					System.out.println(e.getMessage());
					System.out.println("Please try again");
					i--;
				} catch (Exception e) {
					System.out.println("General exception: " + e.getMessage());
					i--;
				}
				sc.nextLine();
			}
		}
		return recipe;
	}

	private static void runTasks(Ingredient[] recipe) {
		for (Ingredient ing : recipe) {
			ing.add();
		}

		System.out.println();

		for (Ingredient ing : recipe) {
			ing.action();
		}
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
