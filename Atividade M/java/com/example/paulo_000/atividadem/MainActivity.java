package com.example.paulo_000.atividadem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nome;
    String nomeUsuario = "";
    public static final String pacote = "pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.nome);
    }

    public void avancar(View view) {
        final Intent intent = new Intent(this,InformacoesActivity.class);
        nomeUsuario = nome.getText().toString();
        intent.putExtra(pacote,nomeUsuario);
        startActivity(intent);

    }
}
