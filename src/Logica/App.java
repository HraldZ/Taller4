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
	//Scanner y sistema implementado agregados en metodo estatico para que se vea en todo el codigo
	public static SistemaImp sistema = SistemaImp.getInstance();
	public static Scanner sc = new Scanner(System.in);

	
	
	
	
	public static void main(String[] args) {
		
		cargarCartas();
		//ventana instanciada y disponible para la vista
		VentanaPrincipal main = VentanaPrincipal.getInstance();
		main.setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	
	
	//Lectura de archivos redistribuyendo la creacion de objetos hacia el patron de diseño factory
	public static void cargarCartas() {
		try {
			Scanner lector = new Scanner(new File("src/Sobres.txt"));
			while ( lector.hasNextLine()) {
				String linea = lector.nextLine();
				//instancia factory
				Carta cartas = CartaFactory.CrearCartas(linea);
				SistemaImp.getInstance().getColeccion().add(cartas);
				
			}	
		}catch(FileNotFoundException e) {
			System.out.println("No se encuentra el archivo.");
		}
	}
	
	
	
	
	
	
	
	

	
	

}
