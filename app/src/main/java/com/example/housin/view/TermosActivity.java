package com.example.housin.view;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.housin.R;

public class TermosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termos);

        ImageView back = findViewById(R.id.imageView);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TermosActivity.this, CadastroActivity.class);
                startActivity(intent);


            }
        });
        //Como justificar um texto
        TextView teste = findViewById(R.id.txtTermos);
        teste.setText(R.string.termos_compromisso);

    }
}
