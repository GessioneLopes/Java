package com.ordem.servico.repository;

import com.ordem.servico.dao.GenericDao;
import com.ordem.servico.models.Produto;
import java.io.Serializable;
import javax.persistence.TypedQuery;
import org.hibernate.Session;

public class ProdutoRepository extends GenericDao<Produto> implements Serializable {

    public Produto findByCodBarAndId(Long id, String codbar) {
        Session s = factory.openSession();
        s.beginTransaction();
        TypedQuery<Produto> query = s.createQuery("SELECT p FROM Produto p WHERE p.codigo = :id OR p.codbar = :bar", Produto.class);
        query.setParameter("id", id);
        query.setParameter("bar", codbar);
        var tipo = query.getSingleResult();
        s.getTransaction().commit();
        s.close();

        return tipo;
    }
}
