package com.example.tpfinal.ui.perfil;

import com.example.tpfinal.modelo.Propietario;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PerfilViewModel extends ViewModel {

    private MutableLiveData<Propietario> propietario;

    public PerfilViewModel() {
        propietario = new MutableLiveData<>();

    }

    public LiveData<Propietario> getPropietario() {
        if(propietario==null){
            propietario=new MutableLiveData<>();
        }
        return propietario;
    }
    public  void recuperarPrpietario(){
        Propietario p=new Propietario("Antonio","Noelia","noelia@gamil.com","noelia");
        Propietario.setValue(p);
        }

    }
}