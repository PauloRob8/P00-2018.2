package modelo;

public class Arquivo {
	
	public String nome;
	public String status = "untracked";
	public String tipo;
	public String conteudo;
	public boolean editado = false;
	public boolean removido = false;
	
	public Arquivo(String n,String tipo) {
		this.nome = n;
		this.tipo = tipo;
	}
	
	public void editar(String novo) {
		this.conteudo = novo;
		this.editado = true;
		
	}
	
	public void add() {
		this.status = "Stage Zone";
	}
	
	public void reset() {
		this.editado = false;
		this.status = "untracked";
	}
}
