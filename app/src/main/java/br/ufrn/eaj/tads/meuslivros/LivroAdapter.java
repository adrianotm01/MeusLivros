package br.ufrn.eaj.tads.meuslivros;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mand4 on 15/09/2017.
 */

public class LivroAdapter extends BaseAdapter{
    private List<Livro> list = new ArrayList<>();
    Context contexto;
    private ViewHolder holder;

    public LivroAdapter (List<Livro> list, Context contexto){
        this.contexto = contexto;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return list.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1;
        if(view == null) {
            view1 = LayoutInflater.from(contexto).inflate(R.layout.inflar, viewGroup, false);
           holder = new  ViewHolder(view1);
            view1.setTag(holder);
        }else{
            view1=view;
           holder = (ViewHolder) view.getTag();
        }
        Livro novoL = list.get(i);
        holder.getTitulo().setText(novoL.getTitulo());
        holder.getAutor().setText(novoL.getAutor());
        holder.getAno().setText(String.valueOf(novoL.getAno()));
        holder.getNota().setText(String.valueOf(novoL.getNota()));
        return view1;
    }

}
