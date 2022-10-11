import java.util.Scanner;
import java.util.Date;

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

    /*
     * Funcion que registra un nuevo estudiante
     */
    public void registrarEstudiante(String nombreCompleto, int carnet, String correo, Date fechaNacimiento, byte edad, String genero, String lugarProcedencia)
    {        
        p.listaEstudiantes.add(new Estudiante(nombreCompleto, carnet, correo, fechaNacimiento, edad, genero, lugarProcedencia));
    }

    /*
     * Funcion que actualiza datos del estudiante
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

    /*
     * Funcion que ingresa un nuevo curso
     */
    public void registrarCurso(String codigo, String nombre, byte creditos, byte cantidadHorasLectivas)
    {
        p.listaCursos.add(new Curso(codigo, nombre, creditos, cantidadHorasLectivas));
    }


    /*
     * Funcion que actualiza un curso
     */
    public void actualizarCurso(Curso c,String codigo, String nombre, byte creditos, byte cantidadHorasLectivas)
    {
        c.setCodigo(codigo);
        c.setNombre(nombre);
        c.setCreditos(creditos);
        c.setCantidadHorasLectivas(cantidadHorasLectivas);
    }
    
    /*
     * Funcion que ingresa un nuevo grupo
     */
    public void registrarGrupoPresencial(String horario, Profesor profesor, byte numeroGrupo, Date fechaInicio, Date fechaFinalizacion, Curso curso, int aula)
    {
        Grupo g = new Grupo(horario, profesor, numeroGrupo, fechaInicio, fechaFinalizacion, curso, aula);
        p.listaGrupos.add(g);
        profesor.setGrupo(g);
    }

    public void registrarGrupoVA(Profesor profesor, byte numeroGrupo, Date fechaInicio, Date fechaFinalizacion, Curso curso, String plataforma){
        Grupo g = new Grupo(profesor, numeroGrupo, fechaInicio, fechaFinalizacion, curso, plataforma);
        p.listaGrupos.add(g);
        profesor.setGrupo(g);
    }

    public void registrarGrupoVS(String horario, Profesor profesor, byte numeroGrupo, Date fechaInicio, Date fechaFinalizacion, Curso curso, String plataforma){
        Grupo g = new Grupo(horario, profesor, numeroGrupo, fechaInicio, fechaFinalizacion, curso, plataforma);
        p.listaGrupos.add(g);
        profesor.setGrupo(g);
    }


    /*
     * Funcion que actualiza un curso
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
    public void actualizarGrupoVA(Grupo g, Profesor profesor, byte numeroGrupo, Date fechaInicio, Date fechaFinalizacion, Curso curso, String plataforma)
    {
        g.setProfesor(profesor);
        g.setNumeroGrupo(numeroGrupo);
        g.setFechaInicio(fechaInicio);
        g.setFechaFinalizacion(fechaFinalizacion);
        g.setCurso(curso);
        g.setPlataforma(plataforma);
    }

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


    /*
     * Funcion que asocia una matricula con el estudiante
     */
    public void asociarMatriculaEstudiante()
    {
        System.out.println("Funcion");
    }

    /*
     * Funcion que registra un tramite estudiantil
     */
    public void registrarTramiteEstudiantil()
    {
        System.out.println("Funcion");
    }

}
