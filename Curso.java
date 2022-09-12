import java.util.ArrayList;

/**
 * Describe los datos del curso
 */
public class Curso{
    private String codigo;
    private String nombre;
    private byte creditos;
    private byte cantidadHorasLectivas;
    private ArrayList<Curso> requisitos;
    private ArrayList<Curso> correquisitos;
    //private modalidad; ***** FALTA PENSAR ESTO BIEN ******

    public Curso(String codigo, String nombre, byte creditos, byte cantidadHorasLectivas){
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.cantidadHorasLectivas = cantidadHorasLectivas;
    }

    // Declaro los getters y setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getCreditos() {
        return creditos;
    }

    public void setCreditos(byte creditos) {
        this.creditos = creditos;
    }


    public byte getCantidadHorasLectivas() {
        return cantidadHorasLectivas;
    }

    public void setCantidadHorasLectivas(byte cantidadHorasLectivas) {
        this.cantidadHorasLectivas = cantidadHorasLectivas;
    }

    // Otros metodos

    public void agregarRequisito(Curso requisito){
        requisitos.add(requisito);
    }

    public void agregarCorrequisito(Curso correquisito){
        correquisitos.add(correquisito);
    }
}
