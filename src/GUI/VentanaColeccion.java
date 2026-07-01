package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class VentanaColeccion extends JDialog {
	
	public static Color azul    = new Color(52, 100, 180);
	public static Color blanco  = Color.WHITE;

	public VentanaColeccion(JFrame padre) {
		super(padre,"Ver Coleccion",false);
		setSize(650,500);
		setLocationRelativeTo(padre);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setLayout(new BorderLayout(6,6));
		
		add(panelOrdenar(),BorderLayout.NORTH);
		
		
		
		setVisible(true);

	}

	
	private JPanel panelOrdenar() {
		JPanel panelo = new JPanel( new FlowLayout());
		
		JButton rareza  = boton("Rareza",azul);
        JButton nombre  = boton("Nombre",azul);
        JButton poder   = boton("Poder",azul);
        JButton actualizar = boton("Actualizar",azul);
		
        
        rareza.setPreferredSize(new Dimension(100, 32));
        nombre.setPreferredSize(new Dimension(100, 32));
        poder.setPreferredSize(new Dimension(100, 32));
        actualizar.setPreferredSize(new Dimension(110, 32));
        
        panelo.add(rareza);
        panelo.add(nombre);
        panelo.add(poder);
        panelo.add(actualizar);
        return panelo;
		
	}
	
	private JScrollPane panelScroll() {
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static JButton boton(String texto,Color color) {
		JButton b = new JButton(texto);
		b.setBackground(color);
        b.setForeground(blanco);
        b.setFocusPainted(false);
        b.setFont(new Font("SansSerif", Font.PLAIN, 13));
        b.setPreferredSize(new Dimension(0, 45));
        return b;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
