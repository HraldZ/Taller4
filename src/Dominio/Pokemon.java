package Dominio;

import Visitor.Visitor;
//clase de herencia a carta  
public class Pokemon extends Carta {
//variables extra de esta clase 
	private int dano;
	private int cantEnergia;
	public Pokemon(String nombre, int rareza, String tipo, int dano, int cantEnergia) {
		super(nombre, rareza, tipo);
		this.dano = dano;
		this.cantEnergia = cantEnergia;
	}
	//getters and setters y su correspondiente visitor
	public int getDano() {
		return dano;
	}
	public int getCantEnergia() {
		return cantEnergia;
	}
	public double accept(Visitor visitor) {
		return visitor.visitar(this);
	}
	public void setDano(int dano) {
		this.dano = dano;
	}
	public void setCantEnergia(int cantEnergia) {
		this.cantEnergia = cantEnergia;
	}
	
	
	
	
}
