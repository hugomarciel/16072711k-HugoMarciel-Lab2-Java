package org.example;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Filesystem_Marciel16072711k implements IFilesystem_Marciel16072711k {


    private String nombre;


    private Date fechaCreacion;

    private List<User_Marciel16072711k> users = new ArrayList<>();


    private List<Drive_Marciel16072711k> drives = new ArrayList<>();

    private List<Folder_Marciel16072711k> folders = new ArrayList<>();

    private String currentUser;


    private boolean isLogged;
    private String currentDrive;
    private String currentPath;





    public Filesystem_Marciel16072711k(String nombre) {
        this.nombre = nombre;
        this.fechaCreacion = new Date();
        this.currentPath = "C:/";
        this.currentDrive= "C:/";
        this.currentUser= "";
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
                this.isLogged = true;
                this.currentUser = username;
            }
        }
    }

    @Override
    public void logout() {
        for (User_Marciel16072711k user : users) {
            if (user.isEstaLogeado() == true) {
                user.logoff();
                this.isLogged=false;
                this.currentUser = "";
            }
        }
    }


    @Override
    public void switchDrive(String letter) {
        //System.out.println(letter);

        for (User_Marciel16072711k user : users) {
            if (user.isEstaLogeado() == true) {
                for (Drive_Marciel16072711k drive : drives) {
                    System.out.println(drive.getLetter());
                    String str = drive.getLetter();
                    if (str.equals(letter) ) {
                       // drive.switchDrive();
                        this.currentDrive = letter;
                        this.currentPath= letter;

                    }
                }
            }
        }
    }
 public void mkDir(String name){

     Folder_Marciel16072711k folder = new Folder_Marciel16072711k(name,this.currentUser, this.currentDrive,this.currentPath );
     folders.add(folder);

 }



    //@Override
    public void cd(String comando) {

        if (comando == "..") {
            if(this.currentDrive != this.currentPath){
            System.out.println("Dos puntoooos");}
        } else if (comando == "/") {
            System.out.println("SLAAAASHH");
        } else  {

            this.cdFolder( comando);


        }
    }

    public void cdFolder(String folderName){
        //System.out.println(folderName);
        //System.out.println();
        for(Folder_Marciel16072711k folder : folders){
            if(folder.getNombre() == folderName){
                this.currentPath = folder.getCurrentPath()+folderName+"/";
                this.currentDrive =folder.getCurrentDrive();
            }

        }


    }
    /*    for (User_Marciel16072711k user : users) {
            if (user.isEstaLogeado() == true) {
                for (Drive_Marciel16072711k drive : drives) {
                    if (drive.getLetter() == letter) {
                        // drive.switchDrive();
                        this.currentDrive = letter + ":/";
                        this.currentPath= letter + ":/";

                    }
                }
            }
        }
    }

     */



    @Override
    public String toString() {
        return "Filesystem_Marciel16072711k{" +
                "nombre='" + nombre + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", users=" + users +
                ", drives=" + drives +
                ", folders=" + folders +
                ", isLogged=" + isLogged +
                ", currentUser='" + currentUser + '\'' +
                ", currentDrive='" + currentDrive + '\'' +
                ", currentPath='" + currentPath + '\'' +
                '}';
    }
}

