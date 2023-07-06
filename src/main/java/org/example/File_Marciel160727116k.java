package org.example;

public class File_Marciel160727116k {
    private String tipo;
    private String nombre;
    private String extencion;
    private String contenido;

    private String user;

    private String drive;

    private String path;



    public File_Marciel160727116k(String tipo, String nombre, String extencion, String contenido, String user, String drive, String path) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.extencion = extencion;
        this.contenido = contenido;
        this.user = user;
        this.drive = drive;
        this.path = path;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExtencion() {
        return extencion;
    }

    public void setExtencion(String extencion) {
        this.extencion = extencion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "File_Marciel160727116k{" +
                "tipo='" + tipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", extencion='" + extencion + '\'' +
                ", contenido='" + contenido + '\'' +
                ", user='" + user + '\'' +
                ", drive='" + drive + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
