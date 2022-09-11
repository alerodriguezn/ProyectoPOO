import java.util.Date;

public class TramitesEstudiantiles {

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
