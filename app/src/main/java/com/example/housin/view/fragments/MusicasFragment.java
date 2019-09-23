package com.example.housin.view.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.housin.R;
import com.example.housin.rxjava.MusicalFacade;
import com.example.housin.view.ComunicadorEntreFragments;

/**
 * A simple {@link Fragment} subclass.
 */
public class MusicasFragment extends Fragment {
    private String username;
    private ComunicadorEntreFragments comunicadorEntreFragments;

    Switch pop;
    Switch bregaRecife;
    Switch rock;
    Switch funk;
    Switch pagode;
    Switch indie;
    Switch eletronica;
    Switch hipHop;
    Switch rap;
    Switch metal;
    Switch jazz;
    Switch folk;
    Switch rb;
    Switch forro;
    Switch classica;

    ImageButton next;


    public MusicasFragment() {
        // Required empty public constructor
    }

    public MusicasFragment(String username) {
        this.username = username;
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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_musicas, container, false);

        pop = view.findViewById(R.id.switch_pop);
        bregaRecife = view.findViewById(R.id.switch_brega);
        rock = view.findViewById(R.id.switch_rock);
        funk = view.findViewById(R.id.switch_funk);
        pagode = view.findViewById(R.id.switch_pagode);
        indie = view.findViewById(R.id.switch_indie);
        eletronica = view.findViewById(R.id.switch_eletronica);
        hipHop = view.findViewById(R.id.switch_hiphop);
        rap = view.findViewById(R.id.switch_rap);
        metal = view.findViewById(R.id.switch_metal);
        jazz = view.findViewById(R.id.switch_jazz);
        folk = view.findViewById(R.id.switch_folk);
        rb = view.findViewById(R.id.switch_rb);
        forro = view.findViewById(R.id.switch_forro);
        classica = view.findViewById(R.id.switch_classica);

        next = view.findViewById(R.id.img_btn_next2);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        MusicalFacade facade = new MusicalFacade(new LivrosFragment(), getContext());

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                facade.postGostoMusical(
                      username,
                      pop.isChecked(),
                      rock.isChecked(),
                      bregaRecife.isChecked(),
                      funk.isChecked(),
                      pagode.isChecked(),
                      indie.isChecked(),
                      eletronica.isChecked(),
                      hipHop.isChecked(),
                      rap.isChecked(),
                      metal.isChecked(),
                      jazz.isChecked(),
                      folk.isChecked(),
                      rb.isChecked(),
                      forro.isChecked(),
                      classica.isChecked()
                );
            }
        });

    }
}
