package com.example.tpfinal.pagos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tpfinal.R;
import com.example.tpfinal.inmuebles.InmuebleAdapter;
import com.example.tpfinal.modelo.Inmueble;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class InmuebleConPagosAdapter extends RecyclerView.Adapter<InmuebleConPagosAdapter.ViewHolder>{
    private Context context;
    private List<Inmueble> inmuebles;
    private LayoutInflater inflater;



    public InmuebleConPagosAdapter(Context context, List<Inmueble> inmuebles, LayoutInflater inflater) {
        this.context = context;
        this.inmuebles = inmuebles;
        this.inflater = inflater;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_inmueble_con_pagos_fragment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvDireccion.setText(inmuebles.get(position).getDireccion());
        holder.ivImagenInmueble.setImageResource(inmuebles.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return inmuebles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDireccion;
        ImageView ivImagenInmueble;
        Button btPagos;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImagenInmueble = itemView.findViewById(R.id.ivImagenInmueble);
            tvDireccion = itemView.findViewById(R.id.tvDireccion);
            btPagos = itemView.findViewById(R.id.btPagos);
            btPagos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    Inmueble inmueble = inmuebles.get(getAdapterPosition());
                    bundle.putSerializable("inmueble", inmueble);
                    Navigation.findNavController((Activity) context, R.id.nav_host_fragment).navigate(R.id.pagoFragment, bundle);
                }
            });
        }
    }
}
