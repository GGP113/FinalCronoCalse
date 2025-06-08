import java.util.Scanner;

public class cronoClase {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*
         * se define un array con el número de materias, para las cuales un profesor
         * puede
         * ingresar actividades
         */

        String[] materias = { "Materia_1", "Materia_2", "Materia_3" };

        /*
         * fechasTareas contiene en formato string las fechas asignadas para las
         * actividades
         * es una lista de lista en donde el numero de columnas es igual al numero de
         * tareas asignadas y el
         * filas es igual al numero de materias
         */

        String[][] fechasTareas = new String[materias.length][5];
        String[][] fechasTareasE = new String[materias.length][5];

        /*
         * tareas es una matriz con las mismas dimensiones de fechasTareas. aca se
         * guardan los nombres
         * de las actividades asignadas por el docente. todas las variables de tareas
         * se declaran aqui porque deben estar disponibles para ser consultadas por el
         * estudiante luego de que sean asignadas por el profesor
         */

        String[][] tareas = new String[materias.length][5];

        /*
         * tareasDias y tareasMes son matrices, con las mismas dimensiones de la matriz
         * tareas
         * estas contienen las fechas en tipo int para que así se puedan comparar con
         * las fechas de entrega del estudiante
         */

        int[][] tareasDias = new int[materias.length][5];
        int[][] tareasMes = new int[materias.length][5];

        int[][] tareasDiasE = new int[materias.length][5];
        int[][] tareasMesE = new int[materias.length][5];

        int[][] difPlazoDia = new int[materias.length][5];
        int[][] difPlazoMes = new int[materias.length][5];

        String[][] plazoCheck = new String[materias.length][5];

        /*
         * El contadorTareas almacena el número de tareas, menos uno, ingresadas por
         * materias
         */

        int[] contadorTareas = { 0, 0, 0 };

