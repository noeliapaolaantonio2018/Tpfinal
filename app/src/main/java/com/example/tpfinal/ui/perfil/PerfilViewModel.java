package com.example.tpfinal.ui.perfil;

import com.example.tpfinal.modelo.Propietario;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PerfilViewModel extends ViewModel {

    private MutableLiveData<Propietario> propietario;
    public PerfilViewModel() {
        super();
    }
    public LiveData<Propietario> getPropietario() {
        if (propietario == null) {
            propietario = new MutableLiveData<>();
        }
        return propietario;
    }

    public void cargarPropietario() {
        Propietario propietario = new Propietario(1, "31276462", "Noelia", "Antonio", "noelia@gmail.com", "noelia", "2664869278");
        this.propietario.setValue(propietario);
    }
}