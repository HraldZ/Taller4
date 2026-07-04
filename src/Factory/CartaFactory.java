package Factory;

import Dominio.*;

public class CartaFactory {
	
public static Carta CrearCartas(String linea) {
	String[] partes = linea.split(";");
	String nombre = partes[0];
	int rareza = Integer.parseInt(partes[1]);
	String tipo = partes[2].toLowerCase();
	switch(tipo) {
	case "pokemon" :
		int daño = Integer.parseInt(partes[3]);
		int cantenergia = Integer.parseInt(partes[4]);
		return new Pokemon(nombre, rareza, tipo, daño, cantenergia);
		
	case "item" :
		int bonificacion = Integer.parseInt(partes[3]);
		return new Item(nombre, rareza, tipo, bonificacion);
		
	case "supporter":
		int efectoxturno = Integer.parseInt(partes[3]);
		return new Supporter(nombre, rareza, tipo, efectoxturno);
	case "energy" :
		String elemento = partes[3];
		return new Energy(nombre, rareza, tipo, elemento);
	}
	return null;
	
}
	

}
