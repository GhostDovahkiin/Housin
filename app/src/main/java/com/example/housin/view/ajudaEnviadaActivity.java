package com.example.housin.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.housin.R;

public class ajudaEnviadaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajuda2);

        ImageButton home = findViewById(R.id.homeButton);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ajudaEnviadaActivity.this, feedActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ImageButton perfil = findViewById(R.id.perfilButton);
        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ajudaEnviadaActivity.this, PerfilActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
