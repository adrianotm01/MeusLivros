package br.ufrn.eaj.tads.meuslivros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {
    private TextView titulo;
    private TextView autor;
    private TextView ano;
    private TextView nota;
    private List<Livro> livroList = new ArrayList<Livro>();
    private int contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BancoHelper bancoHelper = new BancoHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livroscadastrados);
        titulo = (TextView) findViewById(R.id.textView9);
        autor = (TextView) findViewById(R.id.textView10);
        ano = (TextView) findViewById(R.id.textView11);
        nota = (TextView) findViewById(R.id.textView12);
        livroList = bancoHelper.findAll();
        atualizarTextos(0);
        contador=0;
    }

    public void atualizarTextos(int i){
        titulo.setText(" "+ livroList.get(i).getTitulo());
        autor.setText(" "+livroList.get(i).getAutor());
        ano.setText(" "+String.valueOf(livroList.get(i).getAno()));
        nota.setText(" "+String.valueOf(livroList.get(i).getNota()));
    }

    public void previous(View v){
        if (contador == 0) {
            Toast t = Toast.makeText(this,"Voce esta no primeiro registro", Toast.LENGTH_SHORT);
            t.show();
        }
        else{
            contador--;
            atualizarTextos(contador);
        }

    }

    public void next(View v){
        if (contador == livroList.size()-1) {
            Toast t = Toast.makeText(this,"Voce esta no ultimo registro", Toast.LENGTH_SHORT);
            t.show();
        }
        else{
            contador++;
            atualizarTextos(contador);
        }

    }
}
