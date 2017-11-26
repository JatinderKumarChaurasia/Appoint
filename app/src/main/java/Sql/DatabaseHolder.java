package Sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import Model.User;

/**
 * Created by Jatinder Kumar on 02-11-2017.
 */

public class DatabaseHolder extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "UserManager.db";
    private static final String TABLE_USER = "user";

    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PHONE ="user_phone";
    private static final String COLUMN_USER_PASSWORD = "user_password";


    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," +COLUMN_USER_PHONE+" INTEGER,"+ COLUMN_USER_PASSWORD + " TEXT" + ")";

    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    public DatabaseHolder(Context context) {
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
        values.put( COLUMN_USER_PHONE,user.getPhone_number() );
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }
    public List<User> getAllUser()
    {
        String[] columns ={COLUMN_USER_ID,COLUMN_USER_NAME,COLUMN_USER_EMAIL,COLUMN_USER_PHONE,COLUMN_USER_PASSWORD};
        String sortOrder = COLUMN_USER_NAME + "ASC";
        List<User> userList =new ArrayList<User>( );
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query( TABLE_USER,columns,null,null,null,null,sortOrder );
        if(cursor.moveToFirst())
        {
            do {

                    User user = new User();
                    user.setId( Integer.parseInt( cursor.getString( cursor.getColumnIndex( COLUMN_USER_ID ) ) ) );
                    user.setName(cursor.getString( cursor.getColumnIndex( COLUMN_USER_NAME ) ) );
                    user.setEmail( cursor.getString( cursor.getColumnIndex( COLUMN_USER_EMAIL ) ) );
                    user.setPhone_number( Integer.parseInt( cursor.getString( cursor.getColumnIndex( COLUMN_USER_PHONE ) ) ) );
                    user.setPassword( cursor.getString( cursor.getColumnIndex( COLUMN_USER_PASSWORD ) ) );
            }while(cursor.moveToNext());

        }
        cursor.close();
        database.close();
        return userList;
    }

    public void updateUser(User user)
    {
        SQLiteDatabase database =this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put( COLUMN_USER_NAME,user.getName() );
        values.put( COLUMN_USER_EMAIL,user.getEmail() );
        values.put( COLUMN_USER_PHONE,user.getPhone_number() );
        values.put( COLUMN_USER_PASSWORD,user.getPassword() );
        database.update( TABLE_USER,values,COLUMN_USER_ID + " = ?",new String[]{String.valueOf( user.getId() )});
        database.close();
    }
    public void deleteUser(User user)
    {
        SQLiteDatabase database =this.getWritableDatabase();
        database.delete( TABLE_USER,COLUMN_USER_ID + " = ?",new String[]{String.valueOf( user.getId() )} );
        database.close();
    }
    public boolean checkUser(String email)
    {
        String[] columns ={COLUMN_USER_ID};
        SQLiteDatabase database = this.getReadableDatabase();
        String selection = COLUMN_USER_EMAIL + " = ? ";
        String [] selectionArgs = {email};
        Cursor cursor = database.query( TABLE_USER,columns,selection,selectionArgs,null,null,null );
        int cursorCount = cursor.getCount();
        cursor.close();
        database.close();
        if(cursorCount>0)
        {
            return  true;
        }
        else
        {
            return false;
        }

    }
    public boolean checkUser(String user_name,String password)
    {
        String[] columns ={COLUMN_USER_ID};
        SQLiteDatabase database = this.getReadableDatabase();
        String selection = COLUMN_USER_NAME + " = ? " + " AND " + COLUMN_USER_PASSWORD + " = ? ";
        String [] selectionArgs = {user_name,password};
        Cursor cursor = database.query( TABLE_USER,columns,selection,selectionArgs,null,null,null );
        int cursorCount = cursor.getCount();
        cursor.close();
        database.close();
        if(cursorCount>0)
        {
            return  true;
        }
        else
        {
            return false;
        }
    }


}
