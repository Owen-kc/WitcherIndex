package com.example.assignment1application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Ocvist extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocvist);
        setTitle("Go to:");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.ocvist) {
            overridePendingTransition(R.transition.slide_in_right,R.transition.slide_out_left);
            Toast.makeText(this, "You are on Ocvist page", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.shupe){
            startActivity(new Intent(Ocvist.this, Shupe.class));
            overridePendingTransition(R.transition.slide_in_right,R.transition.slide_out_left);
        }
        else if(id == R.id.pheonix){
            startActivity(new Intent(Ocvist.this, Pheonix.class));
            overridePendingTransition(R.transition.slide_in_right,R.transition.slide_out_left);
        }

        return super.onOptionsItemSelected(item);
    }


}