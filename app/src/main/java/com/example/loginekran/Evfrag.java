package com.example.loginekran;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.UUID;

public class Evfrag extends Fragment
{
    RecyclerView liste1;
    private ArrayList<Urunler> urunler;
    private MyAdaptor myAdaptor;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_evfrag,container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        diziolustur();
        liste1=view.findViewById(R.id.liste);
        liste1.setLayoutManager(new LinearLayoutManager(getContext()));
        liste1.setHasFixedSize(true);
        myAdaptor=new MyAdaptor(getContext(),urunler);
        liste1.setAdapter(myAdaptor);
        myAdaptor.notifyDataSetChanged();
    }

    private void diziolustur()
    {
        urunler=new ArrayList<>();
        urunler.add(new Urunler(R.drawable.forma1,"MACRON 2022/23 BORDO MAVI ÇUBUKLU FORMA","₺599.99"));
        urunler.add(new Urunler(R.drawable.forma2,"MACRON TEK TARAFI İMZALI SIYAH KEŞANLI FORMA","₺967.00"));
        urunler.add(new Urunler(R.drawable.forma3,"MACRON 2022/23 SIYAH KEŞANLI FORMA","₺599.99"));
        urunler.add(new Urunler(R.drawable.forma4,"MACRON 2022/23 MAVI FORMA","₺599.99"));
        urunler.add(new Urunler(R.drawable.sweat1,"TRABZONSPOR SWEAT KAPŞONLU 3 İPLIK","₺999.99"));
        urunler.add(new Urunler(R.drawable.sweat2,"TRABZONSPOR SWEAT KAPŞONLU 3 İPLIK","₺999.99"));
        urunler.add(new Urunler(R.drawable.sweat3,"TRABZONSPOR SWEAT KAPŞONLU 3 İPLIK","₺999.99"));
        urunler.add(new Urunler(R.drawable.eso1,"TRABZONSPOR EŞOFMAN ALT PAÇA RIBANALI FIRÇALI 3 İPLIK","₺949.99"));
        urunler.add(new Urunler(R.drawable.eso2,"TRABZONSPOR EŞOFMAN ALT PAÇA RIBANALI FIRÇALI 3 İPLIK","₺949.99"));
        urunler.add(new Urunler(R.drawable.eso3,"TRABZONSPOR EŞOFMAN ALT PAÇA RIBANALI FIRÇALI 3 İPLIK","₺949.99"));
        urunler.add(new Urunler(R.drawable.eso4,"TRABZONSPOR EŞOFMAN ALT PAÇA RIBANALI FIRÇALI 3 İPLIK","₺949.99"));
        urunler.add(new Urunler(R.drawable.eso5,"TRABZONSPOR EŞOFMAN ALT PAÇA RIBANALI FIRÇALI 3 İPLIK","₺949.99"));
        urunler.add(new Urunler(R.drawable.mont1,"TRABZONSPOR MONT SOFTSHELL İKI RENK PARÇALI","₺1,749.99"));
        urunler.add(new Urunler(R.drawable.mont2,"TRABZONSPOR KOLEJ MONT LOGOLU","₺1,299.99"));
        urunler.add(new Urunler(R.drawable.mont3,"TRABZONSPOR MONT SOFTSHELL","₺1,749.99"));
    }
}