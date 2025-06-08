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
         * estas contienen las fechas en tipo int para que así s epuedan comparar con
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

        /* MODO PROFESOR */

        while (true) {

            System.out.println("Ingrese la materia para la cual desea registrara actividades" + '\n');

            System.out.println("Escriba el número entre 1 y " + materias.length
                    + " que corresponde con la materia deaseada" + '\n');

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
                 * el nombre de las actividades y las fhechas se usa el contador de tareas para
                 * así
                 * ubicar las tareas en la columna correcta. así si se quiere agregar tareas más
                 * d euna vez en una misma materia es
                 * posible. de igual forma se elige para cual materia se ingresan actividades.
                 * se pueden ingresar hasta 5
                 * actividades, pero es un numero que puede ser cambiado en la definicion de la
                 * matriz
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

            }

            System.out.println(
                    "Ha finalizado de asignar las tareas para la materia: " + materias[materiaElegida - 1] + '\n');
            System.out.println("¿Desea ingresar tareas para una materia diferente? + '\n'");
            System.out.println(
                    "Escriba 0 ó 1 de acuerdo con su respuesta: " + '\n' + "0.No" + '\n' + "1.Si" + '\n');

            int registrarAgain = sc.nextInt();
            sc.nextLine();

            contadorTareas[indexMatEle] += numTareas;

            if (registrarAgain == 0) {

                break;

            }

        }

        for (int i = 0; i < tareasDias.length; i++) {
            for (int j = 0; j < tareasDias[i].length; j++) {

                fechasTareas[i][j] = tareasDias[i][j] + "/" + tareasMes[i][j] + "/2025";

            }
        }

        System.out.println("A continuación se presenta un resumen de las actividades ingresadas: " + '\n' + '\n');

        for (int i = 0; i < materias.length; i++) {

            System.out.println("Las actividades ingresadas para la " + materias[i] + " son" + '\n');

            /*
             * se imprimen las tareas ingresadas anteriormente, se usa el contador tareas
             * para así impriir unicamente las actividades
             * asignadas por materias. Así si no se asignó ninguna actividad, entonces se
             * mostrará vacío
             */
            for (int j = 0; j < contadorTareas[i]; j++) {

                System.out.println(tareas[i][j] + ": " + fechasTareas[i][j]);

            }

            System.out.println('\n');

        }

        /* MODO ESTUDIANTE */

        System.out.println('\n' + '\n' + "MODO ESTUDIANTE");

        System.out.println("Las tareas asignadas por el docente son: ");

        for (int i = 0; i < materias.length; i++) {

            System.out.println("Actividades " + materias[i] + ": " + '\n');

            /*
             * se imprimen las tareas ingresadas anteriormente, se usa el contador tareas
             * para así impriir unicamente las actividades
             * asignadas por materias. Así si no se asignó ninguna actividad, entonces se
             * mostrará vacío
             */
            for (int j = 0; j < contadorTareas[i]; j++) {

                System.out.println(tareas[i][j] + ": " + fechasTareas[i][j]);

            }

            System.out.println('\n');

        }

        while (true) {

            System.out.println("Ingrese la materia para la cual desea entregar actividades" + '\n');
            System.out.println("Escriba el número entre 1 y " + materias.length
                    + " que corresponde con la materia deaseada" + '\n');

            for (int i = 0; i < materias.length; i++) {

                System.out.println((i + 1) + ". " + materias[i]);

            }

            System.out.println('\n');

            int materiaElegida = sc.nextInt();
            int indexMatEle = materiaElegida - 1;
            sc.nextLine();

            System.out.println("Las actividades correspondientes a la materia seleccionada son: " + '\n');

            for (int i = 0; i < contadorTareas[indexMatEle]; i++) {

                System.out
                        .println((i + 1) + ". " + tareas[indexMatEle][i] + ": " + fechasTareas[indexMatEle][i] + '\n');
            }

            System.out.println(
                    "¿Cual tarea desea entregar? Escriba el número entre 1 y " + contadorTareas[indexMatEle] + '\n');
            int tareaEntrega = sc.nextInt();
            int indexTE = tareaEntrega - 1;

            System.out.println("Ingrese la fecha de entrega" + '\n' + " Escriba el día como número entero" + '\n');

            tareasDiasE[indexMatEle][indexTE] = sc.nextInt();
            sc.nextLine();

            System.out.println("Escriba el mes como número entero" + '\n');
            tareasMesE[indexMatEle][indexTE] = sc.nextInt();
            sc.nextLine();

            fechasTareasE[indexMatEle][indexTE] = tareasDiasE[indexMatEle][indexTE] + "/"
                    + tareasMesE[indexMatEle][indexTE] + "/2025";

            System.out.println("Desea entregar otra tarea");

            System.out.println(
                    "Escriba 0 ó 1 de acuerdo con su respuesta: " + '\n' + "0.No" + '\n' + "1.Si" + '\n');

            int registrarAgain = sc.nextInt();

            sc.nextLine();

            if (registrarAgain == 0) {

                break;

            }

        }

        for (int i = 0; i < materias.length; i++) {

            for (int j = 0; j < contadorTareas[i]; j++) {

                difPlazoDia[i][j] = tareasDias[i][j] - tareasDiasE[i][j];
                difPlazoMes[i][j] = tareasMes[i][j] - tareasMesE[i][j];

                if (difPlazoDia[i][j] >= 0 && difPlazoMes[i][j] >= 0) {

                    plazoCheck[i][j] = "  A tiempo";

                }

                else if(fechasTareasE[i][j]==null){

                    plazoCheck[i][j] = "  Sin entrega";


                }

                else {

                    plazoCheck[i][j] = "  Entrega tarde";

                }

            }

        }

        for (int i = 0; i < materias.length; i++) {

            System.out.println("Fechas de entrega de actividades:  " + materias[i] + ": " + '\n');

            for (int j = 0; j < contadorTareas[i]; j++) {

                System.out.println(tareas[i][j] + ": " + fechasTareasE[i][j] + plazoCheck[i][j]);

            }

            System.out.println('\n');

        }

    }

}
