package com.uniyaz.core.service;

import com.uniyaz.core.domain.Secenek;
import org.junit.Test;

import java.util.List;

public class SecenekServiceTest
{
    @Test
    public void secenekEkle()
    {
        Secenek secenek = new Secenek();
        SecenekService secenekService = new SecenekService();
        secenekService.save(secenek);
    }

    @Test
    public void findAll()
    {
        SecenekService secenekService = new SecenekService();
        List<Secenek> secenekList = secenekService.findAll();
        for (Secenek secenek : secenekList) {
            System.out.println(secenek.getSecenek());
        }
    }

}