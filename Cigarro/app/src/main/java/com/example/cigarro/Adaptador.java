package com.example.cigarro;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Adaptador  extends FragmentStateAdapter {
    public Adaptador(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) { //só usa o terceiro método construtor, o life cycle é enquanto  o aplicativo roda
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {// bagulho para retornar fragment
        switch (position){
            case 1:
                //return new Segundo(); // 0 - Primeiro | 1 - Segundo | 2 - Terceiro
            case 2:
                //return new Terceiro(); //tela 3
        }
        return new DiasSemFumar();  // caso não tenha a posição informada, da a primeira tela
    }

    @Override
    public int getItemCount() {
        return 3; //quantidade de fragment
    }
}
