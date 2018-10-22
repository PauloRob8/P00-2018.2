package negocios;

public class Agencia {
	
	public ContaBancaria[] contas = new ContaBancaria[50];
	public int numeroAgencia;
	public String endereco;
	public int contContas = 0;
	
	public Agencia(int numero) {
		this.numeroAgencia = numero;
	}
	
	public String novaConta(ContaBancaria c) {
		if(c.agencia == this.numeroAgencia) {
			this.contas[contContas] = c;
			this.contContas ++;
			return "Conta criada com sucesso!";
		}
		else {
			return "A conta pertence a outra agência";
		}
	}
	
	public int qtdContas() {
		return this.contContas;
	}
	
	public ContaBancaria getConta(int i) {
		return this.contas[i];
		
	}

}
