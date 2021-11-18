//frame principal, o primeiro que abre 

package frames;


import classesBd.VendasBD;
import java.util.List;
import javax.swing.JOptionPane;


public class principal extends javax.swing.JFrame {

    
    public principal() {
        initComponents();
    }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        tituloPrincipal = new javax.swing.JLabel();
        btnAbrir = new javax.swing.JButton();
        btnCriarMes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jDesktopPane1.setBackground(new java.awt.Color(206, 217, 212));
        jDesktopPane1.setForeground(new java.awt.Color(255, 255, 255));

        tituloPrincipal.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        tituloPrincipal.setText("Relatórios de vendas");

        btnAbrir.setBackground(new java.awt.Color(201, 219, 205));
        btnAbrir.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnCriarMes.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnCriarMes.setText("Criar");
        btnCriarMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarMesActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(tituloPrincipal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnAbrir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnCriarMes, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addComponent(btnCriarMes, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(tituloPrincipal)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAbrir, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(btnCriarMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(137, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //estrutura do frame
    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed

     //função criada para esconder uma tela antiga quando não estiver em uso
     listarMes listar = new listarMes();
     this.setVisible(false);
     listar.setVisible(true);
     listar.setLocationRelativeTo(null);
     
     
     //consultar consultarfrm = new consultar();
     //consultarfrm.setVisible(true);
    }//GEN-LAST:event_btnAbrirActionPerformed

    //botão para criar uma nova tabela
    private void btnCriarMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarMesActionPerformed
      //quando o botao é clicado, gera um evento que cria um novo mês
        
      String nome = JOptionPane.showInputDialog(null, "Digite o nome do mês que deseja criar:"); //recebe a resposta do usuário
                     
      VendasBD novomes = new VendasBD(); //Instancia um objeto da classe VendasBD
      List lista = novomes.consultarTabelas();
      try{
      if (lista.contains(nome)){ //verifica se o nome do mês já existe
                JOptionPane.showMessageDialog(null, "Este nome já existe"); //mostra pop up com aviso de sucesso

      }if(nome.equals("") || nome.isEmpty() || nome == null ){ //verifica se o nome foi preenchido vazio
         JOptionPane.showMessageDialog(null, "O nome não pode ser vazio"); //mostra pop up com aviso de sucesso

      } 
      
      else{
      novomes.criarTabela(nome); //cria tabela nova no banco de dados
      JOptionPane.showMessageDialog(null, "Novo mês criado com sucesso!"); //mostra pop up com aviso de sucesso
      consultar tela = new consultar(nome); 
      tela.setVisible(true); //entra com a pagina principal na nova tabela
      tela.setLocationRelativeTo(null); //deixa a nova tela centralizada 
      
    
      }  
      }catch(Exception e){
      
      }
               
    }//GEN-LAST:event_btnCriarMesActionPerformed

    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
               
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCriarMes;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel tituloPrincipal;
    // End of variables declaration//GEN-END:variables
}
