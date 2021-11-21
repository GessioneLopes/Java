
package com.ordem.servico.repository;

import com.ordem.servico.dao.GenericDao;
import com.ordem.servico.models.Estoque;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class EstoqueRespository extends GenericDao<Estoque>{
    
    public int verificarQtdeEmEstoque(long codProduto) {
        try (Session s = factory.openSession()) {
            s.beginTransaction();
            Query<Estoque> query = s.createQuery("select e from Estoque e where e.id = :cod ", Estoque.class);
           
            query.setParameter("cod", codProduto);
            
            Estoque estoque = query.uniqueResult();
            
            s.getTransaction().commit();
            return estoque.getAtual();
        }
    }
}
