package it.lorenzo.cotti.cisitasample2020.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import it.lorenzo.cotti.cisitasample2020.R;

public class HomeFragment extends Fragment implements  View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //referenzio Button per gestione logica pulsante
        Button buttonShowList = view.findViewById(R.id.buttonShowUsers);

        //implemento onClick pulsante
        buttonShowList.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Log.d("CISITA", "Pulsante premuto!");

        //cambio view applicativa
        showListUsers();
    }

    //Mostro fragment ListUsersFragment
    private void showListUsers() {
        //istanziato il nuovo fragment ListUsers
        ListUsersFragment listUsersFragment = new ListUsersFragment();

        //Avvio una transizione tramite FragmentManager ottenuto dalla MainActivity
        //fragment sta chiedendo ad activity di condividergli il suo fragment manager per iniziare transizione
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

        //sostuisco il fragment attuale con la nuova istanza di fragment nel FrameLayout
        transaction.replace(R.id.FrameLayoutCountainer, listUsersFragment, "LIST_USERS_FRAGMENT");

        //aggiungo fragment corrente tramite tag allo stack di navigazione
        transaction.addToBackStack(listUsersFragment.getTag());

        transaction.commit();
    }
}
