package arbolesBinarios;
public class Nodo {
	Nodo padre;
    Nodo derecha;
    Nodo izquierda;
    Datos datos;
    
    public Nodo() {
        datos=null;
        derecha=null;
        izquierda=null;
        padre=null;
    }
    //---------------------------------------------------
    //Características del nodo Raiz
    //---------------------------------------------------
    public Nodo(Datos datos) {
    	this.datos=datos;
    	derecha=null;
    	izquierda=null;
    	padre=null;
    }
    //---------------------------------------------------------
    //              Getters y Setters (Derecha, Izquierda)
    //---------------------------------------------------------
    public Datos getDato() {
        return datos;
    }

    public void setDato(Datos dato) {
        this.datos = dato;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    public Nodo getPadre() {
        return padre;
    }
    public void setPadre(Nodo padre) {
        this.padre = padre;
    }
}
