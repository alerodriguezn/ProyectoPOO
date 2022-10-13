import java.util.ArrayList;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Estudiante getEstudianteTutor() {
        return estudianteTutor;
    }

    public void setEstudianteTutor(Estudiante estudianteTutor) {
        this.estudianteTutor = estudianteTutor;
    }

    public void imprimirListaTutorias(){
        for (String s : this.listaSesiones) {
            System.out.println(s);

        }
    }

    public Grupo getCursoAsociado() {
        return cursoAsociado;
    }

    public void setCursoAsociado(Grupo cursoAsociado) {
        this.cursoAsociado = cursoAsociado;
    }

    public ArrayList<String> getListaSesiones() {
        return listaSesiones;
    }

    public void setListaSesiones(String sesion) {
        this.listaSesiones.add(sesion);
    }
}


