package com.example.housin.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.housin.R;

public class DetalhesCasaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_anuncios2);

        ImageButton voltar = findViewById(R.id.imageButton3);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetalhesCasaActivity.this, PerfilActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
