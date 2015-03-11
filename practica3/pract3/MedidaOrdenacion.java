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
		Random rnd = new Random();
		for (int i = 0; i < t; i++) {
			a[i] = rnd.nextInt(t);
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
			a[i] = i + 1;
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

		 for (int r = 0; r < REPETICIONES; r++) {
			a = crearArrayAleatorio(talla);
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
		// Completar
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

		medidaSeleccion();
		int[] b = new int[10];
		b = crearArrayAleatorio(10);
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}

		b = crearArrayOrdCreciente(10);

		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
		b = crearArrayOrdDecreciente(10);
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
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
