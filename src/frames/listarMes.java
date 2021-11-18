//frame para listar os meses

package frames;

import classesBd.VendasBD;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class listarMes extends javax.swing.JFrame {

    public listarMes() {
        initComponents();
        //assim que você chama esse método ja instacia em vendas
        VendasBD venda = new VendasBD();
        //cria uma lista de string que armazena o nome de todas as tabelas
        List <String> listadetabelas = new ArrayList(venda.consultarTabelas()); //cria uma lista que armazena as tabelas do banco de dados
        
        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(listadetabelas.toArray());
        cbLista.setModel(defaultComboBox); //popula o combobox
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbLista = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Selecione o mês:");

        cbLista.setToolTipText("Selecione o mês:");
        cbLista.setName("Selecione o mês:"); // NOI18N

        jButton1.setText("Selecionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(cbLista, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButton2)))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(cbLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(32, 32, 32))
        );

        cbLista.getAccessibleContext().setAccessibleName("Selecione o mês:");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //pega o valor do combobox e chama o frame de consulta para esse valor
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
      String selecionado = (cbLista.getSelectedItem()).toString();
      consultar consultas = new consultar(selecionado);
      this.setVisible(false);
      consultas.setVisible(true);
      consultas.setLocationRelativeTo(null);
      
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    //botão para voltar uma tela
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        principal voltar = new principal();
        this.setVisible(false);
        voltar.setVisible(true);
        voltar.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    //veio com o frame (Estilo usado no frame)
    public static void main(String args[]) {
        
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(listarMes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listarMes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listarMes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listarMes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listarMes().setVisible(true);
            }
        });
                   
               
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbLista;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
