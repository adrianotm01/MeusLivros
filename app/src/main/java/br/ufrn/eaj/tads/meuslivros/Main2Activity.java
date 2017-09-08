package br.ufrn.eaj.tads.meuslivros;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;

public class Main2Activity extends AppCompatActivity {
    private EditText titulo;
    private EditText autor;
    private EditText ano;
    private RatingBar nota;
    private BancoHelper banco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrolivros);
        titulo = (EditText) findViewById(R.id.editText);
        autor = (EditText) findViewById(R.id.editText2);
        ano = (EditText) findViewById(R.id.editText3);
        nota = (RatingBar) findViewById(R.id.ratingBar);
        banco = new BancoHelper(this);

    }

    public void salvar(View view){
        Intent i = new Intent();
        Integer anos = Integer.valueOf(ano.getText().toString());
        Livro l = new Livro(anos,titulo.getText().toString(), autor.getText().toString(),  nota.getRating());
        banco.save(l);

        setResult(RESULT_OK,i);
        finish();
    }

    public void cancelar(View v){
        setResult(RESULT_CANCELED);
        finish();
    }
}
