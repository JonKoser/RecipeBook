package com.jkoser.jon.recipebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PickExistingIngredients extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_existing_ingredients);

        String[] ingredients = getResources().getStringArray(R.array.temp_array);

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, ingredients);

        findViews();

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);

    }

    private void findViews() {
        listView = (ListView) findViewById(R.id.existingIngredientList);
    }

}
