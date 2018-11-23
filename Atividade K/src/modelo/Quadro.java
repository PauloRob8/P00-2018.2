package modelo;

import java.util.ArrayList;

public class Quadro {
	
	public String nome;
	public boolean privado;
	public String tema;
	public ArrayList<Lista> listas = new ArrayList();
	public boolean favorito;
	
	
	public Quadro(String nome,boolean pri,String tema) {
		this.nome = nome;
		this.privado = pri;
		this.tema = tema;
	}
	
	
	public void adicionarLista(String nome) {
		listas.add(new Lista(nome));
	}
	
	public void alterarTema(String tema) {
		this.tema = tema;
	}
	
	public void alterarPrivacidade() {
		this.privado = !this.privado;
	}
	
	public void alterarFavorito() {
		this.favorito = !this.favorito;
	}
	
}