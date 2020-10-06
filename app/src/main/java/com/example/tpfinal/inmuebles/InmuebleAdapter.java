package com.example.tpfinal.inmuebles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tpfinal.R;
import com.example.tpfinal.modelo.Inmueble;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class InmuebleAdapter extends ArrayAdapter<Inmueble> {
    private Context context;
    private List<Inmueble> inmuebles;
    private LayoutInflater inflater;

    public InmuebleAdapter(@NonNull Context context, int resource, @NonNull List<Inmueble> objects, LayoutInflater inflater) {
        super(context, resource, objects);
        this.context = context;
        this.inmuebles = objects;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View viewInmueble = convertView;
        if (viewInmueble == null) {
            viewInmueble = inflater.inflate(R.layout.item_inmueble_fragment, parent, false);
        }

        Inmueble inmueble = inmuebles.get(position);
        ImageView ivImagenInmueble = viewInmueble.findViewById(R.id.ivImagenInmueble);
        TextView tvTipo = viewInmueble.findViewById(R.id.tvTipo);
        TextView tvDireccion = viewInmueble.findViewById(R.id.tvDireccion);
        TextView tvPrecio = viewInmueble.findViewById(R.id.tvPrecio);
        ivImagenInmueble.setImageResource(inmueble.getImagen());
        tvTipo.setText(inmueble.getTipo());
        tvDireccion.setText(inmueble.getDireccion());
        tvPrecio.setText("$" + inmueble.getPrecio());

        return viewInmueble;

    }
}
