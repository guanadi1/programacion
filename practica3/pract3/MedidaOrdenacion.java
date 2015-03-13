package src;

/** Clase MedidaOrdenacion: Estudio empirico de costes de los metodos de ordenacion.
 * @author PRG ETSInf
 * @version Year 2014-2015
 */
import java.util.*;

class MedidaOrdenacion {
    public static final double NMS = 1e3;
    public static final int REPETICIONES = 50;
    public static final int INITALLA=10000;
    public static final int MAXTALLA=100000;
    public static final int INCRTALLA=10000;

    // Constantes que definen los parametros de medida

    /*
     * Genera un array de int de talla t con valores comprendidos entre 0 y t.
     * 
     * @param int la talla
     * 
     * @result int[] el array generado
     */
    private static int[] crearArrayAleatorio(int t) {
        int[] a = new int[t];
        for (int i = 0; i < t; i++) {
            a[i] = (int) Math.floor(Math.random() * t);
        }
        return a;
    }

    /*
     * Genera un array de int de talla t ordenado de forma creciente.
     * 
     * @param int la talla
     * 
     * @result int[] el array generado
     */
    private static int[] crearArrayOrdCreciente(int t) {
        int[] a = new int[t];
        for (int i = 0; i < t; i++) {
            a[i] = i+1;
        }
        return a;
    }

    /*
     * Genera un array de int de talla t ordenado de forma decreciente.
     * 
     * @param int la talla
     * 
     * @result int[] el array generado
     */
    private static int[] crearArrayOrdDecreciente(int t) {
        int[] a = new int[t];
        for (int i = 0; t > 0; i++) {
            a[i] = t;
            t--;
        }
        return a;
    }

    public static void medidaSeleccion() {

        int talla = INITALLA;
        long ti=0,tf=0;
        double tt = 0;
        AlgoritmosMedibles am = new AlgoritmosMedibles();
        
        System.out.println("# Selección directa. Tiempos en microsegundos");
        System.out.printf("#  Talla   Promedio\n");
        System.out.printf("#-----------------\n");
        
        while(talla<=MAXTALLA){
            
        int[] a = new int[talla];
         a = crearArrayAleatorio(talla);
         for (int r = 0; r < REPETICIONES; r++) {
            ti = System.nanoTime();
            am.seleccion(a);
            tf = System.nanoTime();
            tt += (double) (tf - ti);
        }
        tt=(double) tt/REPETICIONES;
        System.out.printf(Locale.US,"%8d   %.2f\n",talla,tt/ NMS);
        talla+=INCRTALLA;
        }
        // Completar
    }

    // Completar

    public static void medidaInsercion() {
        int talla = INITALLA;
        long ti=0,tf=0;
        double tmejor = 0, tpeor=0, promedio=0;
        
        AlgoritmosMedibles am = new AlgoritmosMedibles();
        System.out.println("# Insercion. Tiempos en microsegundos");
        System.out.printf("# Talla       Mejor        Peor       Promedio\n");
        System.out.printf("#-----------------------------------------\n");
        
        while(talla<= MAXTALLA){
           //caso mejor 
           int [] a = new int[talla];
           int [] b = new int[talla];
           a = crearArrayOrdDecreciente(talla); 
           b = crearArrayOrdCreciente(talla); 
           
           tmejor=0;
           for(int i =0; i<= REPETICIONES;i++){         
            ti= System.nanoTime();
            am.seleccion(b);
            tf= System.nanoTime();
            tmejor += (double) (tf - ti);
            }
           tpeor=0;
            for(int i =0; i<= REPETICIONES;i++){
            ti= System.nanoTime();
            am.seleccion(a);
            tf= System.nanoTime();
            tpeor += (double) (tf - ti);
            }            
            tmejor= tmejor/REPETICIONES;
            tpeor= tpeor/REPETICIONES;
            promedio=(tmejor+tpeor)/2;
            System.out.printf(Locale.US,"%8d   %8.2f   %8.2f   %8.2f\n",talla,tmejor/NMS,tpeor/NMS,promedio/NMS);
            talla+=INCRTALLA;
          }
        
    }

    public static void medidaMergeSort() {
        // Completar
    }

    public static void uso() {
        System.out.println("Uso: java MedidaOrdenacion numero_algoritmo");
        System.out.println("   Donde numero_algoritmo es:");
        System.out.println("   1 -> Insercion");
        System.out.println("   2 -> Seleccion");
        System.out.println("   3 -> MergeSort");
    }

    public static void main(String[] args) {
          int talla = 10;
           long ti=0,tf=0;
           AlgoritmosMedibles am = new AlgoritmosMedibles();
           double tmejor = 0, tpeor=0, promedio=0;
           int [] b = new int[talla];
           int [] c = new int[talla];
            b = crearArrayOrdCreciente(talla);
            c = crearArrayOrdDecreciente(talla); 

                       
            tmejor=0;
            ti= System.nanoTime();
            am.seleccion(b);
            tf= System.nanoTime();
            tmejor += (double) (tf - ti);
            
                        tpeor=0;
            ti= System.nanoTime();
            am.seleccion(c);
            tf= System.nanoTime();
            tpeor += (double) (tf - ti);

            tmejor=(double) tmejor/REPETICIONES;
            tpeor=(double) tpeor/REPETICIONES;
            promedio=(tmejor+tpeor)/2;

           
             for(int i =0; i< b.length;i++){                 
              System.out.println( tmejor+"---"+tpeor+"----"+b[i] +" ---"+ c[i] );
             }
        
        int a;
        if (args.length != 1) {
            uso();
            return;
        }

        try {
            a = Integer.parseInt(args[0]);
        } catch (Exception e) {
            uso();
            return;
        }

        switch (a) {
        case 1:
            medidaInsercion();
            break;
        case 2:
            medidaSeleccion();
            break;
        case 3:
            medidaMergeSort();
            break;
        default:
            uso();
        }
    }

}
