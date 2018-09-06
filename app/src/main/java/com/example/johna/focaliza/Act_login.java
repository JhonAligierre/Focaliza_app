package com.example.johna.focaliza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Act_login extends AppCompatActivity {

EditText user_txt, pass_txt;
Button btn_login;
BDHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);
            db = new BDHelper(this);

        user_txt = (EditText) findViewById(R.id.user_text);
        pass_txt = (EditText) findViewById(R.id.pass_text);
        btn_login = (Button) findViewById(R.id.btn_login);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = user_txt.getText().toString();
                String password = pass_txt.getText().toString();

                if (username.equals("")){
                    Toast.makeText(Act_login.this,"O username não digitado! Tente novamente.",Toast.LENGTH_SHORT).show();
                }else if (password.equals("")){
                    Toast.makeText(Act_login.this,"O password não digitado! Tente novamente.",Toast.LENGTH_SHORT).show();
                }else {
                    //Tudo Ok!
                    String res = db.Validarlogin(username,password);
                    if (res.equals("OK")){
                        Toast.makeText(Act_login.this,"Bem vindo!",Toast.LENGTH_SHORT).show();
                        Intent home = new Intent(Act_login.this, act_home.class);
                        startActivity(home);
                    }else {
                        Toast.makeText(Act_login.this,"Erro no login! Tente novamente.",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });



 }
}


