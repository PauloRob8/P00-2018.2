package modelo;

import java.util.ArrayList;

public class Lista {
	
	public String nome;
	public ArrayList<Cartoes> cartoes = new ArrayList();
	public int posicao;
	
	
	public Lista(String n) {
		this.nome = n;
	}
	
	public Lista(String n,int p) {
		this.nome = n;
		this.posicao = p;
	}
	
	public void adicionarCartão(String nome) {
		this.cartoes.add(new Cartoes(nome,this.nome));
	}
	

}
