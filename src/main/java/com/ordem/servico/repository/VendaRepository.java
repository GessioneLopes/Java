package com.ordem.servico.repository;

import com.ordem.servico.dao.GenericDao;
import com.ordem.servico.models.Venda;

public class VendaRepository extends GenericDao<Venda> {

    public long salvaVenda(Venda venda) {
        var session = factory.openSession();
        session.beginTransaction();
        var idSalvo = (long) session.save(venda);
        session.getTransaction().commit();
        session.close();

        return idSalvo;
    }
}
