import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;


public class Principal {

    public static void limpiarConsola(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Funcion que imprime las multiples opciones para Iniciar Sesion
     */
    public static void menuInicioSesion(){
        limpiarConsola();
        System.out.println(" ==========================================");
        System.out.println(" ============ INICIO DE SESION ============\n");
        System.out.println(" ==== 1. Iniciar sesion como Coordinador ==");
        System.out.println(" ==== 2. Iniciar sesion como Profesor =====\n");
        System.out.println(" =========================================="); 
    }
    /**
     * Funcion que despliega el menu del coordinador
     */
    public static void menuCoordinador(){
        limpiarConsola();
        System.out.println("--------------------------------------------------");
        System.out.println("|                Menu Coordinador                |");
        System.out.println("|    [1]. Crear Nuevo Usuario                    |");
        System.out.println("|    [2]. Registrar Estudiante                   |");
        System.out.println("|    [3]. Actualizar Estudiante                  |");
        System.out.println("|    [4]. Registrar Nuevo Curso                  |");
        System.out.println("|    [5]. Editar Curso                           |");
        System.out.println("|    [6]. Crear Nuevo Grupo                      |");
        System.out.println("|    [7]. Editar Grupo                           |");
        System.out.println("|    [8]. Matricula-Asociacion Estudiante/Curso  |");
        System.out.println("|    [9]. Registro de Tramites Estudiantiles     |");
        System.out.println("|    [S]. Atras                                  |");
        System.out.println("--------------------------------------------------");
    }

    public static void menuProfesor(){
        limpiarConsola();
        System.out.println("--------------------------------------------------");
        System.out.println("|                Menu Profesor                   |");
        System.out.println("|    [1]. Registrar Calificaciones               |");
        System.out.println("|    [2]. Registro de Tiempo Adicional           |");
        System.out.println("|    [3]. Adecuaciones                           |");
        System.out.println("|    [4]. Reporte de incidencia significativa    |");
        System.out.println("|    [5]. Sesiones de tutoria y asistencia       |");
        System.out.println("|    [S]. Atras                                  |");
        System.out.println("--------------------------------------------------");

    }

    /**
     * Funcion que valida el usuario y la contrasena ingresada por el Usuario
     * @param usuario Nombre de Usuario
     * @param contrasena Contrasena del Usuario
     * @param listaUsuarios Lista de los Usuarios
     * @return Retorna verdadero si los datos son correctos, sino retorna falso
     */
    public static boolean validarUsuarioContrasena(String usuario, String contrasena, ArrayList<Usuario> listaUsuarios) {
        boolean datosCorrectos = false;
        for (Usuario us : listaUsuarios) {
            if (us.getUsuario().equals(usuario) && us.getContrasena().equals(contrasena)){
                System.out.println("Datos Correctos");
                datosCorrectos = true;
                return datosCorrectos;
            }
        }
        System.out.println("Datos Incorrectos");
        return datosCorrectos;
    }

    public static void main(String[] args) {

        /*  ============================= PRUEBAS ==============================

        ArrayList<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();
        Estudiante est1 = new Estudiante("Alejandro Rodriguez", 2022230350, new Date(2002,11,19), (byte)19, "Hombre", "El Tanque");
        Estudiante est2 = new Estudiante("Deivid Matute", 2022180126, new Date(2002,11,21), (byte)19, "Hombre", "Santa Clara");

        listaEstudiantes.add(est1);
        listaEstudiantes.add(est2);

        // El arraylist permite hacer un arreglo de la cantidad de elementos que quiera
        

        String usuarioPrueba = "leo";
        String passwordPrueba = "leo123";

        validarUsuarioContrasena(usuarioPrueba, passwordPrueba, listaUsuarios);
        menuCoordinador();
         ============================= PRUEBAS ==============================*/

        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        
        Usuario us1 = new Usuario("Leo", "8523-1232", "leo@leo.com", "leo", "leo123");
        Usuario us2 = new Usuario("Admin", "2022-2202", "admin@admin.com", "admin", "123");
        
        listaUsuarios.add(us1);
        listaUsuarios.add(us2);

        while(true){
            menuInicioSesion();

            System.out.print("Elija Una Opcion: ");
            Scanner in = new Scanner(System.in);
            String opcionLogin = in.nextLine();

            if (opcionLogin.equals("1")){

                System.out.print("Usuario: ");
                String usuario = in.nextLine();

                System.out.print("Contraseña: ");
                String contrasena = in.nextLine();

                if(validarUsuarioContrasena(usuario, contrasena, listaUsuarios)){
                    menuCoordinador();
                    break;// Eliminar esto despues
                }
                
                
            }else if(opcionLogin.equals("2")){
                System.out.print("Usuario: ");
                String usuario = in.nextLine();

                System.out.print("Contraseña: ");
                String contrasena = in.nextLine();

                if(validarUsuarioContrasena(usuario, contrasena, listaUsuarios)){
                    menuProfesor();
                    break;// Eliminar esto despues
                }
            }else{
                System.out.println("Dato incorrecto");
            }

        }
        
    }
    
}
