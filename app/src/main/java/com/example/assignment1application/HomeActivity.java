package com.example.assignment1application;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class HomeActivity extends ListActivity {


    String[] factions = {
            "Index",
            "Neutral",
            "Northern_Realms",
            "Nilfgaard",
            "Scoiatael",
            "Skellige",
            "MonstersList",
            "Preferences",
            "Questions",
            "Camera",
            "Calendar",
            "Gallery",
            "ARCamera",
            "AudioPlayer",
            "QuizStart",
            "Feedback"
    };


    String[] factionLabels = {
            "Index",
            "Neutral",
            "Northern Realms",
            "Nilfgaard",
            "Scoiatael",
            "Skellige",
            "Monsters",
            "Preferences",
            "Questions?",
            "Camera",
            "Calendar",
            "Gallery",
            "ARCamera",
            "AudioPlayer",
            "Quiz",
            "Feedback"
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Binding Array "myLabels" to ListAdapter
        setTitle("Select Index for information, or select one of the factions");
        this.setListAdapter(new ArrayAdapter<String>(HomeActivity.this, android.R.layout.simple_list_item_1, factionLabels));
    }



    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        try {
            Class myClass = Class.forName("com.example.assignment1application." + factions[position]);
            Intent i = new Intent(HomeActivity.this, myClass);
            startActivity(i);
            overridePendingTransition(R.transition.slide_in_right,R.transition.slide_out_left);
        }
        catch
        (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

}
