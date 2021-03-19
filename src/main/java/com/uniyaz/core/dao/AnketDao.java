package com.uniyaz.core.dao;

import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.domain.Soru;
import com.uniyaz.core.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AnketDao extends BaseDao
{
    public AnketDao()
    {
        super(Anket.class);
    }
}
