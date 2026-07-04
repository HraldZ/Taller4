package Factory;

import Dominio.*;
//patron de diseño factory implementado para crear objetos de muchos tipos.
public class CartaFactory {
	
//metodo de creacion de cartas ocupado en la lectura de archivos en el main donde le pasas la linea que lee en el archivo. 
	
// Consta de un switch comparando el tipo de este y asi eligiendo el objeto que creara.
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
