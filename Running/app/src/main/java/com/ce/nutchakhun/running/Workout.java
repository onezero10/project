package com.ce.nutchakhun.running;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class Workout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        String [ ] group = { "Cardio", "Weight Trainning", "Running" };
        String [ ] [ ] children =
                {
                        { "Swimming", "Riding", "Badminton" }
                        , { "Arm", "Abs", "Leg" }
                        , { "Running" }
                };
        MyExpadableAdapter adapter = new MyExpadableAdapter ( group, children );
        ExpandableListView expandableListView = (ExpandableListView) this.findViewById ( R.id.expandableListView );
        expandableListView.setAdapter ( adapter );
        expandableListView.expandGroup ( 0 );
    }
    protected class MyExpadableAdapter extends BaseExpandableListAdapter
    {
        private String [ ] group = null;
        private String [ ] [ ] children = null;
        public MyExpadableAdapter ( String [ ] group, String [ ] [ ] children )
        {
            this.group = group;
            this.children = children;
        }
        public Object getChild ( int groupPosition, int childPosition )
        {
            return this.children [ groupPosition ] [ childPosition ];
        }
        public long getChildId ( int groupPosition, int childPosition )
        {
            return childPosition;
        }
        public View getChildView ( int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent )
        {
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams ( ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT );
            TextView textView = new TextView ( Workout.this );
            textView.setLayoutParams ( layoutParams );
            textView.setPadding ( 10, 10, 10, 10 );
            textView.setText ( this.children [ groupPosition ] [ childPosition ] );
            return textView;
        }
        public int getChildrenCount ( int groupPosition )
        {
            return this.children [ groupPosition ].length;
        }
        public Object getGroup ( int groupPosition )
        {
            return this.group [ groupPosition ];
        }
        public int getGroupCount ( )
        {
            return this.group.length;
        }
        public long getGroupId ( int groupPosition )
        {
            return groupPosition;
        }
        public View getGroupView ( int groupPosition, boolean isExpanded, View convertView, ViewGroup parent )
        {
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams ( ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT );
            TextView textView = new TextView ( Workout.this );
            textView.setLayoutParams ( layoutParams );
            textView.setGravity ( Gravity.CENTER );
            textView.setPadding ( 18, 18, 18, 18 );
            textView.setText ( this.group [ groupPosition ] );
            return textView;
        }
        public boolean hasStableIds ( )
        {
            return true;
        }
        public boolean isChildSelectable ( int groupPosition, int childPosition )
        {
            return true;
        }
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_workout, menu);
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
