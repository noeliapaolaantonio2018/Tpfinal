package com.example.tpfinal.inmuebles;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.tpfinal.R;
import com.example.tpfinal.modelo.Inmueble;



public class InmuebleFragment extends Fragment {

    private InmuebleViewModel inmuebleViewModel;
    private EditText etId;
    private EditText etDireccion;
    private EditText etTipo;
    private EditText etUso;
    private EditText etAmbientes;
    private EditText etPrecio;
    private CheckBox cbEstado;
    private ImageView ivImagenInmueble;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.inmueble_fragment, container, false);
        inicializar(root);
        return root;
    }

    private void inicializar(View view) {
        etId = view.findViewById(R.id.etId);
        etDireccion = view.findViewById(R.id.etDireccion);
        etTipo = view.findViewById(R.id.etTipo);
        etUso = view.findViewById(R.id.etUso);
        etAmbientes = view.findViewById(R.id.etAmbientes);
        etPrecio = view.findViewById(R.id.etPrecio);
        cbEstado = view.findViewById(R.id.cbEstado);
        ivImagenInmueble = view.findViewById(R.id.ivImagenInmueble);
        inmuebleViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InmuebleViewModel.class);
        inmuebleViewModel.getInmueble().observe(getActivity(), new Observer<Inmueble>() {
            @Override
            public void onChanged(Inmueble inmueble) {

                etId.setText(inmueble.getIdInmueble() + "");
                etDireccion.setText(inmueble.getDireccion());
                etTipo.setText(inmueble.getTipo());
                etUso.setText(inmueble.getUso());
                etAmbientes.setText(inmueble.getAmbientes() + "");
                etPrecio.setText("$" + inmueble.getPrecio());
                cbEstado.setChecked(inmueble.isEstado());
                ivImagenInmueble.setImageResource(inmueble.getImagen());

            }
        });
        inmuebleViewModel.cargarInmueble(getArguments());
    }

}

