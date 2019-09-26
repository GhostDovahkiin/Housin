package com.example.housin.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.housin.R;
import com.google.firebase.auth.FirebaseAuth;

public class ContaActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        Button buttonLogout = findViewById(R.id.sairButton1);

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.getInstance().signOut();
                Intent intent = new Intent(ContaActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ImageButton voltar = findViewById(R.id.imageButton4);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContaActivity.this, PerfilActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}