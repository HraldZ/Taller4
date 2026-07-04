package Dominio;

import Visitor.Visitor;

public class Item extends Carta {

	protected int bonificacion;

	public Item(String nombre, int rareza, String tipo, int bonificacion) {
		super(nombre, rareza, tipo);
		this.bonificacion = bonificacion;
	}

	public int getBonificacion() {
		return bonificacion;
	}
	public double accept(Visitor visitor) {
		return visitor.visitar(this);
	}
	
	
	
	
}
