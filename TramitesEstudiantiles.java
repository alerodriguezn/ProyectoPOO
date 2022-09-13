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

    public LevantamientoRequisitos(Estudiante estudiante, Date fechaRegistro, String detalleDescriptivo, Curso cursoALevantar, String justificacion, boolean estado){

        //Constructor del padre
        super(estudiante,fechaRegistro,detalleDescriptivo);

        this.cursoALevantar = cursoALevantar;
        this.justificacion = justificacion;
        this.estado = estado;

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


    public Boolean getEstado(){
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}

class LevantamientoRN extends TramitesEstudiantiles{
    private Curso cursoRN;
    private Curso cursoAMatricular;
    private boolean estado;


    public LevantamientoRN(Estudiante estudiante, Date fechaRegistro, String detalleDescriptivo,Curso cursoRN, Curso cursoAMatricular, boolean estado){
        super(estudiante,fechaRegistro,detalleDescriptivo);
        this.cursoRN = cursoRN;
        this.cursoAMatricular = cursoAMatricular;
        this.estado = estado;
    }

    public Curso getCursoRN() {
        return cursoRN;
    }
    public void setCursoRN(Curso cursoRN) {
        this.cursoRN = cursoRN;
    }
    public Curso getCursoAMatricular() {
        return cursoAMatricular;
    }
    public void setCursoAMatricular(Curso cursoAMatricular) {
        this.cursoAMatricular = cursoAMatricular;
    }
    public Boolean getEstado(){
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

class SolicitudBeca extends TramitesEstudiantiles{

    private String periodoBeca;
    private String tipoBeca;

    public SolicitudBeca(Estudiante estudiante, Date fechaRegistro, String detalleDescriptivo, String periodoBeca, String tipoBeca){
        super(estudiante,fechaRegistro,detalleDescriptivo);
        this.periodoBeca = periodoBeca;
        this.tipoBeca = tipoBeca;

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
}
