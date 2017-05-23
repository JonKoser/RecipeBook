package com.jkoser.jon.recipebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivityMenu extends AppCompatActivity {
    public static final String EXTRA_NEXT_ACTIVITY = "com.jkoser.recipebook.NEXT_ACTIVITY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void onFindRecipeClick(View view) {
        Intent intent = new Intent(this, PickExistingIngredients.class);
        String nextActivity = "FindRecipe";
        intent.putExtra(EXTRA_NEXT_ACTIVITY, nextActivity);
        startActivity(intent);
    }
}
