import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.lang.model.util.ElementScanner6;

public class Principal {


    // Listas
   
    public static ArrayList<Curso> listaCursos = new ArrayList<Curso>();

    public static ArrayList<Coordinador> listaCoordinadores = new ArrayList<Coordinador>();
    public static ArrayList<Profesor> listaProfesores = new ArrayList<Profesor>();
    public static ArrayList<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();
    public static ArrayList<Grupo> listaGrupos = new ArrayList<Grupo>();


    public static boolean permisosUsuarios;
    public static Profesor profesorLogeado;
    public static Coordinador coordinadorLogeado;


    //Funcion para pruebas
    public static void cargarDatos(){

        Curso poo = new Curso("IC2022", "Programacion Orientada a Objetos", (byte) 3, (byte)8);
        Curso ed = new Curso("IC2021", "Estructuras de Datos", (byte) 4, (byte)10);
        Curso arqui = new Curso("IC2020", "Arquitectura de Computadoras", (byte) 4, (byte)10);
        Curso cdi = new Curso("IC2020", "Calculo Diferecial E Integral", (byte) 4, (byte)12);

        listaCursos.add(poo);
        listaCursos.add(ed);
        listaCursos.add(arqui);
        listaCursos.add(cdi);


        
        Profesor  us1 = new Profesor("Leonardo Viquez", "8523-1232", "leo@leo.com", "leo", "leo123");
        Profesor  us3 = new Profesor("Lorena", "8223-4134", "lorena@lorena.com", "lorena", "lore123");

        Coordinador us2 = new Coordinador("Admin", "2022-2202", "admin@admin.com", "admin", "123");
        Estudiante es1 = new Estudiante("Alejandro", 2022230350,"arnavarro@estudiantec.cr", new Date(2002,11,19), (byte)19, "Masculino","La Fortuna");
        Estudiante es2 = new Estudiante("Deivid", 2022180126, "dematute@estudiantec.cr", new Date(2002,11,23), (byte)19, "Masculino","Santa Clara");
        
        Grupo g1 = new Grupo("L-7:00-11:30", us1, (byte)50, new Date(2022,06,10), new Date(2022,12,10), listaCursos.get(0));
        Grupo g2 = new Grupo("M-12:30-16:00", us3, (byte)50, new Date(2022,06,10), new Date(2022,12,10), listaCursos.get(1));

        
        listaProfesores.add(us1);
        listaCoordinadores.add(us2);
        listaEstudiantes.add(es1);
        listaEstudiantes.add(es2);
        listaGrupos.add(g1);
        listaGrupos.add(g2);
        listaProfesores.add(us3);

    }

