package com.example.tpfinal.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.example.tpfinal.MainActivity;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class LoginViewModel extends  androidViewModel {
    private Context context;
    private MutableLiveData<String> error;

    public LoginViewModel(@NonNull Application application){
        super(application);
        context=application.getApplicationContext();
    }

    public LiveData<String> getError() {
        if (error == null) {
            error = new MutableLiveData<>();
        }
        return  error;
    }

    public void autenticacion(String u, String c){
        String usuario="noelia@gmail.com";
        String password="noelia";
        if(usuario.equals(u)&& password.equals(c)){
            Intent intent=new Intent(context, MainActivity.class);
            context.startActivity(intent);
        }else{
            error.setValue("La clave o contraseña es incorrecta");
        }

    }
}
