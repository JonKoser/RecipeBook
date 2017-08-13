package com.jkoser.jon.recipebook;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.util.Log;


/**
 * Created by Jon on 7/16/17.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "RecipeBook.db";
    public static final String INGREDIENTS_TABLE_NAME = "Ingredients";
    public static final String RECIPE_INGREDIENTS_TABLE_NAME = "Recipe_Ingredients";
    public static final String RECIPES_TABLE_NAME = "Recipes";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + INGREDIENTS_TABLE_NAME + " (" +
                "Name TEXT PRIMARY KEY, " +
                "Price_Cents INTEGER," +
                "Type TEXT);");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + RECIPES_TABLE_NAME + " (" +
                "Name TEXT PRIMARY KEY, " +
                "Type TEXT, Book TEXT, " +
                "Page INTEGER, " +
                "Ethnicity TEXT, " +
                "Time INTEGER);");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + RECIPE_INGREDIENTS_TABLE_NAME + " (" +
                "Recipe_Name TEXT, " +
                "Ingredient_Name TEXT, " +
                "Quantity REAL, " +
                "Unit TEXT, " +
                "FOREIGN KEY(Recipe_Name) REFERENCES " + RECIPES_TABLE_NAME + "(Name), " +
                "FOREIGN KEY(Ingredient_Name) REFERENCES " + INGREDIENTS_TABLE_NAME + "(Name));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + INGREDIENTS_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + RECIPES_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + RECIPE_INGREDIENTS_TABLE_NAME);
        onCreate(db);
    }

    /**
     *
     * @param name
     * @param priceInCents
     * @return
     */
    public boolean addIngredient(String name, int priceInCents, String type) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Name", name);
        values.put("Price_Cents", priceInCents);
        values.put("Type", type);
        database.insert("Ingredients", null, values);
        return true;
    }

    /**
     *
     * @return
     */
    public String[] getIngredientNames() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor ingredients = db.rawQuery("SELECT Name FROM " + INGREDIENTS_TABLE_NAME, null);
        ingredients.moveToFirst();
        int totalItems = ingredients.getCount();
        String[] names = new String[totalItems];
        for (int i = 0; i < totalItems; i ++) {
            names[i] = (ingredients.getString(ingredients.getColumnIndex("Name")));
            ingredients.moveToNext();
        }
        return names;
    }

    /**
     * Testing method - clears the ingredients table
     */
    public void deleteAllIngredients() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + INGREDIENTS_TABLE_NAME);
    }

    /**
     * Testing method - clears the Recipes table
     */
    public void deleteAllRecipes() {

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + RECIPES_TABLE_NAME);
    }

    public void deleteAllTables() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + INGREDIENTS_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + RECIPES_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + RECIPE_INGREDIENTS_TABLE_NAME);
        onCreate(db);
    }
}
