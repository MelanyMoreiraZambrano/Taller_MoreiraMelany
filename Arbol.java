package arbolesBinarios;
public class Arbol {
	Nodo raiz;
	//----------------------------------------------
	//        Constructores de la clase
	//----------------------------------------------
	public Arbol() {
		raiz=null;
	}
	public Arbol(Nodo nodo) {
		raiz=nodo;
	}
	//----------------------------------------------
	//       Operaciones para insertar los nodos
	//----------------------------------------------
	public boolean ArbolVacio() {
		if(raiz==null) {
			return true;
		}
		return false;
	}
	public void insertar(Datos dato) {
	    if (ArbolVacio()) {
	        Nodo nodo = new Nodo(dato);
	        raiz = nodo;
	    } else {
	        Nodo nodoNuevo = new Nodo(dato);
	        Nodo padre = null;
	        Nodo actual = raiz;
	        
	        while (actual != null) {
	            padre = actual;
	            //? es un operador ternario, que me permite optimizar una condicional
	            //(confición) "?"<-- else if  (true condición): (false condición)
	            actual = (nodoNuevo.getDato().getValor() < actual.getDato().getValor()) ? actual.getIzquierda() : actual.getDerecha();
	        }
	        
	        if (nodoNuevo.getDato().getValor() < padre.getDato().getValor()) {
	            padre.setIzquierda(nodoNuevo);
	        } else {
	            padre.setDerecha(nodoNuevo);
	        }        
	        nodoNuevo.setPadre(padre);
	    }
	}
	//-----------------------------------------------------------
	//                     Mostrar el árbol in-orden
	//-----------------------------------------------------------
	public void mostrarInOrden(Nodo nodo) {
	    if (nodo != null) {
	        mostrarInOrden(nodo.getIzquierda());    // Recorro el subárbol izquierdo
	        System.out.println(nodo.getDato().getValor());// Muestro el nodo actual
	        mostrarInOrden(nodo.getDerecha());      // Recorro el subárbol derecho
	    }
	}
	//-----------------------------------------------------------
	//                     Mostrar el árbol post-orden
	//-----------------------------------------------------------
	public void mostrarPostOrden(Nodo nodo) {
	    if (nodo != null) {
	        mostrarPostOrden(nodo.getIzquierda());    // Recorro el subárbol izquierdo
	        mostrarPostOrden(nodo.getDerecha());      // Recorro el subárbol derecho
	        System.out.println(nodo.getDato().getValor());// muestro el nodo actual
	    }
	}
	//-----------------------------------------------------------
	//                     Mostrar el árbol pre-orden
	//-----------------------------------------------------------
	public void mostrarPreOrden(Nodo nodo) {
	    if (nodo != null) {
	        System.out.println(nodo.getDato().getValor());// Muestro el nodo actual
	        mostrarPreOrden(nodo.getIzquierda());    // Recorro el subárbol izquierdo
	        mostrarPreOrden(nodo.getDerecha());      // Recorro el subárbol derecho
	    }
	}
	
