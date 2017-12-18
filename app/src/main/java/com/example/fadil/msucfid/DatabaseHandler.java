package com.example.fadil.msucfid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fadil on 17/12/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "personal_notes";
    private static final String TABLE_NAME = "personalNotes";
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_BODY = "body";
    private static final String KEY_CONTENT_ID = "content_id";

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TITLE + " TEXT,"
                + KEY_BODY + " TEXT," + KEY_CONTENT_ID + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
    //Add data to sqlite
    void addPersonalNote(PersonalNote pn) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues v = new ContentValues();
        v.put(KEY_TITLE, pn.getTitle());
        v.put(KEY_BODY, pn.getBody());
        v.put(KEY_CONTENT_ID, pn.getContent_id());

        db.insert(TABLE_NAME, null, v);
        db.close();
    }

    //Call a single data
    PersonalNote getPersonalNote(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] { KEY_ID, KEY_TITLE, KEY_BODY, KEY_CONTENT_ID},
                KEY_ID + "=?", new String[] {String.valueOf(id)}, null, null, null,null);
        if (cursor != null)
            cursor.moveToFirst();

        PersonalNote pn = new PersonalNote(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3));
        return pn;
    }

    public List<PersonalNote> getAllPersonalNotes(String content_id){
        List<PersonalNote> personalNoteList = new ArrayList<PersonalNote>();
        //Select query
        String q = "SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_CONTENT_ID + " = " + content_id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(q, null);

        if (cursor.moveToFirst()){
            do{
                PersonalNote pn = new PersonalNote();
                pn.setId(Integer.parseInt(cursor.getString(0)));
                pn.setTitle(cursor.getString(1));
                pn.setBody(cursor.getString(2));
                pn.setContent_id(cursor.getString(3));
                personalNoteList.add(pn);
            }while (cursor.moveToNext());
        }

        return personalNoteList;
    }

    public void updatePersonalNote(PersonalNote pn){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues v = new ContentValues();
        v.put(KEY_TITLE, pn.getTitle());
        v.put(KEY_BODY, pn.getBody());
        v.put(KEY_CONTENT_ID, pn.getContent_id());

        db.update(TABLE_NAME, v, KEY_ID + " = ?", new String[] { String.valueOf(pn.getId())});
        db.close();
    }

    public void deletePersonalNote(PersonalNote pn){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID + " = ?", new String[] { String.valueOf(pn.getId())});
        db.close();
    }
}
