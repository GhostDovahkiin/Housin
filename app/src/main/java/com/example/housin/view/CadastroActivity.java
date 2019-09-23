package com.example.housin.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.housin.R;
import com.example.housin.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import de.hdodenhof.circleimageview.CircleImageView;

public class CadastroActivity extends AppCompatActivity {
    
    
    private CircleImageView imagem;
    private final int GALERIA_IMAGENS = 1;
    private final int PERMISSAO_REQUEST = 2;
    private EditText editTextNome, editTextEmail, editTextTelefone, editTextUsername, editTextSenha, editTextAdicionarFoto;
    private FirebaseAuth mAuth;
    private static final int PICK_IMAGE_REQUEST = 1;
    private URI mImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


        //Cadastro de usuário completo
        Button cadastrar = findViewById(R.id.buttoncadastrar);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editTextNome.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String senha = editTextSenha.getText().toString().trim();
                String telefone = editTextTelefone.getText().toString().trim();
                String username = editTextUsername.getText().toString().trim();

                if (nome.isEmpty()) {
                    editTextNome.setError("Nome é obrigatório");
                    editTextNome.requestFocus();
                    return;
                }

                if (email.isEmpty()) {
                    editTextEmail.setError("Email é obrigatório");
                    editTextEmail.requestFocus();
                    return;
                }

                if (senha.isEmpty()) {
                    editTextSenha.setError("Senha é obrigatória");
                    editTextSenha.requestFocus();
                    return;
                }

                if (telefone.isEmpty()) {
                    editTextTelefone.setError("Telefone é obrigatório");
                    editTextTelefone.requestFocus();
                    return;
                }

                if (username.isEmpty()) {
                    editTextUsername.setError("Username é obrigatório");
                    editTextUsername.requestFocus();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, senha)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Usuario usuario = new Usuario(nome, email, telefone, senha, username);

                                    FirebaseDatabase.getInstance().getReference("Users")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(usuario).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(CadastroActivity.this, "Registro feito com sucesso!", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(CadastroActivity.this, feedActivity.class);
                                                startActivity(intent);
                                            } else {
                                                Toast.makeText(CadastroActivity.this, "Cadastro não realizado", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });

                                } else {
                                    Toast.makeText(CadastroActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });
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


        //Cancelar cadastro, botão de retorno
        ImageView close = findViewById(R.id.imageClose);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastroActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        editTextAdicionarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFileChooser();
            }
        }


        //adicionando foto
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
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

        editTextNome = findViewById(R.id.textnome);
        editTextEmail = findViewById(R.id.textemail);
        editTextSenha = findViewById(R.id.textsenhaC);
        editTextTelefone = findViewById(R.id.texttelefone);
        editTextUsername = findViewById(R.id.textloginC);
        mAuth = FirebaseAuth.getInstance();
        editTextAdicionarFoto = findViewById(R.id.textAdicionarFoto);

    }

    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }
 
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
 
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            mImageUri = data.getData();
 
            Picasso.with(this).load(mImageUri).into(mImageView);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() != null) {
            // Usuario já logado
        } else {

        }
    }


    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == GALERIA_IMAGENS) {
            Uri selectedImage = data.getData();
            String[] filePath = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
            c.moveToFirst();
            int columnIndex = ((Cursor) c).getColumnIndex(filePath[0]);
            String picturePath = c.getString(columnIndex);
            c.close();
            Bitmap imagemGaleria = (BitmapFactory.decodeFile(picturePath));
            imagem.setImageBitmap(imagemGaleria);

        }
    }*/

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

        if (requestCode == PERMISSAO_REQUEST) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //Permissão dada
            } else {
                //Permissão negada
            }
            return;
        }
    }


}
