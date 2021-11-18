package com.ordem.servico.util;

import com.ordem.servico.models.Cliente;
import com.ordem.servico.models.Empresa;
import com.ordem.servico.repository.ClienteRepository;
import com.ordem.servico.repository.EmpresaRepository;
import java.awt.Dialog.ModalExclusionType;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.NoResultException;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.type.OrientationEnum;
import net.sf.jasperreports.view.JasperViewer;

public class GeraRelatorioUtil {

    private final Empresa empresa;

    public GeraRelatorioUtil() {
        empresa = new EmpresaRepository().find(Empresa.class, 1L);
    }

    public int geraReletorioOrcamento(long codigo) {
        InputStream rel = this.getClass().getResourceAsStream("/relatorios/ordem_os.jasper");
        try {
            Map<String, Object> params = new HashMap<>();

            params.put("OSNR", codigo);
            params.put("TIPO_DOCUMENTO", "ORDEM ORÇAMENTO N°:");

            if (empresa != null) {
                params.put("EMPRESA_CONTATOS", empresa.getContato().getCelular() + "\n"
                        + empresa.getContato().getEmail());

                params.put("EMPRESA_ENDERECO", empresa.getEndereco().getLogradouro() + " - "
                        + empresa.getEndereco().getNumero()
                        + "\n" + empresa.getEndereco().getCidade() + " - "
                        + empresa.getEndereco().getUf());
            } else {
                params.put("EMPRESA_CONTATOS", "Cadastre os dados da empresa");
                params.put("EMPRESA_ENDERECO", "Em configurações - Cadastre os dados da empresa");
            }

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
            params.put("TIPO_DOCUMENTO", "ORDEM DE SERVIÇO N°:");
            params.put("EMPRESA_CONTATOS", empresa.getContato().getCelular() + "\n" + empresa.getContato().getEmail());
            params.put("EMPRESA_ENDERECO", empresa.getEndereco().getLogradouro() + "\n" + empresa.getEndereco().getCidade());

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

    public void geraRecibo(String valor, String obs, String nomeCliente, String nrOrdem) {
        InputStream rel = this.getClass().getResourceAsStream("/relatorios/recibo.jasper");
        try {
            Map<String, Object> params = new HashMap<>();

            params.put("VALOR", valor);
            params.put("OBS", obs);
            params.put("CLIENTE", nomeCliente);
            params.put("ORDEM", nrOrdem);

            JasperPrint jasperPrint = JasperFillManager.fillReport(rel, params, getConexao());
            jasperPrint.setOrientation(OrientationEnum.PORTRAIT);
            JasperViewer jv = new JasperViewer(jasperPrint, false);

            jv.setFitPageZoomRatio();
            jv.setFitWidthZoomRatio();

            jv.setTitle("Recido");

            jv.setVisible(true);
            jv.toFront();

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "\n" + e.getCause());

        }
    }

    public void geraReletorioVendasEfetuadas(long codigoVenda, long codCliente) {
        InputStream rel = this.getClass().getResourceAsStream("/relatorios/Danfe.jasper");
        try {
            Map<String, Object> params = new HashMap<>();

            var emp = new EmpresaRepository().find(Empresa.class, 1L);

            params.put("nomeEmpresa", emp.getNomeEmpresa());
            params.put("codigo", codigoVenda);
            params.put("logo", emp.getLogo());

            //dados do cliente
            try {
                if (codCliente != 0L) {
                    params.put("nomeCliente", new ClienteRepository()
                            .find(Cliente.class, codCliente)
                            .getNome()
                            .toUpperCase());
                }
            } catch (NoResultException e) {
                params.put("nomeCliente", "Cliente não informado");
            }
 
            JasperPrint jasperPrint = JasperFillManager.fillReport(rel, params, getConexao());
            jasperPrint.setOrientation(OrientationEnum.LANDSCAPE);
            JasperViewer j = new JasperViewer(jasperPrint, false);
           
            j.setAlwaysOnTop(true);
            j.setTitle("Venda");
            j.setVisible(true);

            j.setFitPageZoomRatio();
            j.setFitWidthZoomRatio();

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

}
