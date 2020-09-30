package com.example.tpfinal.ui.perfil;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.tpfinal.R;
import com.example.tpfinal.modelo.Propietario;

public class PerfilFragment extends Fragment {

    private EditText etApellido,etNombre,etMail,etPass;
    private Button btnAceptar,btnEditar;
    private PerfilViewModel vm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

                ViewModelProviders.of(this).get(PerfilViewModel.class);
        View root = inflater.inflate(R.layout.perfil, container, false);
       inicializar(root);
        return root;
    }

    private  void inicializar(View view){
        etApellido=view.findViewById(R.id.et_contrasena);
        etNombre=view.findViewById(R.id.et_contrasena);
        etMail=view.findViewById(R.id.etemail);
        etPass=view.findViewById(R.id.etpassword);
        btnAceptar=view.findViewById(R.id.btnAceptar);
        btnEditar=view.findViewById(R.id.btneditar);

        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PerfilViewModel.class);
        vm.getPropietario().observe(getViewLifecycleOwner(), new Observer<Propietario>() {
            @Override
            public void onChanged(Propietario propietario) {
                 etApellido.setText(propietario.getApellido());
                 etNombre.setText(propietario.getNombre());
                 etMail.setText(propietario.getMail());
                 etPass.setText(propietario.getPassword());
            }
        });
        vm.recuperarPrpietario();
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               etApellido.setEnabled(true);
                etNombre.setEnabled(true);
                etMail.setEnabled(true);
                etPass.setEnabled(true);
                btnEditar.setVisibility(view.GONE);
                btnAceptar.setVisibility(view.VISIBLE);

            }
        });
    }
}