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
		return "Você está no quadro " + nomeQ + "\n1-> Alterar Privacidade\n2-> Favoritar/Desfavoritar\n3-> Adicionar Lista"
				+ "\n4-> Acessar Lista\n5-> Arquivar/Restaurar lista\n6-> Mover Lista\n7-> Copiar Lista\n8-> Remover Lista\n0-> Sair";
	}
	
	public String menu3(String nomeLista) {
		return "Ações da lista " + nomeLista + "\n1-> Adicionar Cartão\n2->Acessar Cartão\n3-> Mover todos os cartões desta lista\n4-> Arquivar todos os cartões desta lista\n->0 Sair";
		
	}
	
	public String menu3(String card,String lista) {
		return "Cartão " + card + " na lista " + lista + "\n1-> Adicionar Etiqueta\n2-> Criar uma Descrição\n"
				+ "3->Adicionar Comentário\n4-> Registro de atividades\n5-> Arquivar/Restaurar Cartão\n6-> Mover Cartão\n7-> remover cartão\n->0 Sair"; 
		
	}
	
	
	public String listarQuadros(){
		String quadros = "";
		if(!this.listador.quadros.isEmpty()){
			for(int i = 0; i < this.listador.quadros.size();i++){
				quadros = quadros + "Quadro-> " + this.listador.quadros.get(i).nome + " Possui " + 
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
		String listsArq = "";
		if(!this.listador.quadros.isEmpty()){
			for(int i = 0; i < this.listador.acessaQuadro(nomeDoQuadro).listas.size();i++){
				if(this.listador.acessaQuadro(nomeDoQuadro).listas.get(i).arquivado == false)
					lists = lists + "Lista-> " + this.listador.acessaQuadro(nomeDoQuadro).listas.get(i).nome + "\n";
				
				else if(this.listador.acessaQuadro(nomeDoQuadro).listas.get(i).arquivado == true)
					listsArq = listsArq + "Lista-> " + this.listador.acessaQuadro(nomeDoQuadro).listas.get(i).nome + "\n";
			}
		}
		else{
			lists = "Você não possui listas";
			listsArq = "Ainda não há listas arquivadas";
		}
		
		return "*---Listas---*\n" + lists + "\n*---Listas Arquivadas---*\n" + listsArq;
			
		}
	

	public String listarCartoes(String nomeQ,String nomeDaLista){
		String cards = "";
		String cardArq = "";
		if(!this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.isEmpty()){
			for(int i = 0; i < this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.size();i++){
				if(this.listador.acessaLista(nomeDaLista, nomeQ).cartoes.get(i).arquivado == false)
					cards = cards + "Cartão-> " + this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.get(i).nome + " " + " possui " + 
					this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.get(i).etiquetas.size() + " Etiquetas e possui " + 
					this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.get(i).comentarios.size() + "comentários \n";
				
				else if(this.listador.acessaLista(nomeDaLista, nomeQ).cartoes.get(i).arquivado == true) {
					cardArq = cardArq + "Cartão-> " + this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.get(i).nome + " " + " possui " + 
					this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.get(i).etiquetas.size() + " Etiquetas e possui " + 
					this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.get(i).comentarios.size() + "comentários \n";
				}
			}
		}
		else{
			cards = "\nVocê não possui cartões\n";
			cardArq = "\nAida não há cartões arquivados\n";
		}
		
		return "\n *---Cartões---*\n" + cards + "\n*---Cartões Arquivados---*\n" + cardArq +"\n";
			
		}
	
	public String infoCartao(String nomeQ,String nomeLista,String card) {
		String infoCard = "\nDescrição: " + this.listador.acessarCartao(card, nomeLista, nomeQ).descricao + "\n Etiquetas: \n";
		if(!this.listador.acessarCartao(card, nomeLista, nomeQ).etiquetas.isEmpty())
			for(int j = 0; j < this.listador.acessarCartao(card, nomeLista, nomeQ).etiquetas.size();j++)
				infoCard = infoCard + "Etiqueta-> " + this.listador.acessarCartao(card, nomeLista, nomeQ).etiquetas.get(j).nome + "\n";
		if(!this.listador.acessarCartao(card, nomeLista, nomeQ).comentarios.isEmpty())
			for(int i = 0; i < this.listador.acessarCartao(card, nomeLista, nomeQ).comentarios.size();i++)
			infoCard = infoCard + "Comentário-> " + this.listador.acessarCartao(card, nomeLista, nomeQ).comentarios.get(i) + "\n";
		else
			infoCard += "\n não há comentários";
		
		return infoCard;
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
