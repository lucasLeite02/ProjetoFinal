// frame com as vendas de determinada tabela

package frames;

import classes.Vendas;
import classesBd.VendasBD;
import connectionFactory.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.runtime.Context;


public class consultar extends javax.swing.JFrame {

    String nomeTabela = null;
    
    public consultar(String nomeTab) {
        nomeTabela = nomeTab;
        initComponents();
        DefaultTableModel jVendas = (DefaultTableModel) tabela1.getModel(); //cria um modelo de tabelas padrão*****
        read();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela1 = new javax.swing.JTable();
        btnBuscarVendas = new javax.swing.JButton();
        btnDeletarVenda = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnRelatorio = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_pesquisar = new javax.swing.JTextPane();
        btn_pesquisar = new javax.swing.JButton();
        dropTable = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setBackground(new java.awt.Color(206, 217, 212));
        jInternalFrame1.setBorder(null);
        jInternalFrame1.setForeground(new java.awt.Color(206, 217, 212));
        jInternalFrame1.setVisible(true);

        tabela1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "data", "cliente", "valor bruto", "comissão", "Tipo Pag", "Valor Liquido", "Comissao Venda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela1.setColumnSelectionAllowed(true);
        tabela1.getTableHeader().setReorderingAllowed(false);
        tabela1.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                tabela1HierarchyChanged(evt);
            }
        });
        tabela1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                tabela1AncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tabela1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tabela1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tabela1MouseExited(evt);
            }
        });
        tabela1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tabela1InputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        tabela1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabela1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tabela1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tabela1);
        tabela1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnBuscarVendas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBuscarVendas.setText("Atualizar");
        btnBuscarVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVendasActionPerformed(evt);
            }
        });

        btnDeletarVenda.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDeletarVenda.setText("Deletar Venda");
        btnDeletarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarVendaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("RELATÓRIO DE VENDAS NO PERÍODO");

        jButton2.setText("Deletar tudo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnFechar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnRelatorio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRelatorio.setText("Relatório");
        btnRelatorio.setActionCommand("");
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Inserir Venda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txt_pesquisar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txt_pesquisarPropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(txt_pesquisar);

        btn_pesquisar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_pesquisar.setText("Pesquisar (nome)");
        btn_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisarActionPerformed(evt);
            }
        });

        dropTable.setBackground(new java.awt.Color(255, 0, 0));
        dropTable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dropTable.setText("Deletar Tabela");
        dropTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(btnBuscarVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletarVenda))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_pesquisar)))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dropTable))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(0, 142, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(280, 280, 280)
                        .addComponent(jButton2)))
                .addContainerGap())
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jButton2)
                        .addComponent(btn_pesquisar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dropTable, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 74, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //botão para cadastrar nova venda (quando clica abre o frame cadastro)
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        cadastro c1 = new cadastro(nomeTabela);
        c1.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed
       //botão para abrir o relatório de vendas
    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
     
    relatorio r1 = new relatorio(nomeTabela);
    r1.setVisible(true);    
     
    }//GEN-LAST:event_btnRelatorioActionPerformed

    //voltar para a tela inicial (onde escolhe as tabelas)
    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed

        principal voltar = new principal();
        this.setVisible(false);
        voltar.setVisible(true);
        voltar.setLocationRelativeTo(null);

    }//GEN-LAST:event_btnFecharActionPerformed

    //botão que deleta todas as vendas da tabela atual
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente deletar todas as vendas? (essa ação não poderá ser desfeita)");
        if (resposta != 0) {
            return;
        }

        JOptionPane.showMessageDialog(null, "TODAS VENDAS FORAM APAGADAS!");

        VendasBD v1 = new VendasBD();
        v1.deleteAll(nomeTabela);

        read();
    }//GEN-LAST:event_jButton2ActionPerformed

    //deletar uma venda expecífica
    private void btnDeletarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarVendaActionPerformed
        //pede o id da venda
        String resposta = JOptionPane.showInputDialog(null, "Digite o ID da venda que deseja excluir");
           //cria um objeto das vendas
        Vendas v1 = new Vendas();
        //passa o id para esse objeto
        v1.setId(Integer.parseInt(resposta));
        
        //estancia um objeto de vendas
        VendasBD v2 = new VendasBD();
        
        //confirma se deseja mesmo excluir
        int resposta2 = JOptionPane.showConfirmDialog(null, "Deseja realmente deletar a venda?");
        if (resposta2 != 0) {
            return;
        }
        //método para deletar a venda
        v2.delete(v1, nomeTabela);

        read(); //método que consulta as vendas da tabela atual

        JOptionPane.showMessageDialog(null, "A VENDA FOI APAGADA!");
    }//GEN-LAST:event_btnDeletarVendaActionPerformed

    //botão que atualiza a tabela (F5)
    private void btnBuscarVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVendasActionPerformed

       read();

    }//GEN-LAST:event_btnBuscarVendasActionPerformed
    
    //tentativa e erro (obs, não é possível tirar esses métodos)
    
    private void tabela1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabela1KeyTyped

    }//GEN-LAST:event_tabela1KeyTyped

    private void tabela1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabela1KeyReleased

    }//GEN-LAST:event_tabela1KeyReleased

    private void tabela1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tabela1InputMethodTextChanged

    }//GEN-LAST:event_tabela1InputMethodTextChanged

    private void tabela1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_tabela1MouseExited

    //metodo para editar um dado da venda *****
    private void tabela1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela1MouseClicked

        int row = tabela1.getSelectedRow();  //criando variável da linha e coluna para update
        int col = tabela1.getSelectedColumn();

        String nomeColuna = tabela1.getColumnName(col); //pega o nome da coluna para poder alterar no bd

        String valor = ""; 
           // alteração da forma de pagamento
        if (col == 5) {

            int resp = 0;
            resp = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite qual opção desejada:  \n 1-Débito: \n 2-Parcelado: \n 3-Dinheiro/Transferência:"));

            if (resp == 1) {
                valor = "débito";
            }
            if (resp == 2) {
                valor = "parcelado";
            }
            if (resp > 2 || resp < 0) {
                valor = "dinheiro/trasnferência";
            }

        }
        if (col != 5) {
            valor = JOptionPane.showInputDialog(null, "Digite a alteração:");
        }

        JOptionPane.showMessageDialog(null, valor); //mostrando mensagem na tela para confirmar alteração
        String id0 = tabela1.getValueAt(row, 0).toString(); 
        Integer id = Integer.parseInt(id0);

        Vendas v1 = new Vendas();
        VendasBD v2 = new VendasBD();

        v1.setId(id);
          
        //alteração de data diretamente pelo planilha do console
        if (nomeColuna.equalsIgnoreCase("data")) {
            v1.setData(valor);
               
            //Query usada no update que foi feito
            String sql = "UPDATE `projetofinal`.`"+nomeTabela+"` SET `data`='" + v1.getData().toUpperCase() + "' WHERE `id`='" + v1.getId() + "';";
            Connection conn = ConnectionFactory.getConnection(); //criando conexão para comitar a alteração no banco de dados

            try {
                if (v1.getId() != null || v1 != null) {
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(sql);
                    ConnectionFactory.close(conn, stmt);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if (nomeColuna.equalsIgnoreCase("cliente")) { //alteração do campo cliente
            v1.setCliente(valor);
               
            //Query usada para alteração no banco de dados
            String sql = "UPDATE `projetofinal`.`"+nomeTabela+"` SET `cliente`='" + v1.getCliente().toUpperCase() + "' WHERE `id`='" + v1.getId() + "';";
            Connection conn = ConnectionFactory.getConnection(); // conexação para commitar a alteração no bd

            try {
                if (v1.getId() != null || v1 != null) {
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(sql);
                    ConnectionFactory.close(conn, stmt);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if (nomeColuna.equalsIgnoreCase("valor bruto")) { // alteração do valor bruto na tabela do frame
            v1.setValorBruto(Double.parseDouble(valor));
            v1.setComissao(Double.parseDouble(tabela1.getValueAt(row, 4).toString()));
            v2.calcular(v1);
                        
            String sql = "UPDATE `projetofinal`.`"+nomeTabela+"` SET `valorBruto`='" + v1.getValorBruto()+"',`valorLiquido`='"+v1.getValorliquido()+"', `comissaoVenda`='"+v1.getComissaoVenda()+"' WHERE `id`='" + v1.getId() + "';";
            Connection conn = ConnectionFactory.getConnection();

            try {
                if (v1.getId() != null || v1 != null) {
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(sql);
                    ConnectionFactory.close(conn, stmt);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        //função para alteração da função
        if (nomeColuna.equalsIgnoreCase("comissão")) {
            v1.setComissao(Double.parseDouble(valor));
            v1.setValorBruto(Double.parseDouble(tabela1.getValueAt(row, 3).toString()));
            v2.calcular(v1);

            String sql = "UPDATE `projetofinal`.`"+nomeTabela+"` SET `comissao`='" + v1.getComissao()+"',`valorLiquido`='"+v1.getValorliquido()+"', `comissaoVenda`='"+v1.getComissaoVenda()+"' WHERE `id`='" + v1.getId() + "';";
            Connection conn = ConnectionFactory.getConnection();

            try {
                if (v1.getId() != null || v1 != null) {
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(sql);
                    ConnectionFactory.close(conn, stmt);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        //alteração de pagamento diretamente no frame
        if (nomeColuna.equalsIgnoreCase("tipo pag")) {
            v1.setTipoPag(valor);

            String sql = "UPDATE `projetofinal`.`"+nomeTabela+"` SET `tipoPag`='" + v1.getTipoPag().toUpperCase()+"' WHERE `id`='" + v1.getId() + "';";
            Connection conn = ConnectionFactory.getConnection();

            try {
                if (v1.getId() != null || v1 != null) {
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(sql);
                    ConnectionFactory.close(conn, stmt);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }       
        read();
        
    }//GEN-LAST:event_tabela1MouseClicked

    private void tabela1HierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_tabela1HierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tabela1HierarchyChanged

    private void tabela1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tabela1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tabela1AncestorAdded

      //botão para pesquisar por nome
    private void btn_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisarActionPerformed
     
        String pesquisa = txt_pesquisar.getText(); //pegando o texto do campo txt_pesquisar
                
        DefaultTableModel jVendas = (DefaultTableModel) tabela1.getModel(); //estancia para poder alterar a tabela
        jVendas.setNumRows(0); //exclui todas as linhas

        for (Vendas v : VendasBD.pesquisarRegistros(pesquisa, nomeTabela)) {
            //repopula a tabela com o nome que foi passado em txt_pesquisar
            jVendas.addRow(new Object[]{
                v.getId(),
                v.getData(),
                v.getCliente(),
                v.getValorBruto(),
                v.getComissao(),
                v.getTipoPag(),
                v.getValorliquido(),
                v.getComissaoVenda()

            });

        }
        
    }//GEN-LAST:event_btn_pesquisarActionPerformed

    private void tabela1AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tabela1AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tabela1AncestorMoved

    //função criada para o botão excluir tudo
    private void dropTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropTableActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Realmente deseja excluir toda a tabela?");
        if(resposta != 0){
            return;
        }
        VendasBD venda = new VendasBD();
        try { 
            //throw new SQLException();
               venda.deletarTabela(nomeTabela);
               JOptionPane.showMessageDialog(null, "Tabela Excluida");


        }catch(Exception e ){
            String ex = e.getMessage();
            JOptionPane.showMessageDialog(null, "Error " + ex);
        }
        btnFecharActionPerformed(evt);
        
        
        
    }//GEN-LAST:event_dropTableActionPerformed

    
    private void txt_pesquisarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txt_pesquisarPropertyChange
     
            
    }//GEN-LAST:event_txt_pesquisarPropertyChange
    //metodo read para apresentar o conteúdo na tabela do frame inicial
    
    //metodo para apresentar todo o conteúdo de uma query na tabela do frame (select *)
    public void read() {
        DefaultTableModel jVendas = (DefaultTableModel) tabela1.getModel();
        jVendas.setNumRows(0);
                VendasBD v1 = new VendasBD();

        for (Vendas v : v1.selectAll(nomeTabela)) {

            jVendas.addRow(new Object[]{
                v.getId(),
                v.getData(),
                v.getCliente(),
                v.getValorBruto(),
                v.getComissao(),
                v.getTipoPag(),
                v.getValorliquido(),
                v.getComissaoVenda()

            });

        }
    }



    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarVendas;
    private javax.swing.JButton btnDeletarVenda;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JButton btn_pesquisar;
    private javax.swing.JButton dropTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tabela1;
    private javax.swing.JTextPane txt_pesquisar;
    // End of variables declaration//GEN-END:variables
}
