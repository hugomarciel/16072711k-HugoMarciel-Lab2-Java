package org.example;


public class User_Marciel16072711k {


    private String username;


    public boolean isEstaLogeado() {
        return estaLogeado;
    }


    private boolean estaLogeado;


    public User_Marciel16072711k(String username) {
        this.username = username;
        this.estaLogeado = false;
    }


    @Override
    public String toString() {
        return "User_Marciel16072711k{" +
                "username='" + username + '\'' +
                ", estaLogeado=" + estaLogeado +
                '}';
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public void login() {
        this.estaLogeado = true;
    }


    public void logoff() {
        this.estaLogeado = false;
    }
}
