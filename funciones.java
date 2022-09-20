
import java.util.ArrayList;

public class funciones {

    public void limpiarConsola(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Funcion que imprime las multiples opciones para Iniciar Sesion
     */
    public void menuInicioSesion(){
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
    public void menuCoordinador(){
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

    public void menuProfesor(){
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
    public boolean validarUsuarioContrasena(String usuario, String contrasena, ArrayList<Usuario> listaUsuarios) {
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

}
