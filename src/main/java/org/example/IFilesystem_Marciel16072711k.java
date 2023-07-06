package org.example;


public interface IFilesystem_Marciel16072711k {
    void addDrive(String letter, String name, int capacity);


    void register(String username);


    void login(String username);

    void logout();

    void switchDrive(String letter);

    void mkDir(String name);

    public void cd(String comando);
    public void cdFolder(String folderName);
    public void cdDosPuntos();
    public void cdSlash();

    public void addFile(String tipo, String nombre, String extencion, String contenido);
    public void del(String target);
    public void copy(String target, String newPath);
    public void addCopyFile(File_Marciel160727116k file, String newPath);
    public void addCopyFolder(Folder_Marciel16072711k folderFound, String newPath);
    public void move(String target, String newPath);
    public void addMoveFile(File_Marciel160727116k file, String newPath);
    public void addMoveFolder(Folder_Marciel16072711k folderFound, String newPath);
}
