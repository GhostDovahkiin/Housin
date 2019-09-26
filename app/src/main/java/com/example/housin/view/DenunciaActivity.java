package com.example.housin.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.housin.R;

public class DenunciaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denuncia);

        Button denuncia1 = findViewById(R.id.denuncia1);
        denuncia1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DenunciaActivity.this, DenunciaEnviadaActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ImageButton voltar = findViewById(R.id.voltarButton);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DenunciaActivity.this, feedActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button denuncia2 = findViewById(R.id.denuncia2);
        denuncia2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DenunciaActivity.this, DenunciaEnviadaActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button denuncia3 = findViewById(R.id.denuncia3);
        denuncia3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DenunciaActivity.this, DenunciaEnviadaActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button denuncia4 = findViewById(R.id.denuncia4);
        denuncia4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DenunciaActivity.this, DenunciaEnviadaActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
