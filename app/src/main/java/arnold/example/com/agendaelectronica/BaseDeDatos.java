package arnold.example.com.agendaelectronica;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ARNOLD on 30/06/2015.
 */
public class BaseDeDatos extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "personas.db";

    public static final String TABLA_PERSONAS = "personas";

    public static final String ID = "_id";
    public static final String NOMBRE = "nombre";
    public static final String APELLIDO = "apellido";
    public static String TEL = "telefono";
    public static String EMAIL = "email";
   // public static String DESCRIPCION = "descripcion";


    public BaseDeDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLA_PERSONAS + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NOMBRE + " TEXT, " +
                APELLIDO + " TEXT, " +
                TEL + " TEXT, " +
                EMAIL + " TEXT, " +
               // DESCRIPCION + " TEXT " +
                ");";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_PERSONAS);
        onCreate(db);
    }

    //Añade un nuevo Row a la Base de Datos

    public void addPersona(Contacts personas) {

        ContentValues values = new ContentValues();
        values.put(NOMBRE, personas.getNombre());
        values.put(APELLIDO, personas.getApellido());
        values.put(TEL, personas.getTel());
        values.put(EMAIL, personas.getEmail());
        //values.put(DESCRIPCION, personas.getDescripcion());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLA_PERSONAS, null, values);
        db.close();

    }

    public void updatepersona(Contacts personas){
        ContentValues values = new ContentValues();
        values.put(NOMBRE, personas.getNombre());
        values.put(APELLIDO, personas.getApellido());
        values.put(TEL, personas.getTel());
        values.put(EMAIL, personas.getEmail());
        //values.put(DESCRIPCION, personas.getDescripcion());
        SQLiteDatabase db = getWritableDatabase();
        db.update(TABLA_PERSONAS, values, ID + "= ?", new String[] { String.valueOf(personas.getId())});
        db.close();

    }

    // Borrar una persona de la Base de Datos

    public void borrarPersona(int persona_id){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLA_PERSONAS + " WHERE " + ID + " = " + persona_id + ";");
        db.close();
    }

    //listar por id

    public Cursor personabyid(int id){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLA_PERSONAS + " WHERE " + ID + " = " + id + ";";
        Cursor c = db.rawQuery(query, null);

        if (c != null) {
            c.moveToFirst();
        }

        return c;
    }

    //listar a todas las personas
    public Cursor listarpersonas(){
        SQLiteDatabase db = getReadableDatabase();
        String query = ("SELECT * FROM " + TABLA_PERSONAS + " WHERE 1 ORDER BY " + NOMBRE + ";");
        Cursor c = db.rawQuery(query, null);

        if (c != null) {
            c.moveToFirst();
        }

        return c;
    }

}
