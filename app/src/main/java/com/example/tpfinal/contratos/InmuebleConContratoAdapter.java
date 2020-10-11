package com.example.tpfinal.contratos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tpfinal.R;
import com.example.tpfinal.modelo.Inmueble;
import com.example.tpfinal.modelo.Inquilino;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class InmuebleConContratoAdapter extends ArrayAdapter<Inmueble> {

    ArrayList<Inmueble> inmuebles;
    Context context;
    LayoutInflater inflater;

    public InmuebleConContratoAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Inmueble> objects, LayoutInflater inflater) {
        super(context, resource, objects);
        this.context = context;
        this.inmuebles = objects;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View viewInmuebleConcontrato = convertView;
        if (viewInmuebleConcontrato == null) {
            viewInmuebleConcontrato = inflater.inflate(R.layout.item_inmueble_con_contrato_fragment, parent, false);
        }

        Inmueble inmueble = inmuebles.get(position);
        TextView tvInmuebleConContrato = viewInmuebleConcontrato.findViewById(R.id.tvInmuebleConContrato);
        tvInmuebleConContrato.setText("Inmueble código Nº" + inmuebles.get(position).getIdInmueble() + " ubicado en " + inmuebles.get(position).getDireccion());
        return viewInmuebleConcontrato;

    }
}
