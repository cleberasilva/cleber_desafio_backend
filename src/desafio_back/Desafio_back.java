/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio_back;

import Controller.AccountController;
import java.sql.SQLException;

/**
 *
 * @author cleber
 */
public class Desafio_back {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        AccountController a= new AccountController();
        a.challenge();
    }
}
