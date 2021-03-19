package com.uniyaz.core.service;

import com.uniyaz.core.dao.SecenekDao;
import com.uniyaz.core.dao.SoruDao;
import com.uniyaz.core.domain.Secenek;
import com.uniyaz.core.domain.Soru;

import java.util.List;

public class SecenekService extends BaseService<Secenek, SecenekDao>
{
    public SecenekService() {
        super(SecenekDao.class);
    }
}
