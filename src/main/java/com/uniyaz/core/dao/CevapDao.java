package com.uniyaz.core.dao;

import com.uniyaz.core.domain.Cevap;
import com.uniyaz.core.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CevapDao extends BaseDao
{
    public CevapDao() {
        super(Cevap.class);
    }
}
