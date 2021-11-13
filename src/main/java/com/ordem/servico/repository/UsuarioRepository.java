
package com.ordem.servico.repository;

import com.ordem.servico.dao.GenericDao;
import com.ordem.servico.models.Usuario;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class UsuarioRepository extends GenericDao<Usuario>{
     public Usuario login(String user, String senha) {
        try (Session s = factory.openSession()) {
            s.beginTransaction();

            Query<Usuario> query = s.createQuery("SELECT u"
                    + " FROM Usuario u WHERE u.login = :login"
                    + " AND u.senha = :senha AND u.status = 'ATIVO'", Usuario.class)
                    .setMaxResults(1);

            query.setParameter("login", user);
            query.setParameter("senha", senha);

            s.getTransaction().commit();

            return query.uniqueResult();
        }
    }
}
