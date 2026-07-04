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
    boolean VieneDeSeleccionar = false;
    String tipo = "Pokemon";
    
	
	//Ventana principal de administrador donde se tendra que crear los botones y hacerlos visibles
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
	//panel para crear los botones modificar, agregar, limpiar, eliminar y añadirlos a la gui
	public JPanel panelBotones() {
		JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER,10,4));
 		
		JButton agregar  = boton("Agregar", azul);
        JButton eliminar = boton("Eliminar",azul);
        JButton modificar = boton("Modificar",azul);
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
        
        
        
        
        agregar.addActionListener(e-> {
        	agregar();
        	actualizarLista();
        });
        
        modificar.addActionListener(e-> {
        	modificar();
        	actualizarLista();
        	
        });
        
        
        
		
        panel3.add(agregar);
        panel3.add(eliminar);
        panel3.add(modificar);
        panel3.add(limpiar);
        
        return panel3;
	}
	//crear los botones de una forma mas amigable de tal forma que se pueda elegir su color, forma  y dimensiones en la pantalla
	public JButton boton(String texto,Color color) {
		JButton b = new JButton(texto);
		b.setBackground(color);
        b.setForeground(blanco);
        b.setFocusPainted(false);
        b.setFont(new Font("SansSerif", Font.PLAIN, 13));
        b.setPreferredSize(new Dimension(0, 45));
        return b;
		
	}
	//panel de las cartas en coleccion
	private JPanel panelLista() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createTitledBorder("Cartas en coleccion"));
		panel.setPreferredSize(new Dimension(300,0));
		lista.setFont(new Font("sansSerif",Font.PLAIN,12));
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel.add(new JScrollPane(lista), BorderLayout.CENTER);
		return panel;
	}
	//mostrar la lista actualizada con los cambios correspondientes
	public void actualizarLista() {
		listaP.clear();
		ArrayList<Carta> coleccion = sistema.getColeccion();
		for (int i = 0; i < coleccion.size(); i++) {
			listaP.addElement((i+1)+ ". " + coleccion.get(i).toString());
		}
		
	}
	
	//crear el panel 
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

        //extras
        panelAtrib.setBorder(BorderFactory.createTitledBorder("Atributos del tipo"));
        grid.gridx=0; 
        grid.gridy=3; 
        grid.gridwidth=2; 
        grid.weightx=1;
        p.add(panelAtrib, grid);

        return p;
    }
	//Panel donde cambias los atributos extra por cada tipo de carta
	private void atributos() {
        panelAtrib.removeAll();
        txtDanio = new JTextField(); txtCantEnerg = new JTextField();
        txtBonificacion = new JTextField(); txtEfectos   = new JTextField();
        txtElemento = new JTextField();
        
        if(VieneDeSeleccionar == false ) {
         tipo = ((String) cmbTipo.getSelectedItem());
        }
        VieneDeSeleccionar = false;
        switch(tipo)  {
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

	// sirve para poder seleccionar un pokemon, ver sus atributos y poder cambiarlos dependiendo de la necesidad de cada uno
	 private void alSeleccionar(ListSelectionEvent e) {
	        if (e.getValueIsAdjusting()) return;
	        int idx = lista.getSelectedIndex();
	        if (idx < 0) return;
	        Carta c = sistema.getColeccion().get(idx);
	        txtNombre.setText(c.getNombre());
	        txtRareza.setText(String.valueOf(c.getRareza()));
	        cmbTipo.setSelectedItem(capitalizar(c.getTipo()));
	        atributos();
	        // Rellenar campos del tipo
	        VieneDeSeleccionar = true;
	        if (c instanceof Pokemon) {
	        	tipo = "Pokemon";
	        	atributos();
	            txtDanio.setText(String.valueOf(((Pokemon) c).getDano()));
	            txtCantEnerg.setText(String.valueOf(((Pokemon) c).getCantEnergia()));
	            
	        } else if (c instanceof Item) {
	        	tipo = "Item";
	        	atributos();
	            txtBonificacion.setText(String.valueOf(((Item) c).getBonificacion()));
	        } else if (c instanceof Supporter) {
	        	tipo = "Supporter";
	        	atributos();
	            txtEfectos.setText(String.valueOf(((Supporter) c).getEfectosPorTurno()));
	        } else if (c instanceof Energy) {
	        	tipo = "Energy";
	        	atributos();
	            txtElemento.setText(((Energy) c).getElemento());
	        }
	        
	    }
	
	
	//metodo para eliminar el pokemon que sea seleccionado
	 private void eliminar() {
	        int index = lista.getSelectedIndex();
	        if (index < 0) { 
	        	JOptionPane.showMessageDialog(this, "Selecciona una carta."); 
	        	return; 
	        	}
	        int c = JOptionPane.showConfirmDialog(this, "Eliminar carta seleccionada?", "Confirmar", JOptionPane.YES_NO_OPTION);
	        if (c == JOptionPane.YES_OPTION) {
	            SistemaImp.eliminarCarta(index, "src/Sobres.txt");
	            actualizarLista();
	            limpiar();
	        }
	    }
	
	//metodo para limpiar los cuadros de texto que tengan opciones modificables 
	 private void limpiar() {
	        txtNombre.setText(""); txtRareza.setText("");
	        cmbTipo.setSelectedIndex(0);
	        atributos();
	        lista.clearSelection();
	    }
	 //metodo para arreglar un bug que no permitia que se cambien los cuadros de texto, de lo que consta el metodo es que tu le pasas tu
	 //texto y pone la primera letra en mayuscula
	 private String capitalizar(String texto) {
		    if (texto == null || texto.isEmpty()) return texto;
		    return texto.substring(0, 1).toUpperCase() + texto.substring(1).toLowerCase();
		}
	//metodo para agregar un nuevo pokemon al arraylist  
	 private void agregar() {
		    try {
		        String nombre = txtNombre.getText();
		        int rareza = Integer.parseInt(txtRareza.getText());
		        String tipoSeleccionado = (String) cmbTipo.getSelectedItem();

		        if (nombre.isEmpty()) {
		            JOptionPane.showMessageDialog(this, "Ingresa un nombre.");
		            return;
		        }

		        if (rareza < 1 || rareza > 5) {
		            JOptionPane.showMessageDialog(this, "La rareza debe estar entre 1 y 5.");
		            return;
		        }

		        Carta cartaNueva = null;

		        switch (tipoSeleccionado) {
		            case "Pokemon":
		                int dano = Integer.parseInt(txtDanio.getText());
		                int cantEnergia = Integer.parseInt(txtCantEnerg.getText());

		                if (dano < 0) {
		                    JOptionPane.showMessageDialog(this, "El daño no puede ser negativo.");
		                    return;
		                }
		                if (cantEnergia < 0) {
		                    JOptionPane.showMessageDialog(this, "La cantidad de energias no puede ser negativa.");
		                    return;
		                }

		                cartaNueva = new Pokemon(nombre, rareza, tipoSeleccionado.toLowerCase(), dano, cantEnergia);
		                break;

		            case "Item":
		                int bonificacion = Integer.parseInt(txtBonificacion.getText());

		                if (bonificacion < 0) {
		                    JOptionPane.showMessageDialog(this, "La bonificacion no puede ser negativa.");
		                    return;
		                }

		                cartaNueva = new Item(nombre, rareza, tipoSeleccionado.toLowerCase(), bonificacion);
		                break;

		            case "Supporter":
		                int efectos = Integer.parseInt(txtEfectos.getText());

		                if (efectos < 0) {
		                    JOptionPane.showMessageDialog(this, "Los efectos por turno no pueden ser negativos.");
		                    return;
		                }

		                cartaNueva = new Supporter(nombre, rareza, tipoSeleccionado.toLowerCase(), efectos);
		                break;

		            case "Energy":
		                String elemento = txtElemento.getText();
		                cartaNueva = new Energy(nombre, rareza, tipoSeleccionado.toLowerCase(), elemento);
		                break;
		        }

		        SistemaImp.getInstance().getColeccion().add(cartaNueva);
		        SistemaImp.guardarCambiosCartas();
		        actualizarLista();
		        limpiar();

		    } catch (NumberFormatException e) {
		        JOptionPane.showMessageDialog(this, "Revisa que Rareza y los atributos numericos sean numeros validos.");
		    }
		}
	 //metodo para modificar una carta seleccionada, consta de buscar la instancia de la carta para confirmar los cambios y setearlos  
	 private void modificar() {
		    int idx = lista.getSelectedIndex();
		    if (idx < 0) {
		        JOptionPane.showMessageDialog(this, "Selecciona una carta para modificar.");
		        return;
		    }

		    try {
		        Carta c = sistema.getColeccion().get(idx);

		        if (c instanceof Pokemon) {
		            Pokemon p = (Pokemon) c;
		            int dano = Integer.parseInt(txtDanio.getText());
		            int cantEnergia = Integer.parseInt(txtCantEnerg.getText());

		            if (dano < 0) {
		                JOptionPane.showMessageDialog(this, "El daño no puede ser negativo.");
		                return;
		            }
		            if (cantEnergia < 0) {
		                JOptionPane.showMessageDialog(this, "La cantidad de energías no puede ser negativa.");
		                return;
		            }

		            p.setDano(dano);
		            p.setCantEnergia(cantEnergia);

		        } else if (c instanceof Item) {
		            Item item = (Item) c;
		            int bonificacion = Integer.parseInt(txtBonificacion.getText());

		            if (bonificacion < 0) {
		                JOptionPane.showMessageDialog(this, "La bonificación no puede ser negativa.");
		                return;
		            }

		            item.setBonificacion(bonificacion);

		        } else if (c instanceof Supporter) {
		            Supporter s = (Supporter) c;
		            int efectos = Integer.parseInt(txtEfectos.getText());

		            if (efectos < 0) {
		                JOptionPane.showMessageDialog(this, "Los efectos por turno no pueden ser negativos.");
		                return;
		            }

		            s.setEfectosPorTurno(efectos);

		        } else if (c instanceof Energy) {
		            Energy en = (Energy) c;
		            en.setElemento(txtElemento.getText());
		        }

		        SistemaImp.guardarCambiosCartas();
		        actualizarLista();
		        JOptionPane.showMessageDialog(this, "Carta modificada correctamente.");

		    } catch (NumberFormatException e) {
		        JOptionPane.showMessageDialog(this, "Revisa que los atributos numéricos sean válidos.");
		    }
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
