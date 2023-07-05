package org.example;

public class File_Marciel160727116k {
    private String tipo;
    private String nombre;
    private String extencion;
    private String contenido;

    public File_Marciel160727116k(String tipo, String nombre, String extencion, String contenido) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.extencion = extencion;
        this.contenido = contenido;
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

    @Override
    public String toString() {
        return "File_Marciel160727116k{" +
                "tipo='" + tipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", extencion='" + extencion + '\'' +
                ", contenido='" + contenido + '\'' +
                '}';
    }
}
