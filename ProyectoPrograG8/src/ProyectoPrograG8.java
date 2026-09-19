/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author mmcc28
 */
public class ProyectoPrograG8 {

    /**
     * @param args the command line arguments
     */

    static String codigoPacienteActual=""; // Ayuda a que al momento de consultar solo me ejecute la informacion del usuario ingresado y no todos
    
    // STRING BASE DE DATOS PRECARGADA INFORMACION DE MEDICOS- arreglos unidimensionales
    static String[] nombreMedico = {"Dr. Alejandro Martinez", "Dra. Laura Hernandez", "Dr. Carlos Rojas", "Dra. Ana Soto", "Dr. Luis Perez"};
    static String[] codigoMedico = {"M001", "M002", "M003", "M004", "M005"};
    static String[] passwordMedico = {"Pass1", "Pass2", "Pass3", "Pass4", "Pass5"};
    static String[] especialidadMedico = {"Medicina General", "Dermatologia", "Pediatria", "Cardiologia", "Neurologia"};

    // STRING BASE DE DATOS PRECARGADA INFORMACION DE PACIENTES- arreglos unidimensionales
    static String[] nombrePaciente = {"Maria Lopez", "Carlos Diaz", "Sofia Ramos", "Jorge Molina", "Lucia Torres"};
    static String[] codigoPaciente = {"P006", "P007", "P008", "P009", "P0010"};
    static String[] passwordPaciente = {"Pass6", "Pass7", "Pass8", "Pass9", "Pass10"};

    // StRING BASE DE DATOS PRECARGADA CITAS  - arreglos Bidimensional 
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

     
    
