package br.ufrn.eaj.tads.meuslivros;

import android.provider.BaseColumns;

/**
 * Created by mand4 on 06/09/2017.
 */

public final class LivroContrato {

    public static class LivroEntry implements BaseColumns{
        public static final String TABLE_NAME = "livro";
        public static final String TITULO = "titulo";
        public static final String AUTOR = "autor";
        public static final String NOTA = "nota";
        public static final String ANO = "ano";
    }


}
