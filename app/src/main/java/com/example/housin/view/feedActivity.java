package com.example.housin.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.housin.R;
import com.example.housin.model.Casa;
import com.example.housin.model.Endereco;
import com.example.housin.model.Mobilia;

import java.util.ArrayList;
import java.util.List;

public class feedActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        RecyclerView feedRecycler = findViewById(R.id.ricycleFeed);
        feedRecycler.setAdapter(new FeedAdapter(mockandoCasas(), this));
        feedRecycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));


        ImageButton perfil = findViewById(R.id.buttonPerfil);
        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(feedActivity.this, PerfilActivity.class);
                startActivity(intent);
            }
        });

    }

    private List<Casa> mockandoCasas() {
        List<Casa> casas = new ArrayList<>();
        List<Integer> ids = mockcasas();

        List<Endereco> enderecos = enderecos();
        Mobilia mobilia = new Mobilia(true, true, true, true, true, true, true, true, true, true);
        for(int i = 0; i < 5; i++) {
            casas.add(new Casa(4, enderecos.get(i), 2, 1, mobilia, ids.get(i)));
        }

        return casas;
    }

    private List<Endereco> enderecos() {
        List<Endereco> enderecos = new ArrayList<>();

        enderecos.add(new Endereco("Rio Tinto", "Conjunto", "Rua Projetada", "9273"));
        enderecos.add(new Endereco("Rio Tinto", "Salema", "Rua Professor Alameda", "557"));
        enderecos.add(new Endereco("Rio Tinto", "Centro", "Rua da Mangueira", "0987"));
        enderecos.add(new Endereco("Rio Tinto", "Centro", "rua da Aurora", "8232"));
        enderecos.add(new Endereco("Rio Tinto", "Centro", "rua do Tambor", "349"));

        return enderecos;
    }

    private List<Integer> mockcasas() {
        List<Integer> integers = new ArrayList<>();
        integers.add(R.drawable.casadois);
        integers.add(R.drawable.casatres);
        integers.add(R.drawable.casaquatro);
        integers.add(R.drawable.casacinco);
        integers.add(R.drawable.casaum);

        return integers;
    }

}
