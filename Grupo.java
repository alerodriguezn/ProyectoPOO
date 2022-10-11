import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    public boolean validarProfesor(String nombre){
        if(this.profesor.getNombre() == nombre){
            return true;
        }else{
            return false;
        }
    }

    public boolean validarEstudiante(int carnet){
        boolean existe = false;
        for (Estudiante e : this.listaEstudiantes) {
            if(e.getCarnet() == carnet){
                return true;
            }
        }
        return existe;

    }

    public void agregarEstudiante(Estudiante e) {
        this.listaEstudiantes.add(e);
    }

    public ArrayList<Estudiante> getEstudiantes(){
        return this.listaEstudiantes;
    }

    void imprimirListaEstudiantes(){
        for (Estudiante e : this.listaEstudiantes) {
            System.out.println("- Nombre: "+ e.getNombre() + "Carnet: " + e.getCarnet());
        }
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
