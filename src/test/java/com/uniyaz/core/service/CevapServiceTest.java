package com.uniyaz.core.service;

import com.uniyaz.core.domain.Cevap;
import org.junit.Test;

import java.util.List;

public class CevapServiceTest
{
    @Test
    public void cevapEkle()
    {
        Cevap cevap = new Cevap();
        CevapService cevapService = new CevapService();
        cevapService.save(cevap);
    }

    @Test
    public void findAll()
    {
        CevapService cevapService = new CevapService();
        List<Cevap> cevapList = cevapService.findAll();
        for (Cevap cevap : cevapList) {
            System.out.println(cevap.getCevap());
        }
    }

}