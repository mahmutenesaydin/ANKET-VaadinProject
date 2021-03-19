package com.uniyaz.core.dao;

import com.uniyaz.core.domain.Kullanici;
import com.uniyaz.core.domain.Soru;
import com.uniyaz.core.domain.Soru;
import com.uniyaz.core.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SoruDao extends BaseDao
{
    public SoruDao() {
        super(Soru.class);
    }

    public List<Soru> findByAnketId(long anketId)
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            String hql =
                    "Select     soru " +
                    "From       Soru soru where anket.id = " + anketId;
            Query query = session.createQuery(hql);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

