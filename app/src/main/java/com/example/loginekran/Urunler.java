package com.example.loginekran;

public class Urunler
{
    private int urunresmii;
    private String urunismi,fiyat;

    public Urunler(int urunresmii, String urunismi, String fiyat)
    {
        this.urunresmii = urunresmii;
        this.urunismi = urunismi;
        this.fiyat = fiyat;
    }
    public int getUrunresmii()
    {
        return urunresmii;
    }
    public void setUrunresmii(int urunresmii)
    {
        this.urunresmii = urunresmii;
    }
    public String getUrunismi()
    {
        return urunismi;
    }
    public void setUrunismi(String urunismi)
    {
        this.urunismi = urunismi;
    }
    public String getFiyat()
    {
        return fiyat;
    }
    public void setFiyat(String fiyat)
    {
        this.fiyat = fiyat;
    }
}
