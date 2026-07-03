package Dominio;

public abstract class Carta {

	protected String nombre;
	protected int rareza;
	protected String tipo;
	
	public Carta(String nombre, int rareza, String tipo) {
		super();
		this.nombre = nombre;
		this.rareza = rareza;
		this.tipo = tipo;
	}

	@Override
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
	
	
	
	
	
}
