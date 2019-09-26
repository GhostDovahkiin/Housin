package com.example.housin.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.housin.R;
import com.example.housin.view.fragments.CaracteristicasFragment;

public class ContainerActivity extends AppCompatActivity implements ComunicadorEntreFragments {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);


        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame_layout, new CaracteristicasFragment());
        transaction.commit();

        ImageView voltar = findViewById(R.id.voltarGostosPessoais);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContainerActivity.this, PerfilActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void passandoFragments(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();
    }

    @Override
    public void voltandoParaActivity() {
        Toast.makeText(getApplicationContext(), "Cadastro feito com sucesso!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(ContainerActivity.this, PerfilActivity.class);
        startActivity(intent);
        finish();
    }
}


