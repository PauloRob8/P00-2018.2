package negocios;

public class ContaBancaria {
	
	public String titular;
	public int numeroConta;
	private double saldo;
	public int agencia;
	public int cpfTitular;
	
	public ContaBancaria(String t,int cpf,int agencia,double s,int num) {
		this.titular = t;
		this.saldo = s;
		this.cpfTitular = cpf;
		this.agencia = agencia;
		this.numeroConta = num;
	}
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
	

