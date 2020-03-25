package it.lorenzo.cotti.cisitasample2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import it.lorenzo.cotti.cisitasample2020.fragments.HomeFragment;


public class MainActivity extends AppCompatActivity {
    int conta = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("CISITA", "onCreate app CISITA!");

        //definire quale layout deve mostrare la nostra schermata
        setContentView(R.layout.activity_main);

        // creo Home Fragment all'avvio
        createHomeFragment();

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

    //creo e instanzio un fragment all'avvio dell'applicazione
    private void createHomeFragment() {

        //creo una istanza del Home Fragment
        HomeFragment homeFragment = new HomeFragment();

        //inizio una transizione per aggiungere il fragment tramite il Fragment Manager ottenuto dall'activity
        FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();

        //aggiungo la istanza di fragment  al framelayout contenuto in activity_ main.layout e associo un TAG
        transaction.add(R.id.FrameLayoutCountainer, homeFragment, "HOME_FRAGMENT");

        transaction.commit();
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
