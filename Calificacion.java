public class Calificacion {


    private Estudiante estudiante;
    private float nota;
    private Grupo grupo;

    public Calificacion(Estudiante estudiante, float nota, Grupo grupo){
        this.estudiante = estudiante;
        this.nota = nota;
        this.grupo = grupo;
    }


    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    
}
