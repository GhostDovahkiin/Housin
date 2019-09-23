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
import com.example.housin.rxjava.MovieFacade;
import com.example.housin.view.ComunicadorEntreFragments;

/**
 * A simple {@link Fragment} subclass.
 */
public class FilmesFragment extends Fragment {
    ComunicadorEntreFragments comunicador;

    Switch terror;
    Switch comedia;
    Switch comediaRomantica;
    Switch romantico;
    Switch ficcao;
    Switch anime;
    Switch drama;
    Switch policiais;
    Switch suspense;
    Switch besteirol;
    Switch acao;
    Button next;
    String username;


    public FilmesFragment() {
        // Required empty public constructor
    }

    public FilmesFragment(String username) {
        this.username = username;
    }

    public void onAttach(Context context) {
        super.onAttach(context);

        comunicador = (ComunicadorEntreFragments) context;

    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            comunicador = (ComunicadorEntreFragments) activity;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_filmes, container, false);

        terror = view.findViewById(R.id.switch_terror);
        comedia = view.findViewById(R.id.switch_comedia);
        comediaRomantica = view.findViewById(R.id.switch_comedia_romantica);
        romantico = view.findViewById(R.id.switch_romantico);
        ficcao = view.findViewById(R.id.switch_ficcao);
        anime = view.findViewById(R.id.switch_anime);
        drama = view.findViewById(R.id.switch_drama);
        policiais = view.findViewById(R.id.switch_police);
        suspense = view.findViewById(R.id.switch_suspense);
        besteirol = view.findViewById(R.id.switch_besteirol);
        acao = view.findViewById(R.id.switch_acao);
        next = view.findViewById(R.id.img_btn_next2);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        MovieFacade movieFacade = new MovieFacade(new MusicasFragment(username), getContext(), comunicador);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                movieFacade.postGostoCinefilo(
                        username,
                        terror.isChecked(),
                        suspense.isChecked(),
                        comedia.isChecked(),
                        comediaRomantica.isChecked(),
                        romantico.isChecked(),
                        ficcao.isChecked(),
                        anime.isChecked(),
                        drama.isChecked(),
                        policiais.isChecked(),
                        suspense.isChecked(),
                        besteirol.isChecked(),
                        acao.isChecked()
                );

            }
        });
    }

}
