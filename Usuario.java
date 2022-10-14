

/**
 * Describe los datos del Usuario Cordinador o Profesor
 */
public abstract class Usuario {

    protected String nombre;
    protected String[] telefonos;  
    protected String correo;
    protected String usuario;
    protected String contrasena;
    protected boolean perfil;

    // Constructor
    public Usuario(String nombre,String telefono, String correo, String usuario, String contrasena, Boolean perfil){
        this.nombre = nombre;
        this.telefonos= new String[3];
        this.telefonos[0]=telefono;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.perfil = perfil;
    }

    // Constructor para la herencia que tendrá el estudiante
    public Usuario(String nombre, String correo){
        this.nombre = nombre;
        this.correo = correo;
    }

    /**
     * Obtiene el  nombre del usuario
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece  el nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el telefono del usuario
     * @return telefono
     */
    public String getTelefonos(byte pos) {
        return telefonos[pos];
    }

    /**
     * Establece el telefono
     */
    public void setTelefonos(String telefono, byte pos) {
        this.telefonos[pos] = telefono;
    }


    /**
     * Obtiene el correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene un usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece un usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la contrasena de usuario
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contrasena de usuario
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el perfil de usuario
     */
    public Boolean getPerfil() {
        return perfil;
    }

    /**
     * Establece el perfil de usuario
     */
    public void setPerfil(boolean perfil) {
        this.perfil = perfil;
    }
    
}
