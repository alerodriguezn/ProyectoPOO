import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.lang.model.util.ElementScanner6;

public class Principal {

    public static ArrayList<Coordinador> listaCoordinadores = new ArrayList<Coordinador>();
    public static ArrayList<Profesor> listaProfesores = new ArrayList<Profesor>();

    public static ArrayList<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();

    public static boolean permisosUsuarios;
    public static Profesor profesorLogeado;
    public static Coordinador coordinadorLogeado;


    //Funcion para pruebas
    public static void cargarDatos(){
        Profesor  us1 = new Profesor("Leo", "8523-1232", "leo@leo.com", "leo", "leo123");
        Coordinador us2 = new Coordinador("Admin", "2022-2202", "admin@admin.com", "admin", "123");
        Estudiante es1 = new Estudiante("Alejandro", 2022230350, new Date(2002,11,19), (byte)19, "Masculino", "La Fortuna");
        Estudiante es2 = new Estudiante("Deivid", 2022180126, new Date(2002,11,23), (byte)19, "Masculino", "Santa Clara");
        listaProfesores.add(us1);
        listaCoordinadores.add(us2);
        listaEstudiantes.add(es1);
        listaEstudiantes.add(es2);

    }

    public static void main(String[] args) {

        cargarDatos();
    
        funciones f = new funciones(); //Archivo con funciones.

        //us2.registrarUsuario();

        while(true){
            f.menuInicioSesion();

            System.out.print("Elija Una Opcion: ");
            Scanner in = new Scanner(System.in);
            String opcionLogin = in.nextLine();

            if (opcionLogin.equals("1")){

                System.out.print("Usuario: ");
                String usuario = in.nextLine();

                System.out.print("Contraseña: ");
                String contrasena = in.nextLine();

                if((f.validarCoordinador(usuario, contrasena, listaCoordinadores)) && (permisosUsuarios == true) ){

                    while(true){
                        f.menuCoordinador();
                        System.out.print("Elija una opcion: ");
                        String opcion = in.nextLine();

                        if(opcion.equals("1")){

                        }
                        else if(opcion.equals("2")){
                            f.limpiarConsola();
                            System.out.println("=== Registrando Estudiante..... ===");
                            System.out.print("Nombre Completo: ");
                            String nombreC = in.nextLine();
                            System.out.print("Carnet: ");
                            String carnet = in.nextLine();
                            System.out.print("Fecha Nacimiento(dd-mm-aa): ");
                            String fecha = in.nextLine();
                            System.out.print("Edad: ");
                            String edad = in.nextLine();
                            System.out.print("Genero: ");
                            String genero = in.nextLine();
                            System.out.print("Lugar de Procedencia: ");
                            String lugarProcedencia = in.nextLine();

                            coordinadorLogeado.registrarEstudiante(nombreC, Integer.parseInt(carnet), new Date(f.obtenerFecha(fecha, "dia"),f.obtenerFecha(fecha, "mes"),f.obtenerFecha(fecha, "anio")), (byte) Integer.parseInt(edad), genero, lugarProcedencia);

                            System.out.println("=== Estudiante Registrado Correctamente..... ===");

                            f.limpiarConsola();
                            System.out.println("Lista de Estudiantes: ");
                            f.imprimirListaEstudiantes(listaEstudiantes);

                            System.out.print("Presione enter para continuar.....");
                            String aux = in.nextLine();

                        }
                        else if(opcion.equals("3")){

                        }
                        else if(opcion.equals("4")){

                        }
                        else if(opcion.equals("5")){

                        }
                        else if(opcion.equals("6")){

                        }
                        else if(opcion.equals("s")){
                            break;
                        }
                    }
    
                }
                
            }else if(opcionLogin.equals("2")){

                System.out.print("Usuario: ");
                String usuario = in.nextLine();

                System.out.print("Contraseña: ");
                String contrasena = in.nextLine();


                if((f.validarProfesor(usuario, contrasena, listaProfesores)) && (permisosUsuarios == false)  ){

                    while(true){
                        f.menuProfesor();
                        System.out.print("Elija una opcion: ");
                        String opcion = in.nextLine();

                        if(opcion == "1"){

                        }
                        else if(opcion == "2"){
                        

                        }
                        else if(opcion == "3"){

                        }
                        else if(opcion == "4"){

                        }
                        else if(opcion == "5"){

                        }
                        else if(opcion == "6"){

                        }
                    }
                              
                }
            }else{
                System.out.println("Dato incorrecto");
            }

        }
        
    }

    
}
