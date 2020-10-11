package com.example.tpfinal.contratos;

import android.os.Bundle;

import com.example.tpfinal.modelo.Contrato;
import com.example.tpfinal.modelo.Inmueble;
import com.example.tpfinal.modelo.Inquilino;

import java.util.Calendar;
import java.util.Date;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContratoViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<Contrato> contrato;

    public LiveData<Contrato> getContrato() {
        if (contrato == null) {
            contrato = new MutableLiveData<>();
        }
        return contrato;
    }

    public void cargarContrato(Bundle bundle) {
        //inscribo un inmueble o Id de inmueble, y buscaría en la base de datos el contrato  de ese inmueble
        //En caso de no existir, la vista muestra un mensaje (Si partimos de la pestaña de contratos se supone que el inmueble tiene un contrato vigente)
        Inmueble inmueble = (Inmueble) bundle.get("inmueble");
        Contrato contrato = new Contrato();
        switch (inmueble.getIdInmueble()) {
            case 1:
            {
                Calendar inicio = Calendar.getInstance();
                inicio.set(Calendar.YEAR, 2020);
                inicio.set(Calendar.MONTH, Calendar.MAY);
                inicio.set(Calendar.DAY_OF_MONTH, 18);
                Calendar fin = Calendar.getInstance();
                fin.set(Calendar.YEAR, 2020);
                fin.set(Calendar.MONTH, Calendar.DECEMBER);
                fin.set(Calendar.DAY_OF_MONTH, 26);
                contrato = new Contrato(1, inicio.getTime(), fin.getTime(), inmueble.getPrecio(), 1, inmueble.getIdInmueble(), new Inquilino(), inmueble);
                break;
            }
            case 2:
             {
                Calendar inicio = Calendar.getInstance();
                inicio.set(Calendar.YEAR, 2019);
                inicio.set(Calendar.MONTH, Calendar.JUNE);
                inicio.set(Calendar.DAY_OF_MONTH, 28);
                Calendar fin = Calendar.getInstance();
                fin.set(Calendar.YEAR, 2020);
                fin.set(Calendar.MONTH, Calendar.JANUARY);
                fin.set(Calendar.DAY_OF_MONTH, 25);
                contrato = new Contrato(1, inicio.getTime(), fin.getTime(), inmueble.getPrecio(), 1, inmueble.getIdInmueble(), new Inquilino(), inmueble);
                break;
            }
            case 3:
            {
                Calendar inicio = Calendar.getInstance();
                inicio.set(Calendar.YEAR, 2020);
                inicio.set(Calendar.MONTH, Calendar.DECEMBER);
                inicio.set(Calendar.DAY_OF_MONTH, 1);
                Calendar fin = Calendar.getInstance();
                fin.set(Calendar.YEAR, 2021);
                fin.set(Calendar.MONTH, Calendar.MAY);
                fin.set(Calendar.DAY_OF_MONTH, 5);
                contrato = new Contrato(1, inicio.getTime(), fin.getTime(), inmueble.getPrecio(), 1, inmueble.getIdInmueble(), new Inquilino(), inmueble);
                break;
            }
        }

        this.contrato.setValue(contrato);
    }

}