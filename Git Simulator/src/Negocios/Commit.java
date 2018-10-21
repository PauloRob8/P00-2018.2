package Negocios;

import modelo.*;

public class Commit {
	
	public String message;
	
	
	public Commit(String m) {
		this.message = m;
	}
	
	public void commitar(Arquivo a) {
		a.status = "commited";

	}

	
}
