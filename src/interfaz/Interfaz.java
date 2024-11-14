package interfaz;

import dominio.Libreta;
import dominio.NoEncontradoException;
import dominio.Contacto;
import java.io.*;
import java.util.Scanner;

public class Interfaz implements Serializable {
    public static void ejecutar(String [] args) {
        Scanner sc = new Scanner(System.in);
        Libreta libreta= new Libreta();
        if (args[0].equalsIgnoreCase("add")) {
            if (args.length == 5) {
                String nombre = args[1];
                String apellidos= args[2];
                String telefono= args[3];
                String email= args[4];

                libreta.annadirContacto(new Contacto(nombre, apellidos, telefono, email));
                System.out.println("Contacto añadido: " + nombre + ", " + apellidos
                +", "+telefono+", "+email);
            } else {
                System.out.println("Formato incorrecto. Formato: add <nombre> <apellidos> <telefono> <email>");
            }
        } else if (args[0].equalsIgnoreCase("list")) {
            System.out.println("Contactos en la libreta:");
            System.out.println(libreta);
        } else if (args[0].equalsIgnoreCase("help")) {
            System.out.println("Las operaciones posibles son estas:");
            System.out.println("- Añadir contacto: 'java -jar libreta.jar add <nombre> <apellidos> <telefono> <email>'");
            System.out.println("- Modificar un contacto: 'java -jar libreta.jar mofify <Nombre> <Apellidos> <nuevo telefono> <nuevo email>'");
            System.out.println("- Eliminar contacto: 'java -jar libreta.jar remove <nombre> <apellidos>");
            System.out.println("- Mostrar contactos: 'java -jar libreta.jar list'");
            System.out.println("- Mostrar esta ayuda: 'java -jar libreta.jar help'");
        }else if (args[0].equalsIgnoreCase("remove")){
            libreta.borrar(new Contacto(args[1],args[2]));
            }catch(NoEncontradoException e;){
                System.out.println ("El Contacto: "+e.getContacto().getNombre()+"no se ha encontrado");
            
         }else if (args[0].equalsIgnoreCase("modify")){
            try{
            libreta.modificarContacto(args[1], args[2], args[3], args[4]);
        }catch(NoEncontradoException e){
            System.out.println("El contacto que quiere modificar no existe, ¿Desearía crearlo?, responda 'si' o 'no' ");
        }if(sc.nextLine().equalsIgnoreCase("si")){
            System.out.println("Introduzca los datos del nuevo contacto: <nombre>, <apellidos>, <telefono>, <email>");
            libreta.annadirContacto(new Contacto((sc.nextLine()),(sc.nextLine()),(sc.nextLine()), (sc.nextLine())));
        }

        }else{
            System.out.println("Comando no reconocido. Usa 'help' para visualizar las instrucciones .");

        }
    }
}