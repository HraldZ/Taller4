package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import Dominio.*;
import Logica.*;
import Strategy.Strategy;
import Strategy.StrategyAbc;
import Visitor.visitarPoder;


public class VentanaColeccion extends JDialog {
	
	private final SistemaImp sistema = SistemaImp.getInstance();
	public static Color azul    = new Color(52, 100, 180);
	public static Color blanco  = Color.WHITE;
	private DefaultListModel<String> modeloLista = new DefaultListModel<>();
	private JList<String> lista = new JList<>(modeloLista);
	private ArrayList<Carta> cartasVisibles = new ArrayList<>();
	private JLabel lblTotal = new JLabel("Total: 0 cartas");

	public VentanaColeccion(JFrame padre) {
		super(padre,"Ver Coleccion",false);
		setSize(650,500);
		setLocationRelativeTo(padre);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setLayout(new BorderLayout(6,6));
		
		add(panelOrdenar(),BorderLayout.NORTH);
		add(crearPanelLista(), BorderLayout.CENTER);
		add(clickCarta(),BorderLayout.SOUTH);
		
		cargarSinOrden();
		
		setVisible(true);

	}

	
	private JPanel panelOrdenar() {
		JPanel panelo = new JPanel( new FlowLayout());
		panelo.setBorder(BorderFactory.createTitledBorder("Ordenar por"));
		
		JButton rareza  = boton("Rareza",azul);
        JButton nombre  = boton("Nombre",azul);
        JButton poder   = boton("Poder",azul);
       
        
        
        
        
        nombre.addActionListener(e->{
        
        	SistemaImp.getInstance().OrdenarPorAbc(cartasVisibles);
        	actualizarLista();
        });
        
        
        rareza.addActionListener(e->{
            
        	SistemaImp.getInstance().OrdenarPorRareza(cartasVisibles);
        	actualizarLista();
        });
        
        
        poder.addActionListener(e->{
            
        	SistemaImp.getInstance().OrdenarPorPoder(cartasVisibles);
        	actualizarLista();
        });
        
        
        
        
        
        
        
        
        
        
		
        
        rareza.setPreferredSize(new Dimension(100, 32));
        nombre.setPreferredSize(new Dimension(100, 32));
        poder.setPreferredSize(new Dimension(100, 32));
       
        
        panelo.add(rareza);
        panelo.add(nombre);
        panelo.add(poder);
        
        return panelo;
	
        
        
        
        
        
        
	}
	
	
	private JPanel clickCarta() {
		JPanel panel = new JPanel(new BorderLayout());
		
		
		JLabel detalle = new JLabel("Clic en una carta para ver detalles");
		detalle.setFont(new Font("SansSerif",Font.ITALIC,11));
		detalle.setForeground(blanco);
		panel.add(detalle,BorderLayout.EAST);
		return panel;
			
	}
	
	private JScrollPane crearPanelLista() {
        lista.setFont(new Font("Monospaced", Font.PLAIN, 12));
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        lista.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int idx = lista.locationToIndex(e.getPoint());
                if (idx >= 0 && idx < cartasVisibles.size()) {
                    //new DialogDetalle(padre, cartasVisibles.get(idx));
                }
            }
        });

        return new JScrollPane(lista);
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
	
	private void cargarSinOrden() {
        cartasVisibles = new ArrayList<>(sistema.getColeccion());
        actualizarLista();
    }
	
	private void actualizarLista() {
        modeloLista.clear();
        for (int i = 0; i < cartasVisibles.size(); i++) {
            Carta c = cartasVisibles.get(i);
            //falta calcular poder
            modeloLista.addElement(String.format("%-3d %-28s %-12s Rareza:%-2d  ",
                    i+1, c.getNombre(), "["+c.getTipo()+"]", c.getRareza()) + "Poder : " + c.accept(new visitarPoder()));
        }
        lblTotal.setText("Total: " + cartasVisibles.size() + " cartas");
    }
	

	
	
	
	
	
	
	
	
	
	
}
