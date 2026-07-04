package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

import Logica.*;
import Dominio.*;

public class VentanaAdmin extends JDialog {
	
	public SistemaImp sistema = SistemaImp.getInstance();
	public static Color azul    = new Color(52, 100, 180);
	public static Color blanco  = Color.WHITE;
	public DefaultListModel<String> listaP = new DefaultListModel<>();
	public JList<String> lista = new JList<>(listaP);
	private JPanel panelAtrib = new JPanel(new GridLayout(0, 2, 4, 4));
	private JTextField txtNombre  = new JTextField();
    private JTextField txtRareza  = new JTextField();
    private JComboBox<String> cmbTipo = new JComboBox<>(new String[]{"Pokemon","Item","Supporter","Energy"});
    private JTextField txtDanio, txtCantEnerg, txtBonificacion, txtEfectos, txtElemento;
    
    
	
	
	VentanaAdmin(JFrame padre) {
		super(padre,"Admin",false);
		setSize(800,500);
		setLocationRelativeTo(padre);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout(6,6));
		
		
		add(panelLista(),BorderLayout.WEST);
		add(crearPanelFormulario(),BorderLayout.CENTER);
		add(panelBotones(),BorderLayout.SOUTH);
		cmbTipo.addActionListener(e -> atributos());
		lista.addListSelectionListener(this::alSeleccionar);
		
		atributos();
		actualizarLista();
		
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
        
        limpiar.addActionListener(e->{
        	limpiar();
        });
        
        eliminar.addActionListener(e->{
        	eliminar();
        });
        
		
        panel3.add(agregar);
        panel3.add(eliminar);
        panel3.add(modificar);
        panel3.add(limpiar);
        
        return panel3;
	}
	
	public JButton boton(String texto,Color color) {
		JButton b = new JButton(texto);
		b.setBackground(color);
        b.setForeground(blanco);
        b.setFocusPainted(false);
        b.setFont(new Font("SansSerif", Font.PLAIN, 13));
        b.setPreferredSize(new Dimension(0, 45));
        return b;
		
	}
	
	private JPanel panelLista() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createTitledBorder("Cartas en coleccion"));
		panel.setPreferredSize(new Dimension(300,0));
		lista.setFont(new Font("sansSerif",Font.PLAIN,12));
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel.add(new JScrollPane(lista), BorderLayout.CENTER);
		return panel;
	}
	
	public void actualizarLista() {
		listaP.clear();
		ArrayList<Carta> coleccion = sistema.getColeccion();
		for (int i = 0; i < coleccion.size(); i++) {
			listaP.addElement((i+1)+ ". " + coleccion.get(i).toString());
		}
		
	}
	
	
	private JPanel crearPanelFormulario() {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBorder(BorderFactory.createTitledBorder("Datos de la carta"));
        GridBagConstraints grid = new GridBagConstraints();
        grid.insets = new Insets(4, 6, 4, 6);
        grid.fill = GridBagConstraints.HORIZONTAL;

        //nombre
        grid.gridx=0; 
        grid.gridy=0; 
        grid.weightx=0; 
        p.add(new JLabel("Nombre:"), grid);
        grid.gridx=1; 
        grid.weightx=1; 
        p.add(txtNombre, grid);

        //rareza
        grid.gridx=0; 
        grid.gridy=1; 
        grid.weightx=0; 
        p.add(new JLabel("Rareza:"), grid);
        grid.gridx=1; 
        grid.weightx=1; 
        p.add(txtRareza, grid);

        //tipo
        grid.gridx=0; 
        grid.gridy=2; 
        grid.weightx=0; 
        p.add(new JLabel("Tipo:"), grid);
        grid.gridx=1; 
        grid.weightx=1; 
        p.add(cmbTipo, grid);

        
        panelAtrib.setBorder(BorderFactory.createTitledBorder("Atributos del tipo"));
        grid.gridx=0; 
        grid.gridy=3; 
        grid.gridwidth=2; 
        grid.weightx=1;
        p.add(panelAtrib, grid);

        return p;
    }
	
	private void atributos() {
        panelAtrib.removeAll();
        txtDanio = new JTextField(); txtCantEnerg = new JTextField();
        txtBonificacion = new JTextField(); txtEfectos   = new JTextField();
        txtElemento = new JTextField();

        switch ((String) cmbTipo.getSelectedItem()) {
            case "Pokemon":
                panelAtrib.add(new JLabel("Daño:"));     
                panelAtrib.add(txtDanio);
                panelAtrib.add(new JLabel("Cantidad de Energias:")); 
                panelAtrib.add(txtCantEnerg);
                break;
            case "Item":
                panelAtrib.add(new JLabel("Bonificacion:")); 
                panelAtrib.add(txtBonificacion);
                break;
            case "Supporter":
                panelAtrib.add(new JLabel("Efectos Por Turno:")); 
                panelAtrib.add(txtEfectos);
                break;
            case "Energy":
                panelAtrib.add(new JLabel("Elemento:")); 
                panelAtrib.add(txtElemento);
                break;
        }
        panelAtrib.revalidate();
        panelAtrib.repaint();
    }

	
	 private void alSeleccionar(ListSelectionEvent e) {
	        if (e.getValueIsAdjusting()) return;
	        int idx = lista.getSelectedIndex();
	        if (idx < 0) return;
	        Carta c = sistema.getColeccion().get(idx);
	        txtNombre.setText(c.getNombre());
	        txtRareza.setText(String.valueOf(c.getRareza()));
	        cmbTipo.setSelectedItem(c.getTipo());
	        atributos();
	        // Rellenar campos del tipo
	        if (c instanceof Pokemon) {
	            txtDanio.setText(String.valueOf(((Pokemon) c).getDano()));
	            txtCantEnerg.setText(String.valueOf(((Pokemon) c).getCantEnergia()));
	        } else if (c instanceof Item) {
	            txtBonificacion.setText(String.valueOf(((Item) c).getBonificacion()));
	        } else if (c instanceof Supporter) {
	            txtEfectos.setText(String.valueOf(((Supporter) c).getEfectosPorTurno()));
	        } else if (c instanceof Energy) {
	            txtElemento.setText(((Energy) c).getElemento());
	        }
	    }
	
	
	
	 private void eliminar() {
	        int index = lista.getSelectedIndex();
	        if (index < 0) { 
	        	JOptionPane.showMessageDialog(this, "Selecciona una carta."); 
	        	return; 
	        	}
	        int c = JOptionPane.showConfirmDialog(this, "Eliminar carta seleccionada?", "Confirmar", JOptionPane.YES_NO_OPTION);
	        if (c == JOptionPane.YES_OPTION) {
	            //sistemaImp.eliminarCarta(index, "src/Sobres.txt");
	            actualizarLista();
	            limpiar();
	        }
	    }
	
	
	 private void limpiar() {
	        txtNombre.setText(""); txtRareza.setText("");
	        cmbTipo.setSelectedIndex(0);
	        atributos();
	        lista.clearSelection();
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
