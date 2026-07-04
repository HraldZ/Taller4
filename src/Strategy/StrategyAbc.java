package Strategy;

import java.util.ArrayList;

import Dominio.Carta;

//clase que forma parte del patron de diseño strategy
public class StrategyAbc implements Strategy {

	@Override
	//metodo Ordenar de forma que ordene dependiendo de la letra (alfinal escogi este metodo por que era la forma mas eficiente de hacerlo)
	public void Ordenar(ArrayList<Carta> cartas) {
		int n = cartas.size();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				Carta actual = cartas.get(j);
				Carta siguiente = cartas.get(j + 1);
				if (actual.getNombre().compareToIgnoreCase(siguiente.getNombre()) > 0) {
					cartas.set(j, siguiente);
					cartas.set(j + 1, actual);
				}
			}
		}
	}
}