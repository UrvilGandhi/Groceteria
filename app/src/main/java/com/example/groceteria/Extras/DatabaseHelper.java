package com.example.groceteria.Extras;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.groceteria.Modal.User;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "UserManager.db";

    private static final String TABLE_USER = "user";
    private static final String TABLE_PRODUCTS = "products";
    private static final String COLUMN_PRODUCT_NAME = "prodName";

    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_MOBILE = "user_mobile";
    private static final String COLUMN_USER_PASSWORD = "user_password";

    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_USER_NAME + " TEXT," + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_MOBILE + " INTEGER," + COLUMN_USER_PASSWORD + " TEXT" + ")";

    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_USER_TABLE);
        onCreate(db);
    }

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_MOBILE, user.getMobile());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public void seachData(String searchText){
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery =  "SELECT * FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCT_NAME + " LIKE '%" + searchText + "%'";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(searchText) } );

        if (cursor.moveToFirst()) {
            do {

                String prodName =cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT_NAME));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
    }

    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_MOBILE, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        db.update(TABLE_USER, values, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER, COLUMN_USER_ID + " = ?", new String[]{String.valueOf(user.getId())});
        db.close();
    }

    public boolean checkUser(String email) {

        String[] columns = {COLUMN_USER_ID};
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = COLUMN_USER_EMAIL + " = ?";

        String[] selectionArgs = {email};

        Cursor cursor = db.query(TABLE_USER, columns, selection, selectionArgs, null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        return cursorCount > 0;
    }

    public boolean checkUser(String email, String password) {

        String[] columns = {COLUMN_USER_ID};
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_USER_NAME + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        String[] selectionArgs = {email, password};

        Cursor cursor = db.query(TABLE_USER, columns, selection, selectionArgs, null, null, null);

        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        return cursorCount > 0;
    }
}
