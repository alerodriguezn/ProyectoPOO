public class Calificacion {


    private float nota;
    private Grupo grupo;

    public Calificacion(float nota, Grupo grupo){
        this.nota = nota;
        this.grupo = grupo;
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
