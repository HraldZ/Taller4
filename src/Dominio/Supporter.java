package Dominio;

import Visitor.Visitor;

public class Supporter extends Carta {

	protected int efectosPorTurno;

	public Supporter(String nombre, int rareza, String tipo, int efectosPorTurno) {
		super(nombre, rareza, tipo);
		this.efectosPorTurno = efectosPorTurno;
	}

	public int getEfectosPorTurno() {
		return efectosPorTurno;
	}
	public double accept(Visitor visitor) {
		return visitor.visitar(this);
	}
	
	
	
}
