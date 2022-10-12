import java.util.Scanner;
import java.util.Date;


/**
 * Describe los datos del Coordinador, extiende de la clase Usuario
 */
public class Coordinador extends Usuario{
    
    public Coordinador(String nombre,String telefono, String correo, String usuario, String contrasena){
        
        super(nombre, telefono, correo, usuario, contrasena, true);

    }
    //Esto lo hago de momento para agregar el usuario al array que esta en principal
    Principal p = new Principal();

    /*
     * Funcion que crea un nuevo usuario
     */
    public void registrarUsuario()
    {
        System.out.println("* Datos del nuevo usuario *");
        System.out.print("Nombre: ");
        Scanner in = new Scanner(System.in);
        String nombre = in.nextLine();
        System.out.print("Telefono: ");
        String telefono = in.nextLine();
        System.out.print("Correo: ");
        String correo = in.nextLine();
        System.out.print("Usuario: ");
        String usuario = in.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = in.nextLine();
        System.out.print("Perfil: c/p");
        char perfil = in.nextLine().charAt(0);

        
         
        
        if(perfil == 'c'){
            Coordinador nuevoUsuario = new Coordinador(nombre, telefono, correo, usuario, contrasena);
            p.listaCoordinadores.add(nuevoUsuario); //Se añade a la lista de usuarios que esta en principal
        }
        else if (perfil == 'p'){
            Profesor nuevoUsuario = new Profesor(nombre, telefono, correo, usuario, contrasena);
            p.listaProfesores.add(nuevoUsuario); //Se añade a la lista de usuarios que esta en principal
        }
        
    }

    /**
     * Funcion que registra un estudiante
     * @param nombre Nombre del Estudiante
     * @param carnet Carnet del Estudiante
     * @param correo Correo del Estudiante
     * @param fechaNacimiento Fecha de nacimiento
     * @param edad Edad del estudiante
     * @param genero Genero del estudiante
     * @param lugarProcedencia Procedencia del estudiante
     */
    public void registrarEstudiante(String nombreCompleto, int carnet, String correo, Date fechaNacimiento, byte edad, String genero, String lugarProcedencia)
    {        
        p.listaEstudiantes.add(new Estudiante(nombreCompleto, carnet, correo, fechaNacimiento, edad, genero, lugarProcedencia));
    }

    /**
     * Funcion que actualiza datos del estudiante
     * @param e Instancia de Estudiante
     * @param nombre Nombre del Estudiante
     * @param carnet Carnet del Estudiante
     * @param correo Correo del Estudiante
     * @param fechaNacimiento Fecha de nacimiento
     * @param edad Edad del estudiante
     * @param genero Genero del estudiante
     * @param lugarProcedencia Procedencia del estudiante
     */
    public void actualizarEstudiante(Estudiante e,String nombre, String correo, int carnet, Date fechaNacimiento, byte edad, String genero, String lugarProcedencia)
    {
        
        e.setNombre(nombre);
        e.setCorreo(correo);
        e.setCarnet(carnet);
        e.setFechaNacimiento(fechaNacimiento);
        e.setEdad(edad);
        e.setGenero(genero);
        e.setLugarProcedencia(lugarProcedencia);
        
    }

    /**
     * Funcion que registra un curso
     * @param codigo Codigo del curso
     * @param nombre Nombre del curso
     * @param creditos Creditos
     * @param cantidadHorasLectivas Horas lectivas
     * 
     */
    public void registrarCurso(String codigo, String nombre, byte creditos, byte cantidadHorasLectivas)
    {
        p.listaCursos.add(new Curso(codigo, nombre, creditos, cantidadHorasLectivas));
    }


    /**
     * Funcion que actualiza un curso
     * @param c Instancia de curso a actualizar
     * @param codigo Codigo del curso
     * @param nombre Nombre del curso
     * @param creditos Creditos
     * @param cantidadHorasLectivas Horas lectivas
     * 
     */
    public void actualizarCurso(Curso c,String codigo, String nombre, byte creditos, byte cantidadHorasLectivas)
    {
        c.setCodigo(codigo);
        c.setNombre(nombre);
        c.setCreditos(creditos);
        c.setCantidadHorasLectivas(cantidadHorasLectivas);
    }
    
    /**
     * Funcion ingresa un nuevo grupo presencial
     * @param horario Horario de grupo
     * @param profesor Profesor asignado
     * @param numeroGrupo Numero del grupo
     * @param fechaInicio Fecha en que inicia
     * @param fechaFinalizacion Fecha en que finaliza
     * @param curso Curso
     * @param aula numero de aula
     * 
     */
    public void registrarGrupoPresencial(String horario, Profesor profesor, byte numeroGrupo, Date fechaInicio, Date fechaFinalizacion, Curso curso, int aula)
    {
        Grupo g = new Grupo(horario, profesor, numeroGrupo, fechaInicio, fechaFinalizacion, curso, aula);
        p.listaGrupos.add(g);
        profesor.setGrupo(g);
    }

