package Dominio;
import Visitor.*;
//clase abstracta, el primer objeto donde salen herencias de este
public abstract class Carta {
	//variables que contiene este objeto
	protected String nombre;
	protected int rareza;
	protected String tipo;
	//la forma de aceptar la visita del patron de diseño visitor
	public abstract double accept(Visitor visitor);
	
	public Carta(String nombre, int rareza, String tipo) {
		super();
		this.nombre = nombre;
		this.rareza = rareza;
		this.tipo = tipo;
	}

	@Override
	// getters setter y el to string
	public String toString() {
		return  nombre + " | " + rareza + " | " + tipo ;
	}

	public String getNombre() {
		return nombre;
	}

	public int getRareza() {
		return rareza;
	}

	public String getTipo() {
		return tipo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setRareza(int rareza) {
		this.rareza = rareza;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
	
}
