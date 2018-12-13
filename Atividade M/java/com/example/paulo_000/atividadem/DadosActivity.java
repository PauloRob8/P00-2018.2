package com.example.paulo_000.atividadem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DadosActivity extends AppCompatActivity {

    static final String encomenda = "encomenda";
    static final String encomenda1 = "encomenda1";
    EditText altura,peso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        altura = findViewById(R.id.altura1);
        peso = findViewById(R.id.peso1);
    }

    public void confirmar(View view) {

        Double pesoKg = Double.parseDouble(peso.getText().toString());
        Double alturaM = Double.parseDouble(altura.getText().toString());

        Intent intent = new Intent();
        intent.putExtra(encomenda,pesoKg);
        intent.putExtra(encomenda1,alturaM);
        setResult(RESULT_OK,intent);
        finish();
    }
}
