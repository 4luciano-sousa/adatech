package ada.com.projeto.conta;

import ada.com.projeto.cliente.Cliente;

public interface Conta {
	
	Cliente getCliente();

	String getNumero();

	void depositar(double valor);

	void sacar(double valor);

	void transferir(double valor, Conta contaDestino);

	double consultarSaldo();
}