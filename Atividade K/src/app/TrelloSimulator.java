package app;

import javax.swing.JOptionPane;

import modelo.*;
import services.Listador;
import services.Trello;

public class TrelloSimulator {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		Trello trello = new Trello();
		Listador listador = new Listador(trello);
		
		int option1 = Integer.parseInt((JOptionPane.showInputDialog(listador.menu1())));
		while(option1 != 0) {
			switch(option1) {
			case 1:
				
				String nome = JOptionPane.showInputDialog("Digite o nome do seu quadro: ");
				boolean priv = Boolean.parseBoolean(JOptionPane.showInputDialog("Especifique a privacidade do quadro (true para privado ou false para público)"));
				String tema = JOptionPane.showInputDialog("Digite o tema ");
				
				trello.criaQuadro(nome, priv, tema);
				option1 = Integer.parseInt((JOptionPane.showInputDialog(listador.menu1())));
				
				break;
			
			case 2:
				
				String quadro = JOptionPane.showInputDialog("Digite o nome do quadro que deseja acessar: ");
				if(trello.acessaQuadro(quadro) != null) {
					int option2 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu2(quadro) + "\n" + listador.listarListas(quadro)));
					while(option2 != 0) {
						switch(option2) {
						case 1:
							trello.acessaQuadro(quadro).alterarPrivacidade();
							JOptionPane.showMessageDialog(null, "Privacidade alterada");
							option2 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu2(quadro)+ "\n" + listador.listarListas(quadro)));
							
							break;
							
						case 2:
							
							trello.acessaQuadro(quadro).alterarFavorito();
							JOptionPane.showMessageDialog(null, "Alterado com sucesso !");
							option2 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu2(quadro)+ "\n" + listador.listarListas(quadro)));
							
							break;
							
						case 3:
							String nomeLista = JOptionPane.showInputDialog("Digite nome da sua lista: ");
							trello.criaLista(nomeLista, quadro);
							option2 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu2(quadro)+ "\n" + listador.listarListas(quadro)));
							break;
							
						case 4:
							String listaCard = JOptionPane.showInputDialog("Digite a lista a ser acessada: ");
							if(trello.acessaLista(listaCard, quadro)!= null) {
								int option3 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu3(listaCard)+ listador.listarCartoes(quadro, listaCard)));
								while(option3 != 0) {
									switch(option3) {
									case 1:
										
										String card = JOptionPane.showInputDialog("Digite o nome do seu cartão: ");
										trello.adicionarCartao(card, listaCard, quadro);
										option3 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu3(listaCard)+ listador.listarCartoes(quadro, listaCard)));
										
										break;
										
									case 2:
										String cartao = JOptionPane.showInputDialog("Insira nome do cartão que deseja acessar: ");
										if(trello.acessarCartao(cartao, listaCard, quadro) != null) {
											int option4 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu3(cartao, listaCard)+listador.infoCartao(quadro, listaCard, cartao)));
											while(option4 != 0) {
												switch(option4) {
												case 1:
													String nomeE = JOptionPane.showInputDialog("Insira o nome da etiqueta: ");
													String cor = JOptionPane.showInputDialog("Insira a cor da etiqueta: ");
													trello.adicionarEtiqueta(nomeE, cor, cartao, listaCard, quadro);
													option4 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu3(cartao, listaCard)+listador.infoCartao(quadro, listaCard, cartao)));
													break;
													
												case 2:
													
													String descri = JOptionPane.showInputDialog("Digite a descrição do cartão: ");
													trello.acessarCartao(cartao, listaCard, quadro).addDescricao(descri);
													option4 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu3(cartao, listaCard)+listador.infoCartao(quadro, listaCard, cartao)));
													break;
													
													
												case 3:
													String coment = JOptionPane.showInputDialog("Adicione um comentário: ");
													trello.acessarCartao(cartao, listaCard, quadro).addComentario(coment);
													option4 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu3(cartao, listaCard)+listador.infoCartao(quadro, listaCard, cartao)));
													break;
													
												case 4:
													JOptionPane.showMessageDialog(null,listador.registroAtividade(cartao, listaCard, quadro));
													option4 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu3(cartao, listaCard)+listador.infoCartao(quadro, listaCard, cartao)));
													break;
													
												case 5:
													trello.acessarCartao(cartao, listaCard, quadro).arquivarCartao();
													option4 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu3(cartao, listaCard)+listador.infoCartao(quadro, listaCard, cartao)));
													break;
													
												case 6:
												
													if(trello.acessaQuadro(quadro).listas.size() > 1) {
														String listamove1 = JOptionPane.showInputDialog("Digite a lista que recebera o cartão");
														trello.moverCartao(listaCard, listamove1, cartao, quadro);
													}
													else
														JOptionPane.showMessageDialog(null, "Não há outras listas adicionais para o cartão ser movido ");
													
													option4 = 0;
													break;
													
												case 7:
													trello.removerCartao(cartao, listaCard, quadro);
													option4 = 0;
													break;
													
													}
												}
												
											}
										option3 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu3(listaCard)+ listador.listarCartoes(quadro, listaCard)));
										break;
									
									case 3:
										if(trello.acessaQuadro(quadro).listas.size() > 1) {
											String listmov = JOptionPane.showInputDialog("Digite nome da lista que recebera os cartões");
											trello.moverTodosCartoes(listaCard, listmov,quadro);
											
										}
										
										else
											JOptionPane.showMessageDialog(null, "Não há listas adicionais para os cartões serem movidas");
										
										option3 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu3(listaCard)+ listador.listarCartoes(quadro, listaCard)));
										break;
										
									case 4:
										trello.acessaLista(listaCard, quadro).arquivarTodosCartoes();
										JOptionPane.showMessageDialog(null,"Cartões arquivados!");
										option3 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu3(listaCard)+ listador.listarCartoes(quadro, listaCard)));
										break;
									}
								}
							}
							option2 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu2(quadro)+ "\n" + listador.listarListas(quadro)));
							break;
							
						case 5:
							String arLista = JOptionPane.showInputDialog("Digite a lista a ser arquivada ou restaurada: ");
							trello.acessaLista(arLista, quadro).arquivarLista();
							option2 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu2(quadro)+ "\n" + listador.listarListas(quadro)));
							
							break;
							
						case 6:
							if(trello.quadros.size() > 1) {
								String listmove = JOptionPane.showInputDialog("Digite nome da lista que deseja mover: ");
								String qmove = JOptionPane.showInputDialog("Digite o nome do quadro para qual deseja mover:");
								trello.moverLista(quadro, qmove, listmove);
							}
							else
								JOptionPane.showMessageDialog(null, "Não há quadros adicionais para as listas serem movidas");
							
							option2 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu2(quadro)+ "\n" + listador.listarListas(quadro)));
							break;
							
						case 7:
							
							String copy = JOptionPane.showInputDialog("Digite nome da lista a ser copiada:");
							String nomeLista1 = JOptionPane.showInputDialog("Digite nome da lista copiada:");
							trello.copiarLista(quadro, copy, nomeLista1);
							option2 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu2(quadro)+ "\n" + listador.listarListas(quadro)));
							break;
							
						case 8:
							String remove = JOptionPane.showInputDialog("Digite nome da lista a ser removida:");
							trello.removerLista(remove, quadro);
							option2 = Integer.parseInt(JOptionPane.showInputDialog(listador.menu2(quadro)+ "\n" + listador.listarListas(quadro)));

							
							break;
							
							
						}
						
					}
					
					}
				else
					JOptionPane.showMessageDialog(null,"Esse quadro não existe");
				
				option1 = Integer.parseInt((JOptionPane.showInputDialog(listador.menu1())));
				break;
				
			case 3:
				JOptionPane.showMessageDialog(null,listador.listarQuadros());
				option1 = Integer.parseInt((JOptionPane.showInputDialog(listador.menu1())));
				
				break;
			}
		}
	}

}
