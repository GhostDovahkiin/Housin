package com.example.housin.view.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.housin.R;
import com.example.housin.rxjava.GameFacade;
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
    Button next;


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

        rpg = view.findViewById(R.id.switch_rpg);
        moba = view.findViewById(R.id.switch_moba);
        mmorpg = view.findViewById(R.id.switch_mmorpg);
        fps = view.findViewById(R.id.switch_fps);
        antigos = view.findViewById(R.id.switch_classicos);
        terror = view.findViewById(R.id.switch_jogo_terror);
        corrida = view.findViewById(R.id.switch_corrida);
        esportes = view.findViewById(R.id.switch_esportes);
        next = view.findViewById(R.id.img_btn_next3);

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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        GameFacade gameFacade = new GameFacade(getContext(), comunicadorEntreFragments);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameFacade.postGostoGamer(username,
                        rpg.isChecked(),
                        moba.isChecked(),
                        mmorpg.isChecked(),
                        fps.isChecked(),
                        antigos.isChecked(),
                        terror.isChecked(),
                        corrida.isChecked(),
                        esportes.isChecked());
            }
        });
    }
}
