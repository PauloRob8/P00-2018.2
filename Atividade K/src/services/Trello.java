package services;

import java.util.ArrayList;

import modelo.*;

public class Trello {
	
	public Quadro quadro;
	public Lista lista;
	public Cartao cartoes;
	public Etiqueta etiquetas;
	public ArrayList<Quadro> quadros = new ArrayList();
	
	
	public void moverLista(String q1,String q2,String lista) {
		this.acessaQuadro(q2).listas.add(this.acessaLista(lista, q1));
		this.acessaQuadro(q1).listas.remove(this.acessaLista(lista,q1));
		
		
	}
	
	public void moverCartao(String lista1,String lista2,String card,String quadro) {
		this.acessaLista(lista2, quadro).cartoes.add(this.acessarCartao(card, lista1, quadro));
		this.acessarCartao(card, lista1, quadro).log.add("Usuário moveu este cartão de " + 
		this.acessaLista(lista1, quadro).nome  + " para " + this.acessaLista(lista2, quadro).nome);
		this.acessaLista(lista1, quadro).cartoes.remove(this.acessarCartao(card, lista1, quadro));
		
		
	}
	
	public void moverTodosCartoes(String lista1,String lista2,String quadro) {
		for(int i = 0; i < this.acessaLista(lista1,quadro).cartoes.size();i++) {
			this.acessaLista(lista2, quadro).cartoes.add(this.acessaLista(lista1,quadro).cartoes.get(i));
			this.acessaLista(lista1, quadro).cartoes.get(i).log.add("Usuário moveu este cartão de "
			+this.acessaLista(lista1, quadro).nome + " para " + this.acessaLista(lista2, quadro).nome);
		}
		this.acessaLista(lista1, quadro).cartoes.clear();
		
	}
	
	public void copiarLista(String quadro,String lista,String nome) throws CloneNotSupportedException {
		Lista l = new Lista(nome);
		l = this.acessaLista(lista, quadro).clone();
		l.setNome(nome);
		this.acessaQuadro(quadro).listas.add(l);
	}
	
	
	public void removerLista(String lista,String quadro){
		if(this.acessaLista(lista, quadro).arquivado == true)
			this.acessaQuadro(quadro).listas.remove(this.acessaLista(lista, quadro));
		
	}
	
	public void removerCartao(String card, String list,String quadro){
		if(this.acessarCartao(card, list, quadro).arquivado == true)
			this.acessaLista(list,quadro).cartoes.remove(this.acessarCartao(card, list, quadro));
		
	}
	
	
	public void criaQuadro(String nome,boolean privado,String tema){
		this.quadros.add(new Quadro(nome,privado,tema));
		
	}
	
	public Quadro acessaQuadro(String nome){
		for(int i = 0; i < this.quadros.size();i++) {
			if(this.quadros.get(i).nome.equals(nome))
				return this.quadros.get(i);
		}
		
		return null;
		
	}
	
	public void criaLista(String nomeLista,String nomeQ) {
		this.acessaQuadro(nomeQ).adicionarLista(nomeLista);;
	}
	
	public Lista acessaLista(String nomeLista,String nomeQ) {
		for(int i = 0 ; i < this.acessaQuadro(nomeQ).listas.size(); i++) {
			if(this.acessaQuadro(nomeQ).listas.get(i).nome.equals(nomeLista))
				return this.acessaQuadro(nomeQ).listas.get(i);
		}
		return null;
	}
	
	public void adicionarCartao(String card,String nomeLista,String nomeQ) {
		this.acessaLista(nomeLista, nomeQ).adicionarCartao(card);
	}
	
	public Cartao acessarCartao(String card,String nomeLista,String nomeQ) {
		for(int i = 0; i < this.acessaLista(nomeLista, nomeQ).cartoes.size();i++)
			if(this.acessaLista(nomeLista, nomeQ).cartoes.get(i).nome.equals(card))
				return this.acessaLista(nomeLista, nomeQ).cartoes.get(i);
		
		return null;
	}
	
	public void adicionarEtiqueta(String nomeE,String cor,String card,String lista,String quadro) {
	this.acessarCartao(card, lista, quadro).addEtiqueta(nomeE, cor);
	}
}
