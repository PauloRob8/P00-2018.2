package com.example.paulo_000.atividadem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class InformacoesActivity extends AppCompatActivity {

    TextView nome,estiloDeVida,altura,peso,tbm,get;
    RadioGroup botoes;
    public final int REQUEST_CODE = 1001;
    static final String gastoEnergetico = "gastoEnergetico";
    public Double resultTbm;
    public  Double resultGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes);

        setupViews();
        final Intent intent = getIntent();

        String nomeUsuario = intent.getStringExtra(MainActivity.pacote);
        nome.setText(nomeUsuario);

    }

    public void setupViews(){
        nome = findViewById(R.id.nome2);
        estiloDeVida = findViewById(R.id.estilo);
        botoes = findViewById(R.id.radioGroup);
        altura = findViewById(R.id.altura);
        peso =findViewById(R.id.peso);
        tbm = findViewById(R.id.tbm);
        get = findViewById(R.id.get);
    }

    public void calcularTBM(Double peso,Double altura){
        Double result = (peso * 11.3) + (altura * 16) + 901;
        resultTbm = result;
        tbm.setText(String.format("TBM: %.8sKal",result));
        tbm.setVisibility(View.VISIBLE);
    }

    public void preencherDados(View view) {

        Intent intent = new Intent(this,DadosActivity.class);
        startActivityForResult(intent,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                Double pesoKg = data.getDoubleExtra(DadosActivity.encomenda,0.0);
                Double alturaM = data.getDoubleExtra(DadosActivity.encomenda1,0.0);
                altura.setText(String.format("Altura: %sm", alturaM));
                peso.setText(String.format("Peso: %sKg", pesoKg));
                altura.setVisibility(View.VISIBLE);
                peso.setVisibility(View.VISIBLE);
                calcularTBM(pesoKg,alturaM);
                estiloDeVida.setVisibility(View.VISIBLE);
                botoes.setVisibility(View.VISIBLE);

            }
        }
    }

    public void setSedentario(View view) {
       Double tbmNovo = resultTbm;
       tbmNovo *= 1.00;
       resultGet = tbmNovo;
       get.setText(String.format("Gasto Energético: %.8sKal", tbmNovo));
       get.setVisibility(View.VISIBLE);
    }

    public void setLevemente(View view) {
        Double tbmNovo = resultTbm;
        tbmNovo *=1.11;
        resultGet = tbmNovo;
        get.setText(String.format("Gasto Energético: %.8sKal", tbmNovo));
        get.setVisibility(View.VISIBLE);
    }

    public void setModerado(View view) {
        Double tbmNovo = resultTbm;
        tbmNovo *= 1.25;
        resultGet = tbmNovo;
        get.setText(String.format("Gasto Energético: %.8sKal", tbmNovo));
        get.setVisibility(View.VISIBLE);
    }

    public void setAtivo(View view) {
        Double tbmNovo = resultTbm;
        tbmNovo *= 1.48;
        resultGet = tbmNovo;
        get.setText(String.format("Gasto Energético: %.8sKal", tbmNovo));
        get.setVisibility(View.VISIBLE);
    }

    public void detalhar(View view) {
        Intent intent = new Intent(this,DetalhesActivity.class);
        intent.putExtra(gastoEnergetico,resultGet.toString());
        startActivity(intent);

    }
}
