package com.ordem.servico.util;

import com.ordem.servico.models.Cliente;
import com.ordem.servico.models.Conta;
import com.ordem.servico.models.Contato;
import com.ordem.servico.models.Cor;
import com.ordem.servico.models.Empresa;
import com.ordem.servico.models.Endereco;
import com.ordem.servico.models.Equipamento;
import com.ordem.servico.models.Estoque;
import com.ordem.servico.models.Fornecedor;
import com.ordem.servico.models.ItemOrdem;
import com.ordem.servico.models.ItemVenda;
import com.ordem.servico.models.Marca;
import com.ordem.servico.models.Ordem;
import com.ordem.servico.models.Produto;
import com.ordem.servico.models.Servico;
import com.ordem.servico.models.Tecnico;
import com.ordem.servico.models.Usuario;
import com.ordem.servico.models.Venda;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    private static final String path = System.getProperty("user.dir") + "\\GDMOS\\BANCO\\osData";

    static {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:hsqldb:file:" + path);
        configuration.setProperty("hibernate.connection.username", "gdmos");
        configuration.setProperty("hibernate.connection.password", "gdmos");
        configuration.setProperty("hibernate.connection.pool_size", "20");
        StandardServiceRegistry registry = (new StandardServiceRegistryBuilder()).configure().applySettings(configuration.getProperties()).build();
        try {
            sessionFactory = (new MetadataSources((ServiceRegistry) registry))
                    .addPackage("com.ordem.servico.models")
                    .addAnnotatedClass(Cliente.class)
                    .addAnnotatedClass(Endereco.class)
                    .addAnnotatedClass(Contato.class)
                    .addAnnotatedClass(Tecnico.class)
                    .addAnnotatedClass(Ordem.class)
                    .addAnnotatedClass(Fornecedor.class)
                    .addAnnotatedClass(Produto.class)
                    .addAnnotatedClass(Estoque.class)
                    .addAnnotatedClass(Equipamento.class)
                    .addAnnotatedClass(Servico.class)
                    .addAnnotatedClass(Cor.class)
                    .addAnnotatedClass(Marca.class)
                    .addAnnotatedClass(ItemOrdem.class)
                    .addAnnotatedClass(Usuario.class)
                    .addAnnotatedClass(Empresa.class)
                    .addAnnotatedClass(Venda.class)
                    .addAnnotatedClass(ItemVenda.class)
                    .addAnnotatedClass(Conta.class)
                    .buildMetadata().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Inicial SessionFactory criafalhou." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getHibernateSessionFactory() {
        return sessionFactory;
    }
}
