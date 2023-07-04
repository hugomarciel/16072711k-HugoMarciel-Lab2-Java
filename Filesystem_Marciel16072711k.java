package org.example;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Filesystem_Marciel16072711k implements IFilesystem_Marciel16072711k {


    private String nombre;


    private Date fechaCreacion;


    private List<Drive_Marciel16072711k> drives = new ArrayList<>();


    private List<User_Marciel16072711k> users = new ArrayList<>();






    public Filesystem_Marciel16072711k(String nombre) {
        this.nombre = nombre;
        this.fechaCreacion = new Date();
    }


    @Override
    public void addDrive(String letter, String name, int capacity) {
        Drive_Marciel16072711k drive = new Drive_Marciel16072711k(letter, name, capacity);
        drives.add(drive);
    }


    @Override
    public void register(String username) {
        User_Marciel16072711k user = new User_Marciel16072711k(username);
        users.add(user);
    }


    @Override
    public void login(String username) {
        for (User_Marciel16072711k user : users) {
            if (user.getUsername() == username) {
                user.login();
            }
        }
    }

    @Override
    public void logout() {
        for (User_Marciel16072711k user : users) {
            if (user.isEstaLogeado() == true) {
                user.logoff();
            }
        }
    }


    @Override
    public void switchDrive(String letter) {
        for (User_Marciel16072711k user : users) {
            if (user.isEstaLogeado() == true) {
                for (Drive_Marciel16072711k drive : drives) {
                    if (drive.getLetter() == letter) {
                        drive.switchDrive();
                    }
                }
            }
        }
    }


    @Override
    public String toString() {
        return "Filesystem_Marciel16072711k{" +
                "nombre='" + nombre + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", drives=" + drives +
                ", users=" + users +
                '}';
    }
}

