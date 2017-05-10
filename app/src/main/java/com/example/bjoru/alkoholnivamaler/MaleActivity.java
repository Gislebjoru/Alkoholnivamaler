package com.example.bjoru.alkoholnivamaler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLOutput;
import java.text.DecimalFormat;

public class MaleActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.alkoholnivamaler.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_male);

        sendInfoButton();
    }

    //når knapp merket "Tilbake" trykkes
    public void backMale(View view) {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }

    private void sendInfoButton() {
        Button btn = (Button) findViewById(R.id.maleCalcButton);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent finalIntent = new Intent(MaleActivity.this, FinalActivity.class);

                //EditText verdier
                EditText maleVekt = (EditText) findViewById(R.id.maleVekt);
                String maleVektString = maleVekt.getText().toString();
                int maleVektNr = Integer.parseInt(0+maleVektString);

                EditText maleOl = (EditText) findViewById(R.id.maleOl);
                String maleOlString = maleOl.getText().toString();
                int maleOlNr = Integer.parseInt(0+maleOlString);

                EditText maleVin = (EditText) findViewById(R.id.maleVin);
                String maleVinString = maleVin.getText().toString();
                int maleVinNr = Integer.parseInt(0+maleVinString);

                EditText maleShot = (EditText) findViewById(R.id.maleShot);
                String maleShotString = maleShot.getText().toString();
                int maleShotNr = Integer.parseInt(0+maleShotString);

                EditText maleTimer = (EditText) findViewById(R.id.maleTimer);
                String maleTimerString = maleTimer.getText().toString();
                int maleTimerNr = Integer.parseInt(0+maleTimerString);

                //sjekker at vekt ikke er 0
                if(maleVektNr == 0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Vekt kan ikke vær tom", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    //Omregning av input til gram alkohol
                    double olGram = maleOlNr * 11.9;
                    double vinGram = maleVinNr * 14.4;
                    double shotGram = maleShotNr * 12.8;

                    //Legger sammen gram alkohol
                    double gramAlkohol = olGram + vinGram + shotGram;

                    //Beregner promille
                    double dinPromille = gramAlkohol / (maleVektNr * 0.70) - (0.15 * maleTimerNr);
                    String formattedData = String.format("%.02f", dinPromille);
                    String underNull = "Under 0";

                    //sjekk om promille er under 0 og så send den riktige responsen til ny activity
                    if(dinPromille < 0) {
                        finalIntent.putExtra("Promille", underNull);
                    } else {
                        finalIntent.putExtra("Promille", formattedData);
                    }

                    //start ny activity
                    startActivity(finalIntent);
                }
            }
        });
    }
}
