package com.ordem.servico.repository;

import com.ordem.servico.dao.GenericDao;
import com.ordem.servico.models.Cor;
import javax.persistence.TypedQuery;
import org.hibernate.Session;

public class CorRepository extends GenericDao<Cor> {

     public Cor getByNome(String nome) {
        Session session = factory.openSession();
        session.beginTransaction();
        TypedQuery<Cor> query = session.createQuery("SELECT c FROM Cor c WHERE c.cor = :cor", Cor.class);
       
        query.setMaxResults(1);
        query.setParameter("cor", nome);
        
        var cor = query.getSingleResult();
        
        session.getTransaction().commit();
        session.close();

        return cor;
    }
}
