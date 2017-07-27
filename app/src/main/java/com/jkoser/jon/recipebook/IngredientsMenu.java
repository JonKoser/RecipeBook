package com.jkoser.jon.recipebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IngredientsMenu extends AppCompatActivity implements OnClickListener {
    Button addIngredientMenuButton;
    Button editIngredientsButton;
    Button deleteIngredientButton;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingredients_menu);
        findViews();
    }

    /**
     *
     */
    private void findViews() {
        addIngredientMenuButton = (Button) findViewById(R.id.addIngredientMenuButton);
        editIngredientsButton = (Button) findViewById(R.id.editIngredientsButton);
        deleteIngredientButton = (Button) findViewById(R.id.deleteIngredientsButton);

    }

    /**
     *
     * @param view
     */
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.editIngredientsButton:
                // TODO: all the edit stuff, yuck
                break;
            case R.id.addIngredientMenuButton:
                Intent intent = new Intent(this, AddIngredients.class);
                startActivity(intent);
                break;
            case R.id.deleteIngredientsButton:
                dbHelper = new DBHelper(this);
                dbHelper.deleteAllIngredients();
        }

    }
}
