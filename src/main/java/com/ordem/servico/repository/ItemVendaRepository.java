package com.ordem.servico.repository;

import com.ordem.servico.dao.GenericDao;
import com.ordem.servico.models.ItemVenda;
import com.ordem.servico.models.Venda;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ItemVendaRepository extends GenericDao<ItemVenda> {

    public List<ItemVenda> listItemsByVendaID(Venda venda) {
        Session session = factory.openSession();
        session.beginTransaction();
        Query<ItemVenda> query = session.createQuery("SELECT i FROM ItemVenda i WHERE i.venda.id = :idVenda", ItemVenda.class);
        query.setParameter("idVenda", venda.getId());
        List<ItemVenda> itens = query.getResultList();
        session.getTransaction().commit();
        session.close();

        return itens;
    }
}
