package com.example.searchbar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProdutoDetalheFragment extends Fragment {

    public static final String TAG_DETALHE = "tagDetalhe";
    private TextView txtNome;
    private TextView txtPreco;
    private RatingBar ratingBar;
    private Produto produto;
    private ImageView img_produto;

    //Recebe um produto e cria a
    //instância do fragment.
    public static ProdutoDetalheFragment instanciaFragment(Produto produto) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("produto", produto);
        ProdutoDetalheFragment fragment = new ProdutoDetalheFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        produto = (Produto) getArguments().getSerializable("produto");
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.produto_detalhe_fragment, container, false);
        img_produto = layout.findViewById(R.id.img_produto_fragment);
        txtNome = layout.findViewById(R.id.txt_nome);
        txtPreco = layout.findViewById(R.id.txt_preco);
        ratingBar = layout.findViewById(R.id.rtbar);
        if (produto != null) {
            img_produto.setImageResource(produto.getImg());
            txtNome.setText(produto.getNome());
            txtPreco.setText("R$ " + String.valueOf(String.format("%.2f", produto.getPreco())));
            ratingBar.setRating(produto.getEstrela());
        }
        return layout;
    }
}
