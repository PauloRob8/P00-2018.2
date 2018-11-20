package modelo;


public class Etiqueta {
	
	public String nome;
	public String cor;
	
	public Etiqueta(String n,String c) {
		this.nome = n;
		this.cor = c;
	}
	
	public void editarEiqueta(String n,String c) {
		this.nome = n;
		this.cor = c;
	}

}
