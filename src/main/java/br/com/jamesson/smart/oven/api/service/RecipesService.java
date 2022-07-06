package br.com.jamesson.smart.oven.api.service;

import br.com.jamesson.smart.oven.api.dto.Recipe;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Singleton
public class RecipesService {

    private static List<Recipe> recipes = new ArrayList<>(List.of(
            new Recipe("pizza", 475, 900),
            new Recipe("chicken", 450, 900),
            new Recipe("salmon", 375, 1200)
    ));

    public List<Recipe> getRecipes(Optional<String> query) {
        return recipes.stream()
                .filter(recipe -> !query.isPresent() || query.get().equalsIgnoreCase(recipe.getName()))
                .collect(toList());
    }

    public Recipe createRecipe(Recipe recipe){
        recipes.add(recipe);
        return recipe;
    }

    public Recipe updateRecipe(String recipeName, Recipe recipe){
        recipes.removeIf(rec -> rec.getName().equalsIgnoreCase(recipeName));
        recipes.add(recipe);
        return recipe;
    }

    public Recipe deleteRecipe(String recipeName){
        Recipe recipe = recipes.stream()
                .filter(rec -> rec.getName().equalsIgnoreCase(recipeName))
                .findFirst()
                .get();
        recipes.remove(recipe);
        return recipe;
    }



}
