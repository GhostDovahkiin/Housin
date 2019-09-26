package com.example.housin.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.housin.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mFirebaseAuth; // Login do Firebase
    //private GoogleApiClient mApiClient; // Login do Google
    private EditText editTextUser, editTextSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnInscrevase = findViewById(R.id.buttonInscrever);
        btnInscrevase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mFirebaseAuth = FirebaseAuth.getInstance();

        editTextUser = (EditText) findViewById(R.id.textEmailL);
        editTextSenha = (EditText) findViewById(R.id.textSenhaL);
        findViewById(R.id.buttonLogin).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String user = editTextUser.getText().toString().trim();
        String senha = editTextSenha.getText().toString().trim();

        if(user.isEmpty()){
            editTextUser.setError("Email é requerido");
            editTextUser.requestFocus();
            return;
        }

        if(senha.isEmpty()){
            editTextSenha.setError("Senha é requerida");
            editTextSenha.requestFocus();
            return;
        }

        mFirebaseAuth.signInWithEmailAndPassword(user, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(MainActivity.this, feedActivity.class));
                            finish();
                        }else {
                            Toast.makeText(MainActivity.this, task.getException().toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
