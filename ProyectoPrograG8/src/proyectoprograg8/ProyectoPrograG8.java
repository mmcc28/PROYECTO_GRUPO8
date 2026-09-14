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

    // StRING BASE DE DATOS PRECARGADA CITAS  - arreglos Bidimensional 
    static String[][] citas = {
        {"P006", "María López", "M001", "05/09/2026", "Control general", "Programada"},
        {"P007", "Carlos Díaz", "M002", "12/09/2026", "Dermatologia", "Programada"},
        {"P008", "Sofía Ramos", "M003", "15/09/2026", "Dolor lumbar", "Programada"},
        {"P009", "Jorge Molina", "M004", "18/09/2026", "Revision cardiaca", "Programada"},
        {"P0010", "Lucía Torres", "M005", "20/09/2026", "Consulta neurologia", "Programada"}
    };

    //STRING BASE DE DATOS HISTORIAL MEDICO- arreglo bidimensional
    static String[][] historialMedico = {
        {"P006", "María López", "10/06/2026", "Hemograma", "Valores normales"},
        {"P007", "Carlos Díaz", "22/07/2026", "Radiografia", "Sin anomalias"},
        {"P008", "Sofía Ramos", "15/07/2026", "Radiografia lumbar", "Evaluacion requerida"},
        {"P009", "Jorge Molina", "20/07/2026", "Electrocardiograma", "Ritmo normal"},
        {"P0010", "Lucía Torres", "25/07/2026", "Resonancia", "Sin anomalias"}
    };

    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);
        int menuPrincipal = 0;

        do {
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

            //SWITCH MENU PRINCPIPAL Y LOGIN SEGUN TIPO DE USUARIO A INGRESAR
            switch (menuPrincipal) {
                case 1:
                ;
                    IngresarUsuario(codigoPaciente, passwordPaciente, nombrePaciente, sc);

                    SubmenuPaciente(sc);

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

        } while (menuPrincipal != 3);

    }// FIN MAIN
    
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
            if (codigo[i].equals(usuario) && password[i].equals(contrasena)) { // equals para comparar strings
                validado = true;
                System.out.printf("BIENVENIDO: %s\n", nombre[i]);
                SubmenuMedico(sc, usuario);

                break; // Break para cerrar el ciclo

            }// fin if
        }// fin for

        if (validado == false) {
            System.out.println("USUARIO O CONTRASENA INCORRECTOS");
        }// fin if

    }// FIN FUNCION IngresarUsuario

    public static void SubmenuPaciente(Scanner sc) {

        int submenuPaciente = 0;
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

    }// FFIN FUNCION Submenu Paciente
    
    //FUNCIONES SWITCH SUBMENUPACIENTE
    
    
    
    
    public static void SubmenuMedico(Scanner sc, String codigoMedico) {

        int submenuMedico = 0;
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
                    MostrarCitasAsignadasMedico(citas, codigoMedico);
                    break;

                case 2:
                    MostrarHistorialMedico(historialMedico, sc);

                    break;

                case 3:

                    sc.nextLine(); // Limpieza buffer por el enter del menu
                    RegistarDiagnostico(sc);

                    break;

                case 4:
                    sc.nextLine(); // Limpieza buffer por el enter del menu
                    GestionarIncapacidades(sc);
                    break;

                case 5:
                    sc.nextLine();// Limpieza buffer por el enter del menu
                    AtenderConsulta(sc);
                    break;

                case 6:
                    System.out.println("VOLVIENDO AL MENU PRINCIPAL....");
                    break;

                default:
                    System.out.println("OPCION NO VALIDA, VUELVA A INTENTARLO");
                    break;
            }// FIN SWITCH  
        } while (submenuMedico != 6);

    }// FIN FUNCION submenuMedico

    //FUNCIONES SWITCH SUBMENU MEDICO
    public static void MostrarCitasAsignadasMedico(String[][] arregloCitas, String codigoMedico) {

        System.out.println("--------------------");
        System.out.println("   CITAS ASIGNADAS  ");
        System.out.println("--------------------");

        for (int i = 0; i < arregloCitas.length; i++) {
            if (arregloCitas[i][2].equals(codigoMedico)) {
                // printf de cada columna
                System.out.printf("codigo Paciente: %s\n", arregloCitas[i][0]);
                System.out.printf("Nombre Paciente: %s\n", arregloCitas[i][1]);
                System.out.printf("Medico: %s\n", arregloCitas[i][2]);
                System.out.printf("Fecha: %s\n", arregloCitas[i][3]);
                System.out.printf("Motivo: %s\n", arregloCitas[i][4]);
                System.out.printf("Estado: %s\n", arregloCitas[i][5]);
                System.out.println("----------------");

            }// Fin if
        }// Fin for

    }// FIN FUNCION MostrarCitasAsignadasMedicas

    public static void MostrarHistorialMedico(String[][] arregloHistorial, Scanner sc) {

        String codigoPaciente = "John Doe";

        System.out.println("--------------------");
        System.out.println("  HISTORIAL MEDICO  ");
        System.out.println("--------------------");

        System.out.println("INGRESE EL CODIGO DEL PACIENTE");
        codigoPaciente = sc.next();

        for (int i = 0; i < arregloHistorial.length; i++) {

            if (arregloHistorial[i][0].equals(codigoPaciente)) {

                System.out.printf("codigo Paciente: %s\n", arregloHistorial[i][0]);
                System.out.printf("Nombre Paciente: %s\n", arregloHistorial[i][1]);
                System.out.printf("Fecha: %s\n", arregloHistorial[i][2]);
                System.out.printf("Estudio: %s\n", arregloHistorial[i][3]);
                System.out.printf("Resultados: %s\n", arregloHistorial[i][4]);
                System.out.println("----------------");

            }// Fin if
        }// Fin For

    }// FIN FUNCION MostrarHistorialMedico

    public static void RegistarDiagnostico(Scanner sc) {

        String codigoPaciente = "@";
        String nombrePaciente = "@";
        String diagnosticoPaciente = "John Doe";
        String observacionesPaciente = "John Doe";

        System.out.println("INGRESE NOMBRE DEL PACIENTE");
        nombrePaciente = sc.nextLine();

        System.out.println("INGRESE CODIGO DEL PACIENTE");
        codigoPaciente = sc.nextLine();

        System.out.println("INGRESE DIAGNOSTICO DEL PACIENTE");
        diagnosticoPaciente = sc.nextLine();

        System.out.println("INGRESE OBSERVACIONES ");
        observacionesPaciente = sc.nextLine();

        System.out.println("--------------------------");
        System.out.println("  DIAGNOSTICO REGISTRADO  ");
        System.out.printf("Nombre Paciente: %s\n Diagnostico: %s\n Observaciones: %s\n", nombrePaciente, diagnosticoPaciente, observacionesPaciente);
        System.out.println("--------------------------");

    }// FIN FUNCION RegistrarDiagnostico

    public static void GestionarIncapacidades(Scanner sc) {

        int diasIncapacidad = 0;
        String nombrePaciente = "@";
        String motivoIncapacidad = "@";

        System.out.println("INGRESE NOMBRE DEL PACIENTE:");
        nombrePaciente = sc.nextLine();

        System.out.println("INGRESE DIAS DE INCAPACIDAD");
        diasIncapacidad = sc.nextInt();

        sc.nextLine(); // limpia buffer

        System.out.println("INGRESE MOTIVO:");
        motivoIncapacidad = sc.nextLine();

        if (diasIncapacidad <= 0) {
            System.out.println("ERROR: DIAS NO VALIDOS");
        } else if (diasIncapacidad <= 3) {
            System.out.println("INCAPACIDAD REGISTRADA");
            
            System.out.println("");
            System.out.println("-------------------------------");
            System.out.printf("Paciente: %s\n", nombrePaciente);
            System.out.printf("Dias: %d\n", diasIncapacidad);
            System.out.printf("Motivo: %s\n", motivoIncapacidad);
            System.out.println("------------------------------");

        }// FIN IF

    }// FIN FUNCION GestionarIncapacidades

    public static void AtenderConsulta(Scanner sc) {

        int tipoConsulta = 0;
        String motivoConsulta = "@";

        System.out.println("-------------------------------");
        System.out.println("       ATENDER CONSULTA        ");
        System.out.println("-------------------------------");
        System.out.println("1. Por llamada");
        System.out.println("2. Por mensaje");
        System.out.print("SELECCIONE UNA OPCION: ");
        tipoConsulta = sc.nextInt();
        sc.nextLine();

        System.out.println("INGRESE MOTIVO DE CONSULTA:");
        motivoConsulta = sc.nextLine();

        switch (tipoConsulta) {
            case 1:
                System.out.println("INICIANDO LLAMADA...");
                System.out.printf("Motivo: %s\n", motivoConsulta);
                System.out.println("CONSULTA POR LLAMADA ATENDIDA");
                break;
            case 2:
                System.out.println("ENVIANDO MENSAJE...");
                System.out.printf("Motivo: %s\n", motivoConsulta);
                System.out.println("CONSULTA POR MENSAJE ATENDIDA");
                break;
            default:
                System.out.println("OPCION NO VALIDA");
        }// fin switch

    }// FIN FUNCION AtenderConsulta
    
    
    
}// FIN CLASS
