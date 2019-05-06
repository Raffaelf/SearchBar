package com.example.searchbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class ProdutoDetalheActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.produto_detalhe_activity);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            Produto produto = (Produto) intent.getSerializableExtra("produto");
            ProdutoDetalheFragment fragment = ProdutoDetalheFragment.instanciaFragment(produto);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.detalheLayout, fragment, ProdutoDetalheFragment.TAG_DETALHE);
            ft.commit();
        }
    }
}
