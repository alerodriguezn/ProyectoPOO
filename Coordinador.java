import java.util.Scanner;

public class Coordinador extends Usuario{
    
    public Coordinador(String nombre,String telefono, String correo, String usuario, String contrasena){
        
        super(nombre, telefono, correo, usuario, contrasena,'c');

    }

    /*
     * Funcion que crea un nuevo usuario
     */
    public void registrarUsuario()
    {
        System.out.println("* Datos del nuevo usuario *");
        System.out.print("Nombre: ");
        Scanner in = new Scanner(System.in);
        String nombre = in.nextLine();
        System.out.print("Telefono: ");
        String telefono = in.nextLine();
        System.out.print("Correo: ");
        String correo = in.nextLine();
        System.out.print("Usuario: ");
        String usuario = in.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = in.nextLine();
        System.out.print("Perfil: c/p");
        char perfil = in.nextLine().charAt(0);

        
        Principal p = new Principal(); //Esto lo hago de momento para agregar el usuario al array que esta en principal
        
        if(perfil == 'c'){
            Coordinador nuevoUsuario = new Coordinador(nombre, telefono, correo, usuario, contrasena);
            p.listaUsuarios.add(nuevoUsuario); //Se añade a la lista de usuarios que esta en principal
        }
        else if (perfil == 'p'){
            Profesor nuevoUsuario = new Profesor(nombre, telefono, correo, usuario, contrasena);
            p.listaUsuarios.add(nuevoUsuario); //Se añade a la lista de usuarios que esta en principal
        }
        
    }

    /*
     * Funcion que registra un nuevo estudiante
     */
    public void registrarEstudiante()
    {
        System.out.println("Funcion");
    }

    /*
     * Funcion que actualiza datos del estudiante
     */
    public void actualizarEstudiante()
    {
        System.out.println("Funcion");
    }

    /*
     * Funcion que ingresa un nuevo curso
     */
    public void registrarCurso()
    {
        System.out.println("Funcion");
    }

    /*
     * Funcion que actualiza un curso
     */
    public void actualizarCurso()
    {
        System.out.println("Funcion");
    }

    /*
     * Funcion que crea un nuevo grupo
     */
    public void registrarGrupo()
    {
        System.out.println("Funcion");
    }

    /*
     * Funcion que actualiza un grupo
     */
    public void actualizarGrupo()
    {
        System.out.println("Funcion");
    }

    /*
     * Funcion que asocia una matricula con el estudiante
     */
    public void asociarMatriculaEstudiante()
    {
        System.out.println("Funcion");
    }

    /*
     * Funcion que registra un tramite estudiantil
     */
    public void registrarTramiteEstudiantil()
    {
        System.out.println("Funcion");
    }

}
