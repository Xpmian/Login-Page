package com.example.loginekran;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Aramafrag extends Fragment
{
   private RecyclerView recyclerView;
   private View view;
   MyAdaptor myAdaptor;
   private ArrayList<Urunler> urunlist;
   private SearchView searchView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_aramafrag, container, false);
        recyclerView =view.findViewById(R.id.liste2);
        diziolustur();
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new MyAdaptor(view.getContext(),urunlist));

        searchView=view.findViewById(R.id.searchview);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String query)
            {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                filterList(newText);
                return true;
            }
        });
        return view;
    }

    private void filterList(String newText)
    {
        ArrayList<Urunler>  filteredList = new ArrayList<>();
        for (Urunler urunler : urunlist)
        {
             if(urunler.getUrunismi().toLowerCase().contains(newText.toLowerCase()))
             {
                 filteredList.add(urunler);
             }
        }
        if (filteredList.isEmpty())
        {

        }
        else
        {
            myAdaptor=new MyAdaptor(getContext(),filteredList);
            recyclerView.setAdapter(myAdaptor);
            myAdaptor.notifyDataSetChanged();

        }
    }
    private void diziolustur()
    {
        urunlist=new ArrayList<>();
        urunlist.add(new Urunler(R.drawable.forma1,"MACRON 2022/23 BORDO MAVI ÇUBUKLU FORMA","₺599.99"));
        urunlist.add(new Urunler(R.drawable.forma2,"MACRON TEK TARAFI İMZALI SIYAH KEŞANLI FORMA","₺967.00"));
        urunlist.add(new Urunler(R.drawable.forma3,"MACRON 2022/23 SIYAH KEŞANLI FORMA","₺599.99"));
        urunlist.add(new Urunler(R.drawable.forma4,"MACRON 2022/23 MAVI FORMA","₺599.99"));
        urunlist.add(new Urunler(R.drawable.sweat1,"TRABZONSPOR SWEAT KAPŞONLU 3 İPLIK","₺999.99"));
        urunlist.add(new Urunler(R.drawable.sweat2,"TRABZONSPOR SWEAT KAPŞONLU 3 İPLIK","₺999.99"));
        urunlist.add(new Urunler(R.drawable.sweat3,"TRABZONSPOR SWEAT KAPŞONLU 3 İPLIK","₺999.99"));
        urunlist.add(new Urunler(R.drawable.eso1,"TRABZONSPOR EŞOFMAN ALT PAÇA RIBANALI FIRÇALI 3 İPLIK","₺949.99"));
        urunlist.add(new Urunler(R.drawable.eso2,"TRABZONSPOR EŞOFMAN ALT PAÇA RIBANALI FIRÇALI 3 İPLIK","₺949.99"));
        urunlist.add(new Urunler(R.drawable.eso3,"TRABZONSPOR EŞOFMAN ALT PAÇA RIBANALI FIRÇALI 3 İPLIK","₺949.99"));
        urunlist.add(new Urunler(R.drawable.eso4,"TRABZONSPOR EŞOFMAN ALT PAÇA RIBANALI FIRÇALI 3 İPLIK","₺949.99"));
        urunlist.add(new Urunler(R.drawable.eso5,"TRABZONSPOR EŞOFMAN ALT PAÇA RIBANALI FIRÇALI 3 İPLIK","₺949.99"));
        urunlist.add(new Urunler(R.drawable.mont1,"TRABZONSPOR MONT SOFTSHELL İKI RENK PARÇALI","₺1,749.99"));
        urunlist.add(new Urunler(R.drawable.mont2,"TRABZONSPOR KOLEJ MONT LOGOLU","₺1,299.99"));
        urunlist.add(new Urunler(R.drawable.mont3,"TRABZONSPOR MONT SOFTSHELL","₺1,749.99"));
    }
}