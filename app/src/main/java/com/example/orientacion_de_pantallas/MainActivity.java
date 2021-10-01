package com.example.orientacion_de_pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnConversations, btnLogin, btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnConversations  = (Button) findViewById(R.id.btnConversations);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnCalc = (Button) findViewById(R.id.btnCalc);


        btnConversations.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ListConversationsActivity.class));
        });


        btnLogin.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        });

        btnCalc.setOnClickListener(v -> {
            startActivity(new Intent (MainActivity.this, Calculadora.class));
        });

    }

    //Ver datos
    public void mostrarDatos(View view){
        startActivity(new Intent(MainActivity.this, MostrarActivity.class));

    }
    @Override
    protected void onStart() {
        super.onStart();
        //Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
        // La actividad está a punto de hacerse visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
        // La actividad se ha vuelto visible (ahora se "reanuda").
    }
    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
        // Enfocarse en otra actividad  (esta actividad está a punto de ser "detenida").
    }
    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();
        // La actividad ya no es visible (ahora está "detenida")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
        // La actividad está a punto de ser destruida.
    }
}