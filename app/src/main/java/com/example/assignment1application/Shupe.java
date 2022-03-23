package com.example.assignment1application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Shupe extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shupe);
        setTitle("Go to:");
        overridePendingTransition(R.transition.slide_in_right,R.transition.slide_out_left);
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

        if (id == R.id.shupe) {
            overridePendingTransition(R.transition.slide_in_left,R.transition.slide_out_right);
            Toast.makeText(this, "You are on Shupe page", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.pheonix){
            startActivity(new Intent(Shupe.this, Pheonix.class));
            overridePendingTransition(R.transition.slide_in_left,R.transition.slide_out_right);
        }
        else if(id == R.id.ocvist){
            startActivity(new Intent(Shupe.this, Ocvist.class));
            overridePendingTransition(R.transition.slide_in_left,R.transition.slide_out_right);
        }

        return super.onOptionsItemSelected(item);
    }


}