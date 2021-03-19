package com.uniyaz.core.service;

import com.uniyaz.core.domain.Kullanici;
import org.junit.Test;

import java.util.List;

public class KullaniciServiceTest
{
    @Test
    public void kullaniciEkle()
    {
        Kullanici kullanici = new Kullanici();
        KullaniciService kullaniciService = new KullaniciService();
        kullaniciService.save(kullanici);
    }

    @Test
    public void findAll()
    {
        KullaniciService kullaniciService = new KullaniciService();
        List<Kullanici> kullaniciList = kullaniciService.findAll();
        for (Kullanici kullanici : kullaniciList) {
            System.out.println(kullanici.getMail());
        }
    }

}