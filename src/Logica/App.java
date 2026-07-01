package Logica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Dominio.*;
import GUI.VentanaPrincipal;

public class App {
	
	public static Sistema sistema = new Sistema();
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
					
				case "supporter":
					int efectosPorTurno = Integer.parseInt(partes[3]);
					a = new Supporter(nombre,rareza,tipo,efectosPorTurno);
					
				case "energy":
					String elemento = partes[3];
					a = new Energy(nombre,rareza,tipo,elemento);
					
				case "item":
					int bonificacion = Integer.parseInt(partes[3]);
					a = new Item(nombre,rareza,tipo,bonificacion);	
				}
				if ( a != null) {
					sistema.agregarCarta(a);
				}
			}
			
			
		}catch(FileNotFoundException e) {
			System.out.println("caido");
		}
		
		
		
	}
	
	public static void agregarCartaNueva(Scanner sc) {
		System.out.println("Ingresa nombre de la carta nueva :");
		
		
	}
	
	
	public static void eliminarCarta(Scanner sc) {
		System.out.println("Que carta quieres eliminar");
		
		
	}
	
	
	public static void modificarCarta(Scanner sc) {
		System.out.println("Que carta quieres modificar");
		
	}
	
	
	public static void main(String[] args) {
		
		VentanaPrincipal main = new VentanaPrincipal();
		main.setVisible(true);
	}
	
	
	
	
	
	
	

}
