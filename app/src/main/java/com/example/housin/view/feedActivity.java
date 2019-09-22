package com.example.housin.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.housin.R;
import com.example.housin.model.Casa;
import com.example.housin.model.Endereco;
import com.example.housin.model.Mobilia;
import com.example.housin.model.UserAPI;

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

    }

    private List<Casa> mockandoCasas() {
        List<Casa> casas = new ArrayList<>();
        UserAPI.Usuario user = new UserAPI.Usuario();

        Endereco endereco = new Endereco("Sertãozinho", "centro", "Rua Projetada", "9273");
        Mobilia mobilia = new Mobilia(true, true, true, true, true, true, true, true, true, true);
        for(int i = 0; i < 5; i++) {
            casas.add(new Casa(4, endereco, 2, 1, mobilia));
        }

        return casas;
    }


}
