package com.uniyaz.core.service;

import com.uniyaz.core.dao.CevapDao;
import com.uniyaz.core.dao.CevapDao;
import com.uniyaz.core.domain.Cevap;
import com.uniyaz.core.domain.Cevap;

import java.util.List;

public class CevapService extends BaseService<Cevap, CevapDao>
{
    public CevapService() {
        super(CevapDao.class);
    }
}
