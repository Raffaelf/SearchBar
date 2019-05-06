package com.example.searchbar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProdutoListFragment extends Fragment {
    private List<Produto> produtos;
    private ArrayAdapter<Produto> adapter;
    View view;

    private ProdutoAdapter produtoAdapter;

    private RecyclerView myrecyclerview;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    private List<Produto> carregarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Jaqueta Palace Refletiva", 179.90,4.5f, R.drawable.produto1));
        produtos.add(new Produto("Tênis EST Slim", 159.90,4.0f, R.drawable.produto2));
        produtos.add(new Produto("Calça Camuflada Feminina Laranja", 139.90,5.0f, R.drawable.produto3));
        produtos.add(new Produto("Jaqueta Camuflada Street Line", 179.90,4.7f, R.drawable.produto4));
        produtos.add(new Produto("Tênis Camuflado Masculino", 189.90,3.9f, R.drawable.produto5));

        return produtos;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.produto_view_list,container,false);

        produtos = carregarProdutos();

        myrecyclerview = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        produtoAdapter = new ProdutoAdapter(produtos,getContext());
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        //myrecyclerview.setLayoutManager(new GridLayoutManager(getActivity(),2));

        myrecyclerview.setAdapter(produtoAdapter);

        return view;
    }


    public interface AoClicarNoProduto {
        void clicouNoProduto(Produto produto);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.produto_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        //searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                produtoAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

}
