import java.util.ArrayList;
import java.util.Date;

public class Profesor extends Usuario{

    private ArrayList<Grupo> listaGrupos;
    
    public Profesor(String nombre,String telefono, String correo, String usuario, String contrasena){
        
        super(nombre, telefono, correo, usuario, contrasena, false);
        this.listaGrupos = new ArrayList<Grupo>();

    }
    public void setGrupo(Grupo grupo) {
        this.listaGrupos.add(grupo);
    }

    public ArrayList<Grupo> getGrupos() {
        return this.listaGrupos;
    }

    /**
     * Funcion que imprime los grupos de un profesor
     */
    public void imprimirGrupos(){
        for (Grupo g : this.listaGrupos) {
            System.out.println("Numero de Grupo: "+g.getNumeroGrupo() +" | Nombre del Curso: " +g.getCurso().getNombre());
        }
    }

    /*
     * Funcion que registra una calificacion
     */
    public void registrarCalificacion(Estudiante estudiante, Grupo grupo,float nota)
    {
        estudiante.setCalificaciones(nota, grupo);
    }

    public void setAcompanamiento(Estudiante e, Date fecha, String tipo, String nota ) {
        e.setAcompanamiento(fecha, tipo, e, nota);
    }

    /*
     * Funcion que registra las sesiones tutorias y las asistencias
     */
    public void registrarSesionTutoria()
    {
        System.out.println("Funcion");
    }
}
