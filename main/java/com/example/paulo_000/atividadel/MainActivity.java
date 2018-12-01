package com.example.paulo_000.atividadel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button incremento,decremento,toast;
    TextView numero;
    EditText valor;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();

    }

    public void setupViews(){
        incremento = findViewById(R.id.incrementar);
        decremento = findViewById(R.id.decremento);
        toast = findViewById(R.id.button_toast);
        numero = findViewById(R.id.numero);
        valor = findViewById(R.id.editText);
    }


    public int getIncremento(){
        int increment = Integer.parseInt(String.valueOf(valor.getText()));
        return increment;
    }


    public void mostrarToast(View view) {
        Toast toast = Toast.makeText(this,R.string.toastMessage,Toast.LENGTH_SHORT);
        toast.show();
    }

    public void decrementar(View view) {
        count -= getIncremento();
        numero.setText(Integer.toString(count));
    }

    public void incrementar(View view) {
        count += getIncremento();
        numero.setText(Integer.toString(count));
    }
}
