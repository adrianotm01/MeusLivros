package br.ufrn.eaj.tads.meuslivros;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mand4 on 06/09/2017.
 */

public class BancoHelper extends SQLiteOpenHelper {
        private static final String banco = "banco_livros.sqlite";


    private static final String criarTabela = ("CREATE TABLE "+LivroContrato.LivroEntry.TABLE_NAME+
            "("+ LivroContrato.LivroEntry._ID
            +" INTEGER PRIMARY KEY,"+ LivroContrato.LivroEntry.TITULO+" TEXT ,"+ LivroContrato.LivroEntry.AUTOR+" TEXT, "
            +LivroContrato.LivroEntry.ANO +" INTEGER" +
            ","+LivroContrato.LivroEntry.NOTA+ " TEXT);");
    private static final String dropar = ("DROP TABLE "+ LivroContrato.LivroEntry.TABLE_NAME+";");
    public BancoHelper(Context contexto){
        super(contexto,banco,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase database){
        database.execSQL(criarTabela);
        Log.i("banxo","criado");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int versaoAntiga, int versaoNova){
        if (versaoAntiga != versaoNova) {
            database.execSQL(dropar);
            this.onCreate(database);
        }
    }

    public long save(Livro l){
        long id = l.getId();
        SQLiteDatabase db = getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put(LivroContrato.LivroEntry.TITULO,l.getTitulo());
            values.put(LivroContrato.LivroEntry.AUTOR,l.getAutor());
            values.put(LivroContrato.LivroEntry.ANO,l.getAno());
            values.put(LivroContrato.LivroEntry.NOTA,l.getNota());
            if(id != 0){
                String selection = LivroContrato.LivroEntry._ID + "= ?";
                String[] whereArgs = new String[]{String.valueOf(id)};

                // update carro set values = ... where _id=?
                int count = db.update(LivroContrato.LivroEntry.TABLE_NAME, values, selection, whereArgs);

                return count;
            }
               id = db.insert(LivroContrato.LivroEntry.TABLE_NAME, null, values);
                Log.i("sql", "Inseriu id [" + id + "] no banco.");
                return id;
        }
        finally {
            db.close();
        }
    }

    public List<Livro> findAll(){
        SQLiteDatabase db = getReadableDatabase();
        try{
            Cursor cursor = db.query(LivroContrato.LivroEntry.TABLE_NAME,null,null,null,null,null,null,null);

            return toList(cursor);
        }
        finally {
            db.close();
        }
    }

    private List<Livro> toList(Cursor cursor) {
        List<Livro> carros = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                Livro carro = new Livro();
                carros.add(carro);

                // recupera os atributos de carro
                carro.setId(cursor.getInt(cursor.getColumnIndex(LivroContrato.LivroEntry._ID)));
                carro.setAutor(cursor.getString(cursor.getColumnIndex(LivroContrato.LivroEntry.AUTOR)));
                carro.setTitulo(cursor.getString(cursor.getColumnIndex(LivroContrato.LivroEntry.TITULO)));
                carro.setNota(cursor.getInt(cursor.getColumnIndex(LivroContrato.LivroEntry.NOTA)));
                carro.setAno(cursor.getInt(cursor.getColumnIndex(LivroContrato.LivroEntry.ANO)));

            } while (cursor.moveToNext());
        }

        return carros;
    }

    public Livro buscaPorTitulo(String titulo){
        SQLiteDatabase db = getReadableDatabase();

        try{
            String selecao = LivroContrato.LivroEntry.TITULO +"=?";
            String argumentos[] = {String.valueOf(titulo)};
            Cursor c = db.query(LivroContrato.LivroEntry.TABLE_NAME,null,selecao,argumentos,null,null,null,null);
            if (c.moveToFirst()) {
                Livro livrin = new Livro();
                livrin.setId(c.getInt(c.getColumnIndex(LivroContrato.LivroEntry._ID)));
                livrin.setTitulo(c.getString(c.getColumnIndex(LivroContrato.LivroEntry.TITULO)));
                livrin.setAutor(c.getString(c.getColumnIndex(LivroContrato.LivroEntry.AUTOR)));
                livrin.setAno(c.getInt(c.getColumnIndex(LivroContrato.LivroEntry.ANO)));
                livrin.setNota((int) c.getFloat(c.getColumnIndex(LivroContrato.LivroEntry.NOTA)));
                return livrin;
            }
            else {

                return null;
            }

        }
        finally {
            db.close();
        }
    }

    public void execSQL(String sql) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            db.execSQL(sql);
        } finally {
            db.close();
        }
    }
    public void execSQL(String sql, Object[] args) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            db.execSQL(sql, args);
        } finally {
            db.close();
        }
    }
}
