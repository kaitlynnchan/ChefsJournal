package com.projects.chefsjournal.model;

/**
 * Demonstrates information about a ingredient. Variables
 * includes name and amount.
 */
public class Ingredient {
    private String name;
    private String amount;

    public Ingredient(String name, String amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
