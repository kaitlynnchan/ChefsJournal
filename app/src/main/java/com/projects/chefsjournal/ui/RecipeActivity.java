package com.projects.chefsjournal.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.projects.chefsjournal.R;

/**
 * Allows users to input information about a recipe.
 */
public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupIngredientBtn();
        setupInstructionBtn();
    }

    private void setupInstructionBtn() {
        LinearLayout instructionLayout = findViewById(R.id.ll_instructions);
        LayoutInflater inflater = LayoutInflater.from(this);
        View instructionView = inflater.inflate(R.layout.item_view_instructions, instructionLayout, false);
        instructionLayout.addView(instructionView);
    }

    private void setupIngredientBtn() {

        final LinearLayout ingredientsLayout = findViewById(R.id.ll_ingredients);
        View ingredientView1 = createIngredientView(ingredientsLayout);
        ingredientsLayout.addView(ingredientView1);

        Button addBtn = findViewById(R.id.btn_add);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add in new ingredient items
                View ingredientView = createIngredientView(ingredientsLayout);
                ingredientsLayout.addView(ingredientView);
            }
        });
    }

    private View createIngredientView(LinearLayout ingredientsLayout) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.item_view_ingredient, ingredientsLayout, false);

        Spinner unitsSpinner = view.findViewById(R.id.spn_units);
        String[] unitsArray = getResources().getStringArray(R.array.units_array);
        ArrayAdapter<CharSequence> unitsSpinnerAdapter = new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_spinner_item, unitsArray);
        unitsSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitsSpinner.setAdapter(unitsSpinnerAdapter);
        return view;
    }
}