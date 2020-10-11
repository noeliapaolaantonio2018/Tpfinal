package com.example.tpfinal.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.example.tpfinal.MainActivity;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class LoginActivityViewModel extends AndroidViewModel {
     Context context;
    private MutableLiveData<String> error;
    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<String> getError() {
        if (error == null) {
            error = new MutableLiveData<>();
        }
        return error;
    }

    public void autenticar(String usuario, String contraseña) {
        String usuarioValido = "noelia";
        String contraseñaValida = "noelia";
        if (usuario.equals(usuarioValido) && contraseña.equals(contraseñaValida)) {
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        } else {
            error.setValue("Usuario y/o contraseña incorrecto/s por favor vuelve a intentar");
        }
    }
}
