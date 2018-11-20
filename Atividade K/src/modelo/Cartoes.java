package modelo;

import java.util.ArrayList;

public class Cartoes {
	
	public String nome;
	public String lista;
	public String descricao;
	public boolean arquivado;
	public ArrayList<String> comentarios = new ArrayList();
	public ArrayList<Etiqueta> etiquetas = new ArrayList();
	public ArrayList<String> log = new ArrayList();
	
	
	public Cartoes(String nome,String nomelista) {
		this.nome = nome;
		this.lista = nomelista;
		
	}
	
	public void addEtiqueta(String nome,String cor) {
		this.etiquetas.add(new Etiqueta(nome,cor));
		
	}
	
	public void arquivarCartao(){
		this.arquivado = true;
		this.log.add("O usuário arquivou este cartão");
	}
	
	public void restaurarCartao(){
		this.arquivado = false;
		this.log.add("O usuário enviou este cartão ao quadro");
	}
	
	
	public void addComentario(String c) {
		this.comentarios.add(c);
	}
	
	public void addDescricao(String d) {
		this.descricao = d;
	}

}
