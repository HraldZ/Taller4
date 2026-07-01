package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaAdmin extends JDialog {
	
	public static Color azul    = new Color(52, 100, 180);
	public static Color blanco  = Color.WHITE;
	
	public  VentanaAdmin(JFrame padre) {
		super(padre,"Admin",false);
		setSize(720,500);
		setLocationRelativeTo(padre);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout(6,6));
		
		add(panelColeccion(),BorderLayout.WEST);
		add(panelDatos(),BorderLayout.CENTER);
		add(panelBotones(),BorderLayout.SOUTH);
		setVisible(true);
	}
	
	
	public JPanel panelDatos() {
		JPanel panel1 = new JPanel();
		
		panel1.setBorder(BorderFactory.createTitledBorder("Datos de la carta"));
		GridBagConstraints grid = new GridBagConstraints();
		grid.insets = new Insets(4,6,4,6);
		grid.fill = GridBagConstraints.HORIZONTAL;
		
		return panel1;
		
	}
	
	public JPanel panelColeccion() {
		JPanel panel2 = new JPanel(new GridBagLayout());
		panel2.setBorder(BorderFactory.createTitledBorder("Cartas en coleccion"));
		panel2.setPreferredSize(new Dimension(230,0));
	
		
		return panel2;
			
	}
	
	public JPanel panelBotones() {
		JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER,10,4));
 		
		JButton agregar  = boton("Agregar", azul);
        JButton eliminar = boton("Eliminar",azul);
        JButton modificar    = boton("Modificar",azul);
        JButton limpiar  = boton("Limpiar", azul);

        agregar.setPreferredSize(new Dimension(110, 36));
        eliminar.setPreferredSize(new Dimension(110, 36));
        modificar.setPreferredSize(new Dimension(110, 36));
        limpiar.setPreferredSize(new Dimension(110, 36));
		
        panel3.add(agregar);
        panel3.add(eliminar);
        panel3.add(modificar);
        panel3.add(limpiar);
        
        
        return panel3;
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
