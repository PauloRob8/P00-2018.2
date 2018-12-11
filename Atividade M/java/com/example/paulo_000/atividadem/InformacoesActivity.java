package com.example.paulo_000.atividadem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InformacoesActivity extends AppCompatActivity {

    TextView nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes);

        final Intent intent = getIntent();

        String nomeUsuario = intent.getStringExtra(MainActivity.pacote);

        nome = findViewById(R.id.nome2);
        nome.setText(nomeUsuario);
        

    }

    public void preencherDados(View view) {
    }

    public void setSedentario(View view) {
    }

    public void setLevemente(View view) {
    }

    public void setModerado(View view) {
    }

    public void setAtivo(View view) {
    }
}