    public static void main(String[] args) {

        cargarDatos();
    
        funciones f = new funciones(); //Archivo con funciones.

        //us2.registrarUsuario();

        while(true){
            f.menuInicioSesion();

            System.out.print("Elija Una Opcion: ");
            Scanner in = new Scanner(System.in);
            String opcionLogin = in.nextLine();

            if (opcionLogin.equals("1")){

                System.out.print("Usuario: ");
                String usuario = in.nextLine();

                System.out.print("Contraseña: ");
                String contrasena = in.nextLine();

                if((f.validarCoordinador(usuario, contrasena, listaCoordinadores)) && (permisosUsuarios == true) ){

                    while(true){
                        f.menuCoordinador();
                        System.out.print("Elija una opcion: ");
                        String opcion = in.nextLine();

                        if(opcion.equals("1")){

                        }
                        else if(opcion.equals("2")){
                            f.limpiarConsola();
                            System.out.println("=== Registrando Estudiante..... ===");
                            System.out.print("Nombre Completo: ");
                            String nombreC = in.nextLine();
                            System.out.print("Carnet: ");
                            String carnet = in.nextLine();
                            System.out.print("Correo: ");
                            String correo = in.nextLine();
                            System.out.print("Fecha Nacimiento(dd-mm-aa): ");
                            String fecha = in.nextLine();
                            System.out.print("Edad: ");
                            String edad = in.nextLine();
                            System.out.print("Genero: ");
                            String genero = in.nextLine();
                            System.out.print("Lugar de Procedencia: ");
                            String lugarProcedencia = in.nextLine();

                            if(f.buscarEstudiantePorCarnet( Integer.parseInt(carnet), listaEstudiantes) == null){
                                coordinadorLogeado.registrarEstudiante(nombreC, Integer.parseInt(carnet), correo, new Date(f.obtenerFecha(fecha, "dia"),f.obtenerFecha(fecha, "mes"),f.obtenerFecha(fecha, "anio")), (byte) Integer.parseInt(edad), genero, lugarProcedencia);                              
                                f.limpiarConsola();
                                f.imprimirListaEstudiantes(listaEstudiantes);
                                System.out.print("Presione enter para continuar.....");
                                String aux = in.nextLine();
                            }else{
                                f.limpiarConsola();
                                System.out.println("No Se Pudo Registrar al Estudiante (Ya Existe)");
                                System.out.print("Presione enter para continuar.....");
                                String aux = in.nextLine();
                            }

                            

                        }
                        else if(opcion.equals("3")){
                            f.limpiarConsola();
                            System.out.println("=== Actualizando Estudiante..... ===");
                            
                            System.out.print("Carnet del Estudiante a Actualizar: ");
                            String carnetB = in.nextLine();

                            Estudiante estudianteBuscar = f.buscarEstudiantePorCarnet(Integer.parseInt(carnetB), listaEstudiantes);

                            if(estudianteBuscar != null){
                                System.out.print("Nuevo Nombre Completo: ");
                                String nombreC = in.nextLine();
                                System.out.print("Nuevo Carnet: ");
                                String carnet = in.nextLine();
                                System.out.print("Nuevo Correo: ");
                                String correo = in.nextLine();
                                System.out.print("Nueva Fecha Nacimiento(dd-mm-aa): ");
                                String fecha = in.nextLine();
                                System.out.print("Nueva Edad: ");
                                String edad = in.nextLine();
                                System.out.print("Nuevo Genero: ");
                                String genero = in.nextLine();
                                System.out.print("Nuevo Lugar de Procedencia: ");
                                String lugarProcedencia = in.nextLine();
                                coordinadorLogeado.actualizarEstudiante( estudianteBuscar, nombreC, correo, Integer.parseInt(carnet), new Date(f.obtenerFecha(fecha, "dia"),f.obtenerFecha(fecha, "mes"),f.obtenerFecha(fecha, "anio")),(byte) Integer.parseInt(edad), genero, lugarProcedencia);
                                f.limpiarConsola();
                                f.imprimirListaEstudiantes(listaEstudiantes);
                                System.out.print("Presione enter para continuar.....");
                                String aux = in.nextLine();
                            }else{
                                System.out.println("No Se Ha Encontrado El Estudiante Que Desea Modificar");
                            }
                        }
                        else if(opcion.equals("4")){

                            f.limpiarConsola();
                            System.out.println("=== Registrando Curso..... ===");
                            System.out.print("Codigo: ");
                            String codigo = in.nextLine();
                            System.out.print("Nombre: ");
                            String nombre = in.nextLine();
                            System.out.print("Creditos: ");
                            String creditos = in.nextLine();
                            System.out.print("Cantidad Horas Lectivas: ");
                            String cantidadHorasLectivas = in.nextLine();
                          
                            if(f.buscarCursoPorCodigoCurso(codigo, listaCursos) == null){
                                coordinadorLogeado.registrarCurso(codigo, nombre, (byte) Integer.parseInt(creditos) , (byte)Integer.parseInt(cantidadHorasLectivas));

                                
                                f.limpiarConsola();
                                f.imprimirListaCursos(listaCursos);
                                System.out.print("Presione enter para continuar.....");
                                String aux = in.nextLine();
                            }else{
                                f.limpiarConsola();
                                System.out.println("No Se Pudo Registrar el Curso (Ya Existe)");
                                System.out.print("Presione enter para continuar.....");
                                String aux = in.nextLine();
                            }


                        }
                        else if(opcion.equals("5")){

                            f.limpiarConsola();
                            System.out.println("=== Actualizando Curso..... ===");
                            
                            System.out.print("Codigo del Curso a Actualizar: ");
                            String cod = in.nextLine();

                            Curso cursoBuscar = f.buscarCursoPorCodigoCurso(cod, listaCursos);

                            if(cursoBuscar != null){
                                System.out.print("Nuevo Codigo: ");
                                String codigo = in.nextLine();
                                System.out.print("Nuevo Nombre: ");
                                String nombre = in.nextLine();
                                System.out.print("Nuevo Creditos: ");
                                String creditos = in.nextLine();
                                System.out.print("Nueva Cantidad Horas Lectivas: ");
                                String cantidadHorasLectivas = in.nextLine();

                                coordinadorLogeado.actualizarCurso(cursoBuscar, codigo, nombre, (byte) Integer.parseInt(creditos) , (byte)Integer.parseInt(cantidadHorasLectivas));
                                
                                
                                f.limpiarConsola();
                                f.imprimirListaCursos(listaCursos);
                                System.out.print("Presione enter para continuar.....");
                                String aux = in.nextLine();
                            }else{
                                System.out.println("No Se Ha Encontrado El Curso Que Desea Modificar");
                            }

                        }
                        else if(opcion.equals("6")){

                        }
                        else if(opcion.equals("7")){

                        }
                        else if(opcion.equals("8")){

                        }
                        else if(opcion.equals("9")){

                        }
                        else if(opcion.equals("s")){
                            break;
                        }
                    }
    
                }
                
            }else if(opcionLogin.equals("2")){

                System.out.print("Usuario: ");
                String usuario = in.nextLine();

                System.out.print("Contraseña: ");
                String contrasena = in.nextLine();


                if((f.validarProfesor(usuario, contrasena, listaProfesores)) && (permisosUsuarios == false)  ){

                    while(true){
                        f.menuProfesor();
                        System.out.print("Elija una opcion: ");
                        String opcion = in.nextLine();

                        if(opcion.equals("1")){
                            f.limpiarConsola();
                            System.out.println("=== Registrando Nota de Estudiante..... ===");
                            System.out.print("Carnet del Estudiante: ");
                            String carnet = in.nextLine();
                            Estudiante e = f.buscarEstudiantePorCarnet(Integer.parseInt(carnet), listaEstudiantes);

                            System.out.print("Nota: ");
                            String nota = in.nextLine();
                            //Aqui se deberia de desplegar los cursos matriculados del Estudiante y que el profesor pueda elejir
                            System.out.print("Curso: ");
                            String curso = in.nextLine();
                            
                            // Aqui solo lo estoy probando, Hay que cambiarlo
                            profesorLogeado.registrarCalificacion(e, listaGrupos.get(0), Float.parseFloat(nota));
                        
                        }
                        else if(opcion.equals("2")){
                        

                        }
                        else if(opcion.equals("3")){

                        }
                        else if(opcion.equals("4")){

                        }
                        else if(opcion.equals("5")){

                        }
                        else if(opcion.equals("6")){

                        }
                    }
                              
                }
            }else{
                System.out.println("Dato incorrecto");
            }

        }
        
    }

    
}
