package com.example.tpfinal.inquilinos;

import android.content.Context;

import com.example.tpfinal.modelo.Inquilino;

import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InquilinosViewModel extends ViewModel {
    private Context context;
    private MutableLiveData<ArrayList<Inquilino>> inquilinos;

    public LiveData<ArrayList<Inquilino>> getInquilinos() {
        if (inquilinos == null) {
            inquilinos = new MutableLiveData<>();
        }
        return inquilinos;
    }

    public void cargarInquilinos() {
        ArrayList<Inquilino> inquilinos = new ArrayList<>();
        inquilinos.add(new Inquilino(1, "31276462", "Noelia", "Antonio", "ULP", "noelia@gmail.com", "2664779085", "Mi papa", "Telefono del papa"));
        inquilinos.add(new Inquilino(2, "48017769", "Kevin", "Ferramola", "esc.Rosenda", "kevin@gmail.com", "2664223344", "Hijo", "Telefono del hijo"));
        inquilinos.add(new Inquilino(3, "12123123", "Nora", "Tello", "Depilacion", "nora@gmail.com", "2664116677", "Mi mama", "Telefono la mama"));
        this.inquilinos.setValue(inquilinos);

    }
    // TODO: Implement the ViewModel
}