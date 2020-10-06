package com.example.tpfinal.inmuebles;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tpfinal.R;
import com.example.tpfinal.modelo.Inmueble;

import java.io.Serializable;
import java.util.ArrayList;

public class InmueblesFragment extends Fragment {
    private ListView lvInmuebles;
    private InmueblesViewModel inmueblesViewModel;
    ArrayAdapter<Inmueble> adapter;
    Context context;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.inmuebles_fragment, container, false);
        context = root.getContext();
        inicializar(root);
        return root;
    }

    private void inicializar(View view) {
        lvInmuebles = view.findViewById(R.id.lvInmuebles);
        inmueblesViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InmueblesViewModel.class);
        inmueblesViewModel.getInmuebles().observe(getViewLifecycleOwner(), new Observer<ArrayList<Inmueble>>() {
            @Override


                public void onChanged(ArrayList<Inmueble> inmuebles) {
                    adapter = new InmuebleAdapter(context, R.layout.item_inmueble_fragment, inmuebles, getLayoutInflater());
                    lvInmuebles.setAdapter(adapter);
                    lvInmuebles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Bundle bundle = new Bundle();
                            Inmueble inmueble = adapter.getItem(i);
                            Log.d("Salida: ", inmueble.getDireccion());
                            bundle.putSerializable("inmueble", (Serializable) inmueble);////////////////error
                            Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.inmuebleFragment, bundle);
                        }
                    });
                }
            });
               inmueblesViewModel.cargarInmuebles();
        }
}