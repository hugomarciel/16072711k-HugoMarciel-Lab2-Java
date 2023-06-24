package org.example;


public class Drive_Marciel16072711k {


    private String letter;
    private String name;
    private int capacity;


    private boolean esDriveActual;


    public Drive_Marciel16072711k(String letter, String name, int capacity) {
        this.letter = letter;
        this.name = name;
        this.capacity = capacity;
        this.esDriveActual = false;
    }


    public String getLetter() {
        return letter;
    }


    public void setLetter(String letter) {
        this.letter = letter;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getCapacity() {
        return capacity;
    }


    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public void switchDrive() {
        this.esDriveActual = true;
    }




    @Override
    public String toString() {
        return "Drive_Marciel16072711k{" +
                "letter='" + letter + '\'' +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", esDriveActual=" + esDriveActual +
                '}';
    }
}
