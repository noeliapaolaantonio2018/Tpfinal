package com.example.tpfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListaAdapter extends ArrayAdapter<inmueble> {//constructor
    private Context context;
    private List<inmueble> lista;
    private LayoutInflater li;

    public ListaAdapter(@NonNull Context context, int resource, @NonNull List<inmueble> objects, LayoutInflater li) {//layoutInflater me va a ayudar a inflar las vistas
        super(context, resource, objects);
        this.context = context;
        this.lista = objects;
        this.li = li;//le paso la lista de inmueble
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {//se ejecuta por cada elemento de la lista que pase
        View itemView = convertView;
        if (itemView == null) {
               itemView = li.inflate(R.layout.items, parent, false);
                            }
            inmueble inmueble = lista.get(position);
            // va a traer el valor entero de la imagen,lo recupero
            ImageView foto = itemView.findViewById(R.id.foto);//referencia a foto de la imagen
            foto.setImageResource(inmueble.getFoto());//recupera el atributo foto

            TextView direccion = itemView.findViewById(R.id.direccion);//referencia al texto de la vista
            direccion.setText(inmueble.getDireccion());//setea el texto de la vista

            TextView precio = itemView.findViewById(R.id.precio);
            precio.setText(inmueble.getPrecio() + " ");//espera un string por eso concateno +""

            return itemView;//devuelvo la vista
            //emos crado un adapter
            //ahora debo referencia desde el mainactivity
        }
    }



