import java.util.ArrayList;
import java.util.Date;

public abstract class TramitesEstudiantiles {
    
   Estudiante estudiante;
   Date fechaRegistro;
   String detalleDescriptivo;
   
   public TramitesEstudiantiles(Estudiante estudiante, Date fechaRegistro, String detalleDescriptivo){
       this.estudiante = estudiante;
       this.fechaRegistro=(Date)fechaRegistro.clone();
       this.detalleDescriptivo = detalleDescriptivo;
   }
   public Estudiante getEstudiante() {
       return estudiante;
   }
   public void setEstudiante(Estudiante estudiante) {
       this.estudiante = estudiante;
   }
   public Date getFechaRegistro() {
       return fechaRegistro;
   }
   public void setFechaRegistro(Date fechaRegistro) {
       this.fechaRegistro = (Date)fechaRegistro.clone();
   }
   public String getDetalleDescriptivo() {
       return detalleDescriptivo;
   }
   public void setDetalleDescriptivo(String detalleDescriptivo) {
       this.detalleDescriptivo = detalleDescriptivo;
   }
}
class LevantamientoRequisitos extends TramitesEstudiantiles{

    private Curso cursoALevantar;
    private String justificacion;
    private boolean estado;
    private String justificacionRechazo;

    public LevantamientoRequisitos(Estudiante estudiante, Date fechaRegistro, String detalleDescriptivo, Curso cursoALevantar, String justificacion, boolean estado){

        //Constructor del padre
        super(estudiante,fechaRegistro,detalleDescriptivo);

        this.cursoALevantar = cursoALevantar;
        this.justificacion = justificacion;
        this.estado = estado;
        this.justificacionRechazo = null;
    }


    public Curso getCursoALevantar() {
        return cursoALevantar;
    }

    public void setCursoALevantar(Curso cursoALevantar) {
        this.cursoALevantar = cursoALevantar;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public String getJustificacionRechazo() {
        return justificacionRechazo;
    }

    public void setJustificacionRechazo(String justificacionRechazo) {
        this.justificacionRechazo = justificacionRechazo;
    }

    public Boolean getEstado(){
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String imprimirEstado(){
        if(estado){
            return "Aprobado";
        }else{
            return "Reprobado";
        }
    }
    public String toString(){
            if(estado){
                return "\n| Tramite Levantamiento de Requisitos |\nEstudiante Asociado al tramite: "+estudiante.nombre+"\nFecha del Registro: "+fechaRegistro.getDate()+"/"+fechaRegistro.getMonth()+"/"+fechaRegistro.getYear()+"\nDetalle Descriptivo: "+detalleDescriptivo+"\nCurso A Levantar Requisitos: "+cursoALevantar.getNombre()+"\nJustificacion: "+justificacion+"\nEstado: "+imprimirEstado()+"\n";
            }
            else{
                return "\n| Tramite Levantamiento de Requisitos |\nEstudiante Asociado al tramite: "+estudiante.nombre+"\nFecha del Registro: "+fechaRegistro.getDate()+"/"+fechaRegistro.getMonth()+"/"+fechaRegistro.getYear()+"\nDetalle Descriptivo: "+detalleDescriptivo+"\nCurso A Levantar Requisitos: "+cursoALevantar.getNombre()+"\nJustificacion: "+justificacion+"\nEstado: "+imprimirEstado()+"\nJustificacion Rechazo: "+justificacionRechazo;
            }
        }
}

class LevantamientoRN extends TramitesEstudiantiles{
    private Curso cursoRN;
    private ArrayList<Curso> cursosAMatricular;
    private boolean estado;
    private byte gradoRN;

    public LevantamientoRN(Estudiante estudiante, Date fechaRegistro, String detalleDescriptivo,Curso cursoRN, ArrayList<Curso> cursosAMatricular, boolean estado){
        super(estudiante,fechaRegistro,detalleDescriptivo);
        this.cursoRN = cursoRN;
        this.cursosAMatricular = cursosAMatricular;
        this.estado = estado;
        gradoRN = 1;
    }

    public Curso getCursoRN() {
        return cursoRN;
    }
    public void setCursoRN(Curso cursoRN) {
        this.cursoRN = cursoRN;
    }
    public ArrayList<Curso> getCursosAMatricular() {
        return cursosAMatricular;
    }
    public void agregarCursoAMatricular(Curso cursoAMatricular) {
        this.cursosAMatricular.add(cursoAMatricular);
    }
    
    public Boolean getEstado(){
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public byte getGradoRN(){
        return gradoRN;
    }

    public void setGradoRN(byte gradoRN) {
        this.gradoRN = gradoRN;
    }

    public String imprimirEstado(){
        if(estado){
            return "Aprobado";
        }else{
            return "Reprobado";
        }
    }

    public String imprimirCursosAMatricular()
    {
        String cadena = "";
        if(cursosAMatricular.size()!=0)
        {
            for (Curso curso : cursosAMatricular) {
                cadena+="["+curso.getNombre()+"] ";
            }
        }
        return cadena;
    }

    public String toString(){
        return "\n| Tramite Levantamiento RN |\nEstudiante Asociado al tramite: "+estudiante.nombre+"\nFecha del Registro: "+fechaRegistro.getDate()+"/"+fechaRegistro.getMonth()+"/"+fechaRegistro.getYear()+"\nDetalle Descriptivo: "+detalleDescriptivo+"\nCurso Levantamiento RN: "+cursoRN.getNombre()+"\nCursos a Matricular: "+imprimirCursosAMatricular()+"\nEstado: "+imprimirEstado()+"\n";
    }
}

class SolicitudBeca extends TramitesEstudiantiles{

    private String periodoBeca;
    private String tipoBeca;
    private Date fechaInicio;
    private Date fechaFin;

    public SolicitudBeca(Estudiante estudiante, Date fechaRegistro, String detalleDescriptivo, String periodoBeca, String tipoBeca, Date fechaInicio, Date fechaFin){
        super(estudiante,fechaRegistro,detalleDescriptivo);
        this.periodoBeca = periodoBeca;
        this.tipoBeca = tipoBeca;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;

    }

    public String getPeriodoBeca() {
        return periodoBeca;
    }
    public void setPeriodoBeca(String periodoBeca) {
        this.periodoBeca = periodoBeca;
    }
    public String getTipoBeca() {
        return tipoBeca;
    }
    public void setTipoBeca(String tipoBeca) {
        this.tipoBeca = tipoBeca;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String toString(){
        System.out.println();
        return "\n| Tramite Solicitud de Beca |\nEstudiante Asociado al tramite: "+estudiante.nombre+"\nFecha del Registro: "+fechaRegistro.getDate()+"/"+fechaRegistro.getMonth()+"/"+fechaRegistro.getYear()+"\nDetalle Descriptivo: "+detalleDescriptivo+"\nPeriodo de Beca: "+periodoBeca+"\nTipo de Beca: "+tipoBeca+"\nFecha Inicio: "+fechaInicio.getDate()+"/"+fechaInicio.getMonth()+"/"+fechaInicio.getYear()+"\nFecha Final: "+fechaFin.getDate()+"/"+fechaFin.getMonth()+"/"+fechaFin.getYear()+"\n";
    }
}
