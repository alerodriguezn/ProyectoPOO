import java.util.ArrayList;
import java.util.Date;

/**
 * Describe los datos del Estudiante
 */
public class Estudiante extends Usuario{

    private int carnet;
    private Date fechaNacimiento;
    private byte edad;
    private String genero;
    private String lugarProcedencia;
    private ArrayList<Calificacion> calificaciones;
    private ArrayList<Grupo> cursosMatriculados;

    public Estudiante(String nombreCompleto, int carnet, String correo, Date fechaNacimiento, byte edad, String genero, String lugarProcedencia){

        super(nombreCompleto, correo);
        this.carnet = carnet;
        this.fechaNacimiento=(Date)fechaNacimiento.clone();
        this.edad = edad;
        this.genero = genero;
        this.lugarProcedencia = lugarProcedencia;
        this.calificaciones = new ArrayList<Calificacion>();
        this.cursosMatriculados = new ArrayList<Grupo>();
        
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

    public ArrayList<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(float nota, Grupo grupo) {
        this.calificaciones.add(new Calificacion(this, nota, grupo));
    }

    public ArrayList<Grupo> getcursosMatriculados() {
        return cursosMatriculados;
    }

    public void setcursosMatriculados(Grupo grupo) {
        this.cursosMatriculados.add(grupo);
    }


    
}
