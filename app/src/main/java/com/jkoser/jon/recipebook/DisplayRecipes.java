package com.jkoser.jon.recipebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;


public class DisplayRecipes extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<Long> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_recipes);

        String[] ingredientIDs = getIntent().getStringArrayExtra("SELECTED_INGREDIENTS");
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ingredientIDs);

        findViews();




    }

    private void findViews() {
        listView = (ListView) findViewById(R.id.selectedIngredients);
    }

}
