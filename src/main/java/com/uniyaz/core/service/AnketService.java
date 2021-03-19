package com.uniyaz.core.service;

import com.uniyaz.core.dao.AnketDao;
import com.uniyaz.core.domain.Anket;

import java.util.List;

public class AnketService extends BaseService<Anket, AnketDao>
{
    public AnketService()
    {
       super(AnketDao.class);
    }
}