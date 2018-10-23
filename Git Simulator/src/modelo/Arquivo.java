package modelo;

import java.util.ArrayList;

public class Arquivo {
	
	public String nome;
	public String status = "untracked";
	public String tipo;
	public String conteudo = "";
	public boolean editado = false;
	public boolean removido = false;
	public ArrayList<String> mudanças = new ArrayList();
	
	public Arquivo(String n,String tipo) {
		this.nome = n;
		this.tipo = tipo;
	}
	
	public void editar(String novo) {
		this.conteudo = this.conteudo +"\n" + novo;
		this.mudanças.add(this.conteudo);
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
