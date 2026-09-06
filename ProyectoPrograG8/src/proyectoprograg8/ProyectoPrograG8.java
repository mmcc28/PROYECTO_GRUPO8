/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoprograg8;

import java.util.Scanner;

/**
 *
 * @author mmcc28
 */
public class ProyectoPrograG8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        
        //MENSAJE BIENVENIDA 
        System.out.println("--------------------------------");
        System.out.println("BIENVENVIDOS A CLINICAS MEDICAS ");
        System.out.println("--------------------------------");
        System.out.println("FAVOR SELECCIONE UNA DE LAS SIGUIENTES OPCIONES");
        System.out.println("1. Ingresar como Paciente");
        System.out.println("2. Ingresar como Médico");
        System.out.println("3. Salir");
        opcion = sc.nextInt();
        
        sc.nextLine();//LIMPIEZA BUFFER

        // STRING BASE DE DATOS PRECARGADA INFORMACION DE MEDICOS 
        String[] nombreMedico = {"Dr. Alejandro Martínez", "Dra. Laura Hernández", "Dr. Carlos Rojas", "Dra. Ana Soto", "Dr. Luis Pérez"};
        String[] codigoMedico = {"M001", "M002", "M003", "M004", "M005"};
        String[] passwordMedico = {"pass1", "pass2", "pass3", "pass4", "pass5"};
        
        // STRING BASE DE DATOS PRECARGADA INFORMACION DE PACIENTES
        String[] nombrePaciente = {"María López", "Carlos Díaz", "Sofía Ramos", "Jorge Molina", "Lucía Torres"};
        String[] codigoPaciente= {"P006","P007","P008","P009","P0010"};
        String[] passwordPaciente = {"pass6", "pass7", "pass8","pass9", "pass10" };

        //SWITCH MENU PRINCPIAL Y LOGIN SEGUN TIPO DE USUARIO A INGRESAR
        
        switch (opcion) {
            case 1:
                ;
                IngresarUsuario(codigoPaciente, passwordPaciente, nombrePaciente, sc);

                break;

            case 2:
                            
                IngresarUsuario(codigoMedico, passwordMedico, nombreMedico, sc);
                        

                break;

            case 3:
                System.out.println("REGRESA PRONTO");

                break;

            default:
                System.out.println("OPCION NO VALIDA, VUELVA A INTENTARLO");
                break;
        }// FIN SWITCH MENU PRINCIPAL

        
              
            
        
    }// FIN MAIN
    
    
    //1ra FUNCION INGRESAR USUARIO Y CONTRASENA PARA MEDICO Y PACIENTE
        public static void IngresarUsuario(String[] codigo, String[] password, String[] nombre, Scanner sc) { //código para verificar, password para verificar, nombre para mostrar

        String usuario = "JOHN DOE";
        String contrasena = "JOHN DOE";

        System.out.println("INGRESE SU USUARIO:");
        usuario = sc.next();

        System.out.println("INGRESE CONTRASENA:");
        contrasena = sc.next();

        boolean validado = false;

        //1er ciclo for: verificar el usuario y contrasena que escribio para mostrar el Dr correspondiente
        for (int i = 0; i < codigo.length; i++) { // recorre todo el ciclo buscando los datos del medico
            //1er ciclo if operadores logicos && 
            if (codigo[i].equals(usuario) && password[i].equals(contrasena)) { // equals para comparar strings
                validado = true;
                System.out.printf("BIENVENIDO: %s\n", nombre[i]);
                
           break; // Break para cerrar el ciclo
           
            }// fin if
        }// fin for
            
        // 2ndo ciclo if 
        if (validado == false) {
            System.out.println("USUARIO O CONTRASENA INCORRECTOS");
        }// fin if

    }// FIN FUNCION IngresarUsuario


    
    
    
}// FIN CLASS
