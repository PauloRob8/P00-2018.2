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
				break;
			
			case 2:
				break;
				
			case 3:
				break;
			}
		}
	}

}