     /**
     * Funcion ingresa un nuevo grupo Virtual-Asincronico
     * @param profesor Profesor asignado
     * @param numeroGrupo Numero del grupo
     * @param fechaInicio Fecha en que inicia
     * @param fechaFinalizacion Fecha en que finaliza
     * @param curso Curso
     * @param plataforma Plataforma(Zoom,Teams)
     * 
     */
    public void registrarGrupoVA(Profesor profesor, byte numeroGrupo, Date fechaInicio, Date fechaFinalizacion, Curso curso, String plataforma){
        Grupo g = new Grupo(profesor, numeroGrupo, fechaInicio, fechaFinalizacion, curso, plataforma);
        p.listaGrupos.add(g);
        profesor.setGrupo(g);
    }

     /**
     * Funcion ingresa un nuevo grupo Virtual-Sincronico
     * @param horario Horario de grupo
     * @param profesor Profesor asignado
     * @param numeroGrupo Numero del grupo
     * @param fechaInicio Fecha en que inicia
     * @param fechaFinalizacion Fecha en que finaliza
     * @param curso Curso
     * @param plataforma Plataforma(Zoom,Teams)
     * 
     */
    public void registrarGrupoVS(String horario, Profesor profesor, byte numeroGrupo, Date fechaInicio, Date fechaFinalizacion, Curso curso, String plataforma){
        Grupo g = new Grupo(horario, profesor, numeroGrupo, fechaInicio, fechaFinalizacion, curso, plataforma);
        p.listaGrupos.add(g);
        profesor.setGrupo(g);
    }


   /**
     * Funcion que actualiza un grupo presencial
     * @param g Grupo a actualizar
     * @param horario Horario de grupo
     * @param profesor Profesor asignado
     * @param numeroGrupo Numero del grupo
     * @param fechaInicio Fecha en que inicia
     * @param fechaFinalizacion Fecha en que finaliza
     * @param curso Curso
     * @param aula numero de aula
     * 
     */
    public void actualizarGrupoPresencial(Grupo g, String horario, Profesor profesor, byte numeroGrupo, Date fechaInicio, Date fechaFinalizacion, Curso curso, int aula)
    {
        g.setHorario(horario);
        g.setProfesor(profesor);
        g.setNumeroGrupo(numeroGrupo);
        g.setFechaInicio(fechaInicio);
        g.setFechaFinalizacion(fechaFinalizacion);
        g.setCurso(curso);
        g.setAula(aula);
    }

    /**
     * Funcion ingresa un nuevo grupo Virtual-Asincronico
     * @param g Grupo a actualizar
     * @param profesor Profesor asignado
     * @param numeroGrupo Numero del grupo
     * @param fechaInicio Fecha en que inicia
     * @param fechaFinalizacion Fecha en que finaliza
     * @param curso Curso
     * @param plataforma Plataforma(Zoom,Teams)
     * 
     */
    public void actualizarGrupoVA(Grupo g, Profesor profesor, byte numeroGrupo, Date fechaInicio, Date fechaFinalizacion, Curso curso, String plataforma)
    {
        g.setProfesor(profesor);
        g.setNumeroGrupo(numeroGrupo);
        g.setFechaInicio(fechaInicio);
        g.setFechaFinalizacion(fechaFinalizacion);
        g.setCurso(curso);
        g.setPlataforma(plataforma);
    }

    /**
     * Funcion ingresa un nuevo grupo Virtual-Sincronico
     * @param g Grupo a actualizar
     * @param horario Horario de grupo
     * @param profesor Profesor asignado
     * @param numeroGrupo Numero del grupo
     * @param fechaInicio Fecha en que inicia
     * @param fechaFinalizacion Fecha en que finaliza
     * @param curso Curso
     * @param plataforma Plataforma(Zoom,Teams)
     * 
     */
    public void actualizarGrupoVS(Grupo g, String horario, Profesor profesor, byte numeroGrupo, Date fechaInicio, Date fechaFinalizacion, Curso curso, String plataforma)
    {
        g.setHorario(horario);
        g.setProfesor(profesor);
        g.setNumeroGrupo(numeroGrupo);
        g.setFechaInicio(fechaInicio);
        g.setFechaFinalizacion(fechaFinalizacion);
        g.setCurso(curso);
        g.setPlataforma(plataforma);
    }


    /**
     * Funcion que asocia al estudiante con un grupo y viceversa
     * @param e Estudiante a matricular
     * @param g Grupo en el que se va a matricular
     */
    public void asociarMatriculaEstudiante(Estudiante e, Grupo g)
    {
        e.setcursosMatriculados(g);
        g.agregarEstudiante(e);
    }

    /*
     * Funcion que registra un tramite estudiantil
     */
    public void registrarTramiteEstudiantil()
    {
        System.out.println("Funcion");
    }

}
