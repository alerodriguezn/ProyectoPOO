public class Profesor extends Usuario{
    
    public Profesor(String nombre,String telefono, String correo, String usuario, String contrasena){
        
        super(nombre, telefono, correo, usuario, contrasena,'p');

    }

    
    /*
     * Funcion que registra una calificacion
     */
    public void registrarCalificacion()
    {
        System.out.println("Funcion");
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
