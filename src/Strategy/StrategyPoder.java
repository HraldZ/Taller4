package Strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import Visitor.*;
import Dominio.Carta;

public class StrategyPoder implements Strategy{

	@Override
	public void Ordenar(ArrayList<Carta> cartas) {
		Visitor visitor = new visitarPoder();
		Collections.sort(cartas, new Comparator<Carta>() {
			@Override
			public int compare(Carta c1, Carta c2) {
				return Double.compare(c2.accept(visitor), c1.accept(visitor));
			}
		});
		
	}

}
