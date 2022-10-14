import java.util.ArrayList;

/**
 * Describe los datos de las Tutorias
 */
public class Tutorias {

    int id;
    Estudiante estudianteTutor;
    Grupo cursoAsociado;
    ArrayList<String> listaSesiones;

    public Tutorias(int id, Estudiante estudianteTutor,Grupo cursoAsociado){
        this.id = id;
        this.estudianteTutor = estudianteTutor;
        this.cursoAsociado = cursoAsociado;
        this.listaSesiones = new ArrayList<String>();
    }

    /**
     * Retorna el id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna el estudiante tutor
     * @return estudiante
     */
    public Estudiante getEstudianteTutor() {
        return estudianteTutor;
    }

    /**
     * Establece el estudiante tutor
     */
    public void setEstudianteTutor(Estudiante estudianteTutor) {
        this.estudianteTutor = estudianteTutor;
    }

    /**
     * Imprime la lista de tutorias
     */
    public void imprimirListaTutorias(){
        for (String s : this.listaSesiones) {
            System.out.println(s);

        }
    }

    /**
     * Obtiene el curso asociado
     */
    public Grupo getCursoAsociado() {
        return cursoAsociado;
    }

    /**
     * Establece el curso asociado
     */
    public void setCursoAsociado(Grupo cursoAsociado) {
        this.cursoAsociado = cursoAsociado;
    }

    /**
     * Obtiene la lista de sesiones
     */
    public ArrayList<String> getListaSesiones() {
        return listaSesiones;
    }
    
    /**
     * Establece el curso asociado
     */
    public void setListaSesiones(String sesion) {
        this.listaSesiones.add(sesion);
    }
}


