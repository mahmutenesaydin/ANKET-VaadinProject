package com.uniyaz.core.dao;

import com.uniyaz.core.domain.Panel;
import com.uniyaz.core.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class PanelDao extends BaseDao
{
    public PanelDao()
    {
        super(Panel.class);
    }

    public List<Panel> findAllbyAnketID(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            String hql =
                    "Select     panel " +
                    "From       Panel panel "+
                    "Where panel.anket.id='" + id +"'" ;
            Query query = session.createQuery(hql);

            return query.list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
