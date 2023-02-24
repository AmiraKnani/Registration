package com.example.amiraknani;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    Button connecter;
    Button oublie;
    Button inscrire;
    private final static int ACCOUNT_INSCRIPTION_ACTIVITY_ID = 10;
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ACCOUNT_INSCRIPTION_ACTIVITY_ID){
            if(resultCode == 10){
                String mail = data.getStringExtra("loginExtra");
                String passworde = data.getStringExtra("passwordExtra");
                String message= data.getStringExtra("MSG");
                email.setText(mail);
                password.setText(passworde);
                Toast.makeText(this,message, Toast.LENGTH_LONG).show();

            }
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.password);
        connecter=(Button) findViewById(R.id.connecter);
        oublie=(Button) findViewById(R.id.oublie);
        inscrire=(Button) findViewById(R.id.inscrire);
        connecter.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }});

        inscrire.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, inscription.class);

                startActivityForResult(intent, ACCOUNT_INSCRIPTION_ACTIVITY_ID);
            }
        });
        oublie.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent;
                intent =new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"offrepromotion@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Mot de passe oublié");
                intent.putExtra(Intent.EXTRA_TEXT,"Bonjour J'ai oublié mon mot de passe");
                startActivity(Intent.createChooser(intent, "send"));
            }
        });


    }
}