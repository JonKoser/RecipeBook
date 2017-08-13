package com.jkoser.jon.recipebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivityMenu extends AppCompatActivity {
    public static final String EXTRA_NEXT_ACTIVITY = "com.jkoser.recipebook.NEXT_ACTIVITY";
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    /**
     *
     * @param view
     */
    public void onFindRecipeClick(View view) {
        Intent intent = new Intent(this, PickExistingIngredients.class);
        String nextActivity = "FindRecipes";
        intent.putExtra(EXTRA_NEXT_ACTIVITY, nextActivity);
        startActivity(intent);
    }

    /**
     *
     * @param view
     */
    public void onGroceryListClick(View view) {
        Intent intent = new Intent(this, PickExistingIngredients.class);
        String nextActivity = "GroceryList";
        intent.putExtra(EXTRA_NEXT_ACTIVITY, nextActivity);
        startActivity(intent);
    }

    /**
     *
     * @param view
     */
    public void onIngredientsClick(View view) {
        Intent intent = new Intent(this, IngredientsMenu.class);
        startActivity(intent);
    }

    /**
     *
     * @param view
     */
    public void onRecipeBookClick(View view) {
        Intent intent = new Intent(this, RecipesMenu.class);
        startActivity(intent);
    }

    public void onResetDBClick(View view) {
        dbHelper = new DBHelper(this);
        dbHelper.deleteAllTables();
    }
}
