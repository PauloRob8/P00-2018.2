package services;

import java.util.ArrayList;

import modelo.*;

public class Trello {
	
	public Quadro quadro;
	public Lista lista;
	public Cartoes cartoes;
	public Etiqueta etiquetas;
	public ArrayList<Lista> listasArquivadas = new ArrayList();
	public ArrayList<Cartoes> cartoesArquivados = new ArrayList();
	
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
	
	public void arquivarLista(Lista l) {
		this.listasArquivadas.add(l);
		this.quadro.listas.remove(l.posicao);
	}
	
	public void arquivarTodosCartoes(Lista l,Cartoes c) {
		for(int i = 0; i < l.cartoes.size(); i++ )
			this.cartoesArquivados.add(l.cartoes.get(i));
			l.cartoes.clear();
		
	}
	
	public String menu1() {
		return "Bem-Vindo ao Trello Simulator!\n1-> Adicionar Quadro\n2-> Acessar Quadro\n3-> Listar Quadros\n0-> Sair";
	}

}
