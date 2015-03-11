/** Clase MedidaOrdenacion: Estudio empirico de costes de los metodos de ordenacion.
  * @author PRG ETSInf
  * @version Year 2014-2015
  */
 import java.util.*;
 
class MedidaOrdenacion {
  // Constantes que definen los parametros de medida
  
  /* Genera un array de int de talla t con valores comprendidos entre 0 y t.
   * @param int la talla
   * @result int[] el array generado
   */
  private static int[] crearArrayAleatorio(int t) { 
       int[] a= new int[t];
       Random rnd = new Random();
     for (int i=0;i<t;i++){
         a[i]= rnd.nextInt(t);
        }
        return a;
  }
  
  /* Genera un array de int de talla t ordenado de forma creciente.
   * @param int la talla
   * @result int[] el array generado
   */
  private static int[] crearArrayOrdCreciente(int t) { 
       int[] a= new int[t];
      for(int i=0; i<t ;i++){
          a[i]=i;
        }
        return a;
  }

  /* Genera un array de int de talla t ordenado de forma decreciente.
   * @param int la talla
   * @result int[] el array generado
   */
  private static int[] crearArrayOrdDecreciente(int t) { 
      int[] a= new int[t];
      while(t>0){
          a[t-1]=t;
          t--;
        }
        return a;
  }

  public static void medidaSeleccion() { 
    // Completar
  }

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
     int [] b= new int[10];
     b= crearArrayAleatorio(10);
      for (int i=0;i<b.length;i++){
          System.out.println(b[i]);
        }
        
       b= crearArrayOrdCreciente(10);
        
         for (int i=0;i<b.length;i++){
          System.out.println(b[i]);
        }
      b=  crearArrayOrdDecreciente(10);
       for (int i=0;i<b.length;i++){
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
      uso(); return;
    }
    
    switch (a) {
      case 1: medidaInsercion();
              break;
      case 2: medidaSeleccion();
              break;
      case 3: medidaMergeSort();
              break;
      default: uso();
    }
  }

}
