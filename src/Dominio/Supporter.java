package Dominio;

import Visitor.Visitor;
//clase herencia supporter
public class Supporter extends Carta {
//variables extra
	protected int efectosPorTurno;
//constructor
	public Supporter(String nombre, int rareza, String tipo, int efectosPorTurno) {
		super(nombre, rareza, tipo);
		this.efectosPorTurno = efectosPorTurno;
	}
//getters and setters correspondientes junto con su visitor
	public int getEfectosPorTurno() {
		return efectosPorTurno;
	}
	public double accept(Visitor visitor) {
		return visitor.visitar(this);
	}

	public void setEfectosPorTurno(int efectosPorTurno) {
		this.efectosPorTurno = efectosPorTurno;
	}
	
	
	
}
