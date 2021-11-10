package com.ordem.servico.repository;

import com.ordem.servico.dao.GenericDao;
import com.ordem.servico.models.Ordem;
import java.io.Serializable;
import org.hibernate.Session;

public class OrdemRepository extends GenericDao<Ordem> implements Serializable {

    public long salvaOrdem(Ordem ordem) {
        Session session = factory.openSession();
        session.beginTransaction();
        var idSalvo = (long) session.save(ordem);
        session.getTransaction().commit();
        session.close();

        return idSalvo;
    }

}
