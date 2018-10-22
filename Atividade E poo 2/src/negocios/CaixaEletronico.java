package negocios;

public class CaixaEletronico {
	
	
	public String sacar(ContaBancaria c,double valor) {
		if(c.getSaldo() >= valor) {
			c.setSaldo(c.getSaldo() - valor);
			return "Saque realizado com sucesso!";
		}
		else
			return "valor inválido";
				
	}
	
	public String transferir(ContaBancaria cRemetente,ContaBancaria cDestino,double valor) {
		if(cRemetente.getSaldo() >= valor) {
			cRemetente.setSaldo(cRemetente.getSaldo() - valor);
			cDestino.setSaldo(cDestino.getSaldo() + valor);
			return "Transferencia realizada com sucesso!";
		}
		else 
			return "Valor ou conta inválida";
		
	}
	
	public String depositar(ContaBancaria c,double valor) {
		if(valor > 0) {
			c.setSaldo(c.getSaldo() + valor);
			return "Deposito realizado com sucesso";
		}
		else
			return "Valor inválido";
				
	}
	
	public String menu() {
		return "Realize sua operação:\n 1-> Saque\n 2-> Transferir\n 3-> Saldo\n 0-> Sair";
	}
	
	public String login() {
		return "Bem-Vindo!\n 1-> Login\n 2-> Depositar\n 0-> Sair";
	}
}
