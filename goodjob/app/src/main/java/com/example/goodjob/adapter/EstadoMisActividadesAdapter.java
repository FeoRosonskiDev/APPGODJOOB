package com.example.goodjob.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.goodjob.R;
import com.example.goodjob.classes.EstadoMisActividadesResponse;
import com.example.goodjob.viewholder.EstadoMisActividadesViewHolder;

import java.util.List;

public class EstadoMisActividadesAdapter extends RecyclerView.Adapter<EstadoMisActividadesViewHolder> {

    private List<EstadoMisActividadesResponse> misActividades;
    private OnEstadoActividadListener onEstadoActividadListener;

    public EstadoMisActividadesAdapter(List<EstadoMisActividadesResponse> misActividades, OnEstadoActividadListener onEstadoActividadListener)
    {
        this.misActividades = misActividades;
        this.onEstadoActividadListener = onEstadoActividadListener;
    }

    @NonNull
    @Override
    public EstadoMisActividadesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.estado_mis_actividades_item,
                viewGroup, false);

        return new EstadoMisActividadesViewHolder(view, onEstadoActividadListener);
    }

    @Override
    public void onBindViewHolder(@NonNull EstadoMisActividadesViewHolder eav, int posicion)
    {
        eav.titulo.setText(misActividades.get(posicion).getTitulo());
        eav.autor.setText(misActividades.get(posicion).getAutor().substring(0, 20));
        eav.fecha.setText(dateFormat(posicion));
        eav.estado.setText(misActividades.get(posicion).getEstado());
    }

    @Override
    public int getItemCount() {
        return misActividades.size();
    }

    private String dateFormat(int posicion)
    {
        String [] fechaEnPartes = misActividades.get(posicion).getFecha().split("-");
        return fechaEnPartes[2] + "/" + fechaEnPartes[1] + "/" + fechaEnPartes[0];
    }

    public interface OnEstadoActividadListener
    {
        void onEstadoActividadClick(int posicion);
    }
}
