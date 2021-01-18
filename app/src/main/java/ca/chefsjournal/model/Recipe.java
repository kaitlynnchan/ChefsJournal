package ca.chefsjournal.model;

import java.util.ArrayList;

/**
 * Demonstrates information about a recipe. Variables
 * includes name, prep time, yeilds, ingredients,
 * and instructions.
 */
public class Recipe {
    private String name;
    private String prepTime;
    private String yeilds;
    private ArrayList<Ingredient> ingredients;
    private String instructions;

    public Recipe(String name, String prepTime, String yeilds, String instructions) {
        this.name = name;
        this.prepTime = prepTime;
        this.yeilds = yeilds;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public String getYeilds() {
        return yeilds;
    }

    public void setYeilds(String yeilds) {
        this.yeilds = yeilds;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
