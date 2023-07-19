package arbolesBinarios;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        // Crear el árbol
        Arbol arbol = new Arbol();
        // Insertar nodos en el árbol
        System.out.println("-----------------------------------------");
        System.out.println(" ¿Ingrese cuántos nodos va a ingresar?:");
        System.out.println("-----------------------------------------");        
        int nodosIngresar=scanner.nextInt();
        for(int i=1; i<=nodosIngresar; i++) {
        	System.out.println("Ingrese su valor para el nodo #"+i);
        	int valor=scanner.nextInt();
        	 Datos valorIngresado= new Datos(valor);
        	 arbol.insertar(valorIngresado);
        }    
        //------------------------------------------------------
        //Contar las hojas del árbol        
        //------------------------------------------------------
        int hojas = arbol.contarHojas();
        System.out.println("---------------------------------");
        System.out.println("Número de hojas: " + hojas);     
        //------------------------------------------------------
        // Sumar las cédulas de los elementos del árbol
        //------------------------------------------------------
        int sumaCedulas = arbol.sumarCedulas();
        System.out.println("---------------------------------");
        System.out.println("Suma de los valores: " + sumaCedulas);
        //--------------------------------------------------------------
        // Sumar las cédulas de los elementos múltiplos de 3 del árbol
        //--------------------------------------------------------------
        int sumaCedulasMultiplosDeTres = arbol.sumarMultiplosDeTresCedulas();
        System.out.println("---------------------------------");
        System.out.println("Suma de los valores múltiplos de 3: " + sumaCedulasMultiplosDeTres);
        // Buscar el nodo con la cédula de mayor valor
        Nodo nodoMaximo = arbol.buscarNodoMaximoPorCedula();

        // Mostrar los datos del nodo encontrado
        if (nodoMaximo != null) {
            System.out.println("Nodo con los valores de mayor valor:");
            System.out.println("Valores: " + nodoMaximo.getDato().getValor());
        } else {
            System.out.println("El árbol está vacío. No hay nodos.");
        }
    }
}

