package com.ordem.servico.repository;

import com.ordem.servico.dao.GenericDao;
import com.ordem.servico.models.Venda;
import java.math.BigDecimal;
import org.hibernate.query.Query;

public class VendaRepository extends GenericDao<Venda> {

    public long salvaVenda(Venda venda) {
        var session = factory.openSession();
        session.beginTransaction();
        var idSalvo = (long) session.save(venda);
        session.getTransaction().commit();
        session.close();

        return idSalvo;
    }

    public BigDecimal totalVendas() {
        var session = factory.openSession();
        session.beginTransaction();
        Query<BigDecimal> query = session.createQuery("SELECT SUM(v.total) AS TOTAL FROM Venda v ");
        BigDecimal total = query.uniqueResultOptional().orElse(BigDecimal.ZERO);
        session.getTransaction().commit();
        session.close();

        return total;
    }

}
