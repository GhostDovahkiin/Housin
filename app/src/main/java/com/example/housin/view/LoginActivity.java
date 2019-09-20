package com.example.housin.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.housin.R;

public class LoginActivity extends AppCompatActivity {
    Button button;
    String textError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = findViewById(R.id.buttonLogin);
    }

    private boolean verificandoUsername() {

        if(false) { //username não for encontrado no banco
            textError = "Username não encontrado!";
        } else {
            return true;
        }


        return false;
    }

    private boolean verificandoSenha() {

        if(false) { //senha não bater com o username
            textError = "Senha incorreta!";
        } else {
            return true;
        }

        return false;

    }

    private void verificandoLogin() {

        if (verificandoUsername() && verificandoSenha()) {
            //Vai para a tela de usuários disponíveis
        } else {
            button.setBackgroundColor(getResources().getColor(R.color.loginError));
            Toast.makeText(getApplicationContext(), textError, Toast.LENGTH_SHORT).show();
        }
    }

}
