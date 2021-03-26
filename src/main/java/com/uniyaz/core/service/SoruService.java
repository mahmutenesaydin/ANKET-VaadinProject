package com.uniyaz.core.service;

import com.uniyaz.core.dao.SoruDao;
import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.domain.Soru;

import java.util.List;

public class SoruService extends BaseService<Soru, SoruDao>
{
    SoruDao soruDao = new SoruDao();

    public SoruService() {
        super(SoruDao.class);
    }

    public List<Soru> findAllByAnketId(Long anketId) {
        return soruDao.findByAnketId(anketId);
    }
}
