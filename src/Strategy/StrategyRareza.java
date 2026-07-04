package Strategy;

import java.util.ArrayList;

import Dominio.Carta;
//strategy ocupando la rareza de la carta entre mayor sea la rareza mas arriba de la lista ira.
public class StrategyRareza implements Strategy{

	@Override
	//metodo ordenar con sobrecarga de metodos.
	public void Ordenar(ArrayList<Carta> cartas) {
		int n = cartas.size();

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				Carta actual = cartas.get(j);
				Carta siguiente = cartas.get(j + 1);
				if (actual.getRareza() < siguiente.getRareza()) {
					cartas.set(j, siguiente);
					cartas.set(j + 1, actual);
				}
			}
		}
	}

}