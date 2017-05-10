package com.example.bjoru.alkoholnivamaler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FemaleActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.alkoholnivamaler.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_female);

        sendInfoButton();
    }

    //når knapp merket "Tilbake" trykkes
    public void backFemale(View view) {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }

    private void sendInfoButton() {
        Button btn = (Button) findViewById(R.id.femaleCalcButton);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent finalIntent = new Intent(FemaleActivity.this, FinalActivity.class);

                //EditText verdier
                EditText femaleVekt = (EditText) findViewById(R.id.femaleVekt);
                String femaleVektString = femaleVekt.getText().toString();
                int femaleVektNr = Integer.parseInt(0+femaleVektString);

                EditText femaleOl = (EditText) findViewById(R.id.femaleOl);
                String femaleOlString = femaleOl.getText().toString();
                int femaleOlNr = Integer.parseInt(0+femaleOlString);

                EditText femaleVin = (EditText) findViewById(R.id.femaleVin);
                String femaleVinString = femaleVin.getText().toString();
                int femaleVinNr = Integer.parseInt(0+femaleVinString);

                EditText femaleShot = (EditText) findViewById(R.id.femaleShot);
                String femaleShotString = femaleShot.getText().toString();
                int femaleShotNr = Integer.parseInt(0+femaleShotString);

                EditText femaleTimer = (EditText) findViewById(R.id.femaleTimer);
                String femaleTimerString = femaleTimer.getText().toString();
                int femaleTimerNr = Integer.parseInt(0+femaleTimerString);

                //sjekker at vekt ikke er 0
                if (femaleVektNr == 0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Vekt kan ikke vær tom", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    //Omregning av input til gram alkohol
                    double olGram = femaleOlNr * 11.9;
                    double vinGram = femaleVinNr * 14.4;
                    double shotGram = femaleShotNr * 12.8;

                    //Legger sammen gram alkohol
                    double gramAlkohol = olGram + vinGram + shotGram;

                    //Beregner promille
                    double dinPromille = gramAlkohol / (femaleVektNr * 0.60) - (0.15 * femaleTimerNr);
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