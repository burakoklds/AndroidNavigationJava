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
import android.widget.TextView;


public class SecondFragment extends Fragment {


    public SecondFragment() {
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
        return inflater.inflate(R.layout.fragment_second, container, false); //OnCreate olduğunda hangi fragment_second.xml yakalayacağı söyleniyor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = view.findViewById(R.id.button2); //Buton yakalanıyor
        TextView textView = view.findViewById(R.id.textView); //TextView Yakalanıyor

        button.setOnClickListener(new View.OnClickListener() { //Buttonun tıklanılması için dinliyor
            @Override
            public void onClick(View v) {
                goToFirst(v);
            }
        });

        if (getArguments() != null){ //set edilen argüman boş değilse
            int age = SecondFragmentArgs.fromBundle(getArguments()).getAge(); //SecondFragmentArgs 'dan fromBundle Argumanlarından getAge'i getir
            textView.setText("Age: " + age);
        }

    }

    public void goToFirst(View view){

        NavDirections action = SecondFragmentDirections.actionSecondFragmentToFirstFragment();
        Navigation.findNavController(view).navigate(action);

    }
}