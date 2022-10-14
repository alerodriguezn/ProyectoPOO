import java.util.ArrayList;
import java.util.Date;

/**
 * Describe los datos del Estudiante
 */
public class Estudiante extends Usuario{

    private int carnet;
    private Date fechaNacimiento;
    private byte edad;
    private String genero;
    private String lugarProcedencia;
    private ArrayList<Calificacion> calificaciones;
    private ArrayList<Grupo> cursosMatriculados;
    private ArrayList<AcompanamientoCurso> listaAC;



    public Estudiante(String nombreCompleto, int carnet, String correo, Date fechaNacimiento, byte edad, String genero, String lugarProcedencia){

        super(nombreCompleto, correo);
        this.carnet = carnet;
        this.fechaNacimiento=(Date)fechaNacimiento.clone();
        this.edad = edad;
        this.genero = genero;
        this.lugarProcedencia = lugarProcedencia;
        this.calificaciones = new ArrayList<Calificacion>();
        this.cursosMatriculados = new ArrayList<Grupo>();
        this.listaAC = new ArrayList<AcompanamientoCurso>();

    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }


    @Override
    public String getCorreo() {
        return super.getCorreo();
    }

    @Override
    public void setCorreo(String correo) {
        super.setCorreo(correo);
    }
    
    /**
     * Funcion que devuelve el carnet del estudiante
     * @return Retorna el carnet del estudiante
     */
    public int getCarnet() {
        return carnet;
    }

    /**
     * Funcion que establece el carnet del estudiante
     */
    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    /**
     * Funcion que devuelve la fecha de nacimiento del estudiante
     * @return Retorna la fecha de nacimiento del estudiante
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Funcion que establece la fecha de nacimiento
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = (Date)fechaNacimiento.clone();
    }


    /**
     * Funcion que devuelve la edad del estudiante
     * @return Retorna la edad del estudiante
     */
    public byte getEdad() {
        return edad;
    }

    /**
     * Funcion que establece la edad
     */
    public void setEdad(byte edad) {
        this.edad = edad;
    }

    /**
     * Funcion que devuelve el genero del estudiante
     * @return Retorna el genero del estudiante
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Funcion que establece el genero
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Funcion que devuelve el lugar  del estudiante
     * @return Retorna el lugar del estudiante
     */
    public String getLugarProcedencia() {
        return lugarProcedencia;
    }

    /**
     * Funcion que establece el lugar del estudiante
     */
    public void setLugarProcedencia(String lugarProcedencia) {
        this.lugarProcedencia = lugarProcedencia;
    }

    /**
     * Funcion que devuelve la lista de calificaciones  del estudiante
     * @return Retorna la lista de calificaciones del estudiante
     */
    public ArrayList<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    /**
     * Funcion que agrega la lista de calificaciones  del estudiante
     */
    public void setCalificaciones(float nota, Grupo grupo) {
        this.calificaciones.add(new Calificacion(nota, grupo));
    }


    /**
     * Funcion que establece el acompanamiento de cursos del estudiante
     */
    public void setAcompanamiento(Date fecha, String tipo, Estudiante e,String notaD) {
        this.listaAC.add(new AcompanamientoCurso(fecha,tipo,e,notaD));
    }

    /**
     * Imprime los cursos matriculados
     */
    public void imprimirCursosMatriculados(){
        for (Grupo g : this.cursosMatriculados) {
            System.out.println("- Curso: " + g.getCurso().getNombre());
            
        }
    }

     /**
     * Funcion que obtiene la calificacion de un estudiante apartir de un grupo
     * @return Retorna la nota del estudiante redondeada
     */
    public float getCalificacionesPorGrupo(Grupo g) {
        for (Calificacion c : this.calificaciones) {
            if(c.getGrupo() == g){
                return c.getNotaRedondeada();
            }            
        }
        return 0f;
    }

     /**
     * Funcion que imprime las calificaciones del estudiante
     */
    public void imprimirCalifaciones(){
        for (Calificacion c : this.calificaciones) {
            System.out.println("Nota: " + String.valueOf(c.getNota()) +" | Curso: "+ c.getGrupo().getCurso().getNombre());
            
        }
    }

    /**
     * Funcion que devuelve los cursos matriculados del estudiante
     * @return Retorna los cursos matriculados del estudiante
     */
    public ArrayList<Grupo> getcursosMatriculados() {
        return cursosMatriculados;
    }

    /**
     * Funcion que agrega un curso a los cursos matriculados del estudiante
     */
    public void setcursosMatriculados(Grupo grupo) {
        this.cursosMatriculados.add(grupo);
    }

    /**
     * Funcion ToString del Estudiante
     * @return Retorna los datos del estudiante en un String
     */
    public String toString(){
        return("Nombre: " + this.getNombre() + " | Correo: "+ this.getCorreo() + " | Carnet: "+ this.getCarnet() + " | Fecha Nacimiento: " + this.getFechaNacimiento().getYear())+"/"+this.getFechaNacimiento().getMonth()+"/"+this.getFechaNacimiento().getDay();
    }


    
}
