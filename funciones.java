
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class funciones {

    static Principal p = new Principal();

    public void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Funcion que imprime las multiples opciones para Iniciar Sesion
     */
    public void menuInicioSesion() {
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
    public void menuCoordinador() {
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
        System.out.println("|    [10]. Ver los Tramites Estudiantiles        |");
        System.out.println("|    [s]. Atras                                  |");
        System.out.println("--------------------------------------------------");
    }

    public void menuProfesor() {
        limpiarConsola();
        System.out.println("--------------------------------------------------");
        System.out.println("|                Menu Profesor                   |");
        System.out.println("|    [1]. Registrar Calificaciones               |");
        System.out.println("|    [2]. Acompanamiento en Curso                |");
        System.out.println("|    [3]. Registrar nueva tutoria                |");
        System.out.println("|    [4]. Agregar sesion de tutoria y asistencia |");
        System.out.println("|    [s]. Atras                                  |");
        System.out.println("--------------------------------------------------");

    }

    /**
     * Funcion que valida el usuario y la contrasena ingresada por el coordinador
     * 
     * @param usuario          Nombre de usuario
     * @param contrasena       Contrasena del Usuario
     * @param listaCoordinador Lista de los Coordinadores
     * @return Retorna verdadero si los datos son correctos, sino retorna falso
     */
    public boolean validarCoordinador(String usuario, String contrasena, ArrayList<Coordinador> listaCoordinador) {
        boolean datosCorrectos = false;
        for (Coordinador cor : listaCoordinador) {
            if (cor.getUsuario().equals(usuario) && cor.getContrasena().equals(contrasena)) {
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

    /**
     * Funcion que valida el usuario y la contrasena ingresada por el profesor
     * 
     * @param usuario       Nombre de Usuario
     * @param contrasena    Contrasena del Usuario
     * @param listaProfesor Lista de los profesores
     * @return Retorna verdadero si los datos son correctos, sino retorna falso
     */
    public boolean validarProfesor(String usuario, String contrasena, ArrayList<Profesor> listaProfesor) {
        boolean datosCorrectos = false;
        for (Profesor pr : listaProfesor) {
            if (pr.getUsuario().equals(usuario) && pr.getContrasena().equals(contrasena)) {
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

    /**
     * Funcion que valida si un grupo existe
     * 
     * @param codigoCurso Codigo del curso
     * @param numGrupo    Numero del grupo
     * @param listaGrupos Lista de Grupos global
     * @return Retorna verdadero si encuentra el grupo
     */
    public boolean existeGrupo(String codigoCurso, byte numGrupo, ArrayList<Grupo> listaGrupos) {
        boolean existeGrupo = false;
        for (Grupo g : listaGrupos) {
            if (codigoCurso.equals(g.getCurso().getCodigo()) && (g.getNumeroGrupo() == numGrupo)) {
                existeGrupo = true;
                return existeGrupo;
            }
        }
        return existeGrupo;
    }

    /**
     * Funcion que obtiene el dia, mes o ania apartir de un string
     * 
     * @param fecha Fecha Formato string
     * @param tipo  Dia, mes o anio
     * @return Retorna el mes, anio o dia en Integer
     */
    public int obtenerFecha(String fecha, String tipo) {
        if (tipo == "dia") {
            return Integer.parseInt(String.valueOf(fecha.charAt(0)).concat(String.valueOf(fecha.charAt(1))));
        } else if (tipo == "mes") {
            return Integer.parseInt(String.valueOf(fecha.charAt(3)).concat(String.valueOf(fecha.charAt(4))));
        } else {
            return Integer.parseInt(String.valueOf(fecha.charAt(6)).concat(String.valueOf(fecha.charAt(7)))
                    .concat(String.valueOf(fecha.charAt(8))).concat(String.valueOf(fecha.charAt(9))));
        }
    }




    /**
     * Funcion que imprime las lista global de estudiantes
     * 
     * @param lista lista de estudiantes
     */
    public void imprimirListaEstudiantes(ArrayList<Estudiante> lista) {
        System.out.println("=======================");
        System.out.println("Lista de Estudiantes: ");

        for (Estudiante e : lista) {

            System.out.println(e.toString());

        }
        System.out.println("=======================");
    }

    /**
     * Funcion que busca al estudiante por Carnte
     * 
     * @param carnet carnet del estudiante a buscar
     * @param lista  lista de estudiantes
     * @return Retorna al estudiante si se encontro
     */
    public Estudiante buscarEstudiantePorCarnet(int carnet, ArrayList<Estudiante> lista) {
        for (Estudiante e : lista) {
            if (carnet == e.getCarnet()) {
                return e;
            }
        }

        return null;

    }

    /**
     * Funcion que busca un Curso por codigo
     * 
     * @param codigo codigo de curso
     * @param lista  lista de cursos
     * @return Retorna al curso si se encontro
     */
    public Curso buscarCursoPorCodigo(String codigo, ArrayList<Curso> lista) {
        for (Curso c : lista) {
            if (codigo.equals(c.getCodigo())) {
                return c;
            }
        }
        return null;
    }

    /**
     * Funcion que busca un grupo por codigo y numero
     * 
     * @param codigoCurso codigo de curso
     * @param numGrupo    Numero del grupo
     * @param lista       lista de Grupos
     * @return Retorna al grupo si se encontro
     */
    public Grupo buscarGrupoPorNumeroCurso(String codigoCurso, byte numGrupo, ArrayList<Grupo> lista) {
        for (Grupo g : lista) {
            if ((codigoCurso.equals(g.getCurso().getCodigo())) && (numGrupo == g.getNumeroGrupo())) {
                return g;
            }
        }
        return null;
    }

    /**
     * Funcion que busca un profesor por nombre
     * 
     * @param nombre nombre del profesor
     * @param lista  lista de profesores
     * @return Retorna al profesor si se encontro
     */
    public Profesor buscarProfesorPorNombre(String nombre, ArrayList<Profesor> lista) {
        for (Profesor p : lista) {
            if (nombre.equals(p.getNombre())) {
                return p;
            }
        }
        return null;
    }

    /**
     * Funcion que agrega correquisitos y requisitos a los grupos
     * 
     * @param curso Curso al que se le desea agregar
     * @param lista lista de cursos
     */
    public void agregarCorrequisitoyRequisito(Curso curso, ArrayList<Curso> lista) {
        while (true) {
            limpiarConsola();
            System.out.println("Desea agregar un correquisito(s/n): ");
            Scanner in = new Scanner(System.in);
            String op = in.nextLine();

            if (op.equals("s")) {
                System.out.println("Digite el CODIGO del curso(Correquisito):");
                String cod = in.nextLine();
                Curso correquisito = buscarCursoPorCodigo(cod, lista);
                curso.agregarCorrequisito(correquisito);
                System.out.println("Correquisito Agregado Correctamente");
            } else if (op.equals("n")) {
                break;
            }
        }
        while (true) {
            limpiarConsola();
            System.out.println("Desea agregar un Requisito(s/n): ");
            Scanner in = new Scanner(System.in);
            String op = in.nextLine();

            if (op.equals("s")) {
                System.out.println("Digite el CODIGO del curso(Requisito):");
                String cod = in.nextLine();
                Curso requisito = buscarCursoPorCodigo(cod, lista);
                curso.agregarRequisito(requisito);
                System.out.println("Requisito Agregado Correctamente");
            } else if (op.equals("n")) {
                break;
            }
        }

    }

    public boolean calcularFechaMayor(Date fecha1, Date fecha2)
    {
    if (fecha1.getYear() > fecha2.getYear())
        return true;
    if ((fecha1.getYear() == fecha2.getYear()) && (fecha1.getMonth() > fecha2.getMonth()))
        return true;
    if ((fecha1.getYear() == fecha2.getYear()) && (fecha1.getMonth() >= fecha2.getMonth()) && (fecha1.getDay() >= fecha2.getDay()))
        return true;
    return false;
    }

    


}
