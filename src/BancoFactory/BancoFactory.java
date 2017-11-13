package BancoFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class BancoFactory {
    private static String login; //Static -> Variável que pode ser acessada apartir da classe, sem necessidade de instanciar um obj.
    private static String senha;
    private static String servidor;
    private static String nomeBanco;
    private static Connection conexao; //connection (java.sql)
    
    static { //Primeira coisa que será executada
        login = "root";
        senha = "";
        servidor = "localhost";
        nomeBanco = "accounts";
    }
    
    public static boolean abrir(){ //Método também static.
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Driver p/ comunicação entre o banco e o Java (todo gerenciador de banco tem seu próprio driver)
            conexao = DriverManager.getConnection("jdbc:mysql://" + servidor + ":3306/" + nomeBanco, login, senha);
            return true;
        } catch (SQLException ex) { //Login/senha incorretos, por exemplo
            JOptionPane.showMessageDialog(null, "Erro driver");
            return false;
        } catch (ClassNotFoundException ex) { //Caso não coloque o arquivo do driver
            JOptionPane.showMessageDialog(null, "Erro classe");
            return false;
        }
    }
    
    public static boolean fechar(){
        try {
            conexao.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro fechar");
            return false;
        }
    }
    
    public static Connection getConnection(){
        return conexao;
    }
}