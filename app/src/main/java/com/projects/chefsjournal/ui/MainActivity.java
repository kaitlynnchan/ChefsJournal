package com.projects.chefsjournal.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.projects.chefsjournal.R;

/**
 * Allows users to click the add button.
 */
public class MainActivity extends AppCompatActivity {

    private boolean clicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupAddButton();
    }

    private void setupAddButton() {
        final FloatingActionButton folder = findViewById(R.id.fab_folder);
        folder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement adding folder
            }
        });

        final FloatingActionButton recipe = findViewById(R.id.fab_recipe);
        recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement adding recipe
            }
        });

        final FloatingActionButton addBtn = findViewById(R.id.fab_add);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!clicked){
                    Animation rotateOpen = AnimationUtils.loadAnimation(MainActivity.this,
                            R.anim.anim_rotate_open);
                    addBtn.startAnimation(rotateOpen);

                    Animation moveUp = AnimationUtils.loadAnimation(MainActivity.this,
                            R.anim.anim_translate_up);
                    folder.setClickable(true);
                    recipe.setClickable(true);
                    folder.startAnimation(moveUp);
                    recipe.startAnimation(moveUp);

                    clicked = true;
                } else{
                    Animation rotateClose = AnimationUtils.loadAnimation(MainActivity.this,
                            R.anim.anim_rotate_close);
                    addBtn.startAnimation(rotateClose);

                    Animation moveDown = AnimationUtils.loadAnimation(MainActivity.this,
                            R.anim.anim_translate_down);
                    folder.setClickable(false);
                    recipe.setClickable(false);
                    folder.startAnimation(moveDown);
                    recipe.startAnimation(moveDown);

                    clicked = false;
                }
            }
        });
    }
}