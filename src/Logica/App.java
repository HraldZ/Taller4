package Logica;


import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;



import Dominio.*;
import GUI.VentanaPrincipal;

public class App {
	
	public static SistemaImp sistema = new SistemaImp();
	public static Scanner sc = new Scanner(System.in);
	
	
	public static void cargarCartas() {
		try {
			Scanner lector = new Scanner(new File("src/Sobres.txt"));
			while ( lector.hasNextLine()) {
				String linea = lector.nextLine();
				String[] partes = linea.split(";");
				String nombre = partes[0];
				int rareza = Integer.parseInt(partes[1]);
				String tipo = partes[2].toLowerCase();
				
				Carta a = null;
				switch (tipo) {
				
				case "pokemon":
					int dano = Integer.parseInt(partes[3]);
					int cantEnergias = Integer.parseInt(partes[4]);
					a = new Pokemon(nombre, rareza, tipo,dano,cantEnergias);
					break;
				case "supporter":
					int efectosPorTurno = Integer.parseInt(partes[3]);
					a = new Supporter(nombre,rareza,tipo,efectosPorTurno);
					break;
				case "energy":
					String elemento = partes[3];
					a = new Energy(nombre,rareza,tipo,elemento);
					break;
				case "item":
					int bonificacion = Integer.parseInt(partes[3]);
					a = new Item(nombre,rareza,tipo,bonificacion);	
					break;
				}
				if ( a != null) {
					sistema.agregarCarta(a);
				}
			}	
		}catch(FileNotFoundException e) {
			System.out.println("caido");
		}
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		cargarCartas();
		
		VentanaPrincipal main = new VentanaPrincipal();
		main.setVisible(true);
	}
	
	

}
