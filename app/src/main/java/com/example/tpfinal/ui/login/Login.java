package com.example.tpfinal.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tpfinal.R;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    private EditText correo;
    private EditText contraseña;
    private Button iniciar_sesion;
    private LoginViewModel vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inicializar();
    }

    public void inicializar(){
        correo=findViewById(R.id.et_contrasena);
        contraseña=findViewById(R.id.et_contrasena);
        iniciar_sesion=findViewById(R.id.btn_ir_inicioSesion);

        vm=ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(Login.class);
        vm=getError().observe(owner:this,new Observer<String>() {
            @Override
            public void onChanged(String error) {//cuando cambia muestra el error
                Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
            }
        });
        correo=findViewById(R.id.et_correo);
        contraseña=findViewById(R.id.et_contrasena);
        iniciar_sesion=findViewById(R.id.btn_ir_inicioSesion);
        iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vm.autenticacion(correo.getText().toString(),contraseña.getText().toString());//llama al metodo autenticacion
            }
        });
        }

    }



