package br.ufrn.eaj.tads.meuslivros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {
    private TextView titulo;
    private TextView autor;
    private TextView ano;
    private TextView nota;
    Livro livrao;
    private List<Livro> livroList = new ArrayList<>();
    String titulos[];
    BancoHelper bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bd = new BancoHelper(getApplicationContext());

        setContentView(R.layout.buscarlivros);
        titulo = (TextView) findViewById(R.id.textView17);
        autor = (TextView) findViewById(R.id.textView18);
        ano = (TextView) findViewById(R.id.textView19);
        nota = (TextView) findViewById(R.id.textView20);
        listar();
        AutoCompleteTextView completeTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,titulos);
        completeTextView.setAdapter(adapter);

        completeTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> adapterView, View view, int i, long l) {

                livrao = bd.buscaPorTitulo(((TextView) view).getText().toString());
                titulo.setText(livrao.getTitulo());
                autor.setText(livrao.getAutor());
                ano.setText(String.valueOf(livrao.getAno()));
                nota.setText(String.valueOf(livrao.getNota()));
            }
        });
    }

    public void listar(){

        livroList = bd.findAll();
        titulos = new String[livroList.size()];
        for (int i = 0; i < livroList.size(); i++) {
            titulos[i] = livroList.get(i).getTitulo();
        }
    }


}
