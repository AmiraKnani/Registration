package com.example.amiraknani;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class inscription extends AppCompatActivity {
    EditText nom;
    EditText email;
    EditText pwd;
    RadioButton homme;
    RadioButton femme;
    CheckBox Loisir1;
    CheckBox Loisir2;
    CheckBox Loisir3;
    Button valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        nom=(EditText)findViewById(R.id.nom);

        homme=(RadioButton) findViewById(R.id.homme);
        femme=(RadioButton) findViewById(R.id.femme);
        Loisir1=(CheckBox) findViewById(R.id.Loisir1);
        Loisir2=(CheckBox) findViewById(R.id.Loisir2);
        Loisir3=(CheckBox) findViewById(R.id.Loisir3);
        valider=(Button) findViewById(R.id.valider);
        valider.setOnClickListener(new View.OnClickListener() {


            @Override

            public void onClick(View view) {

                int choix=0;
            if((!homme.isChecked())&&(!femme.isChecked()))
            {
                AlertDialog.Builder alertDialog;
                alertDialog= new AlertDialog.Builder(inscription.this);
                alertDialog.setTitle("Choix de genre manquant");
                alertDialog.setMessage("Vous devez choisir un genre");
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                alertDialog.show();
            }
            if(Loisir1.isChecked())
                choix+=1;
            if(Loisir2.isChecked())
                choix+=1;
            if(Loisir3.isChecked())
                choix+=1;
            if(choix<2)
            {
                AlertDialog.Builder alertDialog;
                alertDialog= new AlertDialog.Builder(inscription.this);
                alertDialog.setTitle("Choix de catégorie manquant");
                alertDialog.setMessage("Vous devez choisir au moins 2 choix de catégorie");
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                alertDialog.show();
            }


            if((homme.isChecked()||femme.isChecked())&&choix>1)
                {
                    goToMainActivity();
                }}
        });
}

            private void goToMainActivity() {
                email=(EditText) findViewById(R.id.email);
                pwd=(EditText) findViewById(R.id.pwd);
                String message=new String();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("loginExtra", email.getText().toString());
                resultIntent.putExtra("passwordExtra", pwd.getText().toString());
                if(homme.isChecked())
                    message=message.concat(" M. ") ;
                if(femme.isChecked())
                    message=message.concat(" Mme. ") ;
                message=message.concat(nom.getText().toString()) ;
                message=message.concat("\n") ;
                if(Loisir1.isChecked())
                    message=message.concat(" Forme et santé ") ;
                if(Loisir2.isChecked())
                    message=message.concat(" Loisirs ") ;
                if(Loisir3.isChecked())
                    message=message.concat(" Shopping ") ;
                resultIntent.putExtra("MSG", message);
                setResult(10, resultIntent);
                finish();

            };
}