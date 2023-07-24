package tacos.data;

import java.util.Optional;

import tacos.Ingredient;

public interface IngredientRepository {
	Iterable<Ingredient> findAll(); //queries for all Ingredients into a collection of Ingredient objects
	Optional<Ingredient> findById(String id); //queries for a single Ingredient by its Id 
	Ingredient save(Ingredient ingredient); //saves and Ingredient object
}
