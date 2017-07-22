package com.jkoser.jon.recipebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddIngredients extends AppCompatActivity implements OnClickListener{
    Button addButton;
    EditText packagePrice;
    EditText ingredientName;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_ingredient_form);
        findViews();

        addButton.setOnClickListener(this);
        dbHelper = new DBHelper(this);

    }

    /**
     *
     */
    private void findViews() {
        addButton = (Button) findViewById(R.id.addIngredientButton);
        packagePrice = (EditText) findViewById(R.id.packagePrice);
        ingredientName = (EditText) findViewById(R.id.ingredientName);
    }

    /**
     *
     * @param view
     */
    public void onClick(View view) {
        String nameString = ingredientName.getText().toString();
        String priceString = packagePrice.getText().toString();
        Float priceFloat = Float.parseFloat(priceString);
        Integer priceCents = (int)(priceFloat * 100);

        dbHelper.addIngredient(nameString, priceCents);

        finish();
    }
}
