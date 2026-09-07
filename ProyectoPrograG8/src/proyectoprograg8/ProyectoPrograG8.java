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
        System.out.println("2. Ingresar como Medico");
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
                boolean isPaciente= IngresarUsuario(codigoPaciente, passwordPaciente, nombrePaciente, sc);
                 // isPaciente= Inicio Sesion Paciente 
                
                if (isPaciente){
                    SelecCitas(sc);
                }
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
        public static boolean IngresarUsuario(String[] codigo, String[] password, String[] nombre, Scanner sc) { //código para verificar, password para verificar, nombre para mostrar

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
        
        return validado;

    }// FIN FUNCION IngresarUsuario


    // Segunda Funcion Citas
          public static void SelecCitas(Scanner sc) {
        int menuCitas = 0;
        
        System.out.println("1. CREAR NUEVA CITA");
        System.out.println("2. VISUALIZAR CITA");
        System.out.println("3. CAMBIAR CITA");
        System.out.println("4. CANCELAR CITA");
        System.out.println("5. REGRESAR AL MENU PRINCIPAL");
        System.out.print("Respuesta: ");
        
        menuCitas = sc.nextInt();
        sc.nextLine(); // Limpieza de buffer
            
        switch(menuCitas) {  // Menu de Citas
            case 1:
                System.out.println("1. Médico General");
                System.out.println("2. Médico Especialista");
                System.out.print("Respuesta: ");
                int filtroTipo = sc.nextInt();
                sc.nextLine(); // Limpieza de buffer
                
                String Buscar = "";
                if (filtroTipo == 1) {
                    Buscar = "General";
                } else if (filtroTipo == 2) {
                    Buscar = "Especialista";
                } else {
                    System.out.println("Error Opcion Invalida");
                    break;
                }

            case 2:
                System.out.println("VISUALIZAR CITA");
                break;
                
            case 3:
                System.out.println("CAMBIAR CITA");
                break;
                
            case 4:
                System.out.println("CANCELAR CITA");
                break;
                
            case 5: 
                System.out.println("ESPERE UNOS MINUTOS");
                break;
                
            default:
                System.out.println("Opción no válida.");
                break;
        }// Fin Segunda Funcion 
          }
    
}// FIN CLASS

   
        
    
    