        while (true) {
            System.out.println("\n=== CRONOCLASES | MENU PRINCIPAL ===");
            System.out.println("1. Modo Profesor");
            System.out.println("2. Modo Estudiante");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 3) {
                System.out.println("¡Gracias por usar el programa!");
                sc.close();
                break;
            }
            if (opcion == 1) {
                /* MODO PROFESOR */
                int intentos = 0;
                while (intentos < 3) {
                    System.out.println("\nLogin de Profesor");
                    System.out.print("Usuario: ");
                    String usuario = sc.nextLine();
                    System.out.print("Contraseña: ");
                    String password = sc.nextLine();
                    if (usuario.equals("profesor") && password.equals("profesor")) {
                        System.out.println("¡Bienvenido Profesor al Sistema de Gestión de Actividades!");
                        break;
                    } else {
                        intentos++;
                        System.out.println("Usuario o contraseña incorrectos. Intento " + intentos + " de 3");
                    }
                }

                if (intentos == 3) {
                    System.out.println("Número máximo de intentos alcanzado. Volviendo al menú principal.");
                    continue;
                }

                while (true) {
                    System.out.println("\nIngrese la materia para la cual desea registrar actividades" + '\n');
                    System.out.println("Escriba el número entre 1 y " + materias.length
                            + " que corresponde con la materia deseada" + '\n');

                    for (int i = 0; i < materias.length; i++) {
                        System.out.println((i + 1) + ". " + materias[i]);
                    }

                    System.out.println('\n');
                    int materiaElegida = sc.nextInt();
                    int indexMatEle = materiaElegida - 1;
                    sc.nextLine();

                    System.out.println(
                            '\n' + "¿Cuantas actividades desea ingresar para la " + materias[indexMatEle] + "?" + '\n');
                    int numTareas = sc.nextInt();
                    sc.nextLine();

                    for (int i = contadorTareas[indexMatEle]; i < numTareas + contadorTareas[indexMatEle]; i++) {
                        /*
                         * Lo que hace este ciclo es que agrega a las matrices descritas en el inicio
                         * el nombre de las actividades y las fechas se usa el contador de tareas para
                         * así ubicar las tareas en la columna correcta. así si se quiere agregar tareas
                         * más
                         * de una vez en una misma materia es posible. de igual forma se elige para cual
                         * materia se ingresan actividades. se pueden ingresar hasta 5 actividades, pero
                         * es
                         * un numero que puede ser cambiado en la definicion de la matriz
                         */

                        System.out.println("Ingrese el nombre de la tarea " + (i + 1) + '\n');
                        tareas[indexMatEle][i] = sc.nextLine();

                        System.out.println("Ingrese la fecha de entrega de la tarea " + (i + 1) + '\n' + '\n'
                                + " Escriba el día como número entero" + '\n');
                        tareasDias[indexMatEle][i] = sc.nextInt();
                        sc.nextLine();

                        System.out.println('\n' + " Escriba el mes como número entero" + '\n');
                        tareasMes[indexMatEle][i] = sc.nextInt();
                        sc.nextLine();

                        fechasTareas[indexMatEle][i] = tareasDias[indexMatEle][i] + "/" + tareasMes[indexMatEle][i]
                                + "/2025";
                    }

                    contadorTareas[indexMatEle] += numTareas;

                    System.out.println("Ha finalizado de asignar las tareas para la materia: "
                            + materias[materiaElegida - 1] + '\n');
                    System.out.println("¿Desea ingresar tareas para una materia diferente?\n");
                    System.out.println("Escriba 0 ó 1 de acuerdo con su respuesta:\n0.No\n1.Si\n");

                    int registrarAgain = sc.nextInt();
                    sc.nextLine();

                    if (registrarAgain == 0) {
                        for (int i = 0; i < materias.length; i++) {
                            System.out.println("Las actividades ingresadas para la " + materias[i] + " son" + '\n');
                            for (int j = 0; j < contadorTareas[i]; j++) {
                                System.out.println(tareas[i][j] + ": " + fechasTareas[i][j]);
                            }
                            System.out.println('\n');
                        }
                        break;
                    }
                }
            }            if (opcion == 2) {
                /* MODO ESTUDIANTE */
                int intentos = 0;
                while (intentos < 3) {
                    System.out.println("\nLogin de Estudiante");
                    System.out.print("Usuario: ");
                    String usuario = sc.nextLine();
                    System.out.print("Contraseña: ");
                    String password = sc.nextLine();
                    if (usuario.equals("estudiante") && password.equals("estudiante")) {
                        System.out.println("¡Bienvenido Estudiante al Sistema de Gestión de Actividades!");
                        break;
                    } else {
                        intentos++;
                        System.out.println("Usuario o contraseña incorrectos. Intento " + intentos + " de 3");
                    }
                }

                if (intentos == 3) {
                    System.out.println("Número máximo de intentos alcanzado. Volviendo al menú principal.");
                    continue;
                }

                if (contadorTareas[0] == 0 && contadorTareas[1] == 0 && contadorTareas[2] == 0) {
                    System.out.println("\nNo hay tareas registradas. El profesor debe registrar tareas primero.\n");
                    continue;
                }

                System.out.println('\n' + '\n' + "MODO ESTUDIANTE");
                System.out.println("Las tareas asignadas por el docente son: ");

                for (int i = 0; i < materias.length; i++) {
                    System.out.println("Actividades " + materias[i] + ": " + '\n');
                    /*
                     * se imprimen las tareas ingresadas anteriormente, se usa el contador tareas
                     * para así imprimir unicamente las actividades asignadas por materias.
                     * Así si no se asignó ninguna actividad, entonces se mostrará vacío
                     */
                    for (int j = 0; j < contadorTareas[i]; j++) {
                        System.out.println(tareas[i][j] + ": " + fechasTareas[i][j]);
                    }
                    System.out.println('\n');
                }

                while (true) {
                    System.out.println("Ingrese la materia para la cual desea entregar actividades" + '\n');
                    System.out.println("Escriba el número entre 1 y " + materias.length
                            + " que corresponde con la materia deseada" + '\n');

                    for (int i = 0; i < materias.length; i++) {
                        System.out.println((i + 1) + ". " + materias[i]);
                    }

                    System.out.println('\n');
                    int materiaElegida = sc.nextInt();
                    int indexMatEle = materiaElegida - 1;
                    sc.nextLine();

                    System.out.println("Las actividades correspondientes a la materia seleccionada son: " + '\n');

                    for (int i = 0; i < contadorTareas[indexMatEle]; i++) {
                        System.out.println(
                                (i + 1) + ". " + tareas[indexMatEle][i] + ": " + fechasTareas[indexMatEle][i] + '\n');
                    }

                    System.out.println(
                            "¿Cual tarea desea entregar? Escriba el número entre 1 y " + contadorTareas[indexMatEle]
                                    + '\n');
                    int tareaEntrega = sc.nextInt();
                    int indexTE = tareaEntrega - 1;

                    System.out.println(
                            "Ingrese la fecha de entrega" + '\n' + " Escriba el día como número entero" + '\n');
                    tareasDiasE[indexMatEle][indexTE] = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Escriba el mes como número entero" + '\n');
                    tareasMesE[indexMatEle][indexTE] = sc.nextInt();
                    sc.nextLine();

                    fechasTareasE[indexMatEle][indexTE] = tareasDiasE[indexMatEle][indexTE] + "/"
                            + tareasMesE[indexMatEle][indexTE] + "/2025";

                    difPlazoDia[indexMatEle][indexTE] = tareasDias[indexMatEle][indexTE]
                            - tareasDiasE[indexMatEle][indexTE];
                    difPlazoMes[indexMatEle][indexTE] = tareasMes[indexMatEle][indexTE]
                            - tareasMesE[indexMatEle][indexTE];

                    if (difPlazoDia[indexMatEle][indexTE] >= 0 && difPlazoMes[indexMatEle][indexTE] >= 0) {
                        plazoCheck[indexMatEle][indexTE] = "  A tiempo";
                    } else {
                        plazoCheck[indexMatEle][indexTE] = "  Entrega tarde";
                    }

                    System.out.println("Desea entregar otra tarea");
                    System.out.println(
                            "Escriba 0 ó 1 de acuerdo con su respuesta:" + '\n' + "0.No" + '\n' + "1.Si" + '\n');

                    int registrarAgain = sc.nextInt();
                    sc.nextLine();

                    if (registrarAgain == 0) {
                        for (int i = 0; i < materias.length; i++) {
                            System.out.println("Fechas de entrega de actividades:  " + materias[i] + ": " + '\n');
                            for (int j = 0; j < contadorTareas[i]; j++) {
                                if (fechasTareasE[i][j] != null) {
                                    System.out.println(tareas[i][j] + ": " + fechasTareasE[i][j] + plazoCheck[i][j]);
                                } else {
                                    System.out.println(tareas[i][j] + ": Sin entrega");
                                }
                            }
                            System.out.println('\n');
                        }
                        break;
                    }
                }
            }
        }
    }
}
