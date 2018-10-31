package App;

import java.util.ArrayList;

import modelo.*;

public class Android {
	
	public ArrayList<Aplicativo> aplicativos = new ArrayList();
	
	
	public void instalaApp(Aplicativo ap) {
		this.aplicativos.add(ap);
		
	}
	
	public void desinstalarApp(Aplicativo ap) {
		if(this.aplicativos.contains(ap))
			this.aplicativos.remove(ap);
		
	}

}
