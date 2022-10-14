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
    private ArrayList<AcompanamientoCurso> listaAC;


    public Estudiante(String nombreCompleto, int carnet, String correo, Date fechaNacimiento, byte edad, String genero, String lugarProcedencia){

        super(nombreCompleto, correo);
        this.carnet = carnet;
        this.fechaNacimiento=(Date)fechaNacimiento.clone();
        this.edad = edad;
        this.genero = genero;
        this.lugarProcedencia = lugarProcedencia;
        this.calificaciones = new ArrayList<Calificacion>();
        this.cursosMatriculados = new ArrayList<Grupo>();
        this.listaAC = new ArrayList<AcompanamientoCurso>();

    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }


    @Override
    public String getCorreo() {
        return super.getCorreo();
    }

    @Override
    public void setCorreo(String correo) {
        super.setCorreo(correo);
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
        this.calificaciones.add(new Calificacion(nota, grupo));
    }


    public void setAcompanamiento(Date fecha, String tipo, Estudiante e,String notaD) {
        this.listaAC.add(new AcompanamientoCurso(fecha,tipo,e,notaD));
    }

    public void imprimirCursosMatriculados(){
        for (Grupo g : this.cursosMatriculados) {
            System.out.println("- Curso: " + g.getCurso().getNombre());
            
        }
    }

    public float getCalificacionesPorGrupo(Grupo g) {
        for (Calificacion c : this.calificaciones) {
            if(c.getGrupo() == g){
                return c.getNotaRedondeada();
            }            
        }
        return 0f;
    }

    public void imprimirCalifaciones(){
        for (Calificacion c : this.calificaciones) {
            System.out.println("Nota: " + String.valueOf(c.getNota()) +" | Curso: "+ c.getGrupo().getCurso().getNombre());
            
        }
    }

    public ArrayList<Grupo> getcursosMatriculados() {
        return cursosMatriculados;
    }

    public void setcursosMatriculados(Grupo grupo) {
        this.cursosMatriculados.add(grupo);
    }

    public String toString(){
        return("Nombre: " + this.getNombre() + " | Correo: "+ this.getCorreo() + " | Carnet: "+ this.getCarnet() + " | Fecha Nacimiento: " + this.getFechaNacimiento().getYear())+"/"+this.getFechaNacimiento().getMonth()+"/"+this.getFechaNacimiento().getDay();
    }


    
}
