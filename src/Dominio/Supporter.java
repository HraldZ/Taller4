package Dominio;

public class Supporter extends Carta {

	protected int efectosPorTurno;

	public Supporter(String nombre, int rareza, String tipo, int efectosPorTurno) {
		super(nombre, rareza, tipo);
		this.efectosPorTurno = efectosPorTurno;
	}
	
	
	
}
