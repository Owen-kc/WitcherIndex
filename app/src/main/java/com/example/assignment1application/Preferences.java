package com.example.assignment1application;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Preferences extends Activity {

    private SharedPreferences person_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
    }

    public void goSave(View v){

        person_details = getApplicationContext().getSharedPreferences("person_details", MODE_PRIVATE);
        EditText myName =  findViewById(R.id.changeText);
        String txt = myName.getText().toString();
        SharedPreferences.Editor editor = person_details.edit();
        editor.putString("key_name", txt);
        editor.commit();

        Toast.makeText(getBaseContext(), "Data Saved!!",
                Toast.LENGTH_SHORT).show();


    }

    public void goShow(View v){
        person_details = getApplicationContext().getSharedPreferences("person_details", MODE_PRIVATE);

        String name = person_details.getString("key_name", null);
        Toast.makeText(getBaseContext(), name,
                Toast.LENGTH_SHORT).show();
    }

}
