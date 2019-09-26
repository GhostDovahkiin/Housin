package com.example.housin.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.housin.R;

public class ObterAjudaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajuda);

        ImageButton voltar = findViewById(R.id.voltarButton);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ObterAjudaActivity.this, PerfilActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ImageButton enviarMensagem = findViewById(R.id.enviarMensagemButton);
        enviarMensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ObterAjudaActivity.this, ajudaEnviadaActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
