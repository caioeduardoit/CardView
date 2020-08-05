package com.example.cardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.cardview.R;
import com.example.cardview.adapter.PostagemAdapter;
import com.example.cardview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvPostagem;
    private List<Postagem> postagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvPostagem = findViewById(R.id.rcvPostagem);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        /*
        Dá pra utilizar o GridLayout para criar uma visualização no estilo galeria de imagens,
        criando colunas de visualização.
         */
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);

        //Existe a possibilidade de passar para o RecyclerView a orientação HORIZONTAL para passar a lista de posts
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rcvPostagem.setLayoutManager(layoutManager);

        this.prepararPostagens();

        PostagemAdapter adapter = new PostagemAdapter(postagens);
        rcvPostagem.setAdapter(adapter);
    }

    public void prepararPostagens() {
        Postagem postagem = new Postagem("Caio Obama", "Férias, finalmente!", R.drawable.imagem1);
        this.postagens.add(postagem);

        postagem = new Postagem("Caio Obama", "Chegando na city", R.drawable.imagem2);
        this.postagens.add(postagem);

        postagem = new Postagem("Caio Obama", "E vamos para Paris, né?", R.drawable.imagem3);
        this.postagens.add(postagem);

        postagem = new Postagem("Caio Obama", "Sempre quis fazer isso...", R.drawable.imagem4);
        this.postagens.add(postagem);
    }
}