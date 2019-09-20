package com.example.housin.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.housin.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class CadastroActivity extends AppCompatActivity {


    private CircleImageView imagem;
    private final int GALERIA_IMAGENS = 1;
    private final int PERMISSAO_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //Provisório --- ir para o feed
        Button cadastrar = findViewById(R.id.buttoncadastrar);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastroActivity.this, feedActivity.class);
                startActivity(intent);
            }
        });

        //indo para os termos
        TextView btntextTermos = findViewById(R.id.termos);
        btntextTermos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastroActivity.this, TermosActivity.class);
                startActivity(intent);
                finish();
            }
        });


        //VOltar para tela inicial
        ImageView close = findViewById(R.id.imageClose);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastroActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });



        //adicionando foto
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)){

            }else {
                ActivityCompat.requestPermissions(this,
                        new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},
                        PERMISSAO_REQUEST);
            }

        }

        imagem = (CircleImageView) findViewById(R.id.ivImagem);
        TextView galeria = (TextView) findViewById(R.id.textAdicionarFoto);
        galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(intent, GALERIA_IMAGENS);
            }
        });




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == GALERIA_IMAGENS){
            Uri selectedImage = data.getData();
            String[] filePath = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage,filePath,null,null,null);
            c.moveToFirst();
            int columnIndex = ((Cursor) c).getColumnIndex(filePath[0]);
            String picturePath = c.getString(columnIndex);
            c.close();
            Bitmap imagemGaleria = (BitmapFactory.decodeFile(picturePath));
            imagem.setImageBitmap(imagemGaleria);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults){

        if(requestCode == PERMISSAO_REQUEST){
            if(grantResults.length > 0 && grantResults[0] ==PackageManager.PERMISSION_GRANTED ){
                //Permissão dada
            }else {
                //Permissão negada
            }
            return;
        }
    }


}
