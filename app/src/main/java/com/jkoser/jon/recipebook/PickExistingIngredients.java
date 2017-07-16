package com.jkoser.jon.recipebook;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.view.View.OnClickListener;
import android.widget.SimpleCursorAdapter;

public class PickExistingIngredients extends AppCompatActivity implements OnClickListener {
    ListView listView;
    ArrayAdapter<String> adapter;
    Button button;
    String nextActivity;
    public static final String EXTRA_SELECTED_INGREDIENTS = "com.jkoser.recipebook.SELECTED_INGREDIENTS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_existing_ingredients);

        nextActivity = getIntent().getStringExtra("NEXT_ACTIVITY");

        String[] ingredients = getResources().getStringArray(R.array.temp_array);

        // TODO: Yeah, I should get the cursor adapter thing working
        /*
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor allIngredients = db.rawQuery("SELECT Name FROM Ingredients", null);
        adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_multiple_choice, allIngredients, null, null, 0);
        */
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, ingredients);

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
