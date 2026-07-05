package Dominio;

import Visitor.Visitor;
//clase herencia item
public class Item extends Carta {
//variables extra
	private int bonificacion;
//constructor de item
	public Item(String nombre, int rareza, String tipo, int bonificacion) {
		super(nombre, rareza, tipo);
		this.bonificacion = bonificacion;
	}
//getters and setters y su correspondiente visitor
	public int getBonificacion() {
		return bonificacion;
	}
	public double accept(Visitor visitor) {
		return visitor.visitar(this);
	}

	public void setBonificacion(int bonificacion) {
		this.bonificacion = bonificacion;
	}
	
	
	
	
	
}
