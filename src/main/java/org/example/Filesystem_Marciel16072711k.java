package org.example;


import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Filesystem_Marciel16072711k implements IFilesystem_Marciel16072711k {


    private String nombre;


    private Date fechaCreacion;

    private List<User_Marciel16072711k> users = new ArrayList<>();


    private List<Drive_Marciel16072711k> drives = new ArrayList<>();

    private List<Folder_Marciel16072711k> folders = new ArrayList<>();

    private List<File_Marciel160727116k> files= new ArrayList<>();

    private String currentUser;


    private boolean isLogged;
    private String currentDrive;
    private String currentPath;

    private List<File_Marciel160727116k> papelera = new ArrayList<>();





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
            if (user.getUsername().equals(username)) {
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
        for (User_Marciel16072711k user : users) {
            if (user.isEstaLogeado() == true) {
                for (Drive_Marciel16072711k drive : drives) {
                    //System.out.println(drive.getLetter());
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

    @Override
 public void mkDir(String name){
     Folder_Marciel16072711k folder = new Folder_Marciel16072711k(name,this.currentUser, this.currentDrive,this.currentPath );
     folders.add(folder);
 }


////////////////////////////////////////////////CD
@Override
    public void cd(String comando) {

        if (comando == "..") {
            if(!this.currentDrive.equals(this.currentPath)){
                this.cdDosPuntos();
            }
        } else if (comando == "/") {
            this.cdSlash();
        } else  {
            this.cdFolder( comando);
        }
    }

@Override
    public void cdFolder(String folderName){
        for(Folder_Marciel16072711k folder : folders){
            if(folder.getNombre() == folderName){
                this.currentPath = folder.getCurrentPath()+folderName+"/";
                this.currentDrive =folder.getCurrentDrive();
            }
        }
    }
@Override
    public void cdDosPuntos(){
    String ruta = this.currentPath;
    int indiceSegundoSlash = ruta.lastIndexOf("/", ruta.lastIndexOf("/") - 1);
    String resultado = ruta.substring(0, indiceSegundoSlash + 1);
    this.currentPath = resultado;
    }



    @Override
    public void cdSlash(){
        this.currentPath = this.currentDrive;
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

///////////////////////////////////////Fin operaciones CD


///////////////////////////////////////addFile
    @Override
    public void addFile(String tipo, String nombre, String extencion, String contenido) {
        boolean yaexiste=false;
        for (File_Marciel160727116k file : files){
            if (file.getNombre().equals(nombre)){
                file.setContenido(contenido);
                file.setTipo(tipo);
                yaexiste = true;
                break;
            }
        }
        if(yaexiste==false){
        if( tipo.equals("texto")){
            TextoFile_Marciel16072711k textFile = new TextoFile_Marciel16072711k(tipo, nombre, extencion, contenido,this.currentUser,this.currentDrive,this.currentPath);
        files.add(textFile);
    } else if (tipo.equals("documento")) {
            DocumentFile_Marciel16072711k docFile = new DocumentFile_Marciel16072711k(tipo, nombre, extencion, contenido,this.currentUser,this.currentDrive,this.currentPath);
            files.add(docFile);
        } else if (tipo.equals("cfuente")) {
            CfuenteFile_Marciel16072711k cfuenteFile = new CfuenteFile_Marciel16072711k(tipo, nombre, extencion, contenido,this.currentUser,this.currentDrive,this.currentPath);
            files.add(cfuenteFile);
        }
    }}

///////////////////////////////////////del


@Override
    public void del(String target){
        int i = 0;
        for(File_Marciel160727116k file : files){
            if(file.getNombre().equals(target)){
                papelera.add(file);
                files.remove(i);
                break;
            }i=i+1;
        }
    }



 /////////////////////////////////////////////////////////////////COPYY
@Override
    public void copy(String target, String newPath) {

        File_Marciel160727116k foundFile = null;
        Folder_Marciel16072711k foundFolder = null;
        if (target.contains(".")) {
            for (File_Marciel160727116k file : files) {
                if (file.getNombre().equals(target)) {
                    foundFile = file;
                    break;
                }
            }


            this.addCopyFile(foundFile, newPath);

        }else {
            for (Folder_Marciel16072711k folder : folders) {
                if (folder.getNombre().equals(target)) {
                    foundFolder = folder;
                    break;
                }
            }
            this.addCopyFolder(foundFolder, newPath);



        }

    }



@Override
    public void addCopyFile(File_Marciel160727116k file, String newPath) {
        System.out.println("Entramooos");
        if( file.getTipo().equals("texto")){
            TextoFile_Marciel16072711k textFile = new TextoFile_Marciel16072711k(file.getTipo(), file.getNombre(), file.getExtencion(), file.getContenido(),this.currentUser,newPath.substring(0,3),newPath);
            files.add(textFile);
        } else if (file.getTipo().equals("documento")) {
            DocumentFile_Marciel16072711k docFile = new DocumentFile_Marciel16072711k(file.getTipo(), file.getNombre(), file.getExtencion(), file.getContenido(),this.currentUser,newPath.substring(0,3),newPath);
            files.add(docFile);
        } else if (file.getTipo().equals("cfuente")) {
            CfuenteFile_Marciel16072711k cfuenteFile = new CfuenteFile_Marciel16072711k(file.getTipo(), file.getNombre(), file.getExtencion(), file.getContenido(),this.currentUser,newPath.substring(0,3),newPath);
            files.add(cfuenteFile);
        }
    }

@Override
    public void addCopyFolder(Folder_Marciel16072711k folderFound, String newPath) {

        Folder_Marciel16072711k folder = new Folder_Marciel16072711k(folderFound.getNombre(),this.currentUser, newPath.substring(0,3),newPath );
        folders.add(folder);
    }








///////////////////////////////////////////////////////////////////MOVE

    @Override
public void move(String target, String newPath) {

    File_Marciel160727116k foundFile = null;
    Folder_Marciel16072711k foundFolder = null;
    if (target.contains(".")) {
        for (File_Marciel160727116k file : files) {
            if (file.getNombre().equals(target)) {
                foundFile = file;
                break;
            }
        }

        int i = 0;
        for (File_Marciel160727116k file : files) {
            if (file.getNombre().equals(target)) {
                files.remove(i);
                break;
            }
            i = i + 1;
        }
        this.addMoveFile(foundFile, newPath);

    }else {

        for (Folder_Marciel16072711k folder : folders) {
            if (folder.getNombre().equals(target)) {
                foundFolder = folder;
                break;
            }
        }

        int i = 0;
        for (Folder_Marciel16072711k folder : folders) {
            if (folder.getNombre().equals(target)) {
                folders.remove(i);
                break;
            }
            i = i + 1;
        }
        this.addMoveFolder(foundFolder, newPath);



    }

}



@Override
    public void addMoveFile(File_Marciel160727116k file, String newPath) {

            if( file.getTipo().equals("texto")){
                TextoFile_Marciel16072711k textFile = new TextoFile_Marciel16072711k(file.getTipo(), file.getNombre(), file.getExtencion(), file.getContenido(),this.currentUser,newPath.substring(0,3),newPath);
                files.add(textFile);
            } else if (file.getTipo().equals("documento")) {
                DocumentFile_Marciel16072711k docFile = new DocumentFile_Marciel16072711k(file.getTipo(), file.getNombre(), file.getExtencion(), file.getContenido(),this.currentUser,newPath.substring(0,3),newPath);
                files.add(docFile);
            } else if (file.getTipo().equals("cfuente")) {
                CfuenteFile_Marciel16072711k cfuenteFile = new CfuenteFile_Marciel16072711k(file.getTipo(), file.getNombre(), file.getExtencion(), file.getContenido(),this.currentUser,newPath.substring(0,3),newPath);
                files.add(cfuenteFile);
            }
        }

@Override
    public void addMoveFolder(Folder_Marciel16072711k folderFound, String newPath) {
        Folder_Marciel16072711k folder = new Folder_Marciel16072711k(folderFound.getNombre(),this.currentUser, newPath.substring(0,3),newPath );
        folders.add(folder);
    }



//////////////////////////////////fin de move





    @Override
    public String toString() {
        return "Filesystem_Marciel16072711k{" +
                "nombre='" + nombre + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", users=" + users +
                ", drives=" + drives +
                ", folders=" + folders +
                ", files=" + files +
                ", currentUser='" + currentUser + '\'' +
                ", isLogged=" + isLogged +
                ", currentDrive='" + currentDrive + '\'' +
                ", currentPath='" + currentPath + '\'' +
                ", papelera=" + papelera +
                '}';
    }}