package com.example.cigarro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class CentroDasCoisas extends AppCompatActivity {
    TabLayout tab;
    ViewPager2 pager;
    Adaptador adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        tab = findViewById(R.id.tab);
        pager = findViewById(R.id.pager);
        FragmentManager fm = getSupportFragmentManager();
        adaptador = new Adaptador(fm,getLifecycle()); //atributos do contrutor
        pager.setAdapter(adaptador);
        tab.addTab(tab.newTab().setText("MAlfati"));
        tab.addTab(tab.newTab().setText("Maickon"));
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {// vincular os fragmentos as tabs
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition()); // vincular a tab com a position | 0 - pri | 1 - Segu | 2 - Ter


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override//qual página está selecionada, vamo usar para passar para o tab
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tab.selectTab(tab.getTabAt(position)); //setar no tab a posição
            }
        });
    }
}