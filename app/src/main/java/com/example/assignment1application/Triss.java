package com.example.assignment1application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Triss extends AppCompatActivity {

    private ImageView trissInfoScreen;
    private RadioGroup radioColorGroup;
    private RadioButton colorSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triss);
        setTitle("The Witcher Index");
    }

    public void goHide(View v) {

        trissInfoScreen =  findViewById(R.id.vilgefortzinfo);
        trissInfoScreen.setVisibility(View.GONE);
        //  androidIcon.setVisibility(View.INVISIBLE);

    }

    public void goShow(View v) {
        trissInfoScreen = findViewById(R.id.vilgefortzinfo);
        trissInfoScreen.setVisibility(View.VISIBLE);
    }

    public void goCheckColor(View v){
        radioColorGroup=(RadioGroup)findViewById(R.id.trissRadio);
        int selectedId = radioColorGroup.getCheckedRadioButtonId();
        colorSelected=(RadioButton)findViewById(selectedId);
        Toast.makeText(getBaseContext(), colorSelected.getText(),
                Toast.LENGTH_SHORT).show();
    }
}