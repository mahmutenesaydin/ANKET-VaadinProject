package com.uniyaz.core.service;

import com.uniyaz.core.dao.AnketDao;
import com.uniyaz.core.dao.CevapDao;
import com.uniyaz.core.dao.KullaniciDao;
import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.domain.Cevap;
import com.uniyaz.core.domain.Kullanici;

import java.util.List;

public class KullaniciService extends BaseService<Kullanici, KullaniciDao>
{
    public KullaniciService() {
        super(KullaniciDao.class);
    }
}
