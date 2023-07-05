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
}
