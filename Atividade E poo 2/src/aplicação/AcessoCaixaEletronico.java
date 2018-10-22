package aplicação;

import javax.swing.JOptionPane;

import negocios.*;

public class AcessoCaixaEletronico {
	
	public static void main(String agrs[]) {
		
		CaixaEletronico caixa = new CaixaEletronico();
		
		ContaBancaria conta1 = new ContaBancaria("João",1234,1,1000.0,1);
		ContaBancaria conta2 = new ContaBancaria("Pedro",12345,1,700,2);
		ContaBancaria conta3 = new ContaBancaria("Jonson",123,1,800,3);
		
		Agencia Caixa = new Agencia(1);
		
		Caixa.novaConta(conta1);
		Caixa.novaConta(conta2);
		Caixa.novaConta(conta3);
		
		//considerando apenas uma agencia pra o uso do caixa eletronico
		
		int log = Integer.parseInt(JOptionPane.showInputDialog(null,caixa.login()));
		while(log != 0) {
		if(log == 2) {
			double valor = Double.parseDouble(JOptionPane.showInputDialog(null,"Insira o valor a ser depositado:"));
			int numConta = Integer.parseInt(JOptionPane.showInputDialog(null,"Insira o número da conta:"));
			for(int i = 0;i < Caixa.qtdContas();i++)
				if(numConta == Caixa.contas[i].numeroConta)
					System.out.println(caixa.depositar(Caixa.contas[i], valor));
					log = Integer.parseInt(JOptionPane.showInputDialog(null,caixa.login()));
		}
		
		else if(log == 1) {
			String titular = JOptionPane.showInputDialog(null,"Digite seu nome: ");
			int cpf = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite seu cpf: "));
			
			for(int i = 0;i < Caixa.qtdContas();i++)
				if(cpf == Caixa.contas[i].cpfTitular) {
					int option = Integer.parseInt(JOptionPane.showInputDialog(null,caixa.menu()));
					while(option != 0) {
						switch(option) {
							case 1:
								JOptionPane.showMessageDialog(null, "Bem-Vindo! " + titular);
								System.out.println(caixa.sacar(Caixa.contas[i],Double.parseDouble((JOptionPane.showInputDialog(null,"Digite valor a ser sacado:")))));
								option = Integer.parseInt(JOptionPane.showInputDialog(caixa.menu()));
								System.out.println("Novo saldo:" + Caixa.contas[i].getSaldo());
								break;
											
							case 2:
								double valorT = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite valor a ser transferido: "));
								int nConta = Integer.parseInt((JOptionPane.showInputDialog(null,"Digite o número da conta destino: ")));
								for(int x = 0;x < Caixa.qtdContas(); x++)
									if(Caixa.contas[x].numeroConta == nConta)
										System.out.println(caixa.transferir(Caixa.contas[i], Caixa.contas[x], valorT));
							
							case 3:
								JOptionPane.showMessageDialog(null, "Seu saldo atual é "+ Caixa.contas[i].getSaldo());
								option = Integer.parseInt(JOptionPane.showInputDialog(caixa.menu()));
								break;		
									
			}
					
		}log = Integer.parseInt(JOptionPane.showInputDialog(null,caixa.login()));
		

	}
	JOptionPane.showMessageDialog(null,"Credencias incorretas!");
	log = Integer.parseInt(JOptionPane.showInputDialog(null,caixa.login()));			
   }
 }
	}
}
