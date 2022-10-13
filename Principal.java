import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.lang.model.util.ElementScanner6;
import javax.sound.midi.Soundbank;

public class Principal {

    // Listas Cursos [Presenciales] [Virtual Sincronicos] [Virtual Asincronicos]
    public static ArrayList<Curso> listaCursos = new ArrayList<Curso>();

    public static ArrayList<Coordinador> listaCoordinadores = new ArrayList<Coordinador>();
    public static ArrayList<Profesor> listaProfesores = new ArrayList<Profesor>();
    public static ArrayList<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();
    public static ArrayList<Grupo> listaGrupos = new ArrayList<Grupo>();
    public static ArrayList<TramitesEstudiantiles> listaTramites = new ArrayList<TramitesEstudiantiles>();

    public static boolean permisosUsuarios;
    public static Profesor profesorLogeado;
    public static Coordinador coordinadorLogeado;

    // Funcion para pruebas
    public static void cargarDatos() {

        Curso poo = new Curso("IC2022", "Programacion Orientada a Objetos", (byte) 3, (byte) 8);
        Curso ed = new Curso("IC2021", "Estructuras de Datos", (byte) 4, (byte) 10);
        Curso arqui = new Curso("IC2020", "Arquitectura de Computadoras", (byte) 4, (byte) 10);
        Curso cdi = new Curso("IC2019", "Calculo Diferecial E Integral", (byte) 4, (byte) 12);

        listaCursos.add(poo);
        listaCursos.add(ed);
        listaCursos.add(arqui);
        listaCursos.add(cdi);

        Profesor us1 = new Profesor("Leonardo Viquez", "8523-1232", "leo@leo.com", "leo", "leo123");
        Profesor us3 = new Profesor("Lorena", "8223-4134", "lorena@lorena.com", "lorena", "lore123");

        Coordinador us2 = new Coordinador("Admin", "2022-2202", "admin@admin.com", "admin", "123");
        Estudiante es1 = new Estudiante("Alejandro", 2022230350, "arnavarro@estudiantec.cr", new Date(2002, 11, 19),
                (byte) 19, "Masculino", "La Fortuna");
        Estudiante es2 = new Estudiante("Deivid", 2022180126, "dematute@estudiantec.cr", new Date(2002, 11, 23),
                (byte) 19, "Masculino", "Santa Clara");

        Grupo g1 = new Grupo("L-7:00-11:30", us3, (byte) 50, new Date(2022 - 1900, 2, 03), new Date(2022, 8, 10),
                listaCursos.get(0), 17);
        Grupo g2 = new Grupo("M-12:30-16:00", us3, (byte) 50, new Date(2022 - 1900, 2, 04), new Date(2022, 8, 11),
                listaCursos.get(1), "Zoom");

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

        funciones f = new funciones(); // Archivo con funciones.

        // us2.registrarUsuario();

        while (true) {
            f.menuInicioSesion();

            System.out.print("Elija Una Opcion: ");
            Scanner in = new Scanner(System.in);
            String opcionLogin = in.nextLine();

            if (opcionLogin.equals("1")) {

                System.out.print("Usuario: ");
                String usuario = in.nextLine();

                System.out.print("Contraseña: ");
                String contrasena = in.nextLine();

                if ((f.validarCoordinador(usuario, contrasena, listaCoordinadores)) && (permisosUsuarios == true)) {

                    while (true) {
                        f.menuCoordinador();
                        System.out.print("Elija una opcion: ");
                        String opcion = in.nextLine();

                        if (opcion.equals("1")) {

                        } else if (opcion.equals("2")) {
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

                            if (f.buscarEstudiantePorCarnet(Integer.parseInt(carnet), listaEstudiantes) == null) {
                                coordinadorLogeado.registrarEstudiante(nombreC, Integer.parseInt(carnet), correo,
                                        new Date(f.obtenerFecha(fecha, "anio"), f.obtenerFecha(fecha, "mes"),
                                                f.obtenerFecha(fecha, "dia")),
                                        (byte) Integer.parseInt(edad), genero, lugarProcedencia);
                                f.limpiarConsola();
                                f.imprimirListaEstudiantes(listaEstudiantes);
                                System.out.print("Presione enter para continuar.....");
                                in.nextLine();
                            } else {
                                f.limpiarConsola();
                                System.out.println("No Se Pudo Registrar al Estudiante (Ya Existe)");
                                System.out.print("Presione enter para continuar.....");
                                in.nextLine();
                            }

                        } else if (opcion.equals("3")) {
                            f.limpiarConsola();
                            System.out.println("=== Actualizando Estudiante..... ===");

                            System.out.print("Carnet del Estudiante a Actualizar: ");
                            String carnetB = in.nextLine();

                            Estudiante estudianteBuscar = f.buscarEstudiantePorCarnet(Integer.parseInt(carnetB),
                                    listaEstudiantes);

                            if (estudianteBuscar != null) {
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
                                coordinadorLogeado.actualizarEstudiante(estudianteBuscar, nombreC, correo,
                                        Integer.parseInt(carnet),
                                        new Date(f.obtenerFecha(fecha, "anio"), f.obtenerFecha(fecha, "mes"),
                                                f.obtenerFecha(fecha, "dia")),
                                        (byte) Integer.parseInt(edad), genero, lugarProcedencia);
                                f.limpiarConsola();
                                f.imprimirListaEstudiantes(listaEstudiantes);
                                System.out.print("Presione enter para continuar.....");
                                in.nextLine();
                            } else {
                                System.out.println("No Se Ha Encontrado El Estudiante Que Desea Modificar");
                            }
                        } else if (opcion.equals("4")) {

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
                            coordinadorLogeado.registrarCurso(codigo, nombre,
                                    (byte) Integer.parseInt(creditos),
                                    (byte) Integer.parseInt(cantidadHorasLectivas));
                            Curso cp = f.buscarCursoPorCodigo(codigo, listaCursos);
                            f.agregarCorrequisitoyRequisito(cp, listaCursos);
                            f.limpiarConsola();
                            System.out.println("Curso Registrado Correctamente!");
                            System.out.println("Pulse enter para ver los cursos");
                            in.nextLine();
                            for (Curso c : listaCursos) {
                                System.out.println(c.toString());
                            }
                            System.out.println("Pulse enter para continuar...");
                            in.nextLine();

                        } else if (opcion.equals("5")) {

                            f.limpiarConsola();
                            System.out.println("=== Actualizando Curso..... ===");

                            System.out.print("Codigo del Curso a Actualizar: ");
                            String cod = in.nextLine();

                            Curso cursoBuscar = f.buscarCursoPorCodigo(cod, listaCursos);
                            ArrayList<Curso> requisitosRespaldo = new ArrayList<Curso>();
                            ArrayList<Curso> correquisitosRespaldo = new ArrayList<Curso>();

                            if (cursoBuscar != null) {
                                try {

                                    requisitosRespaldo = cursoBuscar.getRequisitos();
                                    correquisitosRespaldo = cursoBuscar.getCorrequisitos();

                                    // Se resetean los cursos requisitos o requisitos, pero se respaldan por si algo
                                    // sale mal y no se actualiza

                                    cursoBuscar.resetearCorrequisitos();
                                    cursoBuscar.resetearRequisitos();

                                    System.out.print("Nuevo Codigo: ");
                                    String codigo = in.nextLine();
                                    System.out.print("Nuevo Nombre: ");
                                    String nombre = in.nextLine();
                                    System.out.print("Nuevo Creditos: ");
                                    String creditos = in.nextLine();
                                    System.out.print("Nueva Cantidad Horas Lectivas: ");
                                    String cantidadHorasLectivas = in.nextLine();

                                    Curso cp = f.buscarCursoPorCodigo(codigo, listaCursos);
                                    f.agregarCorrequisitoyRequisito(cp, listaCursos);
                                    coordinadorLogeado.actualizarCurso(cursoBuscar, codigo, nombre,
                                            (byte) Integer.parseInt(creditos),
                                            (byte) Integer.parseInt(cantidadHorasLectivas));

                                    f.limpiarConsola();
                                    System.out.println("¡Curso Actualizado Correctamente!");
                                    System.out.print("Presione enter para mostrar los cursos.....");
                                    in.nextLine();
                                    f.limpiarConsola();
                                    for (Curso c : listaCursos) {
                                        System.out.println(c.toString());
                                    }
                                    System.out.print("Presione enter para continuar.....");
                                    in.nextLine();
                                } catch (Exception e) {
                                    System.out.println(
                                            "Lo sentimos, ha ocurrido un error al intentar actualizar el curso");
                                    cursoBuscar.setCorrequisitos(correquisitosRespaldo);
                                    cursoBuscar.setRequisitos(requisitosRespaldo);
                                }
                            } else {
                                System.out.println("No Se Ha Encontrado El Curso Que Desea Modificar");
                            }

                        } else if (opcion.equals("6")) {

                            f.limpiarConsola();
                            System.out.println("=== Registrando Grupo..... ===");
                            System.out.print("Profesor: ");
                            String profesor = in.nextLine();
                            // VALIDAR SI EL PROFE EXISTE

                            System.out.print("Codigo del Curso: ");
                            String codigoCurso = in.nextLine();
                            System.out.print("Numero del Grupo: ");
                            String numGrupo = in.nextLine();
                            System.out.print("Fecha Inicio (dd-mm-aa): ");
                            String fechaInicio = in.nextLine();
                            System.out.print("Fecha Final (dd-mm-aa): ");
                            String fechaFinal = in.nextLine();

                            System.out.println("Modalidades: ");
                            System.out.println("[1] Presencial");
                            System.out.println("[2] Virtual-Sincronico");
                            System.out.println("[3] Virtual-Asincronico");
                            System.out.println("Elija una modalidad: ");
                            String modalidad = in.nextLine();
                            Curso cursoGrupo = f.buscarCursoPorCodigo(codigoCurso, listaCursos);

                            if (modalidad.equals("1")) {

                                if (cursoGrupo != null) {
                                    System.out.print("Horario: ");
                                    String horario = in.nextLine();
                                    System.out.print("Aula: ");
                                    String aula = in.nextLine();
                                    coordinadorLogeado.registrarGrupoPresencial(horario,
                                            f.buscarProfesorPorNombre(profesor, listaProfesores),
                                            (byte) Integer.parseInt(numGrupo),
                                            new Date(f.obtenerFecha(fechaInicio, "anio"),
                                                    f.obtenerFecha(fechaInicio, "mes"),
                                                    f.obtenerFecha(fechaInicio, "dia")),
                                            new Date(f.obtenerFecha(fechaFinal, "anio"),
                                                    f.obtenerFecha(fechaFinal, "mes"),
                                                    f.obtenerFecha(fechaFinal, "dia")),
                                            cursoGrupo, Integer.parseInt(aula));

                                    f.limpiarConsola();
                                    System.out.println("=== Lista de Grupos  ===");

                                    for (Grupo g : listaGrupos) {
                                        System.out.println(g.toString());
                                    }

                                    System.out.print("Presione enter para continuar.....");
                                    in.nextLine();
                                } else {
                                    f.limpiarConsola();
                                    System.out.println("Este curso no existe");
                                    System.out.print("Presione enter para continuar.....");
                                    in.nextLine();
                                }

                            } else if (modalidad.equals("2")) {

                                if (cursoGrupo != null) {
                                    System.out.print("Plataforma: ");
                                    String plataforma = in.nextLine();
                                    coordinadorLogeado.registrarGrupoVA(
                                            f.buscarProfesorPorNombre(profesor, listaProfesores),
                                            (byte) Integer.parseInt(numGrupo),
                                            new Date(f.obtenerFecha(fechaInicio, "anio"),
                                                    f.obtenerFecha(fechaInicio, "mes"),
                                                    f.obtenerFecha(fechaInicio, "dia")),
                                            new Date(f.obtenerFecha(fechaFinal, "anio"),
                                                    f.obtenerFecha(fechaFinal, "mes"),
                                                    f.obtenerFecha(fechaFinal, "dia")),
                                            cursoGrupo, plataforma);

                                    f.limpiarConsola();
                                    System.out.println("=== Lista de Grupos ===");

                                    for (Grupo g : listaGrupos) {
                                        System.out.println(g.toString());
                                    }

                                    System.out.print("Presione enter para continuar.....");
                                    in.nextLine();
                                } else {
                                    f.limpiarConsola();
                                    System.out.println("Este curso no existe");
                                    System.out.print("Presione enter para continuar.....");
                                    in.nextLine();
                                }

                            } else if (modalidad.equals("3")) {
                                if (cursoGrupo != null) {
                                    System.out.print("Horario: ");
                                    String horario = in.nextLine();
                                    System.out.print("Plataforma: ");
                                    String plataforma = in.nextLine();
                                    coordinadorLogeado.registrarGrupoVS(horario,
                                            f.buscarProfesorPorNombre(profesor, listaProfesores),
                                            (byte) Integer.parseInt(numGrupo),
                                            new Date(f.obtenerFecha(fechaInicio, "anio"),
                                                    f.obtenerFecha(fechaInicio, "mes"),
                                                    f.obtenerFecha(fechaInicio, "dia")),
                                            new Date(f.obtenerFecha(fechaFinal, "anio"),
                                                    f.obtenerFecha(fechaFinal, "mes"),
                                                    f.obtenerFecha(fechaFinal, "dia")),
                                            cursoGrupo, plataforma);

                                    f.limpiarConsola();
                                    System.out.println("=== Lista de Grupos ===");

                                    for (Grupo g : listaGrupos) {
                                        System.out.println(g.toString());
                                    }
                                    System.out.print("Presione enter para continuar.....");
                                    in.nextLine();
                                } else {
                                    f.limpiarConsola();
                                    System.out.println("Este curso no existe");
                                    System.out.print("Presione enter para continuar.....");
                                    in.nextLine();
                                }
                            }

                        } else if (opcion.equals("7")) {
                            f.limpiarConsola();
                            System.out.println("=== Actualizando Grupo..... ===");

                            // Pedir para obtener el codigo del curso y num del grupo
                            System.out.print("Codigo del Curso Asociado: ");
                            String codigoCurso1 = in.nextLine();

                            System.out.print("Numero del Grupo a Modificar: ");
                            String numGrupo1 = in.nextLine();

                            // Validar que el grupo exista
                            if (f.existeGrupo(codigoCurso1, (byte) Integer.parseInt(numGrupo1), listaGrupos)) {
                                System.out.print("Nuevo Profesor: ");
                                String profesor = in.nextLine();

                                // VALIDAR SI EL PROFE EXISTE

                                System.out.print("Nuevo Codigo del Curso: ");
                                String codigoCurso2 = in.nextLine();
                                System.out.print("Nuevo Numero del Grupo: ");
                                String numGrupo2 = in.nextLine();
                                System.out.print("Nueva Fecha Inicio (dd-mm-aa): ");
                                String fechaInicio = in.nextLine();
                                System.out.print("Nueva Fecha Final (dd-mm-aa): ");
                                String fechaFinal = in.nextLine();

                                System.out.println("Modalidades: ");
                                System.out.println("[1] Presencial");
                                System.out.println("[2] Virtual-Sincronico");
                                System.out.println("[3] Virtual-Asincronico");
                                System.out.println("Elija una nueva modalidad: ");
                                String modalidad = in.nextLine();

                                Curso cursoGrupo = f.buscarCursoPorCodigo(codigoCurso2, listaCursos);
                                Grupo grupo = f.buscarGrupoPorNumeroCurso(codigoCurso1,
                                        (byte) Integer.parseInt(numGrupo1), listaGrupos);

                                if (modalidad.equals("1")) {

                                    if (cursoGrupo != null) {
                                        System.out.print("Horario: ");
                                        String horario = in.nextLine();
                                        System.out.print("Aula: ");
                                        String aula = in.nextLine();
                                        coordinadorLogeado.actualizarGrupoPresencial(grupo, horario,
                                                f.buscarProfesorPorNombre(profesor, listaProfesores),
                                                (byte) Integer.parseInt(numGrupo2),
                                                new Date(f.obtenerFecha(fechaInicio, "anio"),
                                                        f.obtenerFecha(fechaInicio, "mes"),
                                                        f.obtenerFecha(fechaInicio, "dia")),
                                                new Date(f.obtenerFecha(fechaFinal, "anio"),
                                                        f.obtenerFecha(fechaFinal, "mes"),
                                                        f.obtenerFecha(fechaFinal, "dia")),
                                                cursoGrupo, Integer.parseInt(aula));

                                        f.limpiarConsola();
                                        System.out.println("=== Lista de Grupos  ===");

                                        for (Grupo g : listaGrupos) {
                                            System.out.println(g.toString());
                                        }

                                        System.out.print("Presione enter para continuar.....");
                                        in.nextLine();
                                    } else {
                                        f.limpiarConsola();
                                        System.out.println("Este curso no existe");
                                        System.out.print("Presione enter para continuar.....");
                                        in.nextLine();
                                    }

                                } else if (modalidad.equals("2")) {

                                    if (cursoGrupo != null) {
                                        System.out.print("Plataforma: ");
                                        String plataforma = in.nextLine();
                                        coordinadorLogeado.actualizarGrupoVA(grupo,
                                                f.buscarProfesorPorNombre(profesor, listaProfesores),
                                                (byte) Integer.parseInt(numGrupo2),
                                                new Date(f.obtenerFecha(fechaInicio, "anio"),
                                                        f.obtenerFecha(fechaInicio, "mes"),
                                                        f.obtenerFecha(fechaInicio, "dia")),
                                                new Date(f.obtenerFecha(fechaFinal, "anio"),
                                                        f.obtenerFecha(fechaFinal, "mes"),
                                                        f.obtenerFecha(fechaFinal, "dia")),
                                                cursoGrupo, plataforma);

                                        f.limpiarConsola();
                                        System.out.println("=== Lista de Grupos ===");

                                        for (Grupo g : listaGrupos) {
                                            System.out.println(g.toString());
                                        }

                                        System.out.print("Presione enter para continuar.....");
                                        in.nextLine();
                                    } else {
                                        f.limpiarConsola();
                                        System.out.println("Este curso no existe");
                                        System.out.print("Presione enter para continuar.....");
                                        in.nextLine();
                                    }

                                } else if (modalidad.equals("3")) {
                                    if (cursoGrupo != null) {
                                        System.out.print("Horario: ");
                                        String horario = in.nextLine();
                                        System.out.print("Plataforma: ");
                                        String plataforma = in.nextLine();
                                        coordinadorLogeado.actualizarGrupoVS(grupo, horario,
                                                f.buscarProfesorPorNombre(profesor, listaProfesores),
                                                (byte) Integer.parseInt(numGrupo2),
                                                new Date(f.obtenerFecha(fechaInicio, "anio"),
                                                        f.obtenerFecha(fechaInicio, "mes"),
                                                        f.obtenerFecha(fechaInicio, "dia")),
                                                new Date(f.obtenerFecha(fechaFinal, "anio"),
                                                        f.obtenerFecha(fechaFinal, "mes"),
                                                        f.obtenerFecha(fechaFinal, "dia")),
                                                cursoGrupo, plataforma);

                                        f.limpiarConsola();
                                        System.out.println("=== Lista de Grupos ===");

                                        for (Grupo g : listaGrupos) {
                                            System.out.println(g.toString());
                                        }
                                        System.out.print("Presione enter para continuar.....");
                                        in.nextLine();
                                    } else {
                                        f.limpiarConsola();
                                        System.out.println("Este curso no existe");
                                        System.out.print("Presione enter para continuar.....");
                                        in.nextLine();
                                    }
                                }
                            } else {
                                f.limpiarConsola();
                                System.out.println("Este grupo no existe.");
                                System.out.println("Presione enter para continuar...");
                                in.nextLine();
                            }

                        } else if (opcion.equals("8")) {
                            f.limpiarConsola();
                            System.out.println("=== Realizando Matricula..... ===");
                            System.out.print("Carnet del Estudiante: ");
                            String carnet = in.nextLine();
                            System.out.print("Codigo del Curso: ");
                            String cod = in.nextLine();
                            System.out.print("Numero de Grupo: ");
                            String numGrupo = in.nextLine();
                            Grupo g = f.buscarGrupoPorNumeroCurso(cod, Byte.parseByte(numGrupo), listaGrupos);
                            Estudiante e = f.buscarEstudiantePorCarnet(Integer.parseInt(carnet), listaEstudiantes);
                            if (g != null && e != null && !(g.validarEstudiante(Integer.parseInt(carnet)))) {
                                coordinadorLogeado.asociarMatriculaEstudiante(e, g);
                                System.out.println("Estudiante Matriculado Correctamente");
                                System.out.println("Presione enter para continuar...");
                                in.nextLine();

                            } else {
                                System.out.println("No se ha podido Matricular al Estudiante");
                                System.out.println("Presione enter para continuar...");
                                in.nextLine();
                            }

                        } else if (opcion.equals("9")) {
                            f.limpiarConsola();
                            System.out.println("=== Realizando Tramite Estudiantil..... ===");

                            System.out.println("¿Que tramite desea realizar?: ");
                            System.out.println("|    [1]. Levantamiento de Requisitos    |");
                            System.out.println("|    [2]. Levantamiento RN               |");
                            System.out.println("|    [3]. Solicitud de Beca              |");
                            String opcionTramite = in.nextLine();

                            System.out.println("Carnet del Estudiante: ");
                            String carnet = in.nextLine();
                            System.out.println("Fecha Registro (dd/mm/yyyy): ");
                            String fecha = in.nextLine();
                            System.out.println("Detalle descriptivo: ");
                            String descripcion = in.nextLine();

                            Estudiante e = f.buscarEstudiantePorCarnet(Integer.parseInt(carnet), listaEstudiantes);

                            Date fechaRegistro = new Date(f.obtenerFecha(fecha, "anio"), f.obtenerFecha(fecha, "mes"),
                                    f.obtenerFecha(fecha, "dia"));

                            if (opcionTramite.equals("1")) {
                                System.out.println("Codigo del Curso a Levantar: ");
                                String cod = in.nextLine();
                                Curso cursoALevantar = null;
                                boolean encontrado = false;

                                for (Curso curso : listaCursos) {
                                    if (curso.getCodigo().equals(cod)) {
                                        cursoALevantar = curso;
                                        encontrado = true;
                                    }
                                }
                                if (!encontrado) {
                                    System.out
                                            .println("Lo sentimos el curso asociado al codigo " + cod + " no existe.");
                                } else {
                                    System.out.println("Justificacion: ");
                                    String justificacion = in.nextLine();

                                    while (true) {
                                        System.out.println("Estado del Levantamiento de Requisitos: ");
                                        System.out.println("|    [1]. Aprobado    |");
                                        System.out.println("|    [2]. Reprobado   |");
                                        String estado = in.nextLine();

                                        if (estado.equals("1")) {
                                            LevantamientoRequisitos nuevoTramite = new LevantamientoRequisitos(e,
                                                    fechaRegistro, descripcion, cursoALevantar, justificacion, true);
                                            listaTramites.add(nuevoTramite);
                                            f.limpiarConsola();
                                            System.out
                                                    .println("El tramite se agrego exitosamente\nDatos del tramite: \n"
                                                            + nuevoTramite.toString()
                                                            + "\nPresione una tecla para salir");
                                            in.nextLine();
                                            break;
                                        } else if (estado.equals("2")) {
                                            LevantamientoRequisitos nuevoTramite = new LevantamientoRequisitos(e,
                                                    fechaRegistro, descripcion, cursoALevantar, justificacion, false);
                                            listaTramites.add(nuevoTramite);
                                            System.out.println("Justificacion del Estado Reprobado: ");
                                            String justificacionRechazo = in.nextLine();
                                            nuevoTramite.setJustificacionRechazo(justificacionRechazo);
                                            f.limpiarConsola();
                                            System.out
                                                    .println("El tramite se agrego exitosamente\nDatos del tramite: \n"
                                                            + nuevoTramite.toString()
                                                            + "\nPresione una tecla para salir");
                                            in.nextLine();
                                            break;
                                        }
                                        System.out.println("Opcion no valida. Intentalo de nuevo");
                                    }
                                }

                            } else if (opcionTramite.equals("2")) {
                                // AQUI VA EL SEGUNDO TRAMITE

                                System.out.println("Codigo del Curso Asociado al estado RN: ");
                                String cod = in.nextLine();

                                ArrayList<Curso> cursosAMatricular = new ArrayList<Curso>();
                                Curso c = null;
                                while (true) {
                                    System.out.println("Codigo del Curso A Matricular: ");
                                    String codigo = in.nextLine();
                                    boolean encontrado = false;
                                    for (Curso curso : listaCursos) {
                                        if (curso.getCodigo().equals(codigo)) {
                                            c = curso;
                                            cursosAMatricular.add(c);
                                            encontrado = true;
                                        }
                                    }
                                    if (encontrado) {
                                        System.out.println("El curso " + c.getNombre() + " fue agregado exitosamente");
                                    } else {
                                        System.out.println(
                                                "El curso asociado al codigo " + codigo + " no ha sido encontrado.");
                                    }

                                    System.out.println("Desea agregar otro curso: ");
                                    System.out.println("|    [1]. Si    |");
                                    System.out.println("|    [2]. No    |");
                                    if (in.nextLine().equals("2")) {
                                        break;
                                    }
                                }
                                String estado = "";
                                while (true) {
                                    System.out.println("Estado del Levantamiento de Requisitos: ");
                                    System.out.println("|    [1]. Aprobado    |");
                                    System.out.println("|    [2]. Reprobado   |");
                                    estado = in.nextLine();
                                    if (estado.equals("1") || (estado.equals("2"))) {
                                        break;
                                    }
                                }

                                if (estado.equals("1")) {
                                    LevantamientoRN nuevoTramite = new LevantamientoRN(e, fechaRegistro, descripcion, c,
                                            cursosAMatricular, true);
                                    listaTramites.add(nuevoTramite);
                                    f.limpiarConsola();
                                    System.out.println("El tramite se agrego exitosamente\nDatos del tramite: \n"
                                            + nuevoTramite.toString() + "\nPresione una tecla para salir");
                                    in.nextLine();
                                } else if (estado.equals("2")) {
                                    LevantamientoRN nuevoTramite = new LevantamientoRN(e, fechaRegistro, descripcion, c,
                                            cursosAMatricular, false);
                                    listaTramites.add(nuevoTramite);
                                    f.limpiarConsola();
                                    System.out.println("El tramite se agrego exitosamente\nDatos del tramite: \n"
                                            + nuevoTramite.toString() + "\nPresione una tecla para salir");
                                    in.nextLine();
                                }

                            } else if (opcionTramite.equals("3")) {
                                System.out.println("Ingrese el periodo de Beca: ");
                                String periodoBeca = in.nextLine();
                                System.out.println("Ingrese el tipo de Beca: ");
                                String tipoBeca = in.nextLine();
                                System.out.println("Fecha Inicio (dd/mm/yyyy): ");
                                String fecha1 = in.nextLine();
                                System.out.println("Fecha Inicio (dd/mm/yyyy): ");
                                String fecha2 = in.nextLine();

                                Date fechaInicio = new Date(f.obtenerFecha(fecha1, "anio"),
                                        f.obtenerFecha(fecha1, "mes"),
                                        f.obtenerFecha(fecha1, "dia"));
                                Date fechaFin = new Date(f.obtenerFecha(fecha2, "anio"), f.obtenerFecha(fecha2, "mes"),
                                        f.obtenerFecha(fecha2, "dia"));

                                SolicitudBeca nuevoTramite = new SolicitudBeca(e, fechaRegistro, descripcion,
                                        periodoBeca, tipoBeca, fechaInicio, fechaFin);
                                listaTramites.add(nuevoTramite);
                                f.limpiarConsola();
                                System.out.println("El tramite se agrego exitosamente\nDatos del tramite: \n"
                                        + nuevoTramite.toString() + "\nPresione una tecla para salir");
                                in.nextLine();
                            }

                            /*
                             * if (g != null && e != null &&
                             * !(g.validarEstudiante(Integer.parseInt(carnet)))){
                             * coordinadorLogeado.asociarMatriculaEstudiante(e,g);
                             * System.out.println("Estudiante Matriculado Correctamente");
                             * System.out.println("Presione enter para continuar...");
                             * in.nextLine();
                             * 
                             * }else{
                             * System.out.println("No se ha podido Matricular al Estudiante");
                             * System.out.println("Presione enter para continuar...");
                             * in.nextLine();
                             * }
                             */
                        } else if (opcion.equals("10")){
                            f.limpiarConsola();
                            f.menuCoordinadorReportes();
                            String opcionReporte = in.nextLine();
                            if (opcionReporte.equals("1")) {
                                System.out.println("Reporte 1\nPresiona cualquir tecla para volver al menu principal");
                                in.nextLine();
                            }
                            else if (opcionReporte.equals("2")) {
                                System.out.println("Reporte 2\nPresiona cualquir tecla para volver al menu principal");
                                in.nextLine();
                            }
                            else if (opcionReporte.equals("3")) {
                                System.out.println("Reporte 3\nPresiona cualquir tecla para volver al menu principal");
                                in.nextLine();
                            }
                            else if (opcionReporte.equals("s")) {
                                System.out.println("Volviendo al menu principal...");
                            }
                            else
                            {
                                System.out.println("Opcion no valida. Presiona cualquier tecla para volver al menu principal");
                            }
                            
                            
                        }else if (opcion.equals("s")) {
                            break;
                        }

                    }
                }
            } else if (opcionLogin.equals("2")) {

                System.out.print("Usuario: ");
                String usuario = in.nextLine();

                System.out.print("Contraseña: ");
                String contrasena = in.nextLine();

                if ((f.validarProfesor(usuario, contrasena, listaProfesores)) && (permisosUsuarios == false)) {

                    while (true) {
                        f.menuProfesor();
                        System.out.print("Elija una opcion: ");
                        String opcion = in.nextLine();

                        if (opcion.equals("1")) {
                            f.limpiarConsola();
                            System.out.println("=== Registrando Nota de Estudiante..... ===");
                            System.out.println("Codigo del Curso: ");
                            String cod = in.nextLine();
                            System.out.println("Numero de Grupo: ");
                            String numGrupo = in.nextLine();
                            Grupo g = f.buscarGrupoPorNumeroCurso(cod, Byte.parseByte(numGrupo), listaGrupos);

                            if (g.validarProfesor(profesorLogeado.getNombre())) {
                                System.out.print("Carnet del Estudiante: ");
                                String carnet = in.nextLine();
                                Estudiante e = f.buscarEstudiantePorCarnet(Integer.parseInt(carnet), listaEstudiantes);
                                System.out.print("Nota: ");
                                String nota = in.nextLine();

                                if (g.validarEstudiante(Integer.parseInt(carnet))) {
                                    profesorLogeado.registrarCalificacion(e, g, Float.parseFloat(nota));
                                    System.out.println("Calificacion Agregada Correctamente");
                                    e.imprimirCalifaciones();
                                    System.out.println("Presione enter para continuar...");
                                    in.nextLine();
                                } else {
                                    System.out.println("El estudiante no esta matriculado en este curso");
                                }

                            } else {
                                System.out.println("No tienes los permisos suficientes para asignar la nota");
                                System.out.println("Presione enter para continuar...");
                                in.nextLine();
                            }

                        } else if (opcion.equals("2")) {
                            System.out.println("=== Registrando Acompanamiento en Curso..... ===");
                            System.out.println("Fecha (dd/mm/yyyy): ");
                            String fecha = in.nextLine();
                            System.out.println("Tipo : ");
                            String tipo = in.nextLine();
                            System.out.println("Nota Descriptiva : ");
                            String notaDescriptiva = in.nextLine();
                            System.out.println("Carnet del Estudiante : ");
                            String carnet = in.nextLine();

                            Date fechaOb = new Date(f.obtenerFecha(fecha, "anio"), f.obtenerFecha(fecha, "mes"),
                                    f.obtenerFecha(fecha, "dia"));

                            Estudiante e = f.buscarEstudiantePorCarnet(Integer.parseInt(carnet), listaEstudiantes);

                            if (e != null) {
                                profesorLogeado.setAcompanamiento(e, fechaOb, tipo, notaDescriptiva);

                                System.out.println("======== Registro Completado ========");
                                System.out.println("Presione enter para continuar...");
                                in.nextLine();

                            }

                        } else if (opcion.equals("3")) {

                            System.out.println("=== Registrando Tutoria..... ===");
                            System.out.println("Codigo del curso: ");
                            String cod = in.nextLine();
                            System.out.println("Numero del grupo: ");
                            String grupo = in.nextLine();
                            System.out.println("Carnet Estudiante Tutor: ");
                            String carnet = in.nextLine();
                            System.out.println("ID de la tutoria: ");
                            String id = in.nextLine();
                            
                            Grupo g = f.buscarGrupoPorNumeroCurso(cod, Byte.parseByte(grupo) ,listaGrupos);
                            Estudiante e = f.buscarEstudiantePorCarnet(Integer.parseInt(carnet), listaEstudiantes);

                            if( e != null && g != null && g.validarProfesor(profesorLogeado.getNombre()) ){
                                profesorLogeado.setTutoria(Integer.parseInt(id),e, g);
                                Tutorias t = profesorLogeado.buscarTutoria(Integer.parseInt(id));
                                while(true){
                                    System.out.println("Desea agregar una sesion(s/n): ");
                                    String op = in.nextLine();
                                    if(op.equals("s")){
                                        
                                        System.out.println("Fecha Tutoria: ");
                                        String fecha = in.nextLine();
                                        System.out.println("Numero de asistentes: ");
                                        String asis = in.nextLine();
                                        t.setListaSesiones("Fecha: "+fecha+" | Numero de Asistentes: "+asis);
                                    }else{
                                        f.limpiarConsola();
                                        System.out.println(" === Lista de Sesiones ===");
                                        t.imprimirListaTutorias();
                                        System.out.println("Presione enter para continuar...");
                                        in.nextLine();
                                        break;
                                    }
                                }

                            }else{
                                System.out.println("No se ha encontrado al estudiante o al grupo");
                            }

                        } else if (opcion.equals("4")) {
                            
                        }
                        else if(opcion.equals("5"))
                        {
                            f.limpiarConsola();
                            f.menuProfesorReportes();
                            String opcionReporte = in.nextLine();
                            if (opcionReporte.equals("1")) {
                                System.out.println("Reporte 1\nPresiona cualquir tecla para volver al menu principal");
                                in.nextLine();
                            }
                            else if (opcionReporte.equals("2")) {
                                System.out.println("Reporte 2\nPresiona cualquir tecla para volver al menu principal");
                                in.nextLine();
                            }
                            else if (opcionReporte.equals("s")) {
                                System.out.println("Volviendo al menu principal...");
                            }
                            else
                            {
                                System.out.println("Opcion no valida. Presiona cualquier tecla para volver al menu principal");
                            }
                        }
                    }
                }
            } else {
                System.out.println("Dato incorrecto");
            }
        }
    }
}