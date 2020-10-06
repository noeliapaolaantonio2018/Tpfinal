package com.example.tpfinal.inquilinos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tpfinal.R;
import com.example.tpfinal.modelo.Inquilino;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class InquilinoAdapter extends ArrayAdapter<Inquilino> {

    ArrayList<Inquilino> inquilinos;
    Context context;
    LayoutInflater inflater;

    public InquilinoAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Inquilino> objects, LayoutInflater inflater) {
        super(context, resource, objects);
        this.context = context;
        this.inquilinos = objects;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View viewInquilino = convertView;
        if (viewInquilino == null) {
            viewInquilino = inflater.inflate(R.layout.item_inquilino_fragment, parent, false);
        }

        Inquilino inquilino = inquilinos.get(position);
        TextView tvNombreInquilino = viewInquilino.findViewById(R.id.tvnada);
        TextView tvTelefonoInquilino = viewInquilino.findViewById(R.id.tvTelefonoInquilino);
        tvNombreInquilino.setText(inquilino.getNombre() + " " + inquilino.getApellido());
        tvTelefonoInquilino.setText(inquilino.getTelefono());

        return viewInquilino;

    }

}
