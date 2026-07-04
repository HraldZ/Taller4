package Strategy;

import java.util.ArrayList;

import Dominio.Carta;
import Visitor.*;

// estrategia concreta que ordena las cartas por su poder calculado
 //el poder de cada carta se obtiene mediante un Visitor
public class StrategyPoder implements Strategy {

	@Override
	//metodo ordenar ocupado con sobrecarga de metodos
	public void Ordenar(ArrayList<Carta> cartas) {
		Visitor visitor = new visitarPoder();
		int n = cartas.size();

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				Carta actual = cartas.get(j);
				Carta siguiente = cartas.get(j + 1);

				double poderActual = actual.accept(visitor);
				double poderSiguiente = siguiente.accept(visitor);
				if (poderActual < poderSiguiente) {
					cartas.set(j, siguiente);
					cartas.set(j + 1, actual);
				}
			}
		}
	}

}