package com.ce.nutchakhun.running;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class food extends AppCompatActivity {
    private List<String> food = new ArrayList<>();
    private List<Integer> cal = new ArrayList<>();
    //function update
    private void updateList(){
        customAdapter adapter=new customAdapter(getApplicationContext(),food,cal);
        ListView listView =(ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

            }

        });


    }

    private database workDB;
    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_food);
        //database that work
        workDB = new database(this);
        //cursor that point to database
        Cursor cur=workDB.getAllFood();

        cur.moveToFirst();

        while(!cur.isAfterLast()){

            food.add(cur.getString(0));
            cal.add(cur.getInt(1));
            cur.moveToNext();



        }


        updateList();




            //dialog add button
            Button btnDialog = (Button) findViewById(R.id.addBtn);
            EditText foodname= (EditText)findViewById(R.id.foodName);
            EditText calr = (EditText)findViewById(R.id.calories);
            //button click dialog
            btnDialog.setOnClickListener(new OnClickListener() {
                public void onClick (View v){
                    final Dialog dialog = new Dialog(food.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.custom_dialog);
                    dialog.setCancelable(true);
                    //button submit
                    Button button1 = (Button) dialog.findViewById(R.id.dialogSubmitButton);
                    button1.setOnClickListener(new OnClickListener() {

                        public void onClick(View v) {
                            EditText newFood=(EditText) dialog.findViewById(R.id.foodName);
                            String foodname=newFood.getText().toString();
                            food.add(foodname);
                            EditText newCal=(EditText) dialog.findViewById(R.id.calories);
                            int calor = Integer.parseInt(newCal.getText().toString());
                            cal.add(calor);

                            workDB.saveFood(foodname,calor);

                            updateList();
                            dialog.dismiss();

                        }
                    });


                    dialog.show();
                }
            }


            );

        }

}