package com.example.tpfinal.contratos;

import android.app.Application;
import android.content.Context;

import com.example.tpfinal.R;
import com.example.tpfinal.modelo.Inmueble;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContratosViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<Inmueble>> inmuebles;
    private Context context;
    public ContratosViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();

    }

    public LiveData<ArrayList<Inmueble>> getInmuebles() {
        if (inmuebles == null) {
            inmuebles = new MutableLiveData<>();
        }
        return inmuebles;
    }

    public void cargarInmueblesConContrato() {
        ArrayList<Inmueble> inmuebles = new ArrayList<> ();
        inmuebles.add(new Inmueble(1, "las heras", "Residencial", "Vivienda", 2, 30000, null, true, R.drawable.casa1));
        inmuebles.add(new Inmueble(2, "av. Illia 43", "Comercial", "Vivienda", 2, 25000, null, true, R.drawable.casa2));
        inmuebles.add(new Inmueble(3, "av.la finur 34", "Residencial", "Vivienda", 2, 35000, null, true, R.drawable.casa3));
        this.inmuebles.setValue(inmuebles);
    }
}
