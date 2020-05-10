"# OOP-homeWork6" 

Nir Avisror
Pinhas Ziv

Our function enable the user to create a recipe, by using some ingredients.
Our function have a 3 classes of ingredient: Vegetable, Spice and Protien when each of them has functions that can be applied on them.


Some comments about the code:

1. We decided to create getters for each one of the fields of all the ingredient to make sure that they'll be accessible
because we'll never want to wrote a code that work only in specific scenario, but to think about all edge cases.

2.  We decided to use IOException for all the cases that we asked the user some specific values to enter (because IOException used for input and output exceptions).