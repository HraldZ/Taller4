package Logica;


import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;



import Dominio.*;
import Factory.CartaFactory;
import GUI.VentanaPrincipal;

public class App {
	
	public static SistemaImp sistema = SistemaImp.getInstance();
	public static Scanner sc = new Scanner(System.in);

	
	
	
	
	public static void main(String[] args) {
		
		cargarCartas();
		
		VentanaPrincipal main = new VentanaPrincipal();
		main.setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void cargarCartas() {
		try {
			Scanner lector = new Scanner(new File("src/Sobres.txt"));
			while ( lector.hasNextLine()) {
				String linea = lector.nextLine();
				Carta cartas = CartaFactory.CrearCartas(linea);
				SistemaImp.getInstance().getColeccion().add(cartas);
				
			}	
		}catch(FileNotFoundException e) {
			System.out.println("caido");
		}
	}
	
	
	
	
	
	
	
	

	
	

}
