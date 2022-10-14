import java.util.ArrayList;
import java.util.Date;

/**
 * Describe los datos de los Tramites Estudiantiles
 */
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


    /**
     * Retorna el curso a levantar
     * @return Retorna el curso a levantar
     */
    public Curso getCursoALevantar() {
        return cursoALevantar;
    }

    /**
     * Establece el curso a levantar
     */
    public void setCursoALevantar(Curso cursoALevantar) {
        this.cursoALevantar = cursoALevantar;
    }

    /**
     * Retorna la justficacion
     * @return Retorna la justificacion
     */
    public String getJustificacion() {
        return justificacion;
    }

    /**
     * Establece la justificacion
     */
    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    /**
     * Retorna la justficacion rechazo
     * @return Retorna la justificacion rechazo
     */
    public String getJustificacionRechazo() {
        return justificacionRechazo;
    }

    /**
     * Establece la justificacion rechazo
     */
    public void setJustificacionRechazo(String justificacionRechazo) {
        this.justificacionRechazo = justificacionRechazo;
    }

    /**
     * Retorna el estado
     * @return Estado
     */
    public Boolean getEstado(){
        return estado;
    }

    /**
     * Establece el estado
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Imprime el estado
     * @return Estado Aprobado o Reprobado
     */
    public String imprimirEstado(){
        if(estado){
            return "Aprobado";
        }else{
            return "Reprobado";
        }
    }

    /**
     * ToString Tramites
     * @return String
     */
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

    /**
     * Retorna el curso RN
     * @return Retorna el cursoRN
     */
    public Curso getCursoRN() {
        return cursoRN;
    }

    /**
     * Establece el curso RN
     * @param cursoRN
     */
    public void setCursoRN(Curso cursoRN) {
        this.cursoRN = cursoRN;
    }

    /**
     * Retorna el curso a matricular
     * @return el curso a matricular
     */
    public ArrayList<Curso> getCursosAMatricular() {
        return cursosAMatricular;
    }

    /**
     * Agrega el curso a matricular
     */
    public void agregarCursoAMatricular(Curso cursoAMatricular) {
        this.cursosAMatricular.add(cursoAMatricular);
    }
    
    /**
     * Estado del tramite
     * @return el estado del tramite
     */
    public Boolean getEstado(){
        return estado;
    }

    /**
     * Establece el estado
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

     /**
     * Devuelve el Grado RN
     * @return retorna el grado RN
     */
    public byte getGradoRN(){
        return gradoRN;
    }

    /**
     * Establece el Grado RN
     */
    public void setGradoRN(byte gradoRN) {
        this.gradoRN = gradoRN;
    }

    /**
     * Imprime el estado del tramite
     * @return Aprobado o Reprobado
     */
    public String imprimirEstado(){
        if(estado){
            return "Aprobado";
        }else{
            return "Reprobado";
        }
    }

    /**
     * Imprime los cursos a matricular
     */
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

     /**
     * Retorna un string con los datos del tramite
     * @return String con todos los datos del tramite
     */
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

    /**
     * Obtiene el periodo de la beca
     * @return Devuelve el periodo
     */
    public String getPeriodoBeca() {
        return periodoBeca;
    }

    /**
     * Establece el periodo de la beca
     */
    public void setPeriodoBeca(String periodoBeca) {
        this.periodoBeca = periodoBeca;
    }

    /**
     * Obtiene el tipo de la beca
     * @return Devuelve el tipo de la beca
     */
    public String getTipoBeca() {
        return tipoBeca;
    }

    /**
     * Establece el tipo de la beca
     */
    public void setTipoBeca(String tipoBeca) {
        this.tipoBeca = tipoBeca;
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

    /**
     * Obtiene le fecha fin
     * @return Devuelve le fecha fin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * Establece la fecha fin
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Devuelve un string con los datos del tramite
     * @return Retorna un string con los datos del tramite
     */
    public String toString(){
        System.out.println();
        return "\n| Tramite Solicitud de Beca |\nEstudiante Asociado al tramite: "+estudiante.nombre+"\nFecha del Registro: "+fechaRegistro.getDate()+"/"+fechaRegistro.getMonth()+"/"+fechaRegistro.getYear()+"\nDetalle Descriptivo: "+detalleDescriptivo+"\nPeriodo de Beca: "+periodoBeca+"\nTipo de Beca: "+tipoBeca+"\nFecha Inicio: "+fechaInicio.getDate()+"/"+fechaInicio.getMonth()+"/"+fechaInicio.getYear()+"\nFecha Final: "+fechaFin.getDate()+"/"+fechaFin.getMonth()+"/"+fechaFin.getYear()+"\n";
    }
}
