package com.uniyaz.core.service;

import com.uniyaz.core.domain.Anket;
import org.junit.Test;

import java.util.List;

public class AnketServiceTest
{
    @Test
    public void anketEkle()
    {
        Anket anket = new Anket();
        AnketService anketService = new AnketService();
        anketService.save(anket);
    }

    @Test
    public void findAll()
    {
        AnketService anketService = new AnketService();
        List<Anket> anketList = anketService.findAll();
        for (Anket anket : anketList) {
            System.out.println(anket.getAd());
        }
    }

}