package Logica;

import java.util.ArrayList;
import Dominio.*;

public class SistemaImp {
	
	
	public static ArrayList<Carta> coleccion = new ArrayList<>();
	
	public void agregarCarta(Carta carta) {
		coleccion.add(carta);
	}

	public ArrayList<Carta> getColeccion() {
		return coleccion;
	}
	
	
	
	
	
	
	

}
