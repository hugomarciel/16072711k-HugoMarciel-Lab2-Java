package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int MENU_EXIT_OPTION = 7;

        int choice;
        Filesystem_Marciel16072711k  fileSystem = new Filesystem_Marciel16072711k("Mi sistema");
        System.out.println("Hola, se ha creado un nuevo sistema, a continuacion tienes distintas opciones para realizar con el: \n ");
        System.out.println(fileSystem);
        System.out.println("\n");

        do {
            printMenu();
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {

                case 1:
                    System.out.println("Ingrese un nombre de usuario para el registro");
                    var user = input.nextLine();
                    fileSystem.register(user);
                    System.out.println(fileSystem);
                    break;

                case 2:
                    System.out.println("Ingrese un nombre de usuario para el inicio de sesion");
                    var userLogin = input.nextLine();
                    fileSystem.login(userLogin);
                    System.out.println(fileSystem);
                    break;


                case 3:
                    System.out.println("Ingrese la letra de unidad del nuevo Drive(solo la letra sin simbolos: C, D):");
                    var letter = input.nextLine();
                    System.out.println("Ingrese el nombre del nuevo Drive");
                    var ndrive = input.nextLine();
                    System.out.println("Ingrese la cpacidad del nuevo Drive");
                    var cap = input.nextInt();
                    fileSystem.addDrive(letter, ndrive, cap);
                    System.out.println(fileSystem);
                    break;

                case 4:
                    System.out.println("Ingrese la letra de la nueva unidad");
                    var folder = input.nextLine();
                    fileSystem.mkDir(folder);
                    System.out.println(fileSystem) ;
                    break;

                    case 5:
                    System.out.println("Ingrese el tipo de archivo(opciones validas: texto, documento, cfuente)");
                    var tipofile = input.nextLine();
                    System.out.println("Ingrese el nombre del Archivo");
                    var nfile = input.nextLine();
                    System.out.println("Ingrese la etension del archivo");
                    var ext = input.nextLine();
                    System.out.println("Ingrese el contenido del archivo");
                    var cont = input.nextLine();
                    fileSystem.addFile(tipofile, nfile, ext, cont);
                    System.out.println(fileSystem) ;
                    break;


                case 6:
                    // addDrive
                    fileSystem.addDrive("Y", "MiDiscoDuro", 1000);
                    System.out.println(fileSystem);


                    fileSystem.addDrive("K", "MiDiscoDuro 2 D", 123);
                    System.out.println(fileSystem);


// register
                    fileSystem.register("Gonzalo");
                    System.out.println(fileSystem);


// login
                    fileSystem.login("Hugo");
                    System.out.println(fileSystem);


                    // logout
                    fileSystem.logout();
                    System.out.println(fileSystem);

                    // login
                    fileSystem.login("Hugo");
                    System.out.println(fileSystem);


// switchDrive the
                    fileSystem.switchDrive("D:/");
                    System.out.println(fileSystem);

// mkDir
                    fileSystem.mkDir("folder25");
                    System.out.println(fileSystem);





// cd
                    fileSystem.cd("folder25");
                    System.out.println(fileSystem);

                    // mkDir
                    fileSystem.mkDir("folder29");
                    System.out.println(fileSystem);

                    // cd
                    fileSystem.cd("folder29");
                    System.out.println(fileSystem);

                    // addfile
                    fileSystem.addFile("texto", "archivo.txt", ".txt", "Hola mundo");
                    System.out.println(fileSystem);

                    // cd
                    fileSystem.cd("/");
                    System.out.println(fileSystem);

// cd
                    fileSystem.cd("folder1");
                    System.out.println(fileSystem);

                    // cd
                    fileSystem.cd("folder2");
                    System.out.println(fileSystem);



// cd
                    fileSystem.cd("..");
                    System.out.println(fileSystem);



                    // addfile
                    fileSystem.addFile("documento", "documento.docx", ".docx", " mundoooooo");
                    System.out.println(fileSystem);

                    // addfile
                    fileSystem.addFile("cfuente", "cfuente.py", ".py", "interpretame");
                    System.out.println(fileSystem);

                    // addfile
                    fileSystem.addFile("texto", "cfuente.py", ".py", "interpretamedenuevo");
                    System.out.println(fileSystem);

                    fileSystem.addFile("cfuente", "nuevoarchivo.py", ".py", "nuevo contenido");
                    System.out.println(fileSystem);

                    fileSystem.del("cfuente.py");
                    System.out.println(fileSystem);




                    fileSystem.move("archivo.txt", "D:/folder1/folder8");
                    System.out.println(fileSystem);

                    fileSystem.copy("folder29", "D:/folder1/folder8");
                    System.out.println(fileSystem);
                    break;

                case 7:
                    System.out.println("Bye.. Que la Fuerza te acompañe");
                    System.exit(0);
                    break;

                default:
                    System.out.println(choice + " is not a valid option! Please select correct option.");

            }
        } while (choice != MENU_EXIT_OPTION);
    }

    private static void printMenu() {
        System.out.println("Menu interactivo\n");
        System.out.print("1. Registrar usuario \n");
        System.out.print("2. Hacer login\n");
        System.out.print("3. Crear Drive.\n");
        System.out.print("4. Crear directorio.\n");
        System.out.print("5. Crear archivo\n");
        System.out.print("6. Resto de operaciones\n");
        System.out.print("7. Salir\n");
        System.out.print("\nIngresa tu opcion: ");
    }
}