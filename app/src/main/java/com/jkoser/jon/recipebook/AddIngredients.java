package com.jkoser.jon.recipebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddIngredients extends AppCompatActivity implements OnClickListener{
    Button addButton;
    EditText packagePrice;
    EditText ingredientName;
    DBHelper dbHelper;
    Spinner ingredientType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_ingredient_form);
        findViews();

        // Spinner stuff
        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(this, R.array.ingredient_types, android.R.layout.simple_spinner_dropdown_item);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ingredientType.setAdapter(typeAdapter);

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
        ingredientType = (Spinner) findViewById(R.id.ingredientTypeDropdown);
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
        String type = ingredientType.getSelectedItem().toString();

        dbHelper.addIngredient(nameString, priceCents, type);

        finish();
    }
}
