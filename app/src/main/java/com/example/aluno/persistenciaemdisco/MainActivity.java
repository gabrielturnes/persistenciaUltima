package com.example.aluno.persistenciaemdisco;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences mPreferences;
    private static final String mSharedPrefFile = "poo.engetelecom.contador";

    private final String CONTADOR_KEY = "contador";
    private final String COR_KEY = "cor";

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = mPreferences.edit();


        TextView textView = (TextView) findViewById(R.id.textView);
        String valorTextView = textView.getText().toString();
        String[] textoSeparado = valorTextView.split(" ");
        int i = Integer.parseInt(textoSeparado[0]);

        int coloracao = textView.getColor();
        editor.putInt(COR_KEY, coloracao);

        editor.putInt(CONTADOR_KEY, i);
        editor.apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPreferences = getSharedPreferences(mSharedPrefFile, MODE_PRIVATE);

        int contador = mPreferences.getInt(CONTADOR_KEY, 0);
        int corDeFundo = mPreferences.getInt(COR_KEY, R.color.black);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("" + contador + " xeroque roumes");
        textView.setTextColor(corDeFundo);

        Button azul = (Button) findViewById(R.id.azul);
        azul.setOnClickListener(this);

        Button vermelho = (Button) findViewById(R.id.vermelho);
        vermelho.setOnClickListener(this);

        Button verde = (Button) findViewById(R.id.verde);
        verde.setOnClickListener(this);
    }

    public void Incrementar(View view){
        TextView textView = (TextView) findViewById(R.id.textView);
        String valorTextView = textView.getText().toString();
        String[] textoSeparado = valorTextView.split(" ");
        int i = Integer.parseInt(textoSeparado[0]) + 1;

        textView.setText("" + i + " xeroque roumes");
    }

    public void AlterarCor(View view){
        TextView textView = (TextView) findViewById(R.id.textView);

    }


    @Override
    public void onClick(View view) {
        TextView textView = (TextView) findViewById(R.id.textView);
        switch (view.getId()){
            case R.id.azul:
                Button azul = (Button) findViewById(R.id.azul);
                int cor = ((ColorDrawable) azul.getBackground()).getColor();

                textView.setTextColor(cor);
                break;

            case R.id.verde:
                Button verde = (Button) findViewById(R.id.verde);
                cor = ((ColorDrawable) verde.getBackground()).getColor();
                textView.setTextColor(cor);
                break;

            case R.id.vermelho:
                Button vermelho = (Button) findViewById(R.id.vermelho);
                cor = ((ColorDrawable) vermelho.getBackground()).getColor();
                textView.setTextColor(cor);
                break;
        }
    }
}
