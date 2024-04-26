package ada.com.projeto;

public interface Conta {

	Cliente getCliente();

	IdentificadorConta getNumero();

	void depositar(double valor);

	boolean sacar(double valor);

	void transferir(double valor, Conta destino);

	double consultarSaldo();
}