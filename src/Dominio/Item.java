package Dominio;

public class Item extends Carta {

	protected int bonificacion;

	public Item(String nombre, int rareza, String tipo, int bonificacion) {
		super(nombre, rareza, tipo);
		this.bonificacion = bonificacion;
	}

	public int getBonificacion() {
		return bonificacion;
	}
	
	
	
	
}
