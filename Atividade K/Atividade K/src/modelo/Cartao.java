package modelo;

import java.util.ArrayList;

public class Cartao {
	
	public String nome;
	public String lista;
	public String descricao;
	public boolean arquivado;
	public ArrayList<String> comentarios = new ArrayList();
	public ArrayList<Etiqueta> etiquetas = new ArrayList();
	public ArrayList<String> log = new ArrayList();
	
	
	public Cartao(String nome,String nomelista) {
		this.nome = nome;
		this.lista = nomelista;
		
	}
	
	public void addEtiqueta(String nome,String cor) {
		this.etiquetas.add(new Etiqueta(nome,cor));
		
	}
	
	public void arquivarCartao(){
		if(this.arquivado == false) {
			this.arquivado = true;
			this.log.add("O usuário arquivou este cartão");
		}
		else
			this.arquivado = false;
			this.log.add("O usuário enviou este cartão ao quadro");
	}
	
	
	public void addComentario(String c) {
		this.comentarios.add(c);
		this.log.add("O usuário adicionou o comentário " + c);
	}
	
	public void addDescricao(String d) {
		this.descricao = d;
	}

}
