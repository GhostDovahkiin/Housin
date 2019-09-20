package com.example.housin.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.housin.R;
import com.example.housin.model.Casa;
import com.example.housin.model.Endereco;
import com.example.housin.model.Mobilia;
import com.example.housin.model.Usuario;
import com.example.housin.model.UsuarioSimples;

import java.util.ArrayList;
import java.util.List;

public class feedActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        RecyclerView feedRecycler = findViewById(R.id.ricycleFeed);
        feedRecycler.setAdapter(new FeedAdapter(mockandoCasas(), this));
        feedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false));

    }

    private List<Casa> mockandoCasas() {
        List<Casa> casas = new ArrayList<>();
        Usuario user = new UsuarioSimples("Ana", "lima.rhcp@gmail.com", "f", "83991598843", false, true, null, null);

        Endereco endereco = new Endereco("Sertãozinho", "centro", "Rua Projetada", "9273");
        Mobilia mobilia = new Mobilia(true, true, true, true, true, true, true, true, true, true);
        for(int i = 0; i < 5; i++) {
            casas.add(new Casa(4, endereco, user, 2, 1, mobilia));
        }

        return casas;
    }


}
