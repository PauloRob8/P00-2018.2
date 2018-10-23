package modelo;

import java.util.ArrayList;

public class Commit {
	
	public String message;
	public int qtdArtigo;
	public String data;
	public int qtdArquivos;
	public ArrayList<Arquivo> commited = new ArrayList();
	
	public Commit(String m,int qtd,String date,ArrayList<Arquivo> lista) {
		this.message = m;
		this.qtdArquivos = qtd;
		this.data = date;
		this.commited = lista;
	}
	
	
}
