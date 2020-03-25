package it.lorenzo.cotti.cisitasample2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int conta = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("CISITA", "onCreate app CISITA!");

        //definire quale layout deve mostrare la nostra schermata
        setContentView(R.layout.activity_main);

        //inflate delle view dal layout
        Button buttonClickMe =(Button)findViewById(R.id.buttonClickMe);
        final TextView myTextView = (TextView)findViewById(R.id.textViewHelloWorld);

        //intercetto il click sul pulsante
        buttonClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                 //v è il nome della variabile

                Log.d("CISITA", "onClick event called!");

                conta++;
                myTextView.setText("Hai premuto "+ String.valueOf(conta)+" volte");

                //cambio activity
                GoToSecondActivity();
            }
        });
    }

    private void GoToSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("CISITA", "onResume app CISITA!");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("CISITA", "onPause app CISITA!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("CISITA", "onDestroy app CISITA!");
    }
}
