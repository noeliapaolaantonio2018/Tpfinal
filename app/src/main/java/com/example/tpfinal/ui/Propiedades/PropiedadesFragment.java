package com.example.tpfinal.ui.Propiedades;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.tpfinal.R;

public class PropiedadesFragment extends Fragment {

    private PropiedadesViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

         View root = inflater.inflate(R.layout.propiedades, container, false);
         Button detalle=root.findViewById(R.id.nav_propiedades);
         detalle.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Navigation.findNavController(getActivity(),R.id.nav_host_fragment_container).navigate(R.id.detallePropiedadFragment);
             }
         });


        return root;
    }
}