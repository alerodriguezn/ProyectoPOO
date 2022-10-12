
/**
 * Describe los datos de la calificacion de un Estudiante
 */
public class Calificacion {


    private float nota;
    private Grupo grupo;

    public Calificacion(float nota, Grupo grupo){
        this.nota = nota;
        this.grupo = grupo;
    }


    /**
     * Funcion que devuelve la nota del estudiante
     * @return Retorna la nota
     */
    public float getNota() {
        return nota;
    }

    /**
     * Funcion que establece la nota
     */
    public void setNota(float nota) {
        this.nota = nota;
    }

    /**
     * Funcion que devuelve el grupo
     * @return Retorna el grupo
     */
    public Grupo getGrupo() {
        return grupo;
    }

    /**
     * Funcion que establece el grupo
     */
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    
}
