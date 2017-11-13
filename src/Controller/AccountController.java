/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AccountDAO;
import DAO.DAO;
import Model.Account;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author cleber
 */
public class AccountController{
    Scanner s=new Scanner(System.in);
    List<Account> list=new ArrayList();
    DAO<Account> dao;

    public AccountController() {
        this.dao = new AccountDAO();
    }
    
    public void challenge() throws SQLException{
        System.out.println("informe o numero de clientes que deseja cadastrar");
        int n=s.nextInt();
        if (n>0){
            for (int i=1;i<=n;i++){
                Account account=new Account();
                System.out.println("informe o id:");
                account.setId(s.nextInt());
                System.out.println("informe o nome:");
                account.setName(s.next());
                System.out.println("informe o cpf/cnpj:");
                account.setDocument(s.next());
                System.out.println("cliente se encontra ativo?");
                account.setStatus(s.next());
                System.out.println("informe o Saldo:");
                account.setBalance(s.nextFloat());
                System.out.println("teste");
                if(dao.insert(account)){
                    System.out.println("cliente registrado");
                }else{
                    System.out.println("falha no registro");
                }
            }
        }
        list = dao.list();
        System.out.println("Média final="+getAverage(list));
        for (Account account: list){
            System.out.println(account.tostring());
        }
        
    }
    public float getAverage(List<Account> list){
        float average=0;
        for (Account account: list){
            average+=account.getBalance();
        }
        average/=list.size();
        return average;
    }
}
