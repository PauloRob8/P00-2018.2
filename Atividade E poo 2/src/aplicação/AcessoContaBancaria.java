package aplicação;

import negocios.*;

public class AcessoContaBancaria {

	public static void main(String[] args) {
		
		ContaBancaria conta1 = new ContaBancaria("João",1234,1,1000.0,1);
		ContaBancaria conta2 = new ContaBancaria("Pedro",12345,1,700,2);
		ContaBancaria conta3 = new ContaBancaria("Jonson",123,2,800,3);
		
		Agencia BB = new Agencia(1);
		Agencia Caixa = new Agencia(2);
		
		
		System.out.println(BB.novaConta(conta2));
		System.out.println(BB.novaConta(conta1));
		System.out.println(Caixa.novaConta(conta3));
		
		System.out.println(BB.qtdContas());
		System.out.println(Caixa.qtdContas());
		
		System.out.println(BB.contas[1].titular);

		
	}
}
