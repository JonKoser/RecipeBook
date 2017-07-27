package com.jkoser.jon.recipebook;
/**
 * Created by Jon on 7/26/17.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RecipesMenu extends AppCompatActivity implements OnClickListener {
    Button addRecipeMenuButton;
    Button editRecipeButton;
    Button deleteRecipesButton;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipes_menu);
        findViews();
    }

    /**
     *
     */
    private void findViews() {
        addRecipeMenuButton = (Button) findViewById(R.id.addRecipeMenuButton);
        editRecipeButton = (Button) findViewById(R.id.editRecipeButton);
        deleteRecipesButton = (Button) findViewById(R.id.deleteRecipesButton);

    }

    /**
     *
     * @param view
     */
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.editRecipeButton:
                // TODO: all the edit stuff, yuck
                break;
            case R.id.addRecipeMenuButton:
                Log.d("merp!", "flerm");
                break;
            case R.id.deleteRecipesButton:
                dbHelper = new DBHelper(this);
                dbHelper.deleteAllRecipes();
        }

    }
}
