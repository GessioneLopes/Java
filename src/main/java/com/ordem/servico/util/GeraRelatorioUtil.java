package com.ordem.servico.util;

import java.awt.Dialog.ModalExclusionType;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.type.OrientationEnum;
import net.sf.jasperreports.view.JasperViewer;

public class GeraRelatorioUtil {

    public GeraRelatorioUtil() {
    }

    public int geraReletorioOrcamento(long codigo) {
        InputStream rel = this.getClass().getResourceAsStream("/relatorios/ordem_os.jasper");
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("OSNR", codigo);

            // params.put("ORCAMENTO", "ORÇAMENTO");
            JasperPrint jasperPrint = JasperFillManager.fillReport(rel, params, getConexao());
            jasperPrint.setOrientation(OrientationEnum.PORTRAIT);
            JasperViewer jv = new JasperViewer(jasperPrint, false);

            jv.setTitle("ORÇAMENTO N° " + codigo);

            jv.setFitPageZoomRatio();
            jv.setFitWidthZoomRatio();

            jv.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
            jv.setVisible(true);

            return 1;

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "\n" + e.getCause());
            return 0;
        }

    }

    public Connection getConexao() {
        Connection conexao = null;
        final String path = System.getProperty("user.dir") + "\\GDMOS\\BANCO\\osData";

        if (conexao == null) {
            try {
                Class.forName("org.hsqldb.jdbcDriver");
                conexao = DriverManager.getConnection("jdbc:hsqldb:file:" + path, "gdmos", "gdmos");

            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Erro na conexão com banco de dados: " + ex.getMessage());
            }
        }
        return conexao;
    }

    public void geraViaOrdemServico(long osnr) {
        InputStream rel = this.getClass().getResourceAsStream("/relatorios/ordem_os.jasper");
        try {
            Map<String, Object> params = new HashMap<>();

            params.put("OSNR", osnr);

            JasperPrint jasperPrint = JasperFillManager.fillReport(rel, params, getConexao());
            jasperPrint.setOrientation(OrientationEnum.PORTRAIT);
            JasperViewer jv = new JasperViewer(jasperPrint, false);

            jv.setFitPageZoomRatio();
            jv.setFitWidthZoomRatio();

            jv.setTitle("OS");

            jv.setVisible(true);
            jv.toFront();

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "\n" + e.getCause());

        }
    }

}
