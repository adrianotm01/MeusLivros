package br.ufrn.eaj.tads.meuslivros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BancoHelper bd = new BancoHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        List<Livro> listaLivro =  bd.findAll();
        Log.i("funcionou",listaLivro.get(1).getTitulo());
        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(new LivroAdapter(listaLivro,this));
    }
}
