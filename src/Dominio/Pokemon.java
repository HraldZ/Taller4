package Dominio;

import Visitor.Visitor;

public class Pokemon extends Carta {

	protected int dano;
	protected int cantEnergia;
	public Pokemon(String nombre, int rareza, String tipo, int dano, int cantEnergia) {
		super(nombre, rareza, tipo);
		this.dano = dano;
		this.cantEnergia = cantEnergia;
	}
	public int getDano() {
		return dano;
	}
	public int getCantEnergia() {
		return cantEnergia;
	}
	public double accept(Visitor visitor) {
		return visitor.visitar(this);
	}
	
	
	
	
}
