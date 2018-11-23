package DataAccessLayer;

import java.util.ArrayList;

import modelo.*;

public class Dados {

	public ArrayList<Quadro> quadros = new ArrayList();
	
	
	public void salvarQuadro(Quadro q) {
		this.quadros.add(q);
	}
	
}
