package com.example.tpfinal.pagos;

import android.app.Application;
import android.content.Context;

import com.example.tpfinal.R;
import com.example.tpfinal.modelo.Inmueble;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


public class PagosViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<ArrayList<Inmueble>> inmuebles;
    private Context context;
    public PagosViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();

    }

    public LiveData<ArrayList<Inmueble>> getInmuebles() {
        if (inmuebles == null) {
            inmuebles = new MutableLiveData<>();
        }
        return inmuebles;
    }

    public void cargarInmueblesConPagos() {
        //Acá haríamos una consulta a la base de datos para traer los inmuebles con un contrato vigente (y por ende pagos)
        ArrayList<Inmueble> inmuebles = new ArrayList<> ();
        inmuebles.add(new Inmueble(1, "Rivadavia 123", "Residencial", "Vivienda", 4, 20000, null, true, R.drawable.casa1));
        inmuebles.add(new Inmueble(2, "Colón 456", "Comercial", "Departamento", 2, 10000, null, true, R.drawable.casa2));
        inmuebles.add(new Inmueble(3, "Las heras 789", "Residencial", "Vivienda", 6, 30000, null, true, R.drawable.casa3));
        this.inmuebles.setValue(inmuebles);

    }
}