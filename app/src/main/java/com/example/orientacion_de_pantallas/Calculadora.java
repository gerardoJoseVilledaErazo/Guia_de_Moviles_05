package com.example.orientacion_de_pantallas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculadora extends AppCompatActivity {
    EditText tvResultado;
    TextView tvVistaPrevia;
    float numero1 = 0.0f;
    float numero2 = 0.0f;
    String operacion = "";

    //Botones numeros
    private Button btnButton0;
    private Button btnButton1;
    private Button btnButton2;
    private Button btnButton3;
    private Button btnButton4;
    private Button btnButton5;
    private Button btnButton6;
    private Button btnButton7;
    private Button btnButton8;
    private Button btnButton9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        tvVistaPrevia = findViewById(R.id.tvVistaPrevia);
        tvResultado = findViewById(R.id.tvResultado);
        tvResultado.setFocusable(true);
        tvResultado.setFocusableInTouchMode(true);
        tvResultado.setInputType(InputType.TYPE_NULL);

        //botones numeros 0
        btnButton0 = findViewById(R.id.btCero);
        btnButton0.setOnClickListener(v -> {
            String textAnterior = tvResultado.getText().toString();
            tvResultado.setText(textAnterior + "0");
        });
        //botones numeros 1
        btnButton1 = findViewById(R.id.btUno);
        btnButton1.setOnClickListener(v -> {
            String textAnterior = tvResultado.getText().toString();
            tvResultado.setText(textAnterior + "1");
        });
        //botones numeros 2
        btnButton2 = findViewById(R.id.btDos);
        btnButton2.setOnClickListener(v -> {
            String textAnterior = tvResultado.getText().toString();
            tvResultado.setText(textAnterior + "2");
        });
        //botones numeros 3
        btnButton3 = findViewById(R.id.btTres);
        btnButton3.setOnClickListener(v -> {
            String textAnterior = tvResultado.getText().toString();
            tvResultado.setText(textAnterior + "3");
        });
        //botones numeros 4
        btnButton4 = findViewById(R.id.btCuatro);
        btnButton4.setOnClickListener(v -> {
            String textAnterior = tvResultado.getText().toString();
            tvResultado.setText(textAnterior + "4");
        });
        //botones numeros 5
        btnButton5 = findViewById(R.id.btCinco);
        btnButton5.setOnClickListener(v -> {
            String textAnterior = tvResultado.getText().toString();
            tvResultado.setText(textAnterior + "5");
        });
        //botones numeros 6
        btnButton6 = findViewById(R.id.btSeis);
        btnButton6.setOnClickListener(v -> {
            String textAnterior = tvResultado.getText().toString();
            tvResultado.setText(textAnterior + "6");
        });
        //botones numeros 7
        btnButton7 = findViewById(R.id.btSiete);
        btnButton7.setOnClickListener(v -> {
            String textAnterior = tvResultado.getText().toString();
            tvResultado.setText(textAnterior + "7");
        });
        //botones numeros 8
        btnButton8 = findViewById(R.id.btOcho);
        btnButton8.setOnClickListener(v -> {
            String textAnterior = tvResultado.getText().toString();
            tvResultado.setText(textAnterior + "8");
        });
        //botones numeros 9
        btnButton9 = findViewById(R.id.btNueve);
        btnButton9.setOnClickListener(v -> {
            String textAnterior = tvResultado.getText().toString();
            tvResultado.setText(textAnterior + "9");
        });
    }

    //AC
    public void LimpiarResultado(View view) {
        numero1 = 0.0f;
        numero2 = 0.0f;
        operacion = "";
        tvResultado.setText("");
        tvVistaPrevia.setText("");
    }

    //DEL
    public void DEL(View view){
        String textAnterior = tvResultado.getText().toString();
        if(textAnterior.length() > 0) {
            String nuevaOperacion = textAnterior.substring(0, textAnterior.length() - 1);
            tvResultado.setText(nuevaOperacion);
        }
    }

    //Porcentaje de un numero
    public void OperacionPorcentaje(View view) {
        numero1 = Float.parseFloat(String.valueOf(tvResultado.getText()));
        operacion = "%";
        tvResultado.setText("");
    }

    //Operaciones
    public void OperacionDividir(View view) {
        numero1 = Float.parseFloat(String.valueOf(tvResultado.getText()));
        operacion = "/";
        tvResultado.setText("");
    }

    public void OperacionMulti(View view) {
        numero1 = Float.parseFloat(String.valueOf(tvResultado.getText()));
        operacion = "*";
        tvResultado.setText("");
    }

    public void OperacionMenos(View view) {
        numero1 = Float.parseFloat(String.valueOf(tvResultado.getText()));
        operacion = "-";
        tvResultado.setText("");
    }

    public void OperacionMas(View view) {
        numero1 = Float.parseFloat(String.valueOf(tvResultado.getText()));
        operacion = "+";
        tvResultado.setText("");
    }

    //Escribir Punto
    public void EscribirPunto(View view) {
        if( !String.valueOf(tvResultado.getText()).contains(".") ){
            tvResultado.setText(tvResultado.getText() + ".");
        }
    }

    //Cambio de signo
    public void CambioSigno(View view) {
        float valor = Float.parseFloat(String.valueOf(tvResultado.getText()));
        valor = valor * -1.0f;
        tvResultado.setText("" + valor);
    }

    //Igual
    public void MostrarResultado(View view) {
        numero2 = Float.parseFloat(String.valueOf(tvResultado.getText()));

        float result = 0.0f;

        if(operacion.equals("%")){
            result = (numero1 / 100.0f) * numero2;
        }else if(operacion.equals("/")){
            if(numero2 != 0.0f){
                result = numero1 / numero2;
            }else{
                result = 0.0f;
                Toast.makeText(this, "OPERACION NO VALIDA", Toast.LENGTH_LONG).show();
            }
        }else if(operacion.equals("*")){
            result = numero1 * numero2;
        }else if(operacion.equals("-")){
            result = numero1 - numero2;
        }else if(operacion.equals("+")){
            result = numero1 + numero2;
        }

        //tvResultado.setText(result + "");
        tvVistaPrevia.setText(result + "");
        numero1 = 0.0f;
        numero2 = 0.0f;
        operacion = "";
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