package com.antsoftware.ejemplorecyclerview.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.antsoftware.ejemplorecyclerview.db.models.StudentsModel;

import java.util.ArrayList;

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
            "FOREIGN KEY(" + SUBJECTSBOARD_STUDENT + ") " +
            "REFERENCES " + STUDENTS_TABLE + "(" + STUDENT_REGISTRY + "), " +
            "FOREIGN KEY(" + SUBJECTSBOARD_SUBJECT + ") " +
            "REFERENCES " + SUBJECTS_TABLE + "(" + SUBJECTS_ID + "));";

    private static final String DROPSUBJECTSBOARDTABLE = "DROP TABLE IF EXISTS " + SUBJECTSBOARD_TABLE;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATESTUDENTSTABLE);
        sqLiteDatabase.execSQL(CREATESUBJECTSTABLE);
        sqLiteDatabase.execSQL(CREATESUBJECTSBOARDTABLE);
        initializeDB(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(DROPSUBJECTSBOARDTABLE);
        sqLiteDatabase.execSQL(DROPSTUDENTSTABLE);
        sqLiteDatabase.execSQL(DROPSUBJECTSTABLE);
    }

    public void initializeDB(SQLiteDatabase db) {
        db.execSQL("INSERT INTO students VALUES(0, 'Chris', 21)");
        db.execSQL("INSERT INTO students VALUES(1, 'Bryan', 20)");
        db.execSQL("INSERT INTO students VALUES(2, 'Maria', 22)");
        db.execSQL("INSERT INTO students VALUES(3, 'Ivan', 22)");

        db.execSQL("INSERT INTO subjects VALUES(0, 'Matematicas')");
        db.execSQL("INSERT INTO subjects VALUES(1, 'Física')");
        db.execSQL("INSERT INTO subjects VALUES(2, 'Quimica')");

        db.execSQL("INSERT INTO subjectsboard VALUES(0, 0, 0)");
        db.execSQL("INSERT INTO subjectsboard VALUES(1, 0, 1)");
        db.execSQL("INSERT INTO subjectsboard VALUES(2, 0, 2)");

        db.execSQL("INSERT INTO subjectsboard VALUES(3, 1, 1)");
        db.execSQL("INSERT INTO subjectsboard VALUES(4, 1, 2)");

        db.execSQL("INSERT INTO subjectsboard VALUES(5, 2, 0)");

        db.execSQL("INSERT INTO subjectsboard VALUES(6, 3, 2)");
    }

    public void insertStudent(StudentsModel student) {
        SQLiteDatabase db = this.getWritableDatabase();
        String insertStatement = "INSERT INTO " + STUDENTS_TABLE + " VALUES(" +
                student.getRegistry() + ", " +
                student.getName() + ", " +
                student.getAge() + ");";
    }

    public ArrayList<StudentsModel> fetchStudents() {
        ArrayList<StudentsModel> students = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectStatement = "SELECT students.*, group_concat(distinct subjects.name) " +
                "FROM students, subjects, subjectsboard " +
                "WHERE students.registry = subjectsboard.fkStudent " +
                "AND subjects.id = subjectsBoard.fkSubject " +
                "GROUP BY 1;";
        Cursor cursor = db.rawQuery(selectStatement, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                students.add(new StudentsModel(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getString(3)
                ));
                cursor.moveToNext();
            }
        }
        return students;
    }
}
