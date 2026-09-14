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
    
    // STRING BASE DE DATOS PRECARGADA INFORMACION DE MEDICOS- arreglos unidimensionales
    static String[] nombreMedico = {"Dr. Alejandro Martínez", "Dra. Laura Hernández", "Dr. Carlos Rojas", "Dra. Ana Soto", "Dr. Luis Pérez"};
    static String[] codigoMedico = {"M001", "M002", "M003", "M004", "M005"};
    static String[] passwordMedico = {"Pass1", "Pass2", "Pass3", "Pass4", "Pass5"};

    // STRING BASE DE DATOS PRECARGADA INFORMACION DE PACIENTES- arreglos unidimensionales
    static  String[] nombrePaciente = {"María López", "Carlos Díaz", "Sofía Ramos", "Jorge Molina", "Lucía Torres"};
    static String[] codigoPaciente = {"P006", "P007", "P008", "P009", "P0010"};
    static String[] passwordPaciente = {"Pass6", "Pass7", "Pass8", "Pass9", "Pass10"};

    // StRING BASE DE DATOS CITAS  - arreglos Bidimensional 
    static String[][] citas = {
        {"P006", "M001", "05/09/2026", "Control general", "Programada"}, 
        {"P006", "M002", "12/09/2026", "Dermatologia", "Programada"}};

    //STRING BASE DE DATOS HISTORIAL MEDICO- arreglo bidimensional
    static String[][] historial = {{"P006", "10/06/2026", "Hemograma", "Valores normales"}, {"P006", "22/07/2026", "Radiografia", "Sin anomalias"}};

    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);
        int menuPrincipal = 0;

        
        //MENSAJE BIENVENIDA 
        System.out.println("--------------------------------");
        System.out.println("BIENVENVIDOS A CLINICAS MEDICAS ");
        System.out.println("--------------------------------");
        System.out.println("FAVOR SELECCIONE UNA DE LAS SIGUIENTES OPCIONES");
        System.out.println("1. Ingresar como Paciente");
        System.out.println("2. Ingresar como Médico");
        System.out.println("3. Salir");
        menuPrincipal = sc.nextInt();
        
        sc.nextLine();//LIMPIEZA BUFFER

        //SWITCH #1 MENU PRINCPIPAL Y LOGIN SEGUN TIPO DE USUARIO A INGRESAR
        
        switch (menuPrincipal) {
            case 1:
                ;
                IngresarUsuario(codigoPaciente, passwordPaciente, nombrePaciente, sc);
                
                SubmenuPaciente(sc);

                break;

            case 2:
                            
                IngresarUsuario(codigoMedico, passwordMedico, nombreMedico, sc);
                
                SubmenuMedico(sc);
               
                
                break;

            case 3:
                System.out.println("REGRESA PRONTO");

                break;

            default:
                System.out.println("OPCION NO VALIDA, VUELVA A INTENTARLO");
                break;
        }// FIN SWITCH MENU PRINCIPAL

        
              
            
        
    }// FIN MAIN
    
    
    // FUNCION INGRESAR USUARIO Y CONTRASENA PARA MEDICO Y PACIENTE
        public static void IngresarUsuario(String[] codigo, String[] password, String[] nombre, Scanner sc) { //código para verificar, password para verificar, nombre para mostrar

        String usuario = "JOHN DOE";
        String contrasena = "JOHN DOE";

        System.out.println("INGRESE SU USUARIO:");
        usuario = sc.next();

        System.out.println("INGRESE CONTRASENA:");
        contrasena = sc.next();

        boolean validado = false;

        //ciclo for: verificar el usuario y contrasena que escribio para mostrar el Dr correspondiente
        for (int i = 0; i < codigo.length; i++) { // recorre todo el ciclo buscando los datos del medico
            //ciclo if operadores logicos && 
            if (codigo[i].equalsIgnoreCase(usuario) && password[i].equalsIgnoreCase(contrasena)) { // equals para comparar strings
                validado = true;
                System.out.printf("BIENVENIDO: %s\n", nombre[i]);
                
                
           break; // Break para cerrar el ciclo
           
            }// fin if
        }// fin for
          
        if (validado == false) {
            System.out.println("USUARIO O CONTRASENA INCORRECTOS");
        }// fin if

    }// FIN FUNCION IngresarUsuario

    // FUNCION SUBMENU PACIENTE
        
    public static void SubmenuPaciente(Scanner sc) {
        
         int submenuPaciente =0; 
        System.out.println("--------------------------------");
        System.out.println("         MENU PACIENTE          ");
        System.out.println("--------------------------------");
        System.out.println("SELECCIONE UNA DE LAS SIGUIENTES OPCIONES");
       
        do {

            System.out.println("1. Menu de Citas ");
            System.out.println("2. Historial Medico");
            System.out.println("3. Registrar Informacion");
            System.out.println("4. Notificaciones");
            System.out.println("5. Consulta Medica por llamada");

            submenuPaciente = sc.nextInt();

            // Switch #3 submenuMedico   
            switch (submenuPaciente) {
                case 1:  
                       
                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:
                    break;

                case 5:
                    break;

                default:
        System.out.println("OPCION NO VALIDA, VUELVA A INTENTARLO");
                    break;
            }// FIN SWITCH  
        } while (submenuPaciente != 5);

    }// FiN FUNCION Submenu Paciente
             
    // FUNCION SUBMENU MEDICO
       
       public static void SubmenuMedico (Scanner sc) {
        
        int submenuMedico =0; 
        System.out.println("--------------------------------");
        System.out.println("         MENU MEDICO            ");
        System.out.println("--------------------------------");
        System.out.println("SELECCIONE UNA DE LAS SIGUIENTES OPCIONES");
       
        do {

            System.out.println("1. Ver citas asignadas");
            System.out.println("2. Consultar historial medico");
            System.out.println("3. Registrar diagnostico");
            System.out.println("4. Gestionar incapacidad");
            System.out.println("5. Atender consulta");
            System.out.println("6. Salir");

            submenuMedico = sc.nextInt();

            // Switch #3 submenuMedico   
            switch (submenuMedico) {
                case 1:  
                    MostrarCitasAsignadasMedico(citas);
                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:
                    break;

                case 5:
                    break;

                default:
        System.out.println("OPCION NO VALIDA, VUELVA A INTENTARLO");
                    break;
            }// FIN SWITCH  
        } while (submenuMedico != 5);

    }// FiN FUNCION submenuMedico
       
       
       
     public static void MostrarCitasAsignadasMedico(String[][] arreglo) {

        System.out.println("--------------------");
        System.out.println("   CITAS ASIGNADAS  ");
        System.out.println("--------------------");

        for (int i = 0; i < arreglo.length; i++) {
            System.out.printf("Codigo: %s\n", arreglo[i][0]);
            System.out.printf("Paciente: %s\n", arreglo[i][1]);
            System.out.printf("Medico: %s\n", arreglo[i][2]);
            System.out.printf("Fecha: %s\n", arreglo[i][3]);
            System.out.printf("Motivo: %s\n", arreglo[i][4]);
            System.out.printf("Estado: %s\n", arreglo[i][5]);
            System.out.println("----------------");
            
          

        }// Fin For 
           
       }// FIN FUNCION MOSTRAR CITAS ASIGNADA
       
       
        
        
    
    
    
}// FIN CLASS
