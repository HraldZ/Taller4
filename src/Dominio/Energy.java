
package Dominio;

import Visitor.Visitor;
//clase herencia energy
public class Energy extends Carta {
//variables extra
	protected String elemento;
//constructor
	public Energy(String nombre, int rareza, String tipo, String elemento) {
		super(nombre, rareza, tipo);
		this.elemento = elemento;
	}
//getters and setters y el visit del visitor
	public String getElemento() {
		return elemento;
	}

	@Override
	public double accept(Visitor visitor) {
		return visitor.visitar(this);
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}
	
	
}