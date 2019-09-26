package com.example.housin.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.housin.R;
import androidx.appcompat.app.AppCompatActivity;


public class MeusAnuncios extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_anuncios);

        ImageButton voltar = findViewById(R.id.imageButton16);
        ImageButton info = findViewById(R.id.infoButton1);
        ImageButton info2 = findViewById(R.id.infoButton2);
        ImageButton info3 = findViewById(R.id.infoButton3);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeusAnuncios.this, PerfilActivity.class);
                startActivity(intent);
                finish();

            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeusAnuncios.this, DetalhesCasaActivity.class);
                startActivity(intent);
                finish();


            }
        });
        info2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeusAnuncios.this, DetalhesCasaActivity.class);
                startActivity(intent);
                finish();


            }
        });
        info3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeusAnuncios.this, DetalhesCasaActivity.class);
                startActivity(intent);
                finish();


            }
        });


    }
}