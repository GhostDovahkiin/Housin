package com.example.housin.view.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.housin.R;
import com.example.housin.rxjava.UserFacade;
import com.example.housin.view.ComunicadorEntreFragments;

/**
 * A simple {@link Fragment} subclass.
 */
public class CaracteristicasFragment extends Fragment {
    EditText txt_username;
    ComunicadorEntreFragments comunicador;
    Button imgNext;
    UserFacade userFacade;
    RadioGroup sexo;
    RadioGroup limpeza;
    RadioGroup organizacao;
    RadioGroup comportamento;
    RadioGroup responsabilidade;
    RadioGroup animais;
    RadioGroup bebidas;
    RadioGroup cigarros;


    public CaracteristicasFragment() {
        // Required empty public constructor
    }

    public void onAttach(Context context) {
        super.onAttach(context);

        comunicador = (ComunicadorEntreFragments) context;

    }

    private String convertendoValor(String value) {

        switch (value) {

            case "Feminino":
                return "f";

            case "Masculino":
                return "m";

            case "Introvertido":
                return "introvertido";

            case "Extrovertido":
                return "extrovertido";

            default:
                return null;

        }
    }

    private boolean convertendoValorBoolean(String value) {

        return value.equals("Sim");
    }

    private String retornandoValorString(RadioGroup radioGroup) {
        int idSelecionado = radioGroup.getCheckedRadioButtonId();

        RadioButton selecionado = radioGroup.findViewById(idSelecionado);

        return convertendoValor(selecionado.getText().toString());
    }

    private boolean retornandoValorBoolean(RadioGroup radioGroup) {
        int idSelecionado = radioGroup.getCheckedRadioButtonId();

        RadioButton selecionado = radioGroup.findViewById(idSelecionado);

        try {
            return convertendoValorBoolean(selecionado.getText().toString());
        } catch (Exception e) {
            Log.i("erro hein", e.getLocalizedMessage());
        }

        return false;

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        userFacade = new UserFacade();

        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valueSexo = retornandoValorString(sexo);
                String valueComportamento = retornandoValorString(comportamento);

                boolean valueLimpo = retornandoValorBoolean(limpeza);
                boolean valueOrganizado = retornandoValorBoolean(organizacao);
                boolean valueResponsavel = retornandoValorBoolean(responsabilidade);
                boolean valueAnimais = retornandoValorBoolean(animais);
                boolean valueBebidas = retornandoValorBoolean(bebidas);
                boolean valueCigarros = retornandoValorBoolean(cigarros);

                boolean status = userFacade.postUsuario(txt_username.getText().toString(), valueSexo, valueLimpo, valueOrganizado, valueComportamento, valueResponsavel, valueAnimais, valueBebidas, valueCigarros);

                Log.i("status lemon", String.valueOf(status));

                if (status) {
                    comunicador.passandoFragments(new FilmesFragment());
                } else {
                    Toast.makeText(getContext(), "Algo deu errado!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_caracteristicas, container, false);
        imgNext = view.findViewById(R.id.img_btn_next1);
        txt_username = view.findViewById(R.id.edit_txt_username);

        sexo = view.findViewById(R.id.group_sexo);
        limpeza = view.findViewById(R.id.group_limpeza);
        organizacao = view.findViewById(R.id.group_organizacao);
        comportamento = view.findViewById(R.id.group_comportamento);
        responsabilidade = view.findViewById(R.id.group_responsabilidade);
        animais = view.findViewById(R.id.group_animais);
        bebidas = view.findViewById(R.id.group_bebidas);
        cigarros = view.findViewById(R.id.group_cigarros);

        return view;
    }

}
