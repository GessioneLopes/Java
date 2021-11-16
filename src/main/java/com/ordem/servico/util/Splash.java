package com.ordem.servico.util;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.ordem.servico.models.Cor;
import com.ordem.servico.models.Marca;
import com.ordem.servico.models.Servico;
import com.ordem.servico.models.Usuario;
import com.ordem.servico.repository.CorRepository;
import com.ordem.servico.repository.MarcaRepository;
import com.ordem.servico.repository.ServicoRepository;
import com.ordem.servico.repository.UsuarioRepository;
import com.ordem.servico.telas.TelaLogin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.BindException;
import java.net.ServerSocket;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.UnsupportedLookAndFeelException;

public class Splash extends JWindow {

    private static final long serialVersionUID = 1L;

    private final int duration;

    private Splash(int d) {
        duration = d;
    }

    public void showSplash() {

        JPanel content = (JPanel) getContentPane();
        JProgressBar progress = new JProgressBar();
        progress.setIndeterminate(true);
        progress.setBorderPainted(false);

        content.setBackground(Color.white);
        int width = 780;
        int height = 405;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);
        JLabel label = new JLabel();

        label.setIcon(new ImageIcon(getClass().getResource("/imagens/bg.png")));
        content.add(label, "Center");
        content.add(progress, BorderLayout.SOUTH);

        setVisible(true);

        //-----init hibernate & users default and values------
        createUserDefault();
        createDefaultColors();
        createDefaultMarcas();
        createDefaultService();
        //-----fim update ------

        try {
            Thread.sleep(duration);

        } catch (InterruptedException e) {
        }
        setVisible(false);
    }

    public void showSplashAndExit() {
        showSplash();
        System.exit(0);
    }

    public static void main(String args[]) throws IOException, SQLException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Splash splash = new Splash(1000);
        splash.showSplash();

        try {
            ////Verifica se o sistema ja esta em execução
            @SuppressWarnings("unused")
            ServerSocket socket = null;
            socket = new ServerSocket(2216);

            FlatLightLaf.setup(new FlatIntelliJLaf());

        } catch (BindException e) {
            JOptionPane.showMessageDialog(null, "A aplicação já está em execução!");
            System.exit(0);

        }

        TelaLogin login = new TelaLogin(null, true);
        login.setVisible(true);

    }

    private void createUserDefault() {
        var repository = new UsuarioRepository();
        if (repository.lista(Usuario.class).isEmpty()) {
            repository.saveOrUpdate(new Usuario("admin", "admin", true, "ATIVO"));
        }
    }

    private void createDefaultColors() {
        var repository = new CorRepository();

        if (repository.lista(Cor.class).isEmpty()) {
            var cor1 = new Cor("CINZA");
            var cor2 = new Cor("PRETO");
            var cor3 = new Cor("BRANCO");

            var cores = new ArrayList<Cor>();
            cores.add(cor1);
            cores.add(cor2);
            cores.add(cor3);

            cores.forEach(cor -> {
                repository.saveOrUpdate(cor);
            });
        }
    }

    private void createDefaultMarcas() {
        var repository = new MarcaRepository();
        if (repository.lista(Marca.class).isEmpty()) {
            var m1 = new Marca("APPLE");
            var m2 = new Marca("SAMSUNG");
            var m3 = new Marca("DELL");

            var marcas = new ArrayList<Marca>();
            marcas.add(m1);
            marcas.add(m2);
            marcas.add(m3);

            marcas.forEach(marca -> {
                repository.saveOrUpdate(marca);
            });
        }
    }

    private void createDefaultService() {
        var repository = new ServicoRepository();
        if (repository.lista(Servico.class).isEmpty()) {
            var sv = new Servico();
            sv.setValor(new BigDecimal(25.0));
            sv.setDescricao("SERVIÇO DE AVALIAÇÂO E ORÇAMENTO");
            sv.setDuracao("1 HORA");
            sv.setGarantia("SEM GARANTIA");
            sv.setDetalhe("Avaliação do equipamento");
            sv.setStatus("ATIVO");
            sv.setTecnico(null);
            repository.saveOrUpdate(sv);
        }
    }

}
