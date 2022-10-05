import java.text.SimpleDateFormat;
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

    // Presencial
    public Grupo(String horario, Profesor profesor, byte numeroGrupo, Date fechaInicio, Date fechaFinalizacion, Curso curso, int aula){
        this.horario = horario;
        this.profesor = profesor;
        this.numeroGrupo = numeroGrupo;
        this.fechaInicio = (Date)fechaInicio.clone();
        this.fechaFinalizacion = (Date)fechaFinalizacion.clone();
        this.curso = curso;
        this.aula = aula;
    }

    // Virtual Asincronico
    public Grupo(Profesor profesor, byte numeroGrupo, Date fechaInicio, Date fechaFinalizacion, Curso curso, String plataforma){
        this.profesor = profesor;
        this.numeroGrupo = numeroGrupo;
        this.fechaInicio = (Date)fechaInicio.clone();
        this.fechaFinalizacion = (Date)fechaFinalizacion.clone();
        this.curso = curso;
        this.plataforma = plataforma;
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
    }

    // Declaro los getters y setters

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

    public int getAula() {
        return aula;
    }

    public void setAula(int aula) {
        this.aula = aula;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

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
