package com.example.housin.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.housin.R;

public class PerfilActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);


        //Entrando na conta
        Button conta = findViewById(R.id.buttonContaPerfil);
        conta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PerfilActivity.this, ContaActivity.class);
                startActivity(intent);
            }
        });

        //Entrando nos favoritos

        Button favoritos = findViewById(R.id.buttonFavoritosPerfil);
        favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PerfilActivity.this, FavoritosActivity.class);
                startActivity(intent);
            }
        });

        //Entrando nos anuncios

        Button anuncios = findViewById(R.id.buttonAnunciosPerfil);
        anuncios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PerfilActivity.this, MeusAnuncios.class);
                startActivity(intent);
            }
        });

        //Entrando nos termos e compomissos

        Button termos = findViewById(R.id.buttonObterAjudaPerfil);
        termos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PerfilActivity.this, TermosActivity.class);
                startActivity(intent);
            }
        });

        Button dadosPessoais = findViewById(R.id.buttonDadosPessoais);
        dadosPessoais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PerfilActivity.this, ContainerActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //entrando no obter ajuda

        Button obterAjuda = findViewById(R.id.buttonObterAjudaPerfil);
        obterAjuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PerfilActivity.this, ObterAjudaActivity.class);
                startActivity(intent);
            }
        });

        //entrando no feedback

        Button feeback = findViewById(R.id.buttonFeedBackPerfil);
        feeback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PerfilActivity.this, FeedbackActivity.class);
                startActivity(intent);
            }
        });


    }
}
