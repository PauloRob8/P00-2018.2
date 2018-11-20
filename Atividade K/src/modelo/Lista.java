package modelo;

import java.util.ArrayList;

public class Lista {
	
	public String nome;
	public ArrayList<Cartoes> cartoes = new ArrayList();
	public int posicao;
	public boolean arquivado;
	
	
	public Lista(String n) {
		this.nome = n;
	}
	
	public Lista(String n,int p) {
		this.nome = n;
		this.posicao = p;
	}
	
	
	public void adicionarCartao(String nome) {
		Cartoes card = new Cartoes(nome,this.nome);
		card.log.add("O usuário adicionou este cartão a lista" + this.nome);
		this.cartoes.add(card);
	}
	
	public void arquivarLista() {
		this.arquivado = true;
	}
	
	public void restaurarLista() {
		this.arquivado = false;
	}
	
	public void arquivarTodosCartoes() {
		for(int i = 0; i < this.cartoes.size(); i++ ){
			this.cartoes.get(i).arquivado = true;
			this.cartoes.get(i).log.add("O usuário aquivou este cartão");
		}
	}
	
	

}
