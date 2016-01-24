package com.ce.nutchakhun.running;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Goal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

        Spinner actlevel = (Spinner) findViewById(R.id.spinner_level);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.array_actlevel, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        actlevel.setAdapter(adapter);

        Spinner goal = (Spinner) findViewById(R.id.spinner_goal);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.array_goal, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        goal.setAdapter(adapter2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_goal, menu);
        return true;
    }   

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean checkdata(){


    return true;
    }

    public void sumbit_data(View view) {
        if(checkdata()==true){
            EditText edit = (EditText) findViewById(R.id.fill_age);
            int age = Integer.parseInt(edit.getText().toString());
            edit = (EditText) findViewById(R.id.fill_weight);
            int weight = Integer.parseInt(edit.getText().toString());
            edit = (EditText) findViewById(R.id.fill_height);
            int height = Integer.parseInt(edit.getText().toString());
            RadioGroup radioGroup = (RadioGroup) findViewById(R.id.sex);
            int sex = radioGroup.getCheckedRadioButtonId();
            if(sex==R.id.male) sex = 0;
            else sex = 1;
            Spinner spinner = (Spinner) findViewById(R.id.spinner_level);
            int level = spinner.getSelectedItemPosition();
            Spinner spinner2 = (Spinner) findViewById(R.id.spinner_goal);
            int goal = spinner2.getSelectedItemPosition();
            Log.d("age",age+"");
            Log.d("weight",weight+"");
            Log.d("Height",height+"");
            Log.d("sex",sex+"");
            Log.d("level",level+"");
            Log.d("goal",goal+"");





        }


    }


}
