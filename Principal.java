import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.lang.model.util.ElementScanner6;

public class Principal {

    public static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

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

    
        funciones f = new funciones(); //Archivo con funciones.

        
        Profesor us1 = new Profesor("Leo", "8523-1232", "leo@leo.com", "leo", "leo123");
        Coordinador us2 = new Coordinador("Admin", "2022-2202", "admin@admin.com", "admin", "123");
        
        listaUsuarios.add(us1);
        listaUsuarios.add(us2);
        us2.registrarUsuario();

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

                if(f.validarUsuarioContrasena(usuario, contrasena, listaUsuarios)){
                    f.menuCoordinador();
                    break;// Eliminar esto despues
                }
                
                
            }else if(opcionLogin.equals("2")){
                System.out.print("Usuario: ");
                String usuario = in.nextLine();

                System.out.print("Contraseña: ");
                String contrasena = in.nextLine();

                if(f.validarUsuarioContrasena(usuario, contrasena, listaUsuarios)){
                    f.menuProfesor();
                    break;// Eliminar esto despues
                }
            }else{
                System.out.println("Dato incorrecto");
            }

        }
        
    }

    
}
