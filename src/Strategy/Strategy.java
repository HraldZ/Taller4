package Strategy;
import java.util.ArrayList;

import Dominio.*;

public interface Strategy {
	//Interfaz de estrategia con el metodo que le haremos sobrecarga
	public void Ordenar(ArrayList<Carta> cartas);

}
