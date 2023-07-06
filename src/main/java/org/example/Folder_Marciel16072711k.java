package org.example;

public class Folder_Marciel16072711k {
    private String nombre;
    private String usuario;

    private String currentDrive;
    private String currentPath;

    public Folder_Marciel16072711k(String nombre, String usuario, String currentDrive, String currentPath) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.currentDrive = currentDrive;
        this.currentPath = currentPath;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCurrentDrive() {
        return currentDrive;
    }

    public void setCurrentDrive(String currentDrive) {
        this.currentDrive = currentDrive;
    }

    public String getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }


    @Override
    public String toString() {
        return "Folder_Marciel16072711k{" +
                "nombre='" + nombre + '\'' +
                ", usuario='" + usuario + '\'' +
                ", currentDrive='" + currentDrive + '\'' +
                ", currentPath='" + currentPath + '\'' +
                '}';
    }
}
