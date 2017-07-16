package com.jkoser.jon.recipebook;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
        db.execSQL("CREATE TABLE IF NOT EXISTS Ingredients (Name TEXT, Price_Cents INTEGER)");
        // TODO: Create the other tables once I have the columns down :)
        // db.execSQL("CREATE TABLE IF NOT EXISTS Recipes (Name TEXT, Price_Cents INTEGER)");
        // db.execSQL("CREATE TABLE IF NOT EXISTS Recipe_Ingredients (Name TEXT, Price_Cents INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Ingredients");
        db.execSQL("DROP TABLE IF EXISTS Recipes");
        db.execSQL("DROP TABLE IF EXISTS Recipe_Ingredients");
        onCreate(db);
    }

    /**
     *
     * @param name
     * @param priceInCents
     * @return
     */
    public boolean addIngredient(String name, int priceInCents) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Name", name);
        values.put("Price_Cents", priceInCents);
        database.insert("Ingredients", null, values);
        return true;
    }
}
