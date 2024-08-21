package com.example.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.model.Compromisso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Compromisso> listaCompromissos;

    public Adapter(List<Compromisso> lista) {
        this.listaCompromissos = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Compromisso compromisso = listaCompromissos.get(position);
        holder.titulo.setText(compromisso.getTitulo());
        holder.data.setText(compromisso.getData());
        holder.horario.setText(compromisso.getHorario());
    }

    @Override
    public int getItemCount() {
        return listaCompromissos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titulo;
        TextView data;
        TextView horario;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.textTitulo);
            data = itemView.findViewById(R.id.textData);
            horario = itemView.findViewById(R.id.textHorario);
        }
    }
}
