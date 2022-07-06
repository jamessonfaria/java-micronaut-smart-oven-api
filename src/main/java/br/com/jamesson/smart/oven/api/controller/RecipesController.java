package br.com.jamesson.smart.oven.api.controller;

import br.com.jamesson.smart.oven.api.dto.Recipe;
import br.com.jamesson.smart.oven.api.service.RecipesService;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@Controller("recipes")
public class RecipesController {

    private final RecipesService service;

    @Inject
    public RecipesController(RecipesService service) {
        this.service = service;
    }

    @Get
    public List<Recipe> getRecipes(@QueryValue Optional<String> query){
        return service.getRecipes(query);
    }

    @Post
    public Recipe createRecipe(@Body Recipe recipe){
        return service.createRecipe(recipe);
    }

    @Put("/{recipeName}")
    public Recipe updateRecipe(String recipeName, Recipe recipe){
        return service.updateRecipe(recipeName, recipe);
    }

    @Delete("/{recipeName}")
    public Recipe deleteRecipe(String recipeName){
        return service.deleteRecipe(recipeName);
    }

}
