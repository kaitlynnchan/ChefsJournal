package com.projects.chefsjournal.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.projects.chefsjournal.R;
import com.projects.chefsjournal.model.Folder;
import com.projects.chefsjournal.model.Recipe;

import java.util.ArrayList;

/**
 * Allows users to click the add button.
 */
public class MainActivity extends AppCompatActivity {

    private boolean clicked = false;
    private ArrayList<Object> items = new ArrayList<>();

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
                FragmentManager fragmentManager = getSupportFragmentManager();
                NameDialog dialog = new NameDialog();
                dialog.show(fragmentManager, "Name");

                items.add(new Folder("new folder"));
                createListView();
            }
        });

        final FloatingActionButton recipe = findViewById(R.id.fab_recipe);
        recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement adding recipe
                Intent intent = new Intent(MainActivity.this, RecipeActivity.class);
                startActivity(intent);
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

    private void createListView(){
        ArrayAdapter<Object> adapter = new MyListAdapter();
        ListView list = findViewById(R.id.lv_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object item = items.get(i);
                if(item instanceof Folder){

                } else if(item instanceof Recipe){

                }
            }
        });
    }

    private class MyListAdapter extends ArrayAdapter<Object>{
        public MyListAdapter() {
            super(MainActivity.this, R.layout.item_view_folder, items);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View itemView = convertView;
            if(itemView == null){
                Object object = items.get(position);
                if(object instanceof Folder){
                    itemView = getLayoutInflater().inflate(R.layout.item_view_folder, parent, false);

                    TextView name = itemView.findViewById(R.id.textView_folder);
                    name.setText(((Folder) object).getName());
                } else if(object instanceof Recipe){
                    itemView = getLayoutInflater().inflate(R.layout.item_view_recipe, parent, false);
                }
            }

            return itemView;
        }
    }
}