package com.example.paulo_000.atividadem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetalhesActivity extends AppCompatActivity {

    TextView gastoE,gordurasK,proteinasK,carboidratosK,gordurasG,proteinasG,carboidratosG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        setupViews();
        final Intent intent = getIntent();
        String gastosE = intent.getStringExtra(InformacoesActivity.gastoEnergetico);
        gastoE.setText(String.format("%.6s ",gastosE));
        Double getNovo = Double.parseDouble(gastosE);
        calcularGordura(getNovo);
        calcularProteina(getNovo);
        calcularCarboidrato(getNovo);

    }

    public void setupViews(){
        gastoE = findViewById(R.id.getValor);
        gordurasK = findViewById(R.id.gorduraKal);
        proteinasK=findViewById(R.id.proteinaKal);
        carboidratosK = findViewById(R.id.carboidratoKal);
        gordurasG = findViewById(R.id.gorduraG);
        proteinasG = findViewById(R.id.proteinaG);
        carboidratosG= findViewById(R.id.carboidratoG);
    }

    public void calcularGordura(Double valor){
        Double gordKal = valor * 0.25;
        Double gordGram = gordKal / 9.0;

        gordurasK.setText(String.format("%.6s Kal",gordKal));
        gordurasG.setText(String.format("%.5s gm",gordGram));
    }

    public void calcularProteina(Double valor){
        Double protKal = valor * 0.15;
        Double protGram = protKal / 4.0;
        proteinasK.setText(String.format("%.6s Kal",protKal));
        proteinasG.setText(String.format("%.5s gm",protGram));
    }

    public void calcularCarboidrato(Double valor){
        Double carboKal = valor * 0.60;
        Double carboGram = carboKal / 4.0;
        carboidratosK.setText(String.format("%.6s Kal",carboKal));
        carboidratosG.setText(String.format("%.5s gm",carboGram));

    }

    public void confirmar(View view) {
        this.finish();
    }
}
