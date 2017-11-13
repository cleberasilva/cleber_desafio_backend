/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author cleber
 */
public class Account {
    private int id;
    private float balance;
    private String document, name, status;

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public float getBalance() {
        return balance;
    }

    public String getDocument() {
        return document;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
    
    public String tostring(){
        return name + " com o saldo de " + balance;
    }
    
}
