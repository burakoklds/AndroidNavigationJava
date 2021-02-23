package com.burak.navigationjava;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false); //OnCreate olduğunda hangi fragment_first.xml yakalayacağı söyleniyor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = view.findViewById(R.id.button);   //Buton yakalanıyor
        button.setOnClickListener(new View.OnClickListener() {  //Buttonun tıklanılması için dinliyor
            @Override
            public void onClick(View v) {
                goToSecond(view);
            }
        });
    }

    public  void  goToSecond(View view){
          //1. Yol
        //NavDirections action = FirstFragmentDirections.actionFirstFragmentToSecondFragment();
        //Navigation.findNavController(view).navigate(action);

        //2. Yol parametre göndererek
        FirstFragmentDirections.ActionFirstFragmentToSecondFragment action = FirstFragmentDirections.actionFirstFragmentToSecondFragment();
        action.setAge(50); //Değer yollanıyor
        Navigation.findNavController(view).navigate(action); //action'a set edilen değer yollanıyor

    }
}