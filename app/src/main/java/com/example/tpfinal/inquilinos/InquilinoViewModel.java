package com.example.tpfinal.inquilinos;

import android.os.Bundle;

import com.example.tpfinal.modelo.Inquilino;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InquilinoViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private MutableLiveData<Inquilino> inquilino;

    public LiveData<Inquilino> getInquilino() {
        if (inquilino == null) {
            inquilino = new MutableLiveData<>();
        }
        return inquilino;
    }

    public void cargarInquilino(Bundle bundle) {
        Inquilino inquilino = (Inquilino) bundle.getSerializable("inquilino");
        this.inquilino.setValue(inquilino);
    }
}