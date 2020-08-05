package com.example.cardview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cardview.R;
import com.example.cardview.model.Postagem;
import java.util.List;

public class PostagemAdapter extends RecyclerView.Adapter<PostagemAdapter.MyViewHolder> {

    private List<Postagem> listaPostagens;

    public PostagemAdapter(List<Postagem> postagens) {
        this.listaPostagens = postagens;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.postagem_detalhe, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Postagem postagem = listaPostagens.get(position);

        holder.nome.setText(postagem.getNome());
        holder.postagem.setText(postagem.getDescricao());
        holder.imagem.setImageResource(postagem.getImagem());
    }

    @Override
    public int getItemCount() {
        return listaPostagens.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nome;
        private TextView postagem;
        private ImageView imagem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.txtNome);
            postagem = itemView.findViewById(R.id.txtDescricao);
            imagem = itemView.findViewById(R.id.imgFoto);
        }
    }
}
