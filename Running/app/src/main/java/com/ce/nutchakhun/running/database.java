package com.ce.nutchakhun.running;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Wuttipong on 25/1/2559.
 */
public class database{
    private SQLiteDatabase db;

    public database(Context context){
        Helper hp = new Helper(context);
        db=hp.getWritableDatabase();
    }
    //save food into table
    public void saveFood(String food,int cal){
        db.execSQL("INSERT INTO food (food,cal) VALUES('" + food + "'," + cal + ");");
    }
    //cursor
    public Cursor getAllFood(){
        return db.rawQuery("SELECT * FROM food",null);


    }

    private class Helper extends SQLiteOpenHelper{

        private Context c;

        public Helper(Context context){

            super(context,"EasyWeightLoss",null,1);
            c=context;
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            //Create food table
            db.execSQL("CREATE TABLE food "
                    + "("
                    + "food TEXT,  "
                    + "cal INTEGER);");
            //Create exercise table
            db.execSQL("CREATE TABLE exercise "
                    + "("
                    + "exercise TEXT,  "
                    + "cal INTEGER);");

            String[] nameFood=c.getResources().getStringArray(R.array.foods);
            int[] numcal=c.getResources().getIntArray(R.array.cals);
            for(int i=0;i<nameFood.length;i++){
                db.execSQL("INSERT INTO food (food,cal) VALUES('" + nameFood[i]+ "'," + numcal[i] + ");");



            }
        }



        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            /*db.execSQL("UPDATE food SET"
                    + "food='a',cal=0"
                    + "WHERE food='a';");*/
        }
    }
}
