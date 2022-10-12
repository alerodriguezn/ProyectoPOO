import java.util.ArrayList;

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

    /*
     * Funcion que registra tiempo adicional en evaluaciones
     */
    public void registrarTiempoAdicionalEvaluaciones()
    {
        System.out.println("Funcion");
    }

    /*
     * Funcion que registra adecuacion
     */
    public void registrarAdecuacion()
    {
        System.out.println("Funcion");
    }

    /*
     * Funcion que registra un reporte de una incidencia significativa
     */
    public void registrarReporteIncidencia()
    {
        System.out.println("Funcion");
    }

    /*
     * Funcion que registra las sesiones tutorias y las asistencias
     */
    public void registrarSesionTutoria()
    {
        System.out.println("Funcion");
    }
}