    //-----------------------------------------------
    //   Contar las hojas del arbol binario 13.5
    //-----------------------------------------------	
	//--------------------------------------------------------
	//Metodo que permite Contar Hojas y llama a el metodo recursivo contar hojas
	//--------------------------------------------------------
    public int contarHojas() {
        return contarHojasRecursivo(raiz);
    }
	//-----------------------------------------------------------------------
	//Contar Hojas Recursivo donde primero me compara si el árbol está vacío
	//-----------------------------------------------------------------------
    private int contarHojasRecursivo(Nodo nodo) {
        // Si el nodo es nulo, no hay hojas, retorna 0
        if (nodo == null) {
            return 0;
        }        
    	//-----------------------------------------------------------------------
    	//Contar Hojas Recursivo donde primero me compara si el árbol está vacío
    	//-----------------------------------------------------------------------              
        if (nodo.getIzquierda() == null && nodo.getDerecha() == null) {
            return 1;
        }      
        return contarHojasRecursivo(nodo.getIzquierda()) + contarHojasRecursivo(nodo.getDerecha());
    }   
    //-----------------------------------------------
    //   			Sumar los elemento 13.11
    //-----------------------------------------------
 // Método público para obtener la suma de las cédulas de los elementos del árbol binario
    public int sumarCedulas() {
        return sumarCedulasRecursivo(raiz);
    }
    // Método privado recursivo para obtener la suma de las cédulas de los elementos del árbol binario
    private int sumarCedulasRecursivo(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        // Suma el valor de la cédula del nodo actual más la suma de sus hijos izquierdo y derecho
        return nodo.getDato().getValor() + sumarCedulasRecursivo(nodo.getIzquierda()) + sumarCedulasRecursivo(nodo.getDerecha());
    }
    // Método público para obtener la suma de las cédulas de los elementos múltiplos de 3 del árbol binario
    public int sumarMultiplosDeTresCedulas() {
        return sumarMultiplosDeTresCedulasRecursivo(raiz);
    }
    // Método privado recursivo para obtener la suma de las cédulas de los elementos múltiplos de 3 del árbol binario
    private int sumarMultiplosDeTresCedulasRecursivo(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        int suma = 0;
        if (nodo.getDato().getValor() % 3 == 0) {
            suma = nodo.getDato().getValor();
        }
        // Suma la suma de las cédulas múltiplos de 3 de sus hijos izquierdo y derecho
        return suma + sumarMultiplosDeTresCedulasRecursivo(nodo.getIzquierda()) + sumarMultiplosDeTresCedulasRecursivo(nodo.getDerecha());
    }
    public Datos buscarNodoMaximo() {
        if (raiz == null) {
            return null; // Si el árbol está vacío, retornamos null
        }
        Nodo nodoActual = raiz;
        while (nodoActual.getDerecha() != null) {
            nodoActual = nodoActual.getDerecha(); // Avanzamos hacia la rama derecha hasta llegar al nodo máximo
        }
        return nodoActual.getDato();
    }
    public Nodo buscarNodoMaximoPorCedula() {
        return buscarNodoMaximoPorCedulaRecursivo(raiz, null);
    }
    //-----------------------------------------------
    //   			Buscar nodo máximo 13.5
    //-----------------------------------------------
    // Método privado recursivo para buscar el nodo con la cédula de mayor valor en el árbol
    private Nodo buscarNodoMaximoPorCedulaRecursivo(Nodo nodo, Nodo nodoMaximo) {
        if (nodo == null) {
            return nodoMaximo;
        }
        // Actualiza el nodo máximo si el nodo actual tiene una cédula mayor
        if (nodoMaximo == null || nodo.getDato().getValor() > nodoMaximo.getDato().getValor()) {
            nodoMaximo = nodo;
        }
        // Realiza la búsqueda en los subárboles izquierdo y derecho
        Nodo nodoMaximoIzquierdo = buscarNodoMaximoPorCedulaRecursivo(nodo.getIzquierda(), nodoMaximo);
        Nodo nodoMaximoDerecho = buscarNodoMaximoPorCedulaRecursivo(nodo.getDerecha(), nodoMaximo);
        // Compara el nodo máximo del subárbol izquierdo con el nodo máximo del subárbol derecho y con el nodo actual
        if (nodoMaximoIzquierdo != null && nodoMaximoIzquierdo.getDato().getValor() > nodoMaximo.getDato().getValor()) {
            nodoMaximo = nodoMaximoIzquierdo;
        }
        if (nodoMaximoDerecho != null && nodoMaximoDerecho.getDato().getValor() > nodoMaximo.getDato().getValor()) {
            nodoMaximo = nodoMaximoDerecho;
        }
        return nodoMaximo;
    }        
	public Nodo getRaiz() {
		return raiz;
	}
	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
}
