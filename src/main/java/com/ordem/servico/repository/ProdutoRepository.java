package com.ordem.servico.repository;

import com.ordem.servico.dao.GenericDao;
import com.ordem.servico.models.Produto;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ProdutoRepository extends GenericDao<Produto> implements Serializable {

    public Produto findByCodBarAndId(Long id, String codbar) {
        Session s = factory.openSession();
        s.beginTransaction();
        
        Query<Produto> query = s.createQuery("SELECT p FROM Produto p WHERE p.codigo = :id or p.codbar = :codebar", Produto.class);
        query.setParameter("id", id);
        query.setParameter("codebar", codbar);
        Produto tipo = query.getSingleResult();
        s.getTransaction().commit();
        s.close();

        return tipo;
    }
}
