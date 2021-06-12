package com.antsoftware.ejemplorecyclerview.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {

    private Context context;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "school.db";

    private static final String STUDENTS_TABLE = "students";
    private static final String STUDENT_REGISTRY = "registry";
    private static final String STUDENT_NAME = "name";
    private static final String STUDENT_AGE = "age";


    public static final String CREATESTUDENTSTABLE = "CREATE TABLE "
            + STUDENTS_TABLE + "(" + STUDENT_REGISTRY
            + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + STUDENT_NAME + " TEXT,"
            + STUDENT_AGE + " INTEGER );";

    private static final String DROPSTUDENTSTABLE = "DROP TABLE IF EXISTS " + STUDENTS_TABLE;

    private static final String SUBJECTS_TABLE = "subjects";
    private static final String SUBJECTS_ID = "id";
    private static final String SUBJECTS_NAME = "name";

    public static final String CREATESUBJECTSTABLE = "CREATE TABLE "
            + SUBJECTS_TABLE + "(" + SUBJECTS_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + SUBJECTS_NAME + " TEXT);";

    private static final String DROPSUBJECTSTABLE = "DROP TABLE IF EXISTS " + SUBJECTS_TABLE;

    private static final String SUBJECTSBOARD_TABLE = "subjectsboard";
    private static final String SUBJECTSBOARD_ID = "id";
    private static final String SUBJECTSBOARD_STUDENT = "fkStudent";
    private static final String SUBJECTSBOARD_SUBJECT = "fkSubject";

    public static final String CREATESUBJECTSBOARDTABLE = "CREATE TABLE "
            + SUBJECTSBOARD_TABLE + "(" + SUBJECTSBOARD_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + SUBJECTSBOARD_STUDENT + " INTEGER, "
            + SUBJECTSBOARD_SUBJECT + " INTEGER, " +
            "FOREIGN KEY(" + SUBJECTSBOARD_STUDENT +") " +
            "REFERENCES " + STUDENTS_TABLE +"("+ STUDENT_REGISTRY +"), " +
            "FOREIGN KEY("+ SUBJECTSBOARD_SUBJECT +") " +
            "REFERENCES " + SUBJECTS_TABLE + "(" + SUBJECTS_ID + "));";

    private static final String DROPSUBJECTSBOARDTABLE = "DROP TABLE IF EXISTS " + SUBJECTSBOARD_TABLE;

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(CREATESTUDENTSTABLE);
            sqLiteDatabase.execSQL(CREATESUBJECTSTABLE);
            sqLiteDatabase.execSQL(CREATESUBJECTSBOARDTABLE);
            Toast.makeText(context, ("Si se armo"), Toast.LENGTH_LONG);
        }catch (SQLException e){
            Toast.makeText(context, ("Valio amigo") + e.toString(), Toast.LENGTH_LONG);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(DROPSUBJECTSBOARDTABLE);
        sqLiteDatabase.execSQL(DROPSTUDENTSTABLE);
        sqLiteDatabase.execSQL(DROPSUBJECTSTABLE);
    }
}
