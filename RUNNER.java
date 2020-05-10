package homeWork6;

import java.io.IOException;
import java.util.InputMismatchException;

//Nir Avisror 311499958  Pinhas Ziv 315709139

import java.util.Scanner;

public class RUNNER {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException, InputMismatchException, Exception {

		boolean isHealthy = false;
		Ingredient[] recipe = new Ingredient[1];

		// running operation by while loop to make sure that
		// the recipe that was created by user is unhealthy.
		while (!isHealthy) {

			// call the function that create a recipe and get the recipe.
			recipe = makeRecipe();

			try {
				// check if the recipe is healthy.
				isHealthy = checkHealthiness(recipe);
				isHealthy = true;
			} catch (UnhealthyException e) {
				System.out.println(e.getMessage());
				System.out.println("you have to make a new recipe\n" + "*******************************\n");
				sc.nextLine(); // clean buffer.
			}
		}

		// call the function that print 'add' and 'action' functions.
		runTasks(recipe);

		sc.close();
	}

	// function that make recipe by order.
	private static Ingredient[] makeRecipe() {
		int numOfIngredients = 0;
		int ingChoice = 0;
		boolean validRecipeSize = false;

		// try to get size of recipe by while loop to make sure that
		// the recipe size that was entered by user is valid.
		while (!validRecipeSize) {
			System.out.println("How many ingredients are in the recipe?");
			try {
				numOfIngredients = sc.nextInt();
				if (numOfIngredients < 2 || numOfIngredients > 5)
					throw new IOException(
							"Recipe size should be 2-5. but " + numOfIngredients + " was entered. Please try again");
				else
					validRecipeSize = true;

			} catch (InputMismatchException e) {
				System.out.println("You have to enter an integer. Please try again.");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println("General exception: " + e.getMessage());
			}
			sc.nextLine(); // clean buffer
		}

		// create array of ingredient for the recipe.
		Ingredient recipe[] = new Ingredient[numOfIngredients];

		/// running on the array by for loop to fill the ingredients.
		for (int i = 0; i < recipe.length; i++) {
			boolean validUserChoice = false;
			
			// try to get kind of ingredient by while loop to make sure that
			// the kind of ingredient that was entered by user is valid.
			while (!validUserChoice) {
				printMessage();
				try {
					ingChoice = sc.nextInt();
					if (ingChoice < 1 || ingChoice > 3)
						throw new IOException("You must select a number between 1-3. but " + ingChoice
								+ " was entered. Please try again");
					else
						validUserChoice = true;
				} catch (InputMismatchException e) {
					System.out.println("You have to enter an integer. Please try again.");
				} catch (IOException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println("General exception: " + e.getMessage());
				}
				sc.nextLine(); // clean buffer
			}

			String tempName = null, tempUnits = null;
			int tempQuantity = 0;
			validUserChoice = false;

			// try to get values of ingredient by while loop to make sure that
			// the values that was entered by user are valid.
			while (!validUserChoice) {

				try {
					System.out.println("What is the ingredient name?");
					tempName = sc.next();
					System.out.println("What units of measure to use?");
					tempUnits = sc.next();
					System.out.println("How much to add from this product?");
					tempQuantity = sc.nextInt();

					// check if quantity that entered by user < 1
					// and throw IOException (input output Exception).
					if (tempQuantity < 1)
						throw new IOException("You can't enter less then 1 ingredient");

					// using switch for the fields that unique to each ingredient
					// and initialize new object by user choice.
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
					
					// print to console the number of ingredient that left to choos.
					int leftIngredient = (recipe.length - 1) - i;
					if (leftIngredient != 0)
						System.out.println(leftIngredient + " ingredient left to choose");

				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					System.out.println("Please try again");
				} catch (InputMismatchException e) {
					System.out.println("You have to enter an integer. please try again");
				} catch (NullPointerException | IOException e) {
					System.out.println(e.getMessage());
					System.out.println("Please try again");
				} catch (Exception e) {
					System.out.println("General exception: " + e.getMessage());
				}
				sc.nextLine(); // clean buffer.
			}
		}
		return recipe;
	}

	// function that calling the 'add' and 'action' to each of ingredient in the recipe.
	private static void runTasks(Ingredient[] recipe) {
		for (Ingredient ing : recipe) {
			ing.add();
		}

		System.out.println();

		for (Ingredient ing : recipe) {
			ing.action();
		}
	}

	// function that print the message of choosing ingredient to console.
	private static void printMessage() {
		System.out.println("Hello.\n" + "What would you like to add to the salad?\n" + "Vegetable - press 1\n"
				+ "Spice - prees 2\n" + "Protein - press 3");
	}

	// function that check if the recipe is healthy and throw unhealthyException if not.
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

	// function that returns true or false
	// depending on user choice (0 = true, else = false)
	private static boolean userChoice(int choice) {
		if (choice == 0) {
			return true;
		} else {
			return false;
		}
	}
}
