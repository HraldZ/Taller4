package Visitor;

import Dominio.Energy;
import Dominio.Item;
import Dominio.Pokemon;
import Dominio.Supporter;

/**
 * Interfaz Visitor que define una operación por cada
 * tipo concreto de Carta, sin modificar sus clases.
 */
public interface Visitor {
	double visitar(Pokemon pokemon);
	double visitar(Item item);
	double visitar(Supporter supporter);
	double visitar(Energy energy);
}