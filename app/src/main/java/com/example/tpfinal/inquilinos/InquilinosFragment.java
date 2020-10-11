package com.example.tpfinal.inquilinos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tpfinal.R;
import com.example.tpfinal.modelo.Inquilino;

import java.util.ArrayList;

public class InquilinosFragment extends Fragment {

    private InquilinosViewModel inquilinosViewModel;
    private ListView lvInquilinos;
    private InquilinoAdapter adapter;
    Context context;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.inquilinos_fragment, container, false);
        context = root.getContext();
        inicializar(root);
        return root;
    }



    private void inicializar(View view) {
        inquilinosViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this.getActivity().getApplication()).create(InquilinosViewModel.class);
        lvInquilinos = view.findViewById(R.id.lvInquilinos);
        inquilinosViewModel.getInquilinos().observe(getViewLifecycleOwner(), new Observer<ArrayList<Inquilino>>() {
            @Override
            public void onChanged(ArrayList<Inquilino> inquilinos) {
                adapter = new InquilinoAdapter(context, R.layout.item_inquilino_fragment, inquilinos, getLayoutInflater());
                lvInquilinos.setAdapter(adapter);
                lvInquilinos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Bundle bundle = new Bundle();
                        Inquilino inquilino = adapter.getItem(i);
                        bundle.putSerializable("inquilino", inquilino);
                        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.inquilinoFragment, bundle);
                    }
                });
            }
        });
        inquilinosViewModel.cargarInquilinos();
    }

}