package Strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import Dominio.Carta;

public class StrategyAbc implements Strategy {

	@Override
	public void Ordenar(ArrayList<Carta> cartas) {
		Collections.sort(cartas, new Comparator<Carta>() {
	        public int compare(Carta c1, Carta c2) {
	            return c1.getNombre().compareToIgnoreCase(c2.getNombre());
	        }
	    });
		
	}

}
