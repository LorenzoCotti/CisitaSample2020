package it.lorenzo.cotti.cisitasample2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

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
