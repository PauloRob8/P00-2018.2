package modelo;

import java.util.ArrayList;

public class Lista implements Cloneable{
	
	public String nome;
	public ArrayList<Cartao> cartoes = new ArrayList();
	public boolean arquivado;

	
	
	public Lista(String n) {
		this.nome = n;
	}
	
	public void setNome(String n) {
		this.nome = n;
	}
	
	@Override
    public Lista clone() throws CloneNotSupportedException {
        return (Lista) super.clone();
    }
	
	public void adicionarCartao(String nome) {
		Cartao card = new Cartao(nome,this.nome);
		card.log.add("O usuário adicionou este cartão a lista" + this.nome);
		this.cartoes.add(card);
	}
	
	
	//Arquiva ou restaura uma lista
	public void arquivarLista() {
		this.arquivado = !this.arquivado;
		
	}
	
	
	public void arquivarTodosCartoes() {
		for(int i = 0; i < this.cartoes.size(); i++ ){
			this.cartoes.get(i).arquivado = true;
			this.cartoes.get(i).log.add("O usuário aquivou este cartão");
		}
	}

}
