package com.ordem.servico.repository;

import com.ordem.servico.dao.GenericDao;
import com.ordem.servico.models.Equipamento;

public class EquipamentoRepository extends GenericDao<Equipamento> {

    public long salvaEquipamento(Equipamento eqp) {
        var session = factory.openSession();
        session.beginTransaction();
        var idSalvo = (long) session.save(eqp);
        session.getTransaction().commit();
        session.close();

        return idSalvo;
    }
}
