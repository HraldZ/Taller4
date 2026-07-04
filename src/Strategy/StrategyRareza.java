package Strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Dominio.Carta;

public class StrategyRareza implements Strategy{

	@Override
	public void Ordenar(ArrayList<Carta> cartas) {
	    Collections.sort(cartas, new Comparator<Carta>() {
	        @Override
	        public int compare(Carta c1, Carta c2) {
	            return Integer.compare(c2.getRareza(), c1.getRareza());
	        }
	    });
	}
	

}
