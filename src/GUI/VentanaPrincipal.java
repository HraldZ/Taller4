package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



public class VentanaPrincipal extends JFrame {
	
	public static Color blanco  = Color.WHITE;
	public static Color azul    = new Color(52, 100, 180);
	

	public VentanaPrincipal() throws HeadlessException {
		super("Pokemon TGC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 280);
        setLocationRelativeTo(null);
        setResizable(false);

        setContentPane(createGui());
	}

	public JPanel createGui() {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(blanco);
		panel.setBorder(BorderFactory.createEmptyBorder(20, 30,20, 30));
		
		
		GridBagConstraints grid = new GridBagConstraints();
		grid.fill = GridBagConstraints.HORIZONTAL;
		grid.insets = new Insets(6, 0, 6, 0);
		grid.weightx = 1;
		
		JLabel titulo = new JLabel("Pokemon Gestor de coleccion",SwingConstants.CENTER);
		titulo.setFont(new Font("sansSerif", Font.BOLD, 15));
		grid.gridy = 0; 
		panel.add(titulo, grid);	
		
		JButton admin = boton("Admin",azul);
		admin.addActionListener(e->{
			new VentanaAdmin(this);
		});
		grid.gridy = 2;
		panel.add(admin, grid);
		
		JButton coleccion = boton("Coleccion",azul);
		coleccion.addActionListener(e->{
			new VentanaColeccion(this);
		});
		grid.gridy = 3;
		panel.add(coleccion, grid);

		return panel;
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
