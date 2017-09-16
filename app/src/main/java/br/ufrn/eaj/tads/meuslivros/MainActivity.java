package br.ufrn.eaj.tads.meuslivros;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final int BOA = 1;
    private ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        constraintLayout = (ConstraintLayout) findViewById(R.id.layout);
    }

    public void tela1(View v){
        Intent i = new Intent(this,Main2Activity.class);
        startActivityForResult(i, BOA);
    }
    public void tela2(View v){
        Intent i = new Intent(this,Main3Activity.class);
        startActivity(i);
    }

    public void tela4(View v){
        Intent intent = new Intent(this,MainActivity4.class);
        startActivity(intent);
    }

    public void tela5(View v){
        Intent i = new Intent(this,MainActivity5.class);
        startActivity(i);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Snackbar snackbar = Snackbar.make((View) constraintLayout.getParent(), "Cadastrado com Sucesso", Snackbar.LENGTH_SHORT);
            snackbar.show();
        } else if (resultCode == RESULT_CANCELED) {
            Snackbar snackbar = Snackbar.make((View) constraintLayout.getParent(), "Cancelado", Snackbar.LENGTH_SHORT);
            snackbar.show();
        }
    }
}
