package app;

import javax.swing.JOptionPane;

import modelo.*;
import services.Listador;
import services.Trello;

public class TrelloSimulator {
	
	public static void main(String[] args) {
		
		Trello trello = new Trello();
		Listador listador = new Listador(trello);
		
		int option1 = Integer.parseInt((JOptionPane.showInputDialog(listador.menu1())));
		while(option1 != 0) {
			switch(option1) {
			case 1:
				
				String nome = JOptionPane.showInputDialog("Digite o nome do seu quadro: ");
				boolean priv = Boolean.parseBoolean(JOptionPane.showInputDialog("Especifique a privacidade do quadro (true para privado ou false para público"));
				String tema = JOptionPane.showInputDialog("Digite o tema ");
				
				trello.criaQuadro(nome, priv, tema);
				option1 = Integer.parseInt((JOptionPane.showInputDialog(listador.menu1())));
				
				break;
			
			case 2:
				
				String quadro = JOptionPane.showInputDialog("Digite o nome do quadro que deseja acessar: ");
				if(trello.acessaQuadro(quadro) != null) {
					int option2 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu2(quadro)));
					while(option2 != 0) {
						switch(option2) {
						case 1:
							String nomeLista = JOptionPane.showInputDialog("Digite nome da sua lista: ");
							trello.criaLista(nomeLista, quadro);
							option2 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu2(quadro)));
							
						case 2:
							System.out.println(listador.listarListas(quadro));
							option2 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu2(quadro)));
							break;
							
						case 3:
							String lista = JOptionPane.showInputDialog("Digite o nome da lista em que deseja adicionar um cartão");
							if(trello.acessaLista(lista, quadro) != null) {
								String card = JOptionPane.showInputDialog("Digite o nome do seu cartão: ");
								trello.adicionarCartao(card, lista, quadro);
							}
							
							else
								JOptionPane.showMessageDialog(null, "Lista não encontrada");
							
							option2 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu2(quadro)));
							break;
							
						case 4:
							String listaCard = JOptionPane.showInputDialog("Digite a lista em que seu card se encontra: ");
							if(trello.acessaLista(listaCard, quadro) != null) {
								String cartao = JOptionPane.showInputDialog("Insira nome do cartão que deseja acessar: ");
								if(trello.acessarCartao(cartao, listaCard, quadro) != null) {
									int option3 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu3(cartao, listaCard)));
									while(option3 != 0) {
										switch(option3) {
										case 1:
											String nomeE = JOptionPane.showInputDialog("Insira o nome da etiqueta: ");
											String cor = JOptionPane.showInputDialog("Insira a cor da etiqueta: ");
											trello.adicionarEtiqueta(nomeE, cor, cartao, listaCard, quadro);
											option3 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu3(cartao, listaCard)));
											break;
											
										case 2:
											
											break;
											
											
										case 3:
											break;
											
										case 4:
											break;
										
										}
									}
									
								}
							}
							option2 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu2(quadro)));
							break;
							
						}
					}
					
					}
				else
					JOptionPane.showMessageDialog(null,"Esse quadro não existe");
				
				option1 = Integer.parseInt((JOptionPane.showInputDialog(listador.menu1())));
				break;
				
			case 3:
				
				System.out.println(listador.listarQuadros());
				option1 = Integer.parseInt((JOptionPane.showInputDialog(listador.menu1())));
				
				break;
			}
		}
	}

}
