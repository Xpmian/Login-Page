package com.example.loginekran;

import static android.content.Context.MODE_PRIVATE;
import static android.content.Intent.getIntent;
import static android.content.Intent.getIntentOld;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Profilfrag extends Fragment
{
    TextView tc,sifre;
    String veri1,veri2;
    SQLiteDatabase db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_profilfrag, container, false);
        tc=view.findViewById(R.id.text_tc);
        sifre=view.findViewById(R.id.txt_sifre);

        try
        {
            db=view.getContext().openOrCreateDatabase("Denemee", MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS denemeusers (id INTEGER PRIMARY KEY ,tc VARCHAR, sifre VARCHAR )");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        Intent ii=getActivity().getIntent();
        String un=ii.getStringExtra("nickname");

        Cursor cursor=db.rawQuery("SELECT * FROM denemeusers ",null);
        int tcIndex=cursor.getColumnIndex("tc");
        int sifreIndex=cursor.getColumnIndex("sifre");

        while(cursor.moveToNext())
        {
            String a = cursor.getString(tcIndex);
            String b = cursor.getString(sifreIndex);

            if(a.equals(un))
            {
                tc.setText(a);
                sifre.setText(b);
                break;
            }
        }
        return view;
    }
}