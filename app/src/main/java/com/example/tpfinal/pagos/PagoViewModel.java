package com.example.tpfinal.pagos;

import android.os.Bundle;
import android.util.Log;

import com.example.tpfinal.modelo.Contrato;
import com.example.tpfinal.modelo.Inmueble;
import com.example.tpfinal.modelo.Inquilino;
import com.example.tpfinal.modelo.Pago;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PagoViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<ArrayList<Pago>> pagos;

    public LiveData<ArrayList<Pago>> getPagos () {
        if (pagos == null) {
            pagos = new MutableLiveData<>();
        }
        return pagos;
    }
    public void cargarPagos(Bundle bundle) {
        //Acá recibiríamos un inmueble o Id de inmueble, y buscaríamos en la base de datos el contrato vigente de ese inmueble y sus pagos
        //En caso de no existir, la vista mostraría un mensaje (Si partimos de la pestaña de contratos se supone que el inmueble tiene un contrato y pagos vigente)
        Inmueble inmueble = (Inmueble) bundle.get("inmueble");
        Log.d("salida", inmueble.getIdInmueble()+"");
        ArrayList<Pago> pagos = new ArrayList<>();
        switch (inmueble.getIdInmueble()) {
            case 1:
            {
                Calendar fecha1 = Calendar.getInstance();
                fecha1.set(Calendar.YEAR, 2020);
                fecha1.set(Calendar.MONTH, Calendar.JANUARY);
                fecha1.set(Calendar.DAY_OF_MONTH, 1);
                Calendar fecha2 = Calendar.getInstance();
                fecha2.set(Calendar.YEAR, 2020);
                fecha2.set(Calendar.MONTH, Calendar.FEBRUARY);
                fecha2.set(Calendar.DAY_OF_MONTH, 1);
                Calendar fecha3 = Calendar.getInstance();
                fecha3.set(Calendar.YEAR, 2020);
                fecha3.set(Calendar.MONTH, Calendar.MARCH);
                fecha3.set(Calendar.DAY_OF_MONTH, 1);

                pagos.add(new Pago(1, 1, 1, null, 20000, fecha1.getTime()));
                pagos.add(new Pago(2, 2, 1, null, 20000, fecha2.getTime()));
                pagos.add(new Pago(3, 3, 1, null, 20000, fecha2.getTime()));
                break;
            }
            case 2:
            {
                pagos = new ArrayList<>();
                Calendar fecha1 = Calendar.getInstance();
                fecha1.set(Calendar.YEAR, 2020);
                fecha1.set(Calendar.MONTH, Calendar.MAY);
                fecha1.set(Calendar.DAY_OF_MONTH, 18);
                Calendar fecha2 = Calendar.getInstance();
                fecha2.set(Calendar.YEAR, 2020);
                fecha2.set(Calendar.MONTH, Calendar.JUNE);
                fecha2.set(Calendar.DAY_OF_MONTH, 18);
                Calendar fecha3 = Calendar.getInstance();
                fecha3.set(Calendar.YEAR, 2020);
                fecha3.set(Calendar.MONTH, Calendar.JULY);
                fecha3.set(Calendar.DAY_OF_MONTH, 18);

                pagos.add(new Pago(4, 1, 2, null, 10000, fecha1.getTime()));
                pagos.add(new Pago(5, 2, 2, null, 10000, fecha2.getTime()));
                pagos.add(new Pago(6, 3, 2, null, 10000, fecha2.getTime()));
                break;
            }
            case 3:
            {
                pagos = new ArrayList<>();
                Calendar fecha1 = Calendar.getInstance();
                fecha1.set(Calendar.YEAR, 2020);
                fecha1.set(Calendar.MONTH, Calendar.AUGUST);
                fecha1.set(Calendar.DAY_OF_MONTH, 3);
                Calendar fecha2 = Calendar.getInstance();
                fecha2.set(Calendar.YEAR, 2020);
                fecha2.set(Calendar.MONTH, Calendar.SEPTEMBER);
                fecha2.set(Calendar.DAY_OF_MONTH, 3);
                Calendar fecha3 = Calendar.getInstance();
                fecha3.set(Calendar.YEAR, 2020);
                fecha3.set(Calendar.MONTH, Calendar.NOVEMBER);
                fecha3.set(Calendar.DAY_OF_MONTH, 3);

                pagos.add(new Pago(7, 1, 3, null, 30000, fecha1.getTime()));
                pagos.add(new Pago(8, 2, 3, null, 30000, fecha2.getTime()));
                pagos.add(new Pago(9, 3, 3, null, 30000, fecha2.getTime()));
                break;
            }

        }

        this.pagos.setValue(pagos);
    }

}