package Strategy;

import java.util.ArrayList;

import Dominio.Carta;
import Visitor.*;

/**
 * Estrategia concreta que ordena las cartas por su poder calculado
 * (de mayor a menor), usando un ordenamiento burbuja manual.
 * El poder de cada carta se obtiene mediante un Visitor.
 */
public class StrategyPoder implements Strategy {

	@Override
	public void Ordenar(ArrayList<Carta> cartas) {
		Visitor visitor = new visitarPoder();
		int n = cartas.size();

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				Carta actual = cartas.get(j);
				Carta siguiente = cartas.get(j + 1);

				double poderActual = actual.accept(visitor);
				double poderSiguiente = siguiente.accept(visitor);

				// Si la actual tiene menor poder que la siguiente, se intercambian
				if (poderActual < poderSiguiente) {
					cartas.set(j, siguiente);
					cartas.set(j + 1, actual);
				}
			}
		}
	}

}