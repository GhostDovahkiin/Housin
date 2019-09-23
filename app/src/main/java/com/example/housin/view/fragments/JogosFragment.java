package com.example.housin.view.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import androidx.fragment.app.Fragment;

import com.example.housin.R;
import com.example.housin.view.ComunicadorEntreFragments;

/**
 * A simple {@link Fragment} subclass.
 */
public class JogosFragment extends Fragment {
    private ComunicadorEntreFragments comunicadorEntreFragments;
    private String username;

    Switch rpg;
    Switch moba;
    Switch mmorpg;
    Switch fps;
    Switch antigos;
    Switch terror;
    Switch corrida;
    Switch esportes;


    public JogosFragment() {
        // Required empty public constructor
    }

    public JogosFragment(String username) {
        this.username = username;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogos, container, false);


        return view;
    }

    public void onAttach(Context context) {
        super.onAttach(context);

        comunicadorEntreFragments = (ComunicadorEntreFragments) context;

    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            comunicadorEntreFragments = (ComunicadorEntreFragments) activity;
        }
    }

}
