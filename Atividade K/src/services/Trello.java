package services;

import java.util.ArrayList;

import modelo.*;

public class Trello {
	
	public Quadro quadro;
	public Lista lista;
	public Cartoes cartoes;
	public Etiqueta etiquetas;
	public ArrayList<Quadro> quadros = new ArrayList();
	
	
	//Usando sobrecarga para os diferentes tipos de mover listas e cartões, mover entre posições ou quadros e etc.

	public void moverLista(int posicao,Lista l) {
		if(this.quadro.listas.get(posicao) == null) {
			this.quadro.listas.add(posicao, l);
		}
		else {
			Lista temp = this.quadro.listas.get(posicao);
			this.quadro.listas.add(posicao,l);
			this.quadro.listas.add(l.posicao, temp);
		}
			
	}
	
	public void moverLista(Quadro q,Lista l) {
		
	}
	
	public void moverCartao() {
		
	}
	
	
	public void removerLista(Quadro q){
		for(int i = 0; i < q.listas.size();i++){
			if(q.listas.get(i).arquivado == true)
				q.listas.remove(i);
		}
		
	}
	
	public void removerCartao(Lista l){
		for(int i = 0; i < l.cartoes.size();i++){
			if(l.cartoes.get(i).arquivado == true)
				l.cartoes.remove(i);
		}
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
	
	public Cartoes acessarCartao(String card,String nomeLista,String nomeQ) {
		for(int i = 0; i < this.acessaLista(nomeLista, nomeQ).cartoes.size();i++)
			if(this.acessaLista(nomeLista, nomeQ).cartoes.get(i).nome.equals(card))
				return this.acessaLista(nomeLista, nomeQ).cartoes.get(i);
		
		return null;
	}
	
	public void adicionarEtiqueta(String nomeE,String cor,String card,String lista,String quadro) {
	this.acessarCartao(card, lista, quadro).addEtiqueta(nomeE, cor);
	}
}
