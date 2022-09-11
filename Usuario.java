
/**
 * Describe los datos del Usuario Cordinador o Profesor
 */
public class Usuario {

    private String nombre;
    private String[] telefonos;  
    private String correo;
    private String usuario;
    private String contrasena;


    public Usuario(String nombre,String telefono, String correo, String usuario, String contrasena ){
        this.nombre = nombre;
        this.telefonos= new String[3];
        this.telefonos[0]=telefono;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefonos(byte pos) {
        return telefonos[pos];
    }

    public void setTelefonos(String telefono, byte pos) {
        this.telefonos[pos] = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
}
