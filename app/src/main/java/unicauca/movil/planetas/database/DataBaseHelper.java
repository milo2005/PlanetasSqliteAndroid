package unicauca.movil.planetas.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.SensorManager;

/**
 * Created by Dario Chamorro on 9/12/2016.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "planetas.db";
    static int VERSION = 1;

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlPlaneta = "CREATE TABLE planeta (id INTEGER PRIMARY KEY AUTOINCREMENT"
                +", nombre VARCHAR"
                +", gravedad FLOAT"
                +" )";
        sqLiteDatabase.execSQL(sqlPlaneta);

        //Insertamos un registro en la base de datos
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre", "Estrella de Muerte I");
        contentValues.put("gravedad", SensorManager.GRAVITY_DEATH_STAR_I);

        sqLiteDatabase.insert("planeta",null, contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE planeta");
        onCreate(sqLiteDatabase);
    }
}
