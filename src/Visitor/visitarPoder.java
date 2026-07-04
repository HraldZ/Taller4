package Visitor;

import Dominio.Energy;
import Dominio.Item;
import Dominio.Pokemon;
import Dominio.Supporter;

public class visitarPoder implements Visitor{

	@Override
	//visitarPoder Implementando sobrecarga de metodos para poder cumplir el formato necesario de el patron de diseño visitor(depende de el objeto que acepte)
	public double visitar(Pokemon pokemon) {
		Double poder = (((double) pokemon.getDano() / pokemon.getCantEnergia()) * 100);
		return Math.round(poder);
	}

	@Override
	
	public double visitar(Item item) {
		return item.getBonificacion() * 20;
	}

	@Override
	public double visitar(Supporter supporter) {
		return supporter.getEfectosPorTurno() * 50;
	}

	@Override
	public double visitar(Energy energy) {
		return 1;
	}

}
