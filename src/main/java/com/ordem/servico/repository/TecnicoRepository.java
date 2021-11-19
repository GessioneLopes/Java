package com.ordem.servico.repository;

import com.ordem.servico.dao.GenericDao;
import com.ordem.servico.models.Tecnico;
import java.io.Serializable;
import java.math.BigDecimal;
import org.hibernate.query.Query;

public class TecnicoRepository extends GenericDao<Tecnico> implements Serializable {

    private static final long serialVersionUID = 7959711562795325012L;

    public BigDecimal totalSalarios() {
        var session = factory.openSession();
        session.beginTransaction();
        Query<BigDecimal> query = session.createQuery("SELECT SUM(t.salario) AS TOTAL FROM Tecnico t  ");
        BigDecimal total = query.uniqueResultOptional().orElse(BigDecimal.ZERO);
        session.getTransaction().commit();
        session.close();

        return total;
    }
}
