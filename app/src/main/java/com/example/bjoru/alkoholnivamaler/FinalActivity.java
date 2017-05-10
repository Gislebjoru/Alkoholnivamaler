package com.example.bjoru.alkoholnivamaler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        //Hent info sendt til FinalActivity
        Intent intent = getIntent();
        String myValue = intent.getStringExtra("Promille");
        TextView displayNumber = (TextView) findViewById(R.id.resultat);

        //Endre tekst
        displayNumber.setText("" + myValue);
        System.out.println(myValue);


    }

    //tilbake til start knapp
    public void backFinal(View view) {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }
}
