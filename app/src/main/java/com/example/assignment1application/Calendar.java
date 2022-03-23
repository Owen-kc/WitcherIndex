package com.example.assignment1application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

public class Calendar extends AppCompatActivity {

    CalendarView calendarView;
    TextView redDateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        setTitle("The Witcher Index");

        calendarView = findViewById(R.id.id_calendarView);
        redDateText = findViewById(R.id.id_textView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                String myDate = dayOfMonth + "/" + (month + 1) + "/" + year; // note the months start at 0

                redDateText.setText(myDate);

            }
        });
    }
}