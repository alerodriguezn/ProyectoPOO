import java.util.Date;

/**
 * Describe los datos del grupo
 */
public class Grupo {
    
    private String horario;
    private Profesor profesor;
    private byte numeroGrupo;
    private Date fechaInicio;
    private Date fechaFinalizacion;
    private Curso curso;

    public Grupo(String horario, Profesor profesor, byte numeroGrupo, Date fechaInicio, Date fechaFinalizacion, Curso curso){
        this.horario = horario;
        this.profesor = profesor;
        this.numeroGrupo = numeroGrupo;
        this.fechaInicio = (Date)fechaInicio.clone();
        this.fechaFinalizacion = (Date)fechaFinalizacion.clone();
        this.curso = curso;
    }

    // Declaro los getters y setters
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
