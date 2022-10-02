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

    // Declaro los getters y setters
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public String getNotaDescriptiva() {
        return notaDescriptiva;
    }

    public void setNotaDescriptiva(String notaDescriptiva) {
        this.notaDescriptiva = notaDescriptiva;
    }

}