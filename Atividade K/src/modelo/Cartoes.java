package modelo;

import java.util.ArrayList;

public class Cartoes {
	
	public String nome;
	public String lista;
	public String descricao;
	public ArrayList<String> comentarios = new ArrayList();
	public ArrayList<Etiqueta> etiquetas = new ArrayList();
	public ArrayList<String> log = new ArrayList();
	
	
	public Cartoes(String nome,String nomelista) {
		this.nome = nome;
		this.lista = nomelista;
		
	}
	
	
	public void addEtiqueta() {
		
	}
	
	
	public void addComentario(String c) {
		this.comentarios.add(c);
	}
	
	public void addDescricao(String d) {
		this.descricao = d;
	}

}
