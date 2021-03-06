package com.jkoser.jon.recipebook;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.view.View.OnClickListener;

public class PickExistingIngredients extends AppCompatActivity implements OnClickListener {
    ListView listView;
    ArrayAdapter<String> adapter;
    Button button;
    String nextActivity;
    DBHelper dbHelper;
    public static final String EXTRA_SELECTED_INGREDIENTS = "com.jkoser.recipebook.SELECTED_INGREDIENTS";


    // TODO: I need to make this into a tabbed view which breaks the ingredients into meat, dairy, vegetables, grains, fruit, and other
    // TODO: I need to add a "select defaults" button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_existing_ingredients);

        nextActivity = getIntent().getStringExtra("NEXT_ACTIVITY");

        dbHelper = new DBHelper(this);
        String[] ingredientNames = dbHelper.getIngredientNames();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, ingredientNames);
        findViews();

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);

        button.setOnClickListener(this);
    }

    private void findViews() {
        listView = (ListView) findViewById(R.id.existingIngredientList);
        button = (Button) findViewById(R.id.nextButton);
    }

    public void onClick(View view) {
        return;
    }


}
