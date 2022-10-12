import java.util.Date;

/**
 * Describe los datos de acompañamiento de cursos
 */
public class AcompanamientoCurso {
    
    private Date fecha;
    private String tipo;
    private Estudiante estudiante;
    private String notaDescriptiva;

    public AcompanamientoCurso(Date fecha, String tipo, Estudiante estudiante, String notaDescriptiva){
        this.fecha = fecha;
        this.tipo = tipo;
        this.estudiante = estudiante;
        this.notaDescriptiva = notaDescriptiva;
    }

    
    /**
     * Funcion que devuelve la fecha
     * @return Retorna fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Funcion que establece la fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Funcion que devuelve la el tipo de acompanamiento de curso
     * @return Retorna el tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Funcion que establece el tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Funcion que devuelve la instancia de estudiante
     * @return Retorna al estudiante
     */
    public Estudiante getEstudiante() {
        return estudiante;
    }

    /**
     * Funcion que establece el estudiante
     */
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    /**
     * Funcion que devuelve la nota descriptiva
     * @return Retorna la nota descriptiva
     */
    public String getNotaDescriptiva() {
        return notaDescriptiva;
    }

    /**
     * Funcion que establece la nota descriptiva
     */
    public void setNotaDescriptiva(String notaDescriptiva) {
        this.notaDescriptiva = notaDescriptiva;
    }

}