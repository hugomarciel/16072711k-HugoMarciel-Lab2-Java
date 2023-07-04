package org.example;


public class Main {
    public static void main(String[] args) {


        Filesystem_Marciel16072711k fileSystem = new Filesystem_Marciel16072711k("Mi sistema");
        System.out.println(fileSystem);


// addDrive
        fileSystem.addDrive("C", "MiDiscoDuro", 1000);
        System.out.println(fileSystem);


        fileSystem.addDrive("D", "MiDiscoDuro 2 D", 123);
        System.out.println(fileSystem);


// register
        fileSystem.register("Hugo");
        System.out.println(fileSystem);


// login
        fileSystem.login("Hugo");
        System.out.println(fileSystem);


        // logout
        fileSystem.logout();
        System.out.println(fileSystem);


// switchDrive the
        fileSystem.switchDrive("C");
        System.out.println(fileSystem);




    }
}