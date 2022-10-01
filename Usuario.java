

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

    public Usuario(String nombre,String telefono, String correo, String usuario, String contrasena, Boolean perfil){
        this.nombre = nombre;
        this.telefonos= new String[3];
        this.telefonos[0]=telefono;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.perfil = perfil;
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

    public Boolean getPerfil() {
        return perfil;
    }

    public void setPerfil(boolean perfil) {
        this.perfil = perfil;
    }



    
}
