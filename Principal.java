import java.util.ArrayList;
import java.util.Date;

public class Principal {
    /**
     * Funcion que imprime las multiples opciones para Iniciar Sesion
     */
    public static void menuInicioSesion(){

        System.out.println(" ==========================================");
        System.out.println(" ============ INICIO DE SESION ============\n");
        System.out.println(" ==== 1. Iniciar sesion como Profesor =====");
        System.out.println(" ==== 2. Iniciar sesion como Coordinador ==\n");
        System.out.println(" ==========================================");       
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
            if (us.getUsuario() == usuario && us.getContrasena() == contrasena){
                System.out.println("Datos Correctos");
                datosCorrectos = true;
                return datosCorrectos;
            }
        }
        System.out.println("Datos Incorrectos");
        return datosCorrectos;
    }

    public static void main(String[] args) {

        // ============================= PRUEBAS ==============================

        
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();

        Estudiante est1 = new Estudiante("Alejandro Rodriguez", 2022230350, new Date(2002,11,19), (byte)19, "Hombre", "El Tanque");
        Estudiante est2 = new Estudiante("Deivid Matute", 2022180126, new Date(2002,11,21), (byte)19, "Hombre", "Santa Clara");

        listaEstudiantes.add(est1);
        listaEstudiantes.add(est2);

        // El arraylist permite hacer un arreglo de la cantidad de elementos que quiera
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        
        Usuario us1 = new Usuario("Leo", "8523-1232", "leo@leo.com", "leo", "leo123");
        Usuario us2 = new Usuario("Admin", "2022-2202", "admin@admin.com", "admin", "123");
        
        listaUsuarios.add(us1);
        listaUsuarios.add(us2);


        String usuarioPrueba = "leo";
        String passwordPrueba = "leo123";

        validarUsuarioContrasena(usuarioPrueba, passwordPrueba, listaUsuarios);

        
    }
    
}
