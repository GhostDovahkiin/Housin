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
import com.example.housin.rxjava.BookFacade;
import com.example.housin.view.ComunicadorEntreFragments;

/**
 * A simple {@link Fragment} subclass.
 */
public class LivrosFragment extends Fragment {
    private String username;
    Switch terror;
    Switch quadrinhos;
    Switch manga;
    Switch romance;
    Switch ficcao;
    Switch religioso;
    Switch infanto;
    Switch fantasia;
    Switch academico;
    Button next;
    private ComunicadorEntreFragments comunicadorEntreFragments;


    public LivrosFragment() {
        // Required empty public constructor
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

    public LivrosFragment(String username) {
        this.username = username;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_livros, container, false);

        terror = view.findViewById(R.id.switch_livro_terror);
        quadrinhos = view.findViewById(R.id.switch_livro_hq);
        manga = view.findViewById(R.id.switch_livro_manga);
        romance = view.findViewById(R.id.switch_livro_romance);
        ficcao = view.findViewById(R.id.switch_livro_ficcao);
        religioso = view.findViewById(R.id.switch_livro_biblia);
        infanto = view.findViewById(R.id.switch_livro_juvenil);
        fantasia = view.findViewById(R.id.switch_livro_fantasia);
        academico = view.findViewById(R.id.switch_livro_academico);

        next = view.findViewById(R.id.img_btn_next4);

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        BookFacade bookFacade = new BookFacade(new JogosFragment(username), getContext(), comunicadorEntreFragments);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bookFacade.postGostoLiterario(username,
                        terror.isChecked(),
                        quadrinhos.isChecked(),
                        manga.isChecked(),
                        romance.isChecked(),
                        ficcao.isChecked(),
                        religioso.isChecked(),
                        infanto.isChecked(),
                        fantasia.isChecked(),
                        academico.isChecked());
            }
        });
    }
}
