package com.daeko.het.androidstudiotuto;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private Button bTnSalir, bTnLogin;
    private EditText logTxt, passTxt;
    private TextView intentos;
    private int contador = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Boton de Salir
        bTnSalir = (Button) findViewById(R.id.btnSalir);

        bTnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new  AlertDialog.Builder(Main2Activity.this);
                alertDialogBuilder.setTitle("Confirmar salida");
                alertDialogBuilder
                        .setMessage("¿Seguro que desea salir?")
                        .setCancelable(false)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Main2Activity.this.finish();

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int Which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        }) ;

        //Login
        bTnLogin = findViewById(R.id.btnEnter);
        logTxt = findViewById(R.id.etLogin);
        passTxt = findViewById(R.id.etPass);
        intentos = findViewById(R.id.tvIntentos);

        bTnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar(logTxt.getText().toString(), passTxt.getText().toString());
            }
        });


    }

    private void validar(String userName, String userPassword) {
        if(userName.equals("Admin") && userPassword.equals("1234")){
            Intent logIn = new Intent(Main2Activity.this, Menu.class);
            startActivity(logIn);
            finish();
            }else{
                contador--;
                intentos.setText("Intentos Restantes: " + String.valueOf(contador));
                if(contador == 0){
                    bTnLogin.setEnabled(false);
                }
        }
    }

}
