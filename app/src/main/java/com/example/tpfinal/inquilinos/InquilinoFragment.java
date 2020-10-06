package com.example.tpfinal.inquilinos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tpfinal.R;
import com.example.tpfinal.modelo.Inquilino;

public class InquilinoFragment extends Fragment {

    private InquilinoViewModel inquilinoViewModel;
    private EditText etNombre;
    private EditText etApellido;
    private EditText etDNI;
    private EditText etCodigo;
    private EditText etEmail;
    private EditText etTelefono;
    private EditText etGarante;
    private EditText etTelefonoGarante;

    public InquilinoFragment() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.inquilino_fragment, container, false);
        inicializar(root);
        return root;
    }


    public void inicializar(View view) {
        etNombre = view.findViewById(R.id.etNombre);
        etApellido = view.findViewById(R.id.etApellido);
        etCodigo = view.findViewById(R.id.etCodigo);
        etDNI = view.findViewById(R.id.etDNI);
        etEmail = view.findViewById(R.id.etEmail);
        etTelefono = view.findViewById(R.id.etTelefono);
        etGarante = view.findViewById(R.id.etGarante);
        etTelefonoGarante = view.findViewById(R.id.etTelefonoGarante);

        inquilinoViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InquilinoViewModel.class);
        inquilinoViewModel.getInquilino().observe(getViewLifecycleOwner(), new Observer<Inquilino>() {
            @Override
            public void onChanged(Inquilino inquilino) {
                etNombre.setText(inquilino.getNombre());
                etApellido.setText(inquilino.getApellido());
                etCodigo.setText(inquilino.getIdInquilino() + "");
                etDNI.setText(inquilino.getDNI());
                etEmail.setText(inquilino.getEmail());
                etTelefono.setText(inquilino.getTelefono());
                etGarante.setText(inquilino.getNombreGarante());
                etTelefonoGarante.setText(inquilino.getTelefonoGarante());

            }
        });
        inquilinoViewModel.cargarInquilino(getArguments());
    }

}