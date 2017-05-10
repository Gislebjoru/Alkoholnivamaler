package com.example.bjoru.alkoholnivamaler;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //når knapp merket "Mann" trykkes
    public void sendMessageMale(View view) {
        Intent intentMale = new Intent(this, MaleActivity.class);
        startActivity(intentMale);
    }

    //når knapp merket "Kvinne" trykkes
    public void sendMessageFemale(View view) {
        Intent intentFemale = new Intent(this, FemaleActivity.class);
        startActivity(intentFemale);
    }
}

