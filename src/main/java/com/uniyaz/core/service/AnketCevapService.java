package com.uniyaz.core.service;

import com.uniyaz.core.dao.AnketCevapDao;
import com.uniyaz.core.dao.AnketDao;
import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.domain.AnketCevap;

public class AnketCevapService extends BaseService<AnketCevap, AnketCevapDao>
{
    public AnketCevapService()
    {
       super(AnketCevapDao.class);
    }
}