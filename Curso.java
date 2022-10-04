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

    private String horario;
    private int aula;
    private String plataforma;


    //private modalidad; ***** FALTA PENSAR ESTO BIEN ******

    public Curso(String codigo, String nombre, byte creditos, byte cantidadHorasLectivas, String horario, int aula){
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.cantidadHorasLectivas = cantidadHorasLectivas;
        this.requisitos = new ArrayList<Curso>();
        this.correquisitos = new ArrayList<Curso>();
        this.horario = horario;
        this.aula = aula;
        
    }
    public Curso(String codigo, String nombre, byte creditos, byte cantidadHorasLectivas, String plataforma){
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.cantidadHorasLectivas = cantidadHorasLectivas;
        this.requisitos = new ArrayList<Curso>();
        this.correquisitos = new ArrayList<Curso>();
        this.plataforma = plataforma;
        
    }
    public Curso(String codigo, String nombre, byte creditos, byte cantidadHorasLectivas, String horario, String plataforma){
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.cantidadHorasLectivas = cantidadHorasLectivas;
        this.requisitos = new ArrayList<Curso>();
        this.correquisitos = new ArrayList<Curso>();
        this.horario = horario;
        this.plataforma = plataforma;
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

    public int getAula() {
        return aula;
    }

    public void setAula(int aula) {
        this.aula = aula;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    // Otros metodos

    public void agregarRequisito(Curso requisito){
        requisitos.add(requisito);
    }

    public void agregarCorrequisito(Curso correquisito){
        correquisitos.add(correquisito);
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
        if (this.plataforma == null){
            return ("[PRESENCIAL] "+"Nombre: "+this.getNombre()+ " | Codigo: "+ this.getCodigo()+" | Creditos: " + String.valueOf(this.getCreditos())+ " | Cantidad Horas Lectivas: " + String.valueOf(this.getCantidadHorasLectivas())+" | Aula: "+String.valueOf(this.getAula()) + " | Horario: " + this.getHorario() + " | Correquisitos: " + this.toStringCorrequisitos() + " | Requisitos: " + this.toStringRequisitos()) ;
        }
        else if(this.horario == null ){
            return ("[VIRTUAL-ASINCRONICO] "+"Nombre: "+this.getNombre()+ " | Codigo: "+ this.getCodigo()+" | Creditos: " + String.valueOf(this.getCreditos())+ " | Cantidad Horas Lectivas: " + String.valueOf(this.getCantidadHorasLectivas())+" | Plataforma: "+ this.getPlataforma() + " | Correquisitos: " + this.toStringCorrequisitos() + " | Requisitos: " + this.toStringRequisitos()) ;
        }
        else{
            return ("[VIRTUAL-SINCRONICO] "+"Nombre: "+this.getNombre()+ " | Codigo: "+ this.getCodigo()+" | Creditos: " + String.valueOf(this.getCreditos())+ " | Cantidad Horas Lectivas: " + String.valueOf(this.getCantidadHorasLectivas())+" | Plataforma: "+ this.getPlataforma() + " | Horario: " + this.getHorario() + " | Correquisitos: " + this.toStringCorrequisitos() + " | Requisitos: " + this.toStringRequisitos());
        }
    }
}
