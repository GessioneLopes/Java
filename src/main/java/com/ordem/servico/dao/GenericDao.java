package com.ordem.servico.dao;

import com.ordem.servico.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class GenericDao<T> {

    protected final SessionFactory factory = HibernateUtil.getHibernateSessionFactory();

    public void saveOrUpdate(T obj) {
        try (Session s = factory.openSession()) {
            s.beginTransaction();
            s.saveOrUpdate(obj);
            s.getTransaction().commit();
        }

    }

    public List<T> lista(Class<T> clazz) {
        try (Session s = factory.openSession()) {
            s.beginTransaction();
            List lista = s.createQuery("FROM " + clazz.getName()).getResultList();
            s.getTransaction().commit();
            return lista;
        }
    }

    public void delete(T o) {
        try (Session s = factory.openSession()) {
            s.beginTransaction();
            s.remove(o);
            s.getTransaction().commit();
        }
    }

    public void deleteById(Class<T> c, long o) {
        try (Session s = factory.openSession()) {
            s.beginTransaction();
            s.remove(s.get(c, o));
            s.getTransaction().commit();
        }
    }

    public T find(Class<T> clazz, Long id) {
        Session s = factory.openSession();
        s.beginTransaction();
        T tipo = s.get(clazz, id);
        s.getTransaction().commit();
        s.close();

        return tipo;
    }
}
