package br.ufrn.eaj.tads.meuslivros;

import android.view.View;
import android.widget.TextView;

/**
 * Created by mand4 on 15/09/2017.
 */

public class ViewHolder {
    private TextView titulo;
    private TextView autor;
    private TextView ano;
    private TextView nota;

    public TextView getTitulo() {
        return titulo;
    }

    public void setTitulo(TextView titulo) {
        this.titulo = titulo;
    }

    public TextView getAutor() {
        return autor;
    }

    public void setAutor(TextView autor) {
        this.autor = autor;
    }

    public TextView getAno() {
        return ano;
    }

    public void setAno(TextView ano) {
        this.ano = ano;
    }

    public TextView getNota() {
        return nota;
    }

    public void setNota(TextView nota) {
        this.nota = nota;
    }

    public ViewHolder(View view){
        titulo = (TextView) view.findViewById(R.id.title);
        autor =(TextView)  view.findViewById(R.id.ator);
        ano = (TextView) view.findViewById(R.id.year);
        nota = (TextView) view.findViewById(R.id.note);
    }
}
