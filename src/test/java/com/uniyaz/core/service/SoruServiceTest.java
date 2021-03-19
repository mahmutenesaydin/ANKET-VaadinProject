package com.uniyaz.core.service;

import com.uniyaz.core.domain.Soru;
import org.junit.Test;

import java.util.List;

public class SoruServiceTest
{
    @Test
    public void soruEkle()
    {
        Soru soru = new Soru();
        SoruService soruService = new SoruService();
        soruService.save(soru);
    }

    @Test
    public void findAll()
    {
        SoruService soruService = new SoruService();
        List<Soru> soruList = soruService.findAll();
        for (Soru soru : soruList) {
            System.out.println(soru.getSoru());
        }
    }

}