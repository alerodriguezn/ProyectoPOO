import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * Describe los datos del grupo
 */
public class Grupo {
    
    private Profesor profesor;
    private byte numeroGrupo;
    private Date fechaInicio;
    private Date fechaFinalizacion;
    private Curso curso;
    private String horario;
    private int aula;
    private String plataforma;
    private ArrayList<Estudiante> listaEstudiantes;

    // Presencial
    public Grupo(String horario, Profesor profesor, byte numeroGrupo, Date fechaInicio, Date fechaFinalizacion, Curso curso, int aula){
        this.horario = horario;
        this.profesor = profesor;
        this.numeroGrupo = numeroGrupo;
        this.fechaInicio = (Date)fechaInicio.clone();
        this.fechaFinalizacion = (Date)fechaFinalizacion.clone();
        this.curso = curso;
        this.aula = aula;
        this.listaEstudiantes = new ArrayList<Estudiante>();
    }

    // Virtual Asincronico
    public Grupo(Profesor profesor, byte numeroGrupo, Date fechaInicio, Date fechaFinalizacion, Curso curso, String plataforma){
        this.profesor = profesor;
        this.numeroGrupo = numeroGrupo;
        this.fechaInicio = (Date)fechaInicio.clone();
        this.fechaFinalizacion = (Date)fechaFinalizacion.clone();
        this.curso = curso;
        this.plataforma = plataforma;
        this.listaEstudiantes = new ArrayList<Estudiante>();
    }

    // Virtual Sincronico
    public Grupo(String horario, Profesor profesor, byte numeroGrupo, Date fechaInicio, Date fechaFinalizacion, Curso curso, String plataforma){
        this.horario = horario;
        this.profesor = profesor;
        this.numeroGrupo = numeroGrupo;
        this.fechaInicio = (Date)fechaInicio.clone();
        this.fechaFinalizacion = (Date)fechaFinalizacion.clone();
        this.curso = curso;
        this.plataforma = plataforma;
        this.listaEstudiantes = new ArrayList<Estudiante>();
    }

    // Declaro los getters y setters

    /**
     * Funcion que devuelve el profesor
     * @return Retorna el profesor a cargo
     */
    public Profesor getProfesor() {
        return profesor;
    }

    /**
     * Establece el profesor
     */
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    /**
     * Funcion que devuelve el numero de grupo
     * @return Retorna el numero de grupo
     */
    public byte getNumeroGrupo() {
        return numeroGrupo;
    }

