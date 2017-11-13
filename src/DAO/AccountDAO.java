/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BancoFactory.BancoFactory;
import Model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cleber
 */
public class AccountDAO implements DAO<Account>{
    private PreparedStatement pst; //Variável que vai conter o comando SQL
    private ResultSet rs;//Utiliza essa variável quando o comando SELECT é usado.
    
    @Override
    public boolean insert(Account obj) throws SQLException {
        try{
            BancoFactory.abrir();
            pst=BancoFactory.getConnection().prepareStatement("insert into tb_customer_account "
                    + "(id_customer, cpf_cnpj, nm_customer,is_active,vl_total) values (?,?,?,?,?)");
            pst.setInt(1,obj.getId());
            pst.setString(2,obj.getDocument());
            pst.setString(3,obj.getName());
            pst.setString(4,obj.getStatus());
            pst.setFloat(5,obj.getBalance());
            int rows = pst.executeUpdate();
            return rows > 0;
        }finally{
            BancoFactory.fechar();
        }
    }


    @Override
    public List<Account> list() throws SQLException {
        try{
            List<Account> accounts = new ArrayList<>();
            BancoFactory.abrir();
            pst=BancoFactory.getConnection().prepareStatement("select * from tb_customer_account where vl_total > 560"
                    + " and id_customer between 1500 and 2700 order by vl_total desc");
            rs=pst.executeQuery();
            
                while(rs.next()){
                    Account account=new Account();
                    account.setId(rs.getInt("id_customer"));
                    account.setDocument(rs.getString("cpf_cnpj"));
                    account.setName(rs.getString("nm_customer"));
                    account.setStatus(rs.getString("is_active"));
                    account.setBalance(rs.getFloat("vl_total"));
                    accounts.add(account);
                }
                return accounts;
        }finally{
            BancoFactory.fechar();
        }}
    
}
