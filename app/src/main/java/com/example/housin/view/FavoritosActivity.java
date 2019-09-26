package com.example.housin.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.housin.R;

public class FavoritosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        ImageButton voltar = findViewById(R.id.imageButton16);
        ImageButton info1 = findViewById(R.id.infoButton1);
        ImageButton info2 = findViewById(R.id.infoButton2);
        ImageButton info3 = findViewById(R.id.infoButton3);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FavoritosActivity.this, PerfilActivity.class);
                startActivity(intent);
                finish();
            }
        });
        info1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FavoritosActivity.this, DetalhesCasaActivity.class);
                startActivity(intent);
                finish();


            }
        });
        info2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FavoritosActivity.this, DetalhesCasaActivity.class);
                startActivity(intent);
                finish();


            }
        });
        info3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FavoritosActivity.this, DetalhesCasaActivity.class);
                startActivity(intent);
                finish();


            }
        });

    }
}