    public static void main(String[] args) {
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
            System.out.print("Opción: ");
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
                    System.out.println("OPCION NO VALIDA, VUELVA A INTENTARLO");
                    break;
            } // FIN SWITCH MENU PRINCIPAL

        } while (menuPrincipal != 3);

    } // FIN MAIN

    public static void IngresarUsuario(String[] codigo, String[] password, String[] nombre, Scanner sc, boolean esMedico) { //código para verificar, password para verificar, nombre para mostrar

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

                if (esMedico == true) {
                    SubmenuMedico(sc, usuario);
                } else {
                    codigoPacienteActual=codigo[i]; // Linea para que al momento de ejecutar la funcion mostrar historial medico lo haga segun usuario ingresado
                    
                    SubmenuPaciente(sc, usuario);
                }// finn if

                

                break; // Break para cerrar el ciclo

            }// fin if
        }// fin for

        if (validado == false) {
            System.out.println("USUARIO O CONTRASENA INCORRECTOS");
        }// fin if

    }// FIN FUNCION IngresarUsuario

    // FUNCION SUBMENU PACIENTE
    public static void SubmenuPaciente(Scanner sc, String codigoPaciente ) {
        int submenuPaciente = 0;

        do {
            System.out.println("--------------------------------");
            System.out.println("         MENU PACIENTE          ");
            System.out.println("--------------------------------");
            System.out.println("SELECCIONE UNA DE LAS SIGUIENTES OPCIONES");
            System.out.println("1. Menu de Citas ");
            System.out.println("2. Historial Medico");
            System.out.println("3. Registrar Informacion");
            System.out.println("4. Registro Perfil Familiares");
            System.out.println("5. Notificaciones");
            System.out.println("6. Consultas LLamadas o Mensajes");
            System.out.println("7. Salir");

            submenuPaciente = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

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
                    Notificicaciones(codigoPaciente);
                    break;
                case 6:
                    GestionarConsultas(sc);
                    break;
                
                case 7:
                    System.out.println("Saliendo al menú principal...");
                    break;    
                default:
                    System.out.println("OPCION NO VALIDA, VUELVA A INTENTARLO");
                    break;
            } // FIN SWITCH  
        } while (submenuPaciente != 7);
    } // FIN FUNCION Submenu Paciente

    // FUNCIONES SWITCH SUBMENUPACIENTE
   public static void OpcCitasPaciente(Scanner sc, String codigoPaciente) {
    int opcionCita = 0;
    
    do {
        System.out.println("---Menu Citas----");
        System.out.println("1. Visualizar Citas");
        System.out.println("2. Modificar Cita");
        System.out.println("3. Cancelar Cita");
        System.out.println("4. Volver a Menu Principal");
        System.out.print("Seleccione el Numero de La Opcion: ");
        opcionCita = sc.nextInt();
        sc.nextLine(); // Limpiar Buffer

        switch (opcionCita) {
            case 1:
                System.out.println("\n--- Ver Citas ---");
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
                            }// Fin if cogido medico
                        }// Fin for
                        
                        System.out.println("Médico: " + medNombre + " (" + medEspe + ")"); // Mostrar Mensaje con datos de medico y especialidad 
                        System.out.printf("Fecha: %s\n", citas[i][3]);
                        System.out.printf("Motivo: %s\n",citas[i][4]);
                        System.out.printf("Estado: %s\n ", citas[i][5]);
                        System.out.println("----------------");
                    }// Fin if (Citas)
                }// Fin for (Citas)
                
                if (!encontroCita) {
                System.out.printf("%s No tiene Cita Registrada %s","\u001B[31m","\u001B[0m");
                }// Fin if (encontroCita)
                break;

            case 2:
                boolean programado = false;
                
                for (int i = 0; i < citas.length; i++) {
                    if (citas[i][0].equals(codigoPaciente)) {
                        programado = true;
                        
                        if (citas[i][5].equals("Cancelada")) {
                            System.out.println("No puede programar una cita que ya fue cancelada.");
                        }// Fin If (Citas Cancelada)
                        else {
                            System.out.println("Ingrese la nueva fecha (AAA/MM/DD):");
                            String nuevaFecha = sc.nextLine();
                            citas[i][3] = nuevaFecha; 
                            System.out.println("Cita programada con exito para el día " + nuevaFecha + "!");
                        }// Fin else (para ingresar nueva cita)
                    }// Fin if
                }// Fin For 
                
                if (!programado) {
                System.out.printf("%s No se encontró ninguna cita para modificar %s","\u001B[31m","\u001B[0m");
                }// Fin If
                break; 

            case 3:
                boolean cancelado = false;
                
                for (int i = 0; i < citas.length; i++) {
                    if (citas[i][0].equals(codigoPaciente)) {
                        cancelado = true;
                        
                        if (citas[i][5].equals("Cancelada")) {
                            System.out.println("Cita ya cancelada");
                        } else {
                            System.out.println("¿Está seguro que desea cancelar su cita?");
                            System.out.println("(1. Si / 2. No)");
                            System.out.println("Respuesta:");
                            int confirmar = sc.nextInt();
                            sc.nextLine(); // Limpiar buffer
                            
                            if (confirmar == 1) {
                                citas[i][5] = "Cancelada"; 
                                System.out.println("Su cita ha sido cancelada");
                            } else {
                                System.out.println("Operación abortada.");
                            }// Fin Else Operacion abortada
                        }// Fin else cancelar cita
                    }// fin if Citas
                }// Fin For
                
                if (!cancelado) {
                    System.out.println("No tienes citas para cancelar");
                }// Fin IF
                break;

            case 4:
                System.out.println("Regresando al menú de paciente");
                break;

            default:
                System.out.println("Opción no válida.");
                break;
        }
    } while (opcionCita != 4);
} // Fin Funcion OpcCitasPaciente
         
  public static void VerHistorialMedico() {
 
      boolean CuentaconHistorial=false;
      
      for (int i=0; i<historialMedico.length;i++){
          String codigo = historialMedico [i][0];
          
          if (codigo.equalsIgnoreCase(codigoPacienteActual)){ //  no importa si el usuario usa mayusculas o minusculas
          String nombre= historialMedico [i][1];
          String fecha= historialMedico[i][2];
          String estudio=historialMedico[i][3];
          String resultado=historialMedico [i][4];
          
              System.out.println("SU HISTORIAL MEDICO");
              System.out.println("---------------------------");
              System.out.printf("Codigo Usuario: %s\n", codigo.toUpperCase());
              System.out.printf("Nombre Paciente: %s\n", nombre.toUpperCase());
              System.out.printf("Fecha:            %s\n", fecha.toUpperCase());
              System.out.printf("Estudio Realizado:%s\n", estudio.toUpperCase());
              System.out.printf("Diagnostico:      %s\n\n", resultado.toUpperCase());
              System.out.println("---------------------------");
             CuentaconHistorial=true;
          }// Fin If
      }// Fin for
           if(!CuentaconHistorial){
               System.out.printf("%s Usted No Tiene Historial Medico %s","\u001B[31m","\u001B[0m");
               
           } 
      
      System.out.println("");
      System.out.println("");

    }// FIN FUNCION VerHistorialMedico 
  
  public static void RegistrarInformacionPersonalyFamiliares(Scanner sc){
      String codigoPaciente="@";
      String nombrePaciente="@";
      double peso=0;
      String enfermedadesBase="@";
      String alergias="@";

      
      System.out.println("Ingrese Su Codigo de Usuario:");
      codigoPaciente=sc.nextLine();
      
      System.out.println("Ingrese Su Nombre:");
      nombrePaciente=sc.nextLine();
      
      System.out.println("Ingrese Enfermedades Base:");
      enfermedadesBase=sc.nextLine();
      
      
      System.out.println("Ingrese Peso en KG:");
      peso=sc.nextDouble();
      
      sc.nextLine();
      
      System.out.println("Usted es Alergico a Algun Medicamento?");
      System.out.println("Si/No");
      System.out.println("Si su respuesta es Si Colocar a que medicamento es Alergico!!");
      System.out.println("Respuesta:");
      alergias=sc.nextLine();
      
      System.out.println("-------------------------");
      System.out.println("NUEVO REGISTRO PERSONAL DE PACIENTE");
      System.out.println("-------------------------");
      System.out.printf("Codigo Paciente:%s\n",codigoPaciente.toUpperCase());
      System.out.printf("Nombre Paciente:%s\n",nombrePaciente.toUpperCase());
      System.out.printf("Enfermedades Base Paciente:%s\n",enfermedadesBase.toUpperCase());
      System.out.printf("Peso (KG) Paciente:%s\n",peso);
      System.out.printf("Paciente Alergico(a):%s\n",alergias.toUpperCase());
      
  }// Fin Funcion RegistrarInformacionPersonalyFamiliares
  
  public static void RegistroPerfilesFamiliares(Scanner sc){
      String codigoPaciente="@";
      String nombrePaciente="@";
      String agregarPerfil="@";
      String parentezco="@";
      
      System.out.println("Ingrese su Codigo de Usuario:");
      codigoPaciente=sc.nextLine();
      
      System.out.println("Ingrese su Nombre:");
      nombrePaciente=sc.nextLine();
      
      System.out.println("Que Parentezco Tiene con el Nuevo Usuario?");
      parentezco=sc.nextLine();
              
      System.out.println("---------------------------------");
      System.out.println("INFORMACION SOBRE EL NUEVO PERFIL");
      System.out.println("---------------------------------");
      System.out.println("Agregar Nombre y Apellido");
      System.out.println("");
      agregarPerfil=sc.nextLine();
      
      System.out.println("-------------------------");
      System.out.println("NUEVO REGISTRO DE PERFIL FAMILIAR");
      System.out.println("-------------------------");
      System.out.printf("PERFIL FAMILIAR AGREGADO CON EXITO:%s\n",agregarPerfil.toUpperCase());
      
      
  }// Fin FuncionRegistroPerfilesFamiliares
  
  public static void Notificicaciones(String CodigoPaciente){
      
      boolean citasPendientes=false;
      
      System.out.println("------------------------ ");
      System.out.println("NOTIFICACIONES Y ALERTAS");
      System.out.println("------------------------ ");
      
      for (int i = 0; i < citas.length; i++) {
          if (citas[i][0].equals(CodigoPaciente) && citas[i][5].equalsIgnoreCase("PROGRAMADA")) { // Ignorando si el usuario escribe en mayuscula o minuscula
              System.out.printf("Tiene Una Cita El dia: %s - Motivo: %s\n", citas[i][3], citas[i][4]);

              citasPendientes = true;

          }// fIN IF 

      }// Fin For
        if (!citasPendientes){
               System.out.printf("%sNO TIENE CITAS PENDIENTES PARA ESTE DIA!!%s","\u001B[31m","\u001B[0m");   
          }// Fin if   
      
  }// Fin Funcion Notificaciones
  public static void GestionarConsultas(Scanner sc){
      String tipoConsulta="@";
      String motivoConsulta="@";
     
        System.out.println("       GESTIONAR CONSULTA       ");
        System.out.println("");
        System.out.println("1. LLAMADA");
        System.out.println("2. MENSAJE");
        System.out.println("Respuesta: ");
        tipoConsulta = sc.nextLine();
    
        System.out.println("Motivo de Consulta:");
        motivoConsulta = sc.nextLine();

        switch (tipoConsulta) {
            case "1":
                System.out.println("INICIANDO LLAMADA...");
                System.out.printf("Motivo: %s\n", motivoConsulta);
                System.out.println("CONSULTA EN CURSO, EN BREVE SE LE ASIGNARA UN MEDICO");
                System.out.println("POR FAVOR ESPERE.....");
                  break;
            case "2":
                System.out.println("ENVIANDO MENSAJE...");
                System.out.printf("Motivo: %s\n", motivoConsulta);
                System.out.println("EN BREVE SE LE ASIGNARA UN MEDICO PARA ATENDER SU CONSULTA");
                System.out.println("POR FAVOR ESPERE.....");
                break;
            default:
                System.out.println("OPCION NO VALIDA");
        }// fin switch
  }// Fin FuncionGestionarConsultas
  
  
   //FUNCIONES SWITCH SUBMENU MEDICO
     
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
                    MostrarCitasAsignadasMedico(citas,codigoMedico);
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


    }// FiN FUNCION submenuMedico
    
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
        System.out.printf("Nombre: %s\n", nombrePaciente);
        System.out.printf("Diagnostico: %s\n", diagnosticoPaciente);
        System.out.printf("Observaciones: %s\n", observacionesPaciente);
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
            System.out.println("INCAPACIDAD CORTA REGISTRADA");
            System.out.println("-------------------------------");
            System.out.printf("Paciente: %s\n", nombrePaciente);
            System.out.printf("Dias: %d\n", diasIncapacidad);
            System.out.printf("Motivo: %s\n", motivoIncapacidad);
            System.out.println("------------------------------");
        } else {
            System.out.println("INCAPACIDAD PROLONGADA");
            System.out.println("REFERIR AL INSTITUTO HONDUREÑO DE SEGURIDAD SOCIAL");
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
    
}// Fin de Class

    