package com.jkoser.jon.recipebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.database.sqlite.*;

import java.text.NumberFormat;

public class AddIngredients extends AppCompatActivity implements OnClickListener, android.text.TextWatcher {
    Button addButton;
    EditText packagePrice;
    EditText ingredientName;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_ingredient_form);
        findViews();

        packagePrice.addTextChangedListener(this);
        addButton.setOnClickListener(this);

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

        // TODO: I'm going to want to create a database helper class and open the database when I open the app
        database = openOrCreateDatabase("recipe_book.db", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS Ingredients (Name TEXT, Price_Cents INTEGER)");
        String query = "INSERT INTO Ingredients VALUES ('" + nameString + "', " + priceCents + ");";
        database.execSQL(query);

        finish();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        return;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        return;
    }

    @Override
    public void afterTextChanged(Editable s) {
        // TODO: do some validation magic here - make sure it's a proper currency
        return;
    }
}
