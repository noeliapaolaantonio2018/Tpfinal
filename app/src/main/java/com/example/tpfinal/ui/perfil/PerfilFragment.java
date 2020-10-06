package com.example.tpfinal.ui.perfil;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.tpfinal.modelo.Propietario;
import com.example.tpfinal.R;

public class PerfilFragment extends Fragment {

    private PerfilViewModel perfilViewModel;
    private EditText etId;
    private EditText etDNI;
    private EditText etNombre;
    private EditText etApellido;
    private EditText etEmail;
    private EditText etContraseña;
    private EditText etTelefono;
    private Button btEditar;
    private Button btGuardar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.perfil_fragment, container, false);
        inicializar(root);
        return root;
    }

    private void inicializar(View view) {
        etId = view.findViewById(R.id.etId);
        etDNI = view.findViewById(R.id.etDNI);
        etNombre = view.findViewById(R.id.etNombre);
        etApellido = view.findViewById(R.id.etApellido);
        etEmail = view.findViewById(R.id.etEmail);
        etContraseña = view.findViewById(R.id.etContraseña);
        etTelefono = view.findViewById(R.id.etTelefono);
        btEditar = view.findViewById(R.id.btEditar);
        btGuardar = view.findViewById(R.id.btGuardar);
        perfilViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PerfilViewModel.class);
        perfilViewModel.getPropietario().observe(getViewLifecycleOwner(), new Observer<Propietario>() {
            @Override
            public void onChanged(Propietario propietario) {
                etId.setText(propietario.getId()+"");
                etDNI.setText(propietario.getDNI());
                etNombre.setText(propietario.getNombre());
                etApellido.setText(propietario.getApellido());
                etEmail.setText(propietario.getEmail());
                etTelefono.setText(propietario.getTelefono());
            }
        });
        perfilViewModel.cargarPropietario();
        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btEditar.setVisibility(View.GONE);
                btGuardar.setVisibility(View.VISIBLE);
                etDNI.setEnabled(true);
                etNombre.setEnabled(true);
                etApellido.setEnabled(true);
                etEmail.setEnabled(true);
                etContraseña.setEnabled(true);
                etTelefono.setEnabled(true);

            }
        });
    }
}