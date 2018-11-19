package app;

import javax.swing.JOptionPane;

import modelo.*;

import services.Trello;

public class TrelloSimulator {
	
	public static void main(String[] args) {
		
		Trello trello = new Trello();
		
		int option1 = Integer.parseInt((JOptionPane.showInputDialog(trello.menu1())));
		while(option1 != 0) {
			switch(option1) {
			case 1:
				
				String nome = JOptionPane.showInputDialog("Digite o nome do seu quadro: ");
				boolean priv = Boolean.parseBoolean(JOptionPane.showInputDialog("Especifique a privacidade do quadro (true para privado ou false para público"));
				String tema = JOptionPane.showInputDialog("Digite o tema ");
				
				trello.criaQuadro(nome, priv, tema);
				option1 = Integer.parseInt((JOptionPane.showInputDialog(trello.menu1())));
				
				break;
			
			case 2:
				
				
				break;
				
			case 3:
				
				System.out.println(trello.listarQuadros());
				option1 = Integer.parseInt((JOptionPane.showInputDialog(trello.menu1())));
				
				break;
			}
		}
	}

}

