package br.ufrn.eaj.tads.meuslivros;

/**
 * Created by mand4 on 06/09/2017.
 */

public class Livro {

    private long id;
    private String titulo;
    private String autor;
    private Integer ano;
    private float nota;

    public Livro(){

    }

    public Livro(Integer ano, String titulo, String autor, float nota) {

        this.ano = ano;
        this.titulo = titulo;
        this.autor = autor;
        this.nota = nota;
        this.id = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }
}
