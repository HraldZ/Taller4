package Visitor;

import Dominio.Energy;
import Dominio.Item;
import Dominio.Pokemon;
import Dominio.Supporter;

public class visitarPoder implements Visitor{

	@Override
	public double visitar(Pokemon pokemon) {
		return ((double) pokemon.getDano() / pokemon.getCantEnergia()) * 100;
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
