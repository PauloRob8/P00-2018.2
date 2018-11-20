package services;


//Classe criada pra evitar a sobrecarga de funções da classe Trello

public class Listador {
	
	Trello listador = new Trello();
	
	
	public Listador(Trello trello) {
		this.listador = trello;
	}
	
	public String menu1() {
		return "Bem-Vindo ao Trello Simulator!\n1-> Adicionar Quadro\n2-> Acessar Quadro\n3-> Listar Quadros\n0-> Sair";
	}
	
	public String menu2(String nomeQ) {
		return "Você Está no quadro " + nomeQ + "n\n1-> Adicionar Lista\n2-> Listar listas\n3->Adicionar Cartão há uma lista\n5->Acessar Cartão \n4-> Arquivar/Restaurar Lista"
				+ "\n5-> Arquivar todos os cartões desta Lista\n->6 Alterar Privacidae\n7-> Favoritar/Desfavoritar\n8-> Remover Lista\n0-> Sair";
	}
	
	public String menu3(String card,String lista) {
		return "Cartão " + card + " na lista " + lista + "\n1-> Adicionar Etiqueta\n2-> Criar uma Descrição\n"
				+ "3->Adicionar Comentário\n4-> Registro de atividades\n->5 Arquivar/Restaurar Cartão\n Remover Cartão\n->0 Sair"; 
		
	}
	
	
	public String listarQuadros(){
		String quadros = "";
		if(!this.listador.quadros.isEmpty()){
			for(int i = 0; i < this.listador.quadros.size();i++){
				quadros = quadros + "Quadro-> " + this.listador.quadros.get(i).nome + " Possui" + 
				this.listador.quadros.get(i).listas.size() + " listas" + "\n";
			}
		}
		else{
			quadros = "Você não possui quadros";
		}
		
		return quadros;
			
		}
	
	
	public String listarListas(String nomeDoQuadro){
		String lists = "";
		if(!this.listador.quadros.isEmpty()){
			for(int i = 0; i < this.listador.acessaQuadro(nomeDoQuadro).listas.size();i++){
				lists = lists + "Lista-> " + this.listador.acessaQuadro(nomeDoQuadro).listas.get(i).nome + " Possui" + 
				this.listador.acessaQuadro(nomeDoQuadro).listas.get(i).cartoes.size() + " Cartões" + "\n";
			}
		}
		else{
			lists = "Você não possui listas";
		}
		
		return lists;
			
		}
	

	public String listarCartoes(String nomeQ,String nomeDaLista){
		String cards = "";
		if(!this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.isEmpty()){
			for(int i = 0; i < this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.size();i++){
				cards = cards + "Cartão-> " + this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.get(i).nome + " " + " possui" + 
				this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.get(i).etiquetas.size() + " Etiquetas e possui" + 
				this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.get(i).comentarios.size() + "comentários \n";
			}
		}
		else{
			cards = "Você não possui listas";
		}
		
		return cards;
			
		}
	
	public String registroAtividade(String card,String nomeDaLista,String nomeQ) {
		String log = "";
		if(!this.listador.acessarCartao(card,nomeDaLista,nomeQ).log.isEmpty()){
			for(int i = 0; i < this.listador.acessarCartao(card,nomeDaLista,nomeQ).log.size();i++){
				log = log + this.listador.acessarCartao(card, nomeDaLista, nomeQ).log.get(i) + "\n";
			}
		}
		else{
			log = "Ainda não há registros";
		}
		
		return log;
	}

}
