import java.util.Date;

/**
 * Describe los datos del grupo
 */
public class Grupo {
    
    private String horario;
    private String profesor;
    private byte numeroGrupo;
    private Date fechaInicio;
    private Date fechaFinalizacion;

    public Grupo(String horario, String profesor, byte numeroGrupo, Date fechaInicio, Date fechaFinalizacion){
        this.horario = horario;
        this.profesor = profesor;
        this.numeroGrupo = numeroGrupo;
        this.fechaInicio = (Date)fechaInicio.clone();
        this.fechaFinalizacion = (Date)fechaFinalizacion.clone();
    }

    // Declaro los getters y setters
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
    public byte getNumeroGrupo() {
        return numeroGrupo;
    }

    public void setNumeroGrupo(byte numeroGrupo) {
        this.numeroGrupo = numeroGrupo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }
}
