/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author mmcc28
 */


/*
 * SISTEMA DE GESTIÓN MÉDICA
 * Programación 1 - UNITEC Honduras - CEUTEC Teledocencia
 * Sección 72 - Grupo 8
 * Docente: Oscar Daniel Andrade
 * Integrantes: Mirna María Chávez Cerrato
 *              Liana Mirella Hernández Reyes
 * Fecha: Septiembre 2026
 *
 * Problemática: La gestión de citas médicas en centros de salud se realiza
 * de forma manual, dificultando la comunicación entre pacientes y médicos.
 * Los pacientes no cuentan con un medio para gestionar sus citas ni su
 * historial clínico, y los médicos dependen de procesos manuales para
 * organizar su agenda.
 *
 * Objetivo: Desarrollar un programa en Java que facilite al paciente y al médico optimizar los procesos de servicio de salud.
 * PACIENTE -> 1. Gestionar citas (visualizar,modificar y cancelar)
 *             2. Consultar historial medico
 *             3. Registar informacion personal de salud (alergias, peso)
 *             4. Administrar perfiles de familiares y recibir 
 *             5. Recibir Notificaciones de citas   
 *             6. Consulta por llamada o mensaje 
 *
 * MEDICO -> 1. Visualizar citas asignadas
 *           2. Consultar historial clinico de sus pacientes
 *           3. Registrar diagnostico   
 *           4. Gestionar incapacidades
 *           5. Atender consultas por llamada o mensaje
*/
public class ProyectoPrograG8 {

    /**
     * @param args the command line arguments
     */

    // VARIABLES GLOBALES 
    
    // Ayuda a que al momento de consultar solo me ejecute la informacion del usuario ingresado y no todos
    static String codigoPacienteActual=""; 
    
    // Formateador de fecha para validar el formato dd/MM/yyyy con LocalDate
    static DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // STRING BASE DE DATOS INFORMACION DE MEDICOS- arreglos unidimensionales
    static String[] nombreMedico = {"Dr. Alejandro Martinez", "Dra. Laura Hernandez", "Dr. Carlos Rojas", "Dra. Ana Soto", "Dr. Luis Perez"};
    static String[] codigoMedico = {"M001", "M002", "M003", "M004", "M005"};
    static String[] passwordMedico = {"Pass1", "Pass2", "Pass3", "Pass4", "Pass5"};
    static String[] especialidadMedico = {"Medicina General", "Dermatologia", "Pediatria", "Cardiologia", "Neurologia"};

    // STRING BASE DE DATOS INFORMACION DE PACIENTES- arreglos unidimensionales
    static String[] nombrePaciente = {"Maria Lopez", "Carlos Diaz", "Sofia Ramos", "Jorge Molina", "Lucia Torres"};
    static String[] codigoPaciente = {"P006", "P007", "P008", "P009", "P0010"};
    static String[] passwordPaciente = {"Pass6", "Pass7", "Pass8", "Pass9", "Pass10"};

    // STRING BASE DE DATOS CITAS  - arreglos Bidimensional 
    static String[][] citas = {
        {"P006", "Maria Lopez", "M001", "05/09/2026", "Control general", "Programada"},
        {"P007", "Carlos Diaz", "M002", "12/09/2026", "Dermatologia", "Programada"},
        {"P008", "Sofia Ramos", "M003", "15/09/2026", "Dolor lumbar", "Programada"},
        {"P009", "Jorge Molina", "M004", "18/09/2026", "Revision cardiaca", "Programada"},
        {"P0010", "Lucia Torres", "M005", "20/09/2026", "Consulta neurologia", "Programada"}
    };

    //STRING BASE DE DATOS HISTORIAL MEDICO- arreglo bidimensional
    static String[][] historialMedico = {
        {"P006", "Maria Lopez", "10/06/2026", "Hemograma", "Valores normales"},
        {"P007", "Carlos Diaz", "22/07/2026", "Radiografia", "Sin anomalias"},
        {"P008", "Sofia Ramos", "15/07/2026", "Radiografia lumbar", "Evaluacion requerida"},
        {"P009", "Jorge Molina", "20/07/2026", "Electrocardiograma", "Ritmo normal"},
        {"P0010", "Lucia Torres", "25/07/2026", "Resonancia", "Sin anomalias"}
    };
    
    
    // COLORES ANSI
    static String VERDE = "\u001B[32m";
    static String ROJO = "\u001B[31m";
    static String AMARILLO = "\u001B[33m";
    static String CYAN = "\u001B[36m";
    static String RESET = "\u001B[0m"; // RESETA AL COLOR NORMAL
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menuPrincipal = 0;

        // Repite el menu principal hasta que el usuario elija salir
        do {
            //MENSAJE BIENVENIDA 
            System.out.println("--------------------------------");
            System.out.printf("%sBIENVENVIDOS A CLINICAS MEDICAS%s\n", CYAN, RESET);
            System.out.println("--------------------------------");
            System.out.println("FAVOR SELECCIONE UNA DE LAS SIGUIENTES OPCIONES");
            System.out.println("1. Ingresar como Paciente");
            System.out.println("2. Ingresar como Medico");
            System.out.println("3. Salir");
            System.out.print("Opcion: ");
            menuPrincipal = sc.nextInt();
            sc.nextLine(); //LIMPIEZA BUFFER

            //SWITCH MENU PRINCIPAL Y LOGIN SEGUN TIPO DE USUARIO A INGRESAR
            switch (menuPrincipal) {
                case 1:
                    IngresarUsuario(codigoPaciente, passwordPaciente, nombrePaciente, sc, false);
                    break;

                case 2:
                    IngresarUsuario(codigoMedico, passwordMedico, nombreMedico, sc, true);
                    break;

                case 3:
                    System.out.println("REGRESA PRONTO");
                    break;

                default:
                    System.out.printf("%sOPCION NO VALIDA, VUELVA A INTENTARLO%s",ROJO,RESET);
                    break;
            } // FIN SWITCH MENU PRINCIPAL

        } while (menuPrincipal != 3);// sale cuando el usuario elige 3

    } // FIN MAIN

    // Verifica el usuario y contrasena, si son correctos redirige al usuario correspondiente, de lo contratio no permite ingresar
    public static void IngresarUsuario(String[] codigo, String[] password, String[] nombre, Scanner sc, boolean esMedico) {

        String usuario = "JOHN DOE";
        String contrasena = "JOHN DOE";

        System.out.println("INGRESE SU USUARIO:");
        usuario = sc.next();

        System.out.println("INGRESE CONTRASENA:");
        contrasena = sc.next();

        boolean validado = false;

        for (int i = 0; i < codigo.length; i++) { // recorre todo el ciclo buscando los datos del usuario
            if (codigo[i].equals(usuario) && password[i].equals(contrasena)) { // equals para comparar strings
                validado = true;
                System.out.printf("%sBIENVENIDO: %s%s\n", VERDE, nombre[i], RESET);

                if (esMedico == true) {
                    SubmenuMedico(sc, usuario);
                } else {
                    codigoPacienteActual = codigo[i]; // Linea para que al momento de ejecutar la funcion mostrar historial medico lo haga segun usuario ingresado
                    SubmenuPaciente(sc, usuario);
                }// fin if

                break; // Break para cerrar el ciclo

            }// fin if
        }// fin for

        if (validado == false) {
            System.out.printf("%sUSUARIO O CONTRASENA INCORRECTOS%s\n", ROJO, RESET);
        }// fin if

    }// FIN FUNCION IngresarUsuario

    // ---------- FUNCION SUBMENU PACIENTE-------------------
    
    // Muestra un submenu con 7 opciones del modulo de paciente dentro de un ciclo do-while
    public static void SubmenuPaciente(Scanner sc, String codigoPaciente) {
        int submenuPaciente = 0;

        do {
            System.out.println("--------------------------------");
            System.out.printf("%s         MENU PACIENTE          %s\n", CYAN, RESET);
            System.out.println("--------------------------------");
            System.out.println("SELECCIONE EL NUMERO QUE CORRESPONDE A LAS SIGUIENTES OPCIONES");
            System.out.println("1. Menu de Citas ");
            System.out.println("2. Historial Medico");
            System.out.println("3. Registrar Informacion");
            System.out.println("4. Registro Perfil Familiares");
            System.out.println("5. Notificaciones");
            System.out.println("6. Consultas LLamadas o Mensajes");
            System.out.println("7. Salir");

            submenuPaciente = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            //Swich #2 -> llama a la funcion segun la opcin elegida
            switch (submenuPaciente) {
                case 1:
                    OpcCitasPaciente(sc, codigoPaciente);
                    break;
                case 2:
                    VerHistorialMedico();
                    break;
                case 3:
                    RegistrarInformacionPersonalyFamiliares(sc);

                    break;
                case 4:
                    RegistroPerfilesFamiliares(sc);
                    break;
                case 5:
                    Notificaciones(codigoPaciente);
                    break;
                case 6:
                    GestionarConsultas(sc);
                    break;

                case 7:
                    System.out.println("Saliendo al menú principal...");
                    break;
                default:
                    System.out.printf("%sOPCION NO VALIDA, VUELVA A INTENTARLO%s", ROJO, RESET);
                    break;
            } // FIN SWITCH  
        } while (submenuPaciente != 7);
    } // FIN FUNCION Submenu Paciente

    // FUNCIONES SWITCH SUBMENUPACIENTE
    
    // Permite visualizar, modificar y cancelar citas
    public static void OpcCitasPaciente(Scanner sc, String codigoPaciente) {
        int opcionCita = 0;

        do {
            System.out.println("--------------------------------");
            System.out.printf("%s        MENU DE CITAS     %s\n", CYAN, RESET);
            System.out.println("--------------------------------");
            System.out.println("1. Visualizar Citas");
            System.out.println("2. Modificar Cita");
            System.out.println("3. Cancelar Cita");
            System.out.println("4. Volver a Menu Principal");
            System.out.print("Seleccione el Numero de La Opcion: ");
            opcionCita = sc.nextInt();
            sc.nextLine(); // Limpiar Buffer

            switch (opcionCita) {
                case 1:
                    System.out.printf("\n %s--- Ver Citas --- %s\n", CYAN, RESET);
                    boolean encontroCita = false;

                    for (int i = 0; i < citas.length; i++) {
                        if (citas[i][0].equals(codigoPaciente)) {
                            encontroCita = true;

                            String medNombre = "No asignado";
                            String medEspe = "General";
                            for (int j = 0; j < codigoMedico.length; j++) {
                                if (codigoMedico[j].equals(citas[i][2])) {
                                    medNombre = nombreMedico[j];
                                    medEspe = especialidadMedico[j];
                                }// Fin if case 1
                            }// Fin for case 1

                            System.out.printf("Medico: %s (%s)\n", medNombre, medEspe); // Mostrar Mensaje con datos de medico y especialidad 
                            System.out.printf("Fecha: %s\n", citas[i][3]);
                            System.out.printf("Motivo: %s\n", citas[i][4]);
                            System.out.printf("Estado: %s\n ", citas[i][5]);
                            System.out.println("----------------");
                        }// Fin if (Citas)
                    }// Fin for (Citas)

                    if (!encontroCita) {
                        System.out.printf("%s No tiene Cita Registrada %s", ROJO, RESET);
                    }// Fin if (encontroCita)
                    break;

                case 2:
                    boolean programado = false;
                    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("DD/MM/AAAA");

                    for (int i = 0; i < citas.length; i++) {
                        if (citas[i][0].equals(codigoPaciente)) {
                            programado = true;

                            if (citas[i][5].equals("Cancelada")) {
                                System.out.printf("%sNo puede reprogramar una cita ya cancelada.%s\n", ROJO, RESET);
                            } else {
                                LocalDate fechaValidada = null; // Nueva Funcion 

                                while (fechaValidada == null) {
                                    System.out.println("Ingrese la nueva fecha (DD/MM/AAAA):");
                                    String entradaFecha = sc.nextLine();

                                    try {
                                        LocalDate fechaIngresada = LocalDate.parse(entradaFecha, formateador);

                                        if (fechaIngresada.isBefore(LocalDate.now())) {
                                            System.out.printf("%sError: No puede programar en fecha pasada.%s\n", ROJO, RESET);
                                        } else {
                                            fechaValidada = fechaIngresada;
                                        }

                                    } catch (DateTimeParseException e) {
                                        System.out.printf("%sError: Use el formato DD/MM/AAAA (ej: 15/10/2026)%s\n", ROJO, RESET);
                                    }// fin 
                                }// fin while

                                citas[i][3] = fechaValidada.format(formateador);
                                System.out.printf("%sCita reprogramada con exito para: %s%s\n", VERDE, citas[i][3], RESET);
                            } // fin if #2 case 2
                        }// fin if case 2
                    }// fin for case 2

                    if (!programado) {
                        System.out.printf("%sNo se encontro ninguna cita para modificar%s\n", ROJO, RESET);
                    }// fin if
                    break;

                case 3:
                    boolean cancelado = false;

                    for (int i = 0; i < citas.length; i++) {
                        if (citas[i][0].equals(codigoPaciente)) {
                            cancelado = true;

                            if (citas[i][5].equals("Cancelada")) {
                                System.out.println("Cita ya cancelada");
                            } else {
                                System.out.println("Esta seguro que desea cancelar su cita?");
                                System.out.println("(Coloque un 1. si es Si / un 2. si es No)");
                                System.out.println("Respuesta:");
                                int confirmar = sc.nextInt();
                                sc.nextLine(); // Limpiar buffer

                                if (confirmar == 1) {
                                    citas[i][5] = "Cancelada";
                                    System.out.printf(" %s SU CITA HA SIDO CANCELADA CON EXITO!! %s \n", VERDE, RESET);
                                } else {
                                    System.out.println("Operación abortada");
                                }// Fin Else Operacion abortada
                            }// Fin else cancelar cita
                        }// fin if Citas
                    }// Fin For

                    if (!cancelado) {
                        System.out.printf("%sNo tienes citas para cancelar%s",AMARILLO,RESET);
                    }// Fin if cancelado
                    break;

                case 4:
                    System.out.println("Regresando al menú de paciente");
                    break;

                default:
                    System.out.printf("%sOpción no valida%s", ROJO, RESET);
                    break;
            }// Fin switch #2
        } while (opcionCita != 4);
    } // Fin Funcion OpcCitasPaciente

    // Muestra historial medico del paciente que inicio sesion
    public static void VerHistorialMedico() {

        boolean CuentaconHistorial = false;

        for (int i = 0; i < historialMedico.length; i++) {
            String codigo = historialMedico[i][0];

            if (codigo.equalsIgnoreCase(codigoPacienteActual)) { //  no importa si el usuario usa mayusculas o minusculas
                String nombre = historialMedico[i][1];
                String fecha = historialMedico[i][2];
                String estudio = historialMedico[i][3];
                String resultado = historialMedico[i][4];

                System.out.println("--------------------------------");
                System.out.printf("%s        HISTORIAL MEDICO     %s\n", CYAN, RESET);
                System.out.println("--------------------------------");
                System.out.printf("Codigo Usuario: %s\n", codigo.toUpperCase());
                System.out.printf("Nombre Paciente: %s\n", nombre.toUpperCase());
                System.out.printf("Fecha:            %s\n", fecha.toUpperCase());
                System.out.printf("Estudio Realizado:%s\n", estudio.toUpperCase());
                System.out.printf("Diagnostico:      %s\n\n", resultado.toUpperCase());
                CuentaconHistorial = true;
            }// Fin If
        }// Fin for
        if (!CuentaconHistorial) {
            System.out.printf("%s Usted No Tiene Historial Medico %s",ROJO,RESET);

        }

        System.out.println("");
        System.out.println("");

    }// FIN FUNCION VerHistorialMedico 
  
    // Registra informacion personal de salud del paciente peso, alergias y enfermedades base
    public static void RegistrarInformacionPersonalyFamiliares(Scanner sc) {
        String nombrePaciente = "@";
        double peso = 0;
        String enfermedadesBase = "@";
        String alergias = "@";

        System.out.println("Ingrese Su Nombre:");
        nombrePaciente = sc.nextLine();

        System.out.println("Ingrese Enfermedades Base:");
        enfermedadesBase = sc.nextLine();

        System.out.println("Ingrese Peso en KG:");
        peso = sc.nextDouble();

        sc.nextLine();

        System.out.println("Usted es Alergico a Algun Medicamento?");
        System.out.println("Si/No");
        System.out.println("Si su respuesta es Si Colocar a que medicamento es Alergico!!");
        System.out.println("Respuesta:");
        alergias = sc.nextLine();

        System.out.println("-------------------------");
        System.out.printf("%sNUEVO REGISTRO PERSONAL DE PACIENTE%s\n", VERDE, RESET);
        System.out.println("-------------------------");
        System.out.printf("Nombre Paciente:%s\n", nombrePaciente.toUpperCase());
        System.out.printf("Enfermedades Base Paciente:%s\n", enfermedadesBase.toUpperCase());
        System.out.printf("Peso (KG) Paciente:%.2f\n", peso);
        System.out.printf("Paciente Alergico(a):%s\n", alergias.toUpperCase());

    }// Fin Funcion RegistrarInformacionPersonalyFamiliares

    // Registra un perfil familiar valida la contrasena del paciente antes de continuar
    public static void RegistroPerfilesFamiliares(Scanner sc) {
        String passwordIngresada = "@";
        String agregarPerfil = "@";
        String parentezco = "@";

        System.out.println("Ingrese su Contraseña de Usuario:");
        passwordIngresada= sc.nextLine();
        
        boolean acceso = false;
        for (int i = 0; i < codigoPaciente.length; i++) {
            if (codigoPaciente[i].equals(codigoPacienteActual) && passwordPaciente[i].equals(passwordIngresada)) {
                acceso = true;
                break;
            }// Fin if 
        }// Fin for 

        if (acceso == false) {
            System.out.printf("%sContrasena incorrecta, Vuelva a Intentar!!%s\n", ROJO, RESET);
            return;
        }

        System.out.println("Que Parentezco Tiene con el Nuevo Usuario?");
        parentezco = sc.nextLine();

        System.out.println("---------------------------------");
        System.out.printf("%sINFORMACION SOBRE EL NUEVO PERFIL%s\n", CYAN, RESET);
        System.out.println("---------------------------------");
        System.out.println("Agregar Nombre y Apellido");
        System.out.println("");
        agregarPerfil = sc.nextLine();
        System.out.printf("%sPERFIL FAMILIAR AGREGADO CON EXITO:%s%s \n",VERDE, agregarPerfil.toUpperCase(), RESET);

    }// Fin FuncionRegistroPerfilesFamiliares

    // Muestra las citas programadas del paciente activo como notificaciones
    public static void Notificaciones(String CodigoPaciente) {

        boolean citasPendientes = false;

        System.out.println("--------------------------------");
        System.out.printf("%s        NOTIFICACIONES     %s\n", CYAN, RESET);
        System.out.println("--------------------------------");

        for (int i = 0; i < citas.length; i++) {
            if (citas[i][0].equals(CodigoPaciente) && citas[i][5].equalsIgnoreCase("PROGRAMADA")) { // Ignorando si el usuario escribe en mayuscula o minuscula
                System.out.printf("%sTiene Una Cita El dia: %s - Motivo: %s%s\n", AMARILLO, citas[i][3], citas[i][4], RESET);

                citasPendientes = true;

            }// fIN IF 

        }// Fin For
        if (!citasPendientes) {
            System.out.printf("%sNO TIENE CITAS PENDIENTES PARA ESTE DIA!!%s",ROJO,RESET);
        }// Fin if   

    }// Fin Funcion Notificaciones

    // Simula una consulta medica del paciente por llamada o mensaje usando switch con String
    public static void GestionarConsultas(Scanner sc) {
        String tipoConsulta = "@";
        String motivoConsulta = "@";

        System.out.println("--------------------------------");
        System.out.printf("%s        GESTIONAR CONSULTA     %s\n", CYAN, RESET);
        System.out.println("--------------------------------");
        System.out.println("");
        System.out.println("1. LLAMADA");
        System.out.println("2. MENSAJE");
        System.out.println("Respuesta: ");
        tipoConsulta = sc.nextLine();

        System.out.println("Motivo de Consulta:");
        motivoConsulta = sc.nextLine();

        switch (tipoConsulta) {
            case "1":
                System.out.printf("%sINICIANDO LLAMADA...%s\n", VERDE, RESET);
                System.out.printf("Motivo: %s\n", motivoConsulta);
                System.out.printf("%sCONSULTA EN CURSO, EN BREVE SE LE ASIGNARA UN MEDICO%s\n", VERDE, RESET);
                System.out.printf("%sPOR FAVOR ESPERE.....%s\n", AMARILLO, RESET);
                break;
            case "2":
                System.out.printf("%sENVIANDO MENSAJE...%s\n", VERDE, RESET);
                System.out.printf("Motivo: %s\n", motivoConsulta);
                System.out.printf("%sEN BREVE SE LE ASIGNARA UN MEDICO PARA ATENDER SU CONSULTA%s\n", VERDE, RESET);
                System.out.printf("%sPOR FAVOR ESPERE.....%s\n", AMARILLO, RESET);
                break;
            default:
                System.out.printf("%sOPCION NO VALIDA%s\n", ROJO, RESET);
        }// fin switch
    }// Fin FuncionGestionarConsultas

    //---------- FUNCION SUBMENU MEDICO-------------------
    
    // Muestra un submenu con 6 opciones del modulo de medico dentro de un ciclo do-while
    public static void SubmenuMedico(Scanner sc, String codigoMedico) {

        int submenuMedico = 0;
        System.out.println("--------------------------------");
        System.out.printf("%s      MENU MEDICO          %s\n", CYAN, RESET);
        System.out.println("--------------------------------");
        System.out.println("SELECCIONE EL NUMERO QUE CORRESPONDE A LAS SIGUIENTES OPCIONES");

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
                    System.out.printf("%sOPCION NO VALIDA, VUELVA A INTENTARLO%s",ROJO,RESET);
                    break;
            }// FIN SWITCH  
        } while (submenuMedico != 6);

    }// FiN FUNCION submenuMedico
    
    // FUNCIONES SWITCH SUBMENUMEDICO

    // Muestra las citas asignadas al medico que inicio sesion filtrando por su codigo
    public static void MostrarCitasAsignadasMedico(String[][] arregloCitas, String codigoMedico) {

        System.out.println("--------------------------------");
        System.out.printf("%s       CITAS ASIGNADAS     %s\n", CYAN, RESET);
        System.out.println("--------------------------------");;

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

    // El medico busca y muestra el historial medico de un paciente por su codigo
    public static void MostrarHistorialMedico(String[][] arregloHistorial, Scanner sc) {

        String codigoPaciente = "John Doe";
        boolean encontrado = false;

        System.out.println("--------------------------------");
        System.out.printf("%s       HISTORIAL MEDICO     %s\n", CYAN, RESET);
        System.out.println("--------------------------------");

        System.out.println("INGRESE EL CODIGO DEL PACIENTE");
        codigoPaciente = sc.next();

        for (int i = 0; i < arregloHistorial.length; i++) {

            if (arregloHistorial[i][0].equals(codigoPaciente)) {
                encontrado = true;

                System.out.printf("codigo Paciente: %s\n", arregloHistorial[i][0]);
                System.out.printf("Nombre Paciente: %s\n", arregloHistorial[i][1]);
                System.out.printf("Fecha: %s\n", arregloHistorial[i][2]);
                System.out.printf("Estudio: %s\n", arregloHistorial[i][3]);
                System.out.printf("Resultados: %s\n", arregloHistorial[i][4]);
                System.out.println("----------------");

            }// Fin if
        }// Fin For
        if (encontrado == false) {
            System.out.printf("%sPACIENTE NO ENCONTRADO O SIN HISTORIAL REGISTRADO%s\n", ROJO, RESET);
        }// Fin if 
    }// FIN FUNCION MostrarHistorialMedico

    // Registra el diagnostico y observaciones de un paciente de forma temporal
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
        System.out.printf("%sDIAGNOSTICO REGISTRADO  %s\n", VERDE, RESET);
        System.out.printf("Nombre: %s\n", nombrePaciente);
        System.out.printf("Diagnostico: %s\n", diagnosticoPaciente);
        System.out.printf("Observaciones: %s\n", observacionesPaciente);
        System.out.println("--------------------------");

    }// FIN FUNCION RegistrarDiagnostico

    // Emite una incapacidad laboral  corta (1-3 dias) o prolongada (mas de 3 tramite IHSS)
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
            System.out.printf("%sERROR: DIAS NO VALIDOS%s",ROJO,RESET);
        } else if (diasIncapacidad <= 3) {
            System.out.printf("%sINCAPACIDAD CORTA REGISTRADA%s\n", VERDE,RESET);
            System.out.println("-------------------------------");
            System.out.printf("Paciente: %s\n", nombrePaciente);
            System.out.printf("Dias: %d\n", diasIncapacidad);
            System.out.printf("Motivo: %s\n", motivoIncapacidad);
            System.out.println("------------------------------");
        } else {
            System.out.printf("%sINCAPACIDAD PROLONGADA%s\n", AMARILLO, RESET);
            System.out.printf("%sREFERIR AL INSTITUTO HONDURENO DE SEGURIDAD SOCIAL%s\n", AMARILLO, RESET);
            System.out.println("-------------------------------");
            System.out.printf("Paciente: %s\n", nombrePaciente);
            System.out.printf("Dias: %d\n", diasIncapacidad);
            System.out.printf("Motivo: %s\n", motivoIncapacidad);
            System.out.println("------------------------------");
        }// FIN IF

    }// FIN FUNCION GestionarIncapacidades

    // Simula la atencion de una consulta medica por llamada o por mensaje
    public static void AtenderConsulta(Scanner sc) {

        int tipoConsulta = 0;
        String motivoConsulta = "@";

        System.out.println("--------------------------------");
        System.out.printf("%s       ATENDER CONSULTA     %s\n", CYAN, RESET);
        System.out.println("--------------------------------");
        System.out.println("1. Por llamada");
        System.out.println("2. Por mensaje");
        System.out.print("SELECCIONE UNA OPCION: ");
        tipoConsulta = sc.nextInt();
        sc.nextLine();

        System.out.println("INGRESE MOTIVO DE CONSULTA:");
        motivoConsulta = sc.nextLine();

        switch (tipoConsulta) {
            case 1:
                System.out.printf("%sINICIANDO LLAMADA...%s\n", VERDE, RESET);
                System.out.printf("Motivo: %s\n", motivoConsulta);
                System.out.printf("%sCONSULTA POR LLAMADA ATENDIDA%s\n", VERDE, RESET);
                break;
            case 2:
                System.out.printf("%sENVIANDO MENSAJE...%s\n", VERDE, RESET);
                System.out.printf("Motivo: %s\n", motivoConsulta);
                System.out.printf("%sCONSULTA POR MENSAJE ATENDIDA%s\n", VERDE, RESET);
                break;
            default:
                System.out.printf("%sOPCION NO VALIDA%s\n", ROJO, RESET);
        }
    }// FIN FUNCION AtenderConsulta

}// Fin de Class

    