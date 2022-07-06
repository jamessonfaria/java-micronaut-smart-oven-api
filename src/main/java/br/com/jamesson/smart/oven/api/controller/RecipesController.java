package br.com.jamesson.smart.oven.api.controller;

import io.micronaut.http.annotation.*;

import java.util.Optional;

@Controller("recipes")
public class RecipesController {

    @Get
    public String getRecipes(@QueryValue Optional<String> query){
        return "No recipes yet! Query: " + query.orElse("");
    }

    @Post
    public String createRecipe(@Body String recipe){
        return "Recipe Created: " + recipe;
    }

    @Put("/{recipe}")
    public String updateRecipe(String recipe){
        return "Recipe Updated: " + recipe;
    }

    @Delete("/{recipe}")
    public String deleteRecipe(String recipe){
        return "Recipe Deleted: " + recipe;
    }

}
