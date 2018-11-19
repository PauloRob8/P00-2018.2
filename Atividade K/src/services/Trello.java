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
	
	public void moverCartao(int posicao,Lista l) {
		
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
	
	
	public String menu1() {
		return "Bem-Vindo ao Trello Simulator!\n1-> Adicionar Quadro\n2-> Acessar Quadro\n3-> Listar Quadros\n0-> Sair";
	}
	
	public String listarQuadros(){
		String quadros = "";
		if(!this.quadros.isEmpty()){
			for(int i = 0; i < this.quadros.size();i++){
				quadros = quadros + "Quadro-> " + this.quadros.get(i).nome + " Possui" + 
				this.quadros.get(i).listas.size() + " listas" + "\n";
			}
		}
		else{
			quadros = "Você não possui quadros";
		}
		
		return quadros;
			
		}
	
	public void criaQuadro(String nome,boolean privado,String tema){
		this.quadros.add(new Quadro(nome,privado,tema));
		
	}
	
	
}
