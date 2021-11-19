package com.ordem.servico.telas;

import com.ordem.servico.models.Empresa;
import com.ordem.servico.models.ItemVenda;
import com.ordem.servico.models.Produto;
import com.ordem.servico.models.Venda;
import com.ordem.servico.repository.EmpresaRepository;
import com.ordem.servico.repository.ItemVendaRepository;
import com.ordem.servico.repository.ProdutoRepository;
import com.ordem.servico.repository.VendaRepository;
import com.ordem.servico.util.DataHora;
import com.ordem.servico.util.FormasPgto;
import com.ordem.servico.util.RetornoUpdate;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class TelaFinalizaVenda extends javax.swing.JDialog {

    private final Venda venda;
    private final RetornoUpdate retornoUpdate;

    public boolean printCupom = false;
    private StringBuilder txtcupom;

    public TelaFinalizaVenda(java.awt.Frame parent, boolean modal, Venda venda, TelaMinhasVendas minhasVendas) {
        super(parent, modal);
        initComponents();

        retornoUpdate = minhasVendas;
        this.txtcupom = new StringBuilder();

        this.venda = venda;
        txtTotal.setValue(venda.getTotal());
        carregaTipoPgtos();
    }

    public TelaFinalizaVenda(java.awt.Frame parent, boolean modal, Venda venda) {
        super(parent, modal);
        initComponents();

        retornoUpdate = null;
        this.txtcupom = new StringBuilder();

        this.venda = venda;
        txtTotal.setValue(venda.getTotal());
        carregaTipoPgtos();
    }

    private void carregaTipoPgtos() {
        var status = FormasPgto.values();

        var model = new DefaultComboBoxModel();
        for (FormasPgto fms : status) {
            model.addElement(fms.name());
        }
        txtTipoPgto.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTotal = new javax.swing.JFormattedTextField();
        txtTipoPgto = new javax.swing.JComboBox<>();
        txtObs = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDesconto = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 51));
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTotal.setEditable(false);
        txtTotal.setForeground(new java.awt.Color(255, 102, 0));
        txtTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 320, 34));

        txtTipoPgto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(txtTipoPgto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 150, 34));
        getContentPane().add(txtObs, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 320, 32));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jButton1.setText("Finalizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 320, 34));

        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Observação:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 80, -1));

        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Forma Pagamento:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        txtDesconto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtDesconto.setValue(BigDecimal.ZERO
        );
        getContentPane().add(txtDesconto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 160, 33));

        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Desconto:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, 20));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bgpdv3.png"))); // NOI18N
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        var vendaRepository = new VendaRepository();

        venda.setFormaPgto(FormasPgto.valueOf(txtTipoPgto.getSelectedItem().toString()));
        venda.setObs(txtObs.getText());
        venda.setResponsavel(MainApp.txtUserLogado.getText());
        venda.setDesconto(new BigDecimal(String.valueOf(txtDesconto.getValue())));
        venda.setHora(new DataHora().ler_hora());
        venda.setTotal(new BigDecimal(String.valueOf(txtTotal.getValue())).subtract(venda.getDesconto()));

        System.out.println("os list finalize " + venda.getItens().size());

        venda.setId(vendaRepository.salvaVenda(venda));

        //update estoque
        var repo = new ProdutoRepository();
        venda.getItens().forEach(it -> {
            var produto = repo.find(Produto.class, it.getCodigo_interno());
            
            System.out.println(it.getDescr());

            //vem itens produtos e serviços. Quando serviço produto = null
            if (produto != null) {
                int qtdeAtual = produto.getEstoque().getAtual();
                produto.getEstoque().setAtual(qtdeAtual - it.getQtde());
                repo.saveOrUpdate(produto);
            }
        });

        if (retornoUpdate != null) {
            retornoUpdate.update(venda);
        }

        if (printCupom == true) {
            geraCupomNaoFiscalTextAreaParcial(venda);
            geraCupomNaoFiscal();
            System.out.println("print..");
        }

        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void geraCupomNaoFiscalTextAreaParcial(Venda vendaNr) {

        NumberFormat format = new DecimalFormat("#,##0.00");
        var empresa = new EmpresaRepository().find(Empresa.class, 1L);
        var listaItens = new ItemVendaRepository().listItemsByVendaID(venda);

        txtcupom.append("=============================================\n");
        txtcupom.append(""
                + empresa.getNomeEmpresa() + "\n"
                + empresa.getEndereco().getLogradouro() + " " + empresa.getEndereco().getNumero() + "\n"
                + empresa.getContato().getCelular() + "     "
                + "Vend: " + venda.getResponsavel() + " Venda: " + vendaNr.getId() + "\n");
        txtcupom.append("=============================================\n");
        txtcupom.append("********** NAO E DOCUMENTO FISCAL **********\n");
        txtcupom.append("=============================================\n");
        txtcupom.append("#  PRODUTOS DA VENDA                        \n");
        txtcupom.append("---------------------------------------------\n");
        for (ItemVenda item : listaItens) {

            txtcupom.append(String.format("%1$-6s %2$-30s",
                    item.getCodigo_interno(),
                    item.getDescr()));
            txtcupom.append("\n");
            txtcupom.append(String.format("%1$-3s %2$-12s %3$-25s",
                    "Qtde: " + item.getQtde(),
                    "Unt " + item.getPrecoUnit(),
                    "Total " + item.getSubtotal()));
            txtcupom.append("\n");
        }
        txtcupom.append("=============================================\n");
        txtcupom.append("   INFORMACOES PARA FECHAMENTO DE CONTA    \n");
        txtcupom.append("=============================================\n");
        txtcupom.append(String.format(" DATA: %1s %2s               \n",
                new DataHora().ler_Data(), new DataHora().ler_hora()));
        txtcupom.append("=============================================\n");
        txtcupom.append("SubTotal                       R$ ").append(format.format(venda.getTotal().add(venda.getDesconto()))).append("\n");

        txtcupom.append("=============================================\n");
        txtcupom.append("Desconto Total                 R$ ").append(format.format(venda.getDesconto())).append("\n");
        txtcupom.append("                   --------------------------\n");
        txtcupom.append("Total                          R$ ").append(format.format(venda.getTotal())).append("\n");
        txtcupom.append("=============================================\n\n");
        txtcupom.append("Ass. Cliente:________________________________\n\n");
        txtcupom.append("---------------------------------------------\n\n");
        txtcupom.append("         OBRIGADO. E VOLTE SEMPRE!         \n");
        txtcupom.append("   INFORMACOES PARA FECHAMENTO DE CONTA    \n\n\n");
        txtcupom.append("---------------------------------------------\n\n\n\n\n\n-");

        //codigo para impressora cortar papel
        char[] cortePapel = new char[]{0x1d, 'V', 1};
        txtcupom.append(new String(cortePapel));

    }

    public void geraCupomNaoFiscal() {
        try {
            File arquivo = new File("C:\\GDMOS\\cupom.txt");
            if (arquivo.exists()) {

                arquivo.delete();
                arquivo.createNewFile();
                //se existir
                FileWriter arquivoTxt = new FileWriter(arquivo, true);
                PrintWriter linhasTxt = new PrintWriter(arquivoTxt);

                String[] lines = txtcupom.toString().replaceAll("Ç", "C")
                        .replace("Ã", "A").split("\n");

                for (String line : lines) {
                    linhasTxt.println(line);
                }

                arquivoTxt.flush();
                linhasTxt.flush();
                arquivoTxt.close();
                linhasTxt.close();

            } else {
                //se naum existir
                new File("C:\\GDMOS").mkdirs();
                arquivo.createNewFile();

                FileWriter arquivoTxt = new FileWriter(arquivo, true);
                PrintWriter linhasTxt = new PrintWriter(arquivoTxt);

                String[] lines = txtcupom.toString().replaceAll("Ç", "C")
                        .replace("Ã", "A").split("\n");

                for (String line : lines) {
                    linhasTxt.println(line);
                }

                arquivoTxt.flush();
                arquivoTxt.close();
                linhasTxt.close();

            }
        } catch (IOException error) {
            System.out.println("nao encontrei arquivo");
        }

        try {
            PrintService ps = PrintServiceLookup.lookupDefaultPrintService();
            DocPrintJob job = ps.createPrintJob();

            job.addPrintJobListener(new PrintJobAdapter() {
                @Override
                public void printDataTransferCompleted(PrintJobEvent event) {
                    System.out.println("Impressão completa..");
                }

                @Override
                public void printJobNoMoreEvents(PrintJobEvent event) {
                    System.out.println("Sem eventos de impressão");
                }
            });

            FileInputStream fis = new FileInputStream("C:\\GDMOS\\cupom.txt");

            Doc doc = new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
            PrintRequestAttributeSet attrib = new HashPrintRequestAttributeSet();
            attrib.add(new Copies(1));
            job.print(doc, attrib);

            fis.close();

            try {
                Path path = Paths.get("C:\\GDMOS\\cupom.txt");
                Files.deleteIfExists(path);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (PrintException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao imprimir cupom.");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JFormattedTextField txtDesconto;
    public javax.swing.JTextField txtObs;
    private javax.swing.JComboBox<String> txtTipoPgto;
    public javax.swing.JFormattedTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
