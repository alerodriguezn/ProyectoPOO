import java.util.Date;

public class Estudiante {

    private String nombreCompleto;
    private int carnet;
    private Date fechaNacimiento;
    private byte edad;
    private String genero;
    private String lugarProcedencia;

    public Estudiante(String nombreCompleto, int carnet, Date fechaNacimiento, byte edad, String genero, String lugarProcedencia){

        this.nombreCompleto = nombreCompleto;
        this.carnet = carnet;
        this.fechaNacimiento=(Date)fechaNacimiento.clone();
        this.edad = edad;
        this.genero = genero;
        this.lugarProcedencia = lugarProcedencia;
        
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = (Date)fechaNacimiento.clone();
    }


    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLugarProcedencia() {
        return lugarProcedencia;
    }

    public void setLugarProcedencia(String lugarProcedencia) {
        this.lugarProcedencia = lugarProcedencia;
    }

    
}
