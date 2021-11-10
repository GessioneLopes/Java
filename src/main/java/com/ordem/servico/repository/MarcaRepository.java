package com.ordem.servico.repository;

import com.ordem.servico.dao.GenericDao;
import com.ordem.servico.models.Marca;
import javax.persistence.TypedQuery;
import org.hibernate.Session;

public class MarcaRepository extends GenericDao<Marca> {

    public Marca getByNome(String nome) {
        Session session = factory.openSession();
        session.beginTransaction();
        TypedQuery<Marca> query = session.createQuery("SELECT m FROM Marca m WHERE m.marca = :marca", Marca.class);
       
        query.setMaxResults(1);
        query.setParameter("marca", nome);
        
        var marca = query.getSingleResult();
        
        session.getTransaction().commit();
        session.close();

        return marca;
    }

}
