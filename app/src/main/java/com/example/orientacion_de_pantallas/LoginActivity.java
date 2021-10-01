package com.example.orientacion_de_pantallas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orientacion_de_pantallas.utils.Utils;

public class LoginActivity extends AppCompatActivity {

    private Button btnLog;
    private EditText edtUserName, edtPassword;
    private CheckBox seleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btnLog = (Button) findViewById(R.id.btnLog);
        edtUserName = (EditText) findViewById(R.id.edtUserName);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        seleccion = (CheckBox) findViewById(R.id.cbCondiciones);

        btnLog.setOnClickListener( v -> {
            if(Utils.verifyEditText(edtUserName) && Utils.verifyEditText(edtPassword)) {

                if(!seleccion.isChecked()){
                    String s = "Estado: " + (seleccion.isChecked() ? "Terminos y condiciones aceptados" : "Acepte terminos y condiciones");
                    Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
                    seleccion.requestFocus();
                    return;
                }
                else{
                    Intent intent = new Intent(this, MainActivity.class);
                    String username = edtUserName.getText().toString();
                    String password = edtPassword.getText().toString();

                    Bundle extras = new Bundle();
                    extras.putString("USERNAME",username);
                    extras.putString("PASSWORD",password);
                    //Agrega el objeto bundle a el Intent
                    intent.putExtras(extras);
                    //Inicia Activity
                    startActivity(intent);

                    Toast.makeText(LoginActivity.this,
                            "Login as: " + username,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    //Al dar clic en el botón “Cancelar”
    // debe borrar el texto o valor de todos los componentes del formulario.
    public void Cancel(View view) {
        edtUserName.setText("");
        edtPassword.setText("");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

}