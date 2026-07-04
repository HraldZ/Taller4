package Logica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import Dominio.*;
import Strategy.Strategy;
import Strategy.StrategyAbc;
import Strategy.StrategyPoder;
import Strategy.StrategyRareza;

public class SistemaImp implements Sistema  {
	
	//instancia del singleton
	private static SistemaImp sis = null;
	private SistemaImp() {
	}
	public static SistemaImp getInstance() {
		if(sis == null) {
			sis = new SistemaImp();
			return sis;
		}else return sis; 
	}
	
	//coleccion de cartas 
	public static ArrayList<Carta> coleccion = new ArrayList<>();

	//getter de la coleccion
	public ArrayList<Carta> getColeccion() {
		return coleccion;
	}

	public static void eliminarCarta(int index, String string) {
		coleccion.remove(index);
		guardarCambiosCartas();
		
		
	}
	//strategy instanciado en el sistema, publico para ser ocupado en gui.
	public void OrdenarPorAbc(ArrayList<Carta> cartas ) {
		Strategy estrategia = new StrategyAbc();
		estrategia.Ordenar(cartas);
	}
	//strategy instanciado en el sistema, publico para ser ocupado en gui.
	public void OrdenarPorPoder(ArrayList<Carta> cartas ) {
		Strategy estrategia = new StrategyPoder();
		estrategia.Ordenar(cartas);
	}
	//strategy instanciando en el sistema, publico para ser ocupado en gui.
	public void OrdenarPorRareza(ArrayList<Carta> cartas ) {
		Strategy estrategia = new StrategyRareza();
		estrategia.Ordenar(cartas);
	}
	
	
	
	
	
	
	
	
	//sobreescritura de el archivo sobres.txt consta de un ciclo pasando por toda la arraylist y buscando la instancia de el tipo de carta asi sobreescribiendo
	//dependiendo de sus extra atributos 
	public static void guardarCambiosCartas() {

		try {
			BufferedWriter escritor = new BufferedWriter(new FileWriter("src/Sobres.txt"));

			for (int i = 0; i < SistemaImp.getInstance().getColeccion() .size(); i++) {
				Carta carta = SistemaImp.getInstance().getColeccion().get(i);

				escritor.write(carta.getNombre() + ";" + carta.getRareza() + ";" + carta.getTipo());

				if (carta instanceof Pokemon) {
					Pokemon pokemon = (Pokemon) carta;
					escritor.write(";" + pokemon.getDano() + ";" + pokemon.getCantEnergia());

				} else if (carta instanceof Item) {
					Item item = (Item) carta;
					escritor.write(";" + item.getBonificacion());

				} else if (carta instanceof Supporter) {
					Supporter supporter = (Supporter) carta;
					escritor.write(";" + supporter.getEfectosPorTurno());

				} else if (carta instanceof Energy) {
					Energy energy = (Energy) carta;
					escritor.write(";" + energy.getElemento());
				}

				escritor.newLine();
			}

			escritor.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}
	
	
	
	
	
	

}
