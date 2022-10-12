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

    /**
     * Funcion que devuelve el codigo del curso
     * @return Retorna el codigo del curso
     */
    public String getCodigo() {
        return codigo;
    }


    /**
     * Funcion que establece el codigo del curso
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Funcion que devuelve el nombre del curso
     * @return Retorna el nombre del curso
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Funcion que establece el nombre del curso
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Funcion que devuelve los creditos del curso
     * @return Retorna los creditos del curso
     */
    public byte getCreditos() {
        return creditos;
    }

    /**
     * Funcion que establece los creditos del curso
     */
    public void setCreditos(byte creditos) {
        this.creditos = creditos;
    }

    /**
     * Funcion que devuelve la cantidad de horas lectivas
     * @return Retorna la cantidad de horas lectivas
     */
    public byte getCantidadHorasLectivas() {
        return cantidadHorasLectivas;
    }

    
    /**
     * Funcion que establece la cantidad de horas lectivas
     */
    public void setCantidadHorasLectivas(byte cantidadHorasLectivas) {
        this.cantidadHorasLectivas = cantidadHorasLectivas;
    }

    /**
     * Funcion que establece los requisitos
     */
    public void setRequisitos(ArrayList<Curso> requisitos) {
        this.requisitos = requisitos;
    }

    /**
     * Funcion que establece los correquisitos
     */
    public void setCorrequisitos(ArrayList<Curso> correquisitos) {
        this.correquisitos = correquisitos;
    }


    /**
     * Funcion que agregar un requisito
     * @param requisito Requisito del curso
     */
    public void agregarRequisito(Curso requisito){
        requisitos.add(requisito);
    }

    /**
     * Funcion que agregar un correquisito
     * @param correquisito Correquisito del curso
     */
    public void agregarCorrequisito(Curso correquisito){
        correquisitos.add(correquisito);
    }

     /**
     * Resetea los correquisitos
     */
    public void resetearCorrequisitos(){
        correquisitos.clear();;
    }    

    /**
     * Resetea los requisitos
     */
    public void resetearRequisitos(){
        requisitos.clear();
    }    

    /**
     * Funcion que devuelve los correquisitos
     * @return Retorna los correquisitos
     */
    public ArrayList<Curso> getCorrequisitos() {
        return correquisitos;
    }

    /**
     * Funcion que devuelve los requisitos
     * @return Retorna los requisitos
     */
    public ArrayList<Curso> getRequisitos() {
        return requisitos;
    }

    /**
     * Funcion que devuelve los correquisitos en string
     * @return Retorna un string de correquisitos
     */
    public String toStringCorrequisitos(){
        String res = new String();
        for (Curso c : this.correquisitos) {
            String nombreC = c.getNombre();
            res = res.concat(" ["+nombreC+"] ");
        }
        return res;
    }

    /**
     * Funcion que devuelve los requisitos en string
     * @return Retorna un string de requisitos
     */
    public String toStringRequisitos(){
        String res = "";
        for (Curso c : this.requisitos) {
            String nombreC = c.getNombre();
            res = res.concat(" ["+nombreC+"] ");
        }
        return res;
    }
    
    /**
     * Funcion que devuelve todos los datos del curso en string
     * @return Retorna un string de los datos del curso
     */
    public String toString() {
        return ("Nombre: "+this.getNombre()+ " | Codigo: "+ this.getCodigo()+" | Creditos: " + String.valueOf(this.getCreditos())+ " | Cantidad Horas Lectivas: "+String.valueOf(this.getCantidadHorasLectivas())+" | Correquisitos: " + this.toStringCorrequisitos() + " | Requisitos: " + this.toStringRequisitos()) ;
    }
}

