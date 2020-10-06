package com.example.tpfinal.inmuebles;

import android.app.Application;
import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.tpfinal.R;
import com.example.tpfinal.modelo.Inmueble;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class InmueblesViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<Inmueble>> inmuebles;
    private Context context;
    private ArrayAdapter<Inmueble> adapter;
    public InmueblesViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();

    }

    public LiveData<ArrayList<Inmueble>> getInmuebles() {
        if (inmuebles == null) {
            inmuebles = new MutableLiveData<>();
        }
        return inmuebles;
    }

    public void cargarInmuebles() {
        ArrayList<Inmueble> inmuebles = new ArrayList<> ();
        inmuebles.add(new Inmueble(1, "constitucion 46", "Residencial", "Vivienda", 3, 28000, null, true, R.drawable.casa1));
        inmuebles.add(new Inmueble(2, "casero 976", "Comercial", "Departamento monohambiente", 2, 18000, null, true, R.drawable.casa2));
        inmuebles.add(new Inmueble(3, "av.Mendoza 234", "Residencial", "Vivienda", 4, 38000, null, true, R.drawable.casa3));
        this.inmuebles.setValue(inmuebles);

    }
}