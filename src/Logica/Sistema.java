package Logica;

import java.util.ArrayList;

import Dominio.Carta;

public interface Sistema {

	
	public ArrayList<Carta> getColeccion();
	
	public static void eliminarCarta(int index,String string) {
		
	}
	
	public static void guardarCambiosCartas() {
		
	}
	
	public void OrdenarPorAbc(ArrayList<Carta> cartas);
	
	public void OrdenarPorPoder(ArrayList<Carta> cartas);
	
	public void OrdenarPorRareza(ArrayList<Carta> cartas);
	
	
	
	
	
	
	
	
	
}
