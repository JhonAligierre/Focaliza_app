package com.example.johna.focaliza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;

public class Registrar extends AppCompatActivity {

    EditText text_user_reg, text_pass1, text_pass2;
    Button button_registrar;
    BDHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        db = new BDHelper(this);
        text_user_reg = (EditText) findViewById(R.id.text_username);
        text_pass1 = (EditText) findViewById(R.id.password_text);
        text_pass2 = (EditText) findViewById(R.id.password_text2);

        button_registrar = (Button) findViewById(R.id.btn_registrar);


button_registrar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        String username = text_user_reg.getText().toString();
        String p1 = text_pass1.getText().toString();
        String p2 = text_pass2.getText().toString();

        if (username.equals("")){
            Toast.makeText(Registrar.this,"Username não inserido! Tente novamente", Toast.LENGTH_SHORT).show();
        }else if (p1.equals("")|| p2.equals("")){
            Toast.makeText(Registrar.this,"Password não inserido! Tente novamente", Toast.LENGTH_SHORT).show();
        }else if (!p1.equals(p2)){
            Toast.makeText(Registrar.this,"Os Passwords não Correspondem! Tente novamente", Toast.LENGTH_SHORT).show();
        }else {
            //Tudo Ok
            long res = db.CriarUtilizador(username,p1);
            if (res>0){
                Toast.makeText(Registrar.this,"Registro realizado com sucesso!", Toast.LENGTH_SHORT).show();
                finish();
                Intent log  = new Intent(Registrar.this, Act_login.class);
                startActivity(log);
            }else {
                Toast.makeText(Registrar.this,"Algo errado!! Tente novamente", Toast.LENGTH_SHORT).show();
            }
        }

    }
});

    }
}
