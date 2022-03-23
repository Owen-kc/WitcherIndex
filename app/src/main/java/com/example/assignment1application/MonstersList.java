package com.example.assignment1application;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;


public class MonstersList extends ListActivity {



    private static final String[] monsters={
            "Shupe",
            "Ocvist",
            "Pheonix",
    };

    private static final String[] monstersLabels={
            "Shupe",
            "Ocvist",
            "Pheonix"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monsters_list);

        setListAdapter(new MyOwnAdapter());
        setTitle("The Witcher Index");


    }

    class MyOwnAdapter extends ArrayAdapter<String> {
        MyOwnAdapter() {
            super(MonstersList.this, R.layout.my_row, R.id.label, monstersLabels);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View row=super.getView(position, convertView, parent);
            ImageView icon=(ImageView)row.findViewById(R.id.icon);


            if (monsters[position]== "Shupe")
                icon.setImageResource(R.drawable.aard);
            if (monsters[position]== "Ocvist")
                icon.setImageResource(R.drawable.yrden);
            if (monsters[position]== "Pheonix")
                icon.setImageResource(R.drawable.aard2);



            return(row);
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {


        try {
            Class myClass = Class.forName("com.example.assignment1application." + monsters[position]);
            Intent i = new Intent(MonstersList.this, myClass);
            startActivity(i);
        }
        catch
        (Exception e)
        {
            e.printStackTrace();
        }
    }
}
