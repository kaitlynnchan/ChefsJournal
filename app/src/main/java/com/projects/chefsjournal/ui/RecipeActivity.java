package com.projects.chefsjournal.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.projects.chefsjournal.R;

/**
 * Allows users to input information about a recipe.
 */
public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
    }
}