package unicauca.movil.planetas.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TabLayout;

import java.util.ArrayList;
import java.util.List;

import unicauca.movil.planetas.models.Planeta;

/**
 * Created by Dario Chamorro on 9/12/2016.
 */

public class PlanetaDao {

    static final String TABLE = "planeta";
    static final String C_NAME = "nombre";
    static final String C_GRAVITY = "gravedad";

    SQLiteDatabase db;

    public PlanetaDao(Context context){
        DataBaseHelper helper = new DataBaseHelper(context);
        db = helper.getWritableDatabase();
    }

    public void insert(Planeta planeta){
        ContentValues values = new ContentValues();
        values.put(C_NAME, planeta.getNombre());
        values.put(C_GRAVITY, planeta.getGravedad());

        db.insert(TABLE, null, values);
    }

    public void update(Planeta planeta){
        ContentValues values = new ContentValues();
        values.put(C_NAME, planeta.getNombre());
        values.put(C_GRAVITY, planeta.getGravedad());
        db.update(TABLE, values, "id = ?"
                , new String[]{""+planeta.getId()});
    }

    public void delete(long id){
        db.delete(TABLE,"id = ?", new String[]{""+id});
    }

    public Planeta getById(long id){
        String sql = "SELECT * FROM "+ TABLE+" WHERE id = "+id;
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.getCount() > 0){
            cursor.moveToNext();
            return cursorToPlaneta(cursor);
        }else
            return null;
    }

    public List<Planeta> list(){
        String sql = "SELECT * FROM "+TABLE;
        return cursorToList(sql);
    }

    public List<Planeta> listByName(String name){
        String sql = "SELECT * FROM "+TABLE
                +" WHERE "+C_NAME+" LIKE '%"+name+"%'";
        return cursorToList(sql);
    }

    private Planeta cursorToPlaneta(Cursor cursor){
        Planeta p = new Planeta();
        p.setId(cursor.getLong(0));
        p.setNombre(cursor.getString(1));
        p.setGravedad(cursor.getFloat(2));
        return p;
    }

    private List<Planeta> cursorToList(String sql){
        Cursor cursor = db.rawQuery(sql, null);

        List<Planeta> data = new ArrayList<>();

        while (cursor.moveToNext()){
            Planeta p = cursorToPlaneta(cursor);
            data.add(p);
        }

        return data;
    }


}
