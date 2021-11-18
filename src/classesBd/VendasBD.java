//classe DAO para vendas no bd

package classesBd;

import classes.Vendas;
import connectionFactory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.JdbcRowSet;
import javax.swing.JOptionPane;

public class VendasBD {
    
    // método que salva uma venda no bd
    public void save(Vendas venda, String nome) { 

        String sql = "INSERT INTO `projetofinal`.`"+nome+"` (`data`, `cliente`, `valorBruto`, `comissao`, `tipoPag`, `valorLiquido`, `comissaoVenda`) VALUES ('"+venda.getData()+"', '"+venda.getCliente()+"', '"+venda.getValorBruto()+"', "+venda.getComissao()+", '"+venda.getTipoPag()+"', '"+venda.getValorliquido()+"', '"+venda.getComissaoVenda()+"');";
        Connection conn = ConnectionFactory.getConnection();

        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConnectionFactory.close(conn, stmt);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    // método que calcula uma comissão de venda no bd
    public void calcular(Vendas venda){ 
      
        double comiss = 0;
        double valorLiq = 0;
        
        comiss = venda.getValorBruto()*(venda.getComissao()/100);
        venda.setComissaoVenda(comiss);
        
        valorLiq = venda.getValorBruto() - comiss;
        venda.setValorliquido(valorLiq);
        
    }
    
    // método que atualiza uma venda no bd
    public void update(Vendas venda, String nome){
     
      String sql = "UPDATE `projetofinal`.`"+nome+"` SET `data`='"+venda.getData()+"', `cliente`='"+venda.getCliente()+"', `valorBruto`='"+venda.getValorBruto()+"', `comissao`="+venda.getComissao()+",  `tipoPag`='"+venda.getTipoPag()+"' WHERE `id`='"+venda.getId()+"'"; 
      Connection conn = ConnectionFactory.getConnection();
      
      try{
         if(venda.getId()!=null || venda!=null){
             Statement stmt = conn.createStatement();
             stmt.executeUpdate(sql);
             ConnectionFactory.close(conn, stmt);
         }
        
      }catch(SQLException e){
                 e.printStackTrace();
    }
         
    }
            
    // método que atualiza uma venda no bd após reefetuar o calculo de comissão
    public void updateEditar(Vendas venda, String nome){
     
      String sql = "UPDATE `projetofinal`.`"+nome+"` SET `data`='"+venda.getData()+"', `cliente`='"+venda.getCliente()+"', `valorBruto`='"+venda.getValorBruto()+"',`comissao`="+venda.getComissao()+", `tipoPag`='"+venda.getTipoPag()+"', `valorLiquido`='"+venda.getValorliquido()+"', `comissaoVenda`='"+venda.getComissaoVenda()+"', WHERE `id`='"+venda.getId()+"';";
      Connection conn = ConnectionFactory.getConnection();
      
      try{
         if(venda.getId()!=null || venda!=null){
             Statement stmt = conn.createStatement();
             stmt.executeUpdate(sql);
             ConnectionFactory.close(conn, stmt);
         }
        
      }catch(SQLException e){
                 e.printStackTrace();
    }
         
    }
    
    // método que atualiza uma venda no bd após reefetuar o calculo de comissão
    public void updateCalculo(Vendas venda, String nome){
     
      String sql = "UPDATE `projetofinal`.`"+nome+"` SET `valorLiquido`='"+venda.getValorliquido()+"', `comissaoVenda`='"+venda.getComissaoVenda()+"' WHERE `id`='"+venda.getId()+"';";
      Connection conn = ConnectionFactory.getConnection();
      
      try{
         if(venda.getId()!=null || venda!=null){
             Statement stmt = conn.createStatement();
             stmt.executeUpdate(sql);
             ConnectionFactory.close(conn, stmt);
         }
        
      }catch(SQLException e){
                 e.printStackTrace();
    }
         
    }
    
    // método que deleta uma venda da tabela
    public static void delete(Vendas venda, String nome) {

        String sql = "DELETE FROM `projetofinal`.`"+nome+"` WHERE `id`='" + venda.getId() + "';";
        Connection conn = ConnectionFactory.getConnection();

        try {
            if (venda.getId() != null || venda != null) {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                ConnectionFactory.close(conn, stmt);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // método que deleta todas as vendas de uma única tabela do bd
    public static void deleteAll(String nome) {

        String sql = "SELECT * FROM projetofinal."+nome+";";
        Connection conn = ConnectionFactory.getConnection();

        try {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                rs.deleteRow();
            }

            ConnectionFactory.close(conn, stmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    //listar todas as vendas de uma tabela de uma banco de dados
    public static List<Vendas> selectAll(String nome) {

        String sql = "SELECT * FROM projetofinal."+nome+";";
        Connection conn = ConnectionFactory.getConnection();

        List<Vendas> vendasList = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                vendasList.add(new Vendas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),rs.getDouble(5), rs.getString(6),rs.getDouble(7),rs.getDouble(8)));
            }

            ConnectionFactory.close(conn, stmt, rs);
            return vendasList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
         
    //cria uma tabela no banco de dados
    public void criarTabela(String nome){
    String str = "CREATE TABLE "+nome+" (id int(11) NOT NULL AUTO_INCREMENT, data varchar(45) DEFAULT NULL, cliente varchar(45) DEFAULT NULL, valorBruto double DEFAULT NULL, comissao double DEFAULT NULL, tipoPag varchar(40) DEFAULT NULL, valorLiquido double DEFAULT NULL, comissaoVenda double DEFAULT NULL, PRIMARY KEY (id));";
    
    Connection conne = ConnectionFactory.getConnection();

        try {
            Statement stmt = conne.createStatement();
            stmt.executeUpdate(str);
            ConnectionFactory.close(conne, stmt);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //deleta uma tabela no bd
    public void deletarTabela(String nome){
    String str = "DROP TABLE "+nome+";";
    
    Connection conne = ConnectionFactory.getConnection();

        try {
            Statement stmt = conne.createStatement();
            stmt.executeUpdate(str);
            ConnectionFactory.close(conne, stmt);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //faz consultas por nome em todas as tabelas do bd
    public List<String> consultarTabelas(){
      
        String sql = "show tables;";
        List<String> nomes = new ArrayList();
        
        Connection conne = ConnectionFactory.getConnection();

        try {
            Statement stmt = conne.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
                        
            while (rs.next()) {
                
                nomes.add(rs.getString(1));
            }

            ConnectionFactory.close(conne, stmt, rs);
            
            
            } catch (SQLException e) {
            e.printStackTrace();
        }
    
         return nomes;
                 
    }   
    
    //pesquisa uma venda por nome no bd
    public static List<Vendas> pesquisarRegistros(String nome, String tabela){
            
        String sql = "SELECT * FROM projetofinal."+tabela+" WHERE cliente LIKE '%"+nome+"%'";
        Connection conn = ConnectionFactory.getConnection();

        List<Vendas> vendasList = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                vendasList.add(new Vendas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),rs.getDouble(5), rs.getString(6),rs.getDouble(7),rs.getDouble(8)));
            }

            ConnectionFactory.close(conn, stmt, rs);
            return vendasList;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vendasList; 
         };
    
    
}