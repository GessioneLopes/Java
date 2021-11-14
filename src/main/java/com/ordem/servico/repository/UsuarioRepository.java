package com.ordem.servico.repository;

import com.ordem.servico.dao.GenericDao;
import com.ordem.servico.models.Usuario;
import org.hibernate.query.Query;

public class UsuarioRepository extends GenericDao<Usuario> {

    public Usuario login(String user, String senha) {
        try (var s = factory.openSession()) {
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

    public boolean verificaUsuarioEstaBloqueado(String user) {
        boolean permissao = false;

        try (var session = factory.openSession()) {
            session.beginTransaction();

            Query<Usuario> query = session.createQuery("SELECT u FROM Usuario u WHERE u.login = :user");
            query.setParameter("user", user);

            if (query.uniqueResult() != null) {
                if (query.uniqueResult().getStatus().equals("INATIVO")) {
                    permissao = true;
                }
            }

            session.getTransaction().commit();
            return permissao;
        }

    }

    public boolean verificaPermissao(String user) {
        boolean permissao = false;

        try (var session = factory.openSession()) {
            session.beginTransaction();

            Query<Usuario> query = session.createQuery("SELECT u FROM Usuario u WHERE u.login = :user");
            query.setParameter("user", user);

            if (query.uniqueResult().isAdm()) {
                permissao = true;
            }

            session.getTransaction().commit();
            return permissao;
        }

    }
}
