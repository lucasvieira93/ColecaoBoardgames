package com.lucasvieira.coleoboardgames.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lucasvieira.coleoboardgames.R;
import com.lucasvieira.coleoboardgames.model.Boardgame;

import java.util.List;

public class BoardgameAdapter extends RecyclerView.Adapter<BoardgameAdapter.MyViewHolder> {

    private List<Boardgame> boardgames;

    public BoardgameAdapter(List<Boardgame> boardgames) {
        this.boardgames = boardgames;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View boardLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.boardgame_list, parent, false);

        return new MyViewHolder(boardLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Boardgame boardgame = boardgames.get(position);

        //setar dados dos boards referenciando os componentes da linha 67
        holder.textNome.setText(boardgame.getNome());
        holder.textDuracao.setText(boardgame.getDuração());
        holder.textDificuldade.setText(boardgame.getDificuldade());
        holder.textDescricao.setText(boardgame.getDescrição());
        holder.textCoop.setText(boardgame.getCooperativo());
        holder.textCartas.setText(boardgame.getCartas());
        holder.numeroMin.setText(boardgame.getMinJogadores());
        holder.numeroMax.setText(boardgame.getMaxJogadores());
        holder.capaBoard.setImageResource(boardgame.getCapa());

    }


    @Override
    public int getItemCount() {
        return boardgames.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        //variáveis dos componentes
        private TextView textNome, textDuracao, textDificuldade, textDescricao, textCoop, textCartas, numeroMin, numeroMax;
        private ImageView capaBoard;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //referencias dos componentes
            textNome = itemView.findViewById(R.id.nome);
            textDuracao = itemView.findViewById(R.id.duracao);
            textDificuldade = itemView.findViewById(R.id.dificuldade);
            textDescricao = itemView.findViewById(R.id.descricao);
            textCoop = itemView.findViewById(R.id.cooperativo);
            textCartas = itemView.findViewById(R.id.cartas);
            numeroMin = itemView.findViewById(R.id.minJogador);
            numeroMax = itemView.findViewById(R.id.maxJogador);
            capaBoard = itemView.findViewById(R.id.capaImage);
        }
    }
}
