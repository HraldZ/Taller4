package Logica;

import java.util.ArrayList;
import Dominio.*;

public class SistemaImp implements Sistema  {
	private static SistemaImp sis = null;
	private SistemaImp() {
		
	}
	
	public static SistemaImp getInstance() {
		if(sis == null) {
			sis = new SistemaImp();
			return sis;
		}else return sis; 
		
		
	}
	
	
	public static ArrayList<Carta> coleccion = new ArrayList<>();
	
	public void agregarCarta(Carta carta) {
		coleccion.add(carta);
	}

	public ArrayList<Carta> getColeccion() {
		return coleccion;
	}
	
	
	
	
	
	
	

}
