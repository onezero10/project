package com.ce.nutchakhun.running;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Main extends AppCompatActivity {
private int foodRequest = 69;
private int sumCal=0;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode== foodRequest && resultCode ==RESULT_OK){
            TextView edit = (TextView) findViewById(R.id.showFood);
            int calFood = data.getIntExtra("cal", 0);
            sumCal+=calFood;
            edit.setText(sumCal+"");
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, Main.class);
                startActivity(intent);
            }
        });

        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, Goal.class);
                startActivity(intent);
            }
        });

        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, Workout.class);
                startActivity(intent);
            }
        });

        final Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Main.this,Main.class);
                startActivity(intent);
            }
        });

        final Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        final Button button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, food.class);
                startActivityForResult(intent,foodRequest);
            }
        });

        boolean thisFirstTime=false;
        if(UserData.getAge(this)==null)thisFirstTime=true;
        else if(UserData.getActLevel(this)==null)thisFirstTime=true;
        else if(UserData.getCalPerDay(this)==null)thisFirstTime=true;
        else if(UserData.getHeight(this)==null)thisFirstTime=true;
        else if(UserData.getSex(this)==null)thisFirstTime=true;
        else if(UserData.getWeight(this)==null)thisFirstTime=true;

        if(thisFirstTime==true){
            Intent goGoal = new Intent(getApplicationContext(),Goal.class);
            startActivity(goGoal);


        }
        TextView edit = (TextView) findViewById(R.id.showRemain);
        edit.setText(UserData.getCalPerDay(this)+"");




    }




    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first
        TextView edit = (TextView) findViewById(R.id.showGoal);
        edit.setText(UserData.getCalPerDay(this)+"");
        edit = (TextView) findViewById(R.id.showRemain);
        int remain = UserData.getCalPerDay(this)-sumCal;
        edit.setText(remain+"");



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


}

