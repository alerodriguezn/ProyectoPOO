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

    public Curso(String codigo, String nombre, byte creditos, byte cantidadHorasLectivas){
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.cantidadHorasLectivas = cantidadHorasLectivas;
        this.requisitos = new ArrayList<Curso>();
        this.correquisitos = new ArrayList<Curso>();
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

    public void setRequisitos(ArrayList<Curso> requisitos) {
        this.requisitos = requisitos;
    }

    public void setCorrequisitos(ArrayList<Curso> correquisitos) {
        this.correquisitos = correquisitos;
    }

    // Otros metodos

    public void agregarRequisito(Curso requisito){
        requisitos.add(requisito);
    }

    public void agregarCorrequisito(Curso correquisito){
        correquisitos.add(correquisito);
    }

    
    public void resetearCorrequisitos(){
        correquisitos.clear();;
    }    

    public void resetearRequisitos(){
        requisitos.clear();
    }    

    public ArrayList<Curso> getCorrequisitos() {
        return correquisitos;
    }

    public ArrayList<Curso> getRequisitos() {
        return requisitos;
    }

    public String toStringCorrequisitos(){
        String res = new String();
        for (Curso c : this.correquisitos) {
            String nombreC = c.getNombre();
            res = res.concat(" ["+nombreC+"] ");
        }
        return res;
    }

    public String toStringRequisitos(){
        String res = "";
        for (Curso c : this.requisitos) {
            String nombreC = c.getNombre();
            res = res.concat(" ["+nombreC+"] ");
        }
        return res;
    }
    
    public String toString() {
        return ("Nombre: "+this.getNombre()+ " | Codigo: "+ this.getCodigo()+" | Creditos: " + String.valueOf(this.getCreditos())+ " | Cantidad Horas Lectivas: "+String.valueOf(this.getCantidadHorasLectivas())+" | Correquisitos: " + this.toStringCorrequisitos() + " | Requisitos: " + this.toStringRequisitos()) ;
    }
}

