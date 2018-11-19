package modelo;

import java.util.ArrayList;

public class Quadro {
	
	public String membros;
	public String nome;
	public boolean privado = true;
	public String tema;
	public ArrayList<Lista> listas = new ArrayList();
	public boolean favorito = false;
	public int contLista = 3;
	
	
	public Quadro(String nome,boolean pri,String tema) {
		this.nome = nome;
		this.privado = pri;
		this.tema = tema;
		this.listas.add(0, new Lista("A fazer"));
		this.listas.add(1, new Lista("Fazendo"));
		this.listas.add(2, new Lista("Conclu�do"));
	}
	
	
	public void adicionarLista(String nome) {
		listas.add(this.contLista,new Lista(nome,this.contLista));
		this.contLista++;
	}
	
	public void alterarTema(String tema) {
		this.tema = tema;
	}
	
	public void alterarPrivacidade() {
		if(this.privado == true)
			this.privado = false;
		
		else if(this.privado == false)
			this.privado = true;
	}
	
	public void alterarFavorito() {
		if(this.favorito == true)
			this.favorito = false;
		
		else if(this.favorito == false)
			this.favorito = true;
	}
	

}
