package com.lucasvieira.coleoboardgames.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lucasvieira.coleoboardgames.R;
import com.lucasvieira.coleoboardgames.activity.DownloadImageTask;
import com.lucasvieira.coleoboardgames.model.Boardgame;

import java.util.List;

public class BoardgameAdapter extends RecyclerView.Adapter<BoardgameAdapter.MyViewHolder> {

    private List<Boardgame> listaBoardgames;

    public BoardgameAdapter(List<Boardgame> boardgames) {
        this.listaBoardgames = boardgames;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View boardLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista, parent, false);

        return new MyViewHolder(boardLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Boardgame boardgame = listaBoardgames.get(position);
        String jogadores = (boardgame.getMinJogadores() + " - " + boardgame.getMaxJogadores());

        //setar dados dos boards referenciando os componentes da linha 67
        holder.textNome.setText(boardgame.getNome());
        holder.textDuracao.setText(boardgame.getDuracao());
        holder.textDescricao.setText(boardgame.getDescricao());
        new DownloadImageTask(holder.capaBoard).execute(boardgame.getCapa());
//        holder.textJogador.setText(boardgame.getJogadores());

    }

    @Override
    public int getItemCount() {
        return listaBoardgames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //variáveis dos componentes
        TextView textNome, textDuracao, textDescricao, textJogador;
        ImageView capaBoard;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //referencias dos componentes
            textNome = itemView.findViewById(R.id.nomeBoard);
            textDuracao = itemView.findViewById(R.id.duracaoBoard);
            textDescricao = itemView.findViewById(R.id.descricaoBoard);
            capaBoard = itemView.findViewById(R.id.capaBoard);
//            textJogador = itemView.findViewById(R.id.jogadores);
        }
    }
}
