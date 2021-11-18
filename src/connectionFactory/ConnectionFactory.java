/** 
 * Classe que cria e fecha conexão com banco de dados MYSQL 
 * 
 * @javadoc
 */
package connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class ConnectionFactory {
    
    public static Connection getConnection(){
     
   //CRIA CONEXÃO COM BANCO DE DADOS   
        
   String url = "jdbc:mysql://localhost:3306/projetofinal"; //URL DO BANCO DE DADOS
   String user = "root"; //USUARIO
   String password = ""; //SENHA
   
   try{  //TENTA CRIAR CONEXÃO E SE DER ERRO, O BLOCO CATCH É EXECUTADO
       return DriverManager.getConnection(url, user, password);
       
   }catch(SQLException e){
       e.printStackTrace(); //IMPRIME NO CONSOLE O ERRO
   }  
     return null;
 }
  
 public static void close(Connection connection){ //FECHA CONEXÃO COM BANCO DE DADOS
  
   try{  
   if(connection!=null){ //SE A CONEXÃO EXISTIR:
       connection.close(); //FECHA A CONEXÃO
   }  
   }catch(SQLException e){
       e.printStackTrace(); //IMPRIME O ERRO
   }
 }   
    
 public static void close(Connection connection, Statement stmt){ //FECHA A CONEXÃO E O STATEMENT
  
   close(connection);  //FECHA A CONEXÃO
   try{  
       
   if(stmt!=null){ //FECHA O STATEMENT
       stmt.close();
   }  
   }catch(SQLException e){
       e.printStackTrace(); //IMPRIME SE DER ERRO
   }
 }   
 public static void close(Connection connection, Statement stmt, ResultSet rs){ //FECHA A CONEXÃO, STATEMENT E RESULTSET
  
   close(connection, stmt);  //FECHA CONEXÃO E STATEMENT
   try{  
       
   if(rs!=null){ //FECHA O RESULTSET
       rs.close();
   }  
   }catch(SQLException e){
       e.printStackTrace(); //IMPRIME SE DER ERRO
   }
 }   
 
       
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

