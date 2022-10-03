
import java.util.ArrayList;
import java.util.Optional;

public class funciones {

    static Principal p = new Principal();

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
        System.out.println("|    [s]. Atras                                  |");
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
        System.out.println("|    [s]. Atras                                  |");
        System.out.println("--------------------------------------------------");

    }

    /**
     * Funcion que valida el usuario y la contrasena ingresada por el Usuario
     * @param usuario Nombre de Usuario
     * @param contrasena Contrasena del Usuario
     * @param listaUsuarios Lista de los Usuarios
     * @return Retorna verdadero si los datos son correctos, sino retorna falso
     */

    public boolean validarCoordinador(String usuario, String contrasena, ArrayList<Coordinador> listaCoordinador) {
        boolean datosCorrectos = false;
        for (Coordinador cor : listaCoordinador) {
            if (cor.getUsuario().equals(usuario) && cor.getContrasena().equals(contrasena)){
                System.out.println("Datos Correctos");
                datosCorrectos = true;
                p.permisosUsuarios = true;
                p.coordinadorLogeado = cor;
                return datosCorrectos;
            }
        }
        System.out.println("Datos Incorrectos");
        return datosCorrectos;
    }

    public boolean validarProfesor(String usuario, String contrasena, ArrayList<Profesor> listaProfesor) {
        boolean datosCorrectos = false;
        for (Profesor pr : listaProfesor) {
            if (pr.getUsuario().equals(usuario) && pr.getContrasena().equals(contrasena)){
                System.out.println("Datos Correctos");
                datosCorrectos = true;
                
                p.permisosUsuarios = false;
                p.profesorLogeado = pr;
    
                return datosCorrectos;
            }
        }
        System.out.println("Datos Incorrectos");  
        return datosCorrectos;
    }
    


    public int obtenerFecha(String fecha, String tipo){
        if (tipo == "dia"){
            return Integer.parseInt(String.valueOf(fecha.charAt(0)).concat(String.valueOf(fecha.charAt(1))));
        }
        else if (tipo == "mes"){
            return Integer.parseInt(String.valueOf(fecha.charAt(3)).concat(String.valueOf(fecha.charAt(4))));
        }
        else{
            return Integer.parseInt(String.valueOf(fecha.charAt(6)).concat(String.valueOf(fecha.charAt(7))).concat(String.valueOf(fecha.charAt(8))).concat(String.valueOf(fecha.charAt(9))));
        }
    }

    public void imprimirListaEstudiantes(ArrayList<Estudiante> lista){
        System.out.println("=======================");
        System.out.println("Lista de Estudiantes: ");

        for (Estudiante e : lista) {

            System.out.println(e.toString());
            
        }
        System.out.println("=======================");
    }

    public void imprimirListaCursos(ArrayList<Curso> lista){
        System.out.println("=======================");
        System.out.println("Lista de Cursos: ");

        for (Curso c : lista) {

            System.out.println(c.toString());
            
        }
        System.out.println("=======================");
    }


    public Estudiante buscarEstudiantePorCarnet(int carnet, ArrayList<Estudiante> lista){
        for (Estudiante e : lista) {
            if(carnet == e.getCarnet()){
                return e;
            }
        }

        return null;

    }

    public Curso buscarCursoPorCodigoCurso(String codigo,ArrayList<Curso> lista){
        for (Curso c : lista) {
            if(codigo.equals(c.getCodigo())){
                return c;
            }
        }

        return null;
        
    } 


}