    /**
     * Establece el numero de grupo
     * @param numeroGrupo numero de grupo
     */
    public void setNumeroGrupo(byte numeroGrupo) {
        this.numeroGrupo = numeroGrupo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de inicio
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    /**
     * Establece la fecha de finalizacion
     */
    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    /**
     * Devuelve el grupo
     * @return retorna el grupo
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * Establece el curso asociado
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**
     * Devuelve el aula
     * @return retorna el aula
     */
    public int getAula() {
        return aula;
    }

    /**
     * Establece el aula
     */
    public void setAula(int aula) {
        this.aula = aula;
    }

    /**
     * Devuelve el horario
     * @return retorna el horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * Establece el horario
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * Devuelve la plataforma
     * @return retorna la plataforma
     */
    public String getPlataforma() {
        return plataforma;
    }

    /**
     * Establece la plataforma
     */ 
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    /**
     * Valida si el profesor esta a cargo
     * @param nombre Nombre del profesor
     * @return retorna True si esta a cargo
     */
    public boolean validarProfesor(String nombre){
        if(this.profesor.getNombre() == nombre){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Valida si el estudiante esta matriculado en el curso
     * @param carnet del estudiante
     * @return retorna True si esta matriculado
     */
    public boolean validarEstudiante(int carnet){
        boolean existe = false;
        for (Estudiante e : this.listaEstudiantes) {
            if(e.getCarnet() == carnet){
                return true;
            }
        }
        return existe;

    }

    /**
     * Agrega un estudiante
     */ 
    public void agregarEstudiante(Estudiante e) {
        this.listaEstudiantes.add(e);
    }

    /**
     * Devuelve la lista de estudiantes
     * @return retorna la lista de estudiantes
     */
    public ArrayList<Estudiante> getEstudiantes(){
        return this.listaEstudiantes;
    }

    /**
     * Imprime toda la lista de estudiantes
     */
    void imprimirListaEstudiantes(){
        for (Estudiante e : this.listaEstudiantes) {
            System.out.println("- Nombre: "+ e.getNombre() + "Carnet: " + e.getCarnet());
        }
    }

    /**
     * Imprime la lista de califaciones de los estudiantes 
     */
    void reporteCalificaciones() {
        float sumaNota = 0f;
        float contador = 0f;

        Grupo g = this;
        ArrayList<Estudiante> lista = this.listaEstudiantes;

        Collections.sort(lista, new Comparator<Estudiante>() {
            public int compare(Estudiante p1, Estudiante p2) {
                return Float.valueOf(p1.getCalificacionesPorGrupo(g)).compareTo(p2.getCalificacionesPorGrupo(g));
            }
        });
        Collections.reverse(lista);
        if (this.plataforma == null) {

            System.out.println("Codigo: " + this.getCurso().getCodigo() + " | [PRESENCIAL] Profesor: "
                    + this.profesor.getNombre() + " | Curso: " + this.getCurso().getNombre());
            for (Estudiante e : lista) {
                System.out.println("Nombre: " + e.getNombre() + " | Nota: " + e.getCalificacionesPorGrupo(this));
                sumaNota += e.getCalificacionesPorGrupo(this);
                contador += 1;
            }
            System.out.println("Promedio Ponderado: " + sumaNota / contador);
        }

        else if (this.horario == null) {
            System.out.println("Codigo: " + this.getCurso().getCodigo() + " | [Virtual-Asincronico] Profesor: "
                    + this.profesor.getNombre() + " | Curso: " + this.getCurso().getNombre());
            for (Estudiante e : lista) {
                System.out.println("Nombre: " + e.getNombre() + " | Nota: " + e.getCalificacionesPorGrupo(this));
                sumaNota += e.getCalificacionesPorGrupo(this);
                contador += 1;
            }
            System.out.println("Promedio Ponderado: " + sumaNota / contador);
        } else {
            System.out.println("Codigo: " + this.getCurso().getCodigo() + " | [Virtual-Sincronico] Profesor: "
                    + this.profesor.getNombre() + " | Curso: " + this.getCurso().getNombre());
            for (Estudiante e : lista) {
                System.out.println("Nombre: " + e.getNombre() + " | Nota: " + e.getCalificacionesPorGrupo(this));
                sumaNota += e.getCalificacionesPorGrupo(this);
                contador += 1;
            }
            System.out.println("Promedio Ponderado: " + sumaNota / contador);
        }
    }

    /**
     * ToString de la clase Grupo
     * @return Retorna un String con todos los datos del Grupo
     */
    public String toString() {
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String fechaInicioCadena = simpleDateFormat.format(fechaInicio);
        String fechaFinCadena = simpleDateFormat.format(fechaFinalizacion);

        if (this.plataforma == null){
            return ("[PRESENCIAL] Profesor: "+this.profesor.getNombre()+ " | Numero Grupo: "+String.valueOf(numeroGrupo)+" | Fecha Inicio: " + fechaInicioCadena + " Fecha Finalizacion: " + fechaFinCadena +" | Curso: "+ this.curso.getNombre() + " | Horario: " + this.getHorario() + " | Aula: " + String.valueOf(this.getAula()));
        }
        else if(this.horario == null ){
            return "[VIRTUAL-ASINCRONICO] Profesor: "+this.profesor.getNombre()+ " | Numero Grupo: "+String.valueOf(numeroGrupo)+" | Fecha Inicio: " + fechaInicioCadena + " Fecha Finalizacion: " + fechaFinCadena +" | Curso: "+ this.curso.getNombre() + " | Horario: " + this.getHorario() + " | Plataforma: " + String.valueOf(this.getPlataforma());
        }
        else{
            return ("[VIRTUAL-SINCRONICO] Profesor: "+this.profesor.getNombre()+ " | Numero Grupo: "+String.valueOf(numeroGrupo)+" | Fecha Inicio: " + fechaInicioCadena + " Fecha Finalizacion: " + fechaFinCadena +" | Curso: "+ this.curso.getNombre() + " | Plataforma: " + String.valueOf(this.getPlataforma()));
        }
        
    }

}
