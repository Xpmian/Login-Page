package com.example.loginekran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button btngir,btnkayit;
    EditText kTc,kSifre;
    String kullaniciTc,kullaniciSifre,usertc2,usersifre;
    int aa;
    int countt;
    Intent i;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kTc=findViewById(R.id.Tctxt);
        kSifre=findViewById(R.id.Sifreeeeeeee);
        btngir=findViewById(R.id.hesapvar);
        btnkayit=findViewById(R.id.buttonkayit);

        try
        {
            db=this.openOrCreateDatabase("Denemee",MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS denemeusers (id INTEGER PRIMARY KEY ,tc VARCHAR, sifre VARCHAR)");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        btnkayit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                countt=1;
                kullaniciTc=kTc.getText().toString();
                kullaniciSifre=kSifre.getText().toString();

                Cursor cursor=db.rawQuery("SELECT * FROM denemeusers ",null);
                int usernameIndex=cursor.getColumnIndex("tc");
                int nameIndex=cursor.getColumnIndex("sifre");

                while(cursor.moveToNext())
                {
                    usertc2 = cursor.getString(usernameIndex);
                    usersifre = cursor.getString(nameIndex);

                    if(usertc2.equals(kullaniciTc))
                    {
                        Toast.makeText(MainActivity.this, "Bu kullanıcı adı alınmış.", Toast.LENGTH_SHORT).show();
                        countt=0;
                    }
                }
                if(kullaniciTc.length()==0 || kullaniciSifre.length()==0 )
                {
                    Toast.makeText(MainActivity.this, "Boş olamaz.", Toast.LENGTH_SHORT).show();

                }
                else if(countt==1)
                {
                    db.execSQL("INSERT INTO denemeusers(tc,sifre) VALUES('"+kullaniciTc+"','"+kullaniciSifre+"')");
                    Toast.makeText(MainActivity.this, "Kayıt başarılı.", Toast.LENGTH_SHORT).show();
                    Intent ii=new Intent(MainActivity.this,MainActivity.class);
                    startActivity(ii);
                }
            }
        });


        btngir.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                kullaniciTc=kTc.getText().toString();
                kullaniciSifre=kSifre.getText().toString();

                if(kullaniciTc.length() == 0 || kullaniciSifre.length() == 0)
                {
                    Toast.makeText(MainActivity.this, "Alanları Doldurunuz", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    aa=1;
                    Cursor cursor=db.rawQuery("SELECT * FROM denemeusers ",null);
                    int usernameIndex=cursor.getColumnIndex("tc");
                    int passwordIndex=cursor.getColumnIndex("sifre");

                    while(cursor.moveToNext())
                    {
                        String a = cursor.getString(usernameIndex);
                        String b = cursor.getString(passwordIndex);

                        if(kullaniciTc.equals(a) && kullaniciSifre.equals(b) )
                        {
                            aa=0;
                            i=new Intent(MainActivity.this,MainActivity2.class);
                            i.putExtra("nickname",a);
                            startActivity(i);
                            finish();
                            break;
                        }
                    }
                    if(aa==1)
                    {
                        Toast.makeText(MainActivity.this, "Hata", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

}