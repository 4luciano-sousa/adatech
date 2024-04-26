package ada.com.projeto;

public class ContaFactory {

	public static Conta criarConta(String tipoConta, Cliente cliente) {
		if ("Corrente".equalsIgnoreCase(tipoConta)) {
			return new ContaCorrente(cliente);
		} else if ("Poupanca".equalsIgnoreCase(tipoConta)) {
			return new ContaPoupanca(cliente);
		} else if ("Investimento".equalsIgnoreCase(tipoConta)) {
			return new ContaInvestimento(cliente);
		}
		throw new IllegalArgumentException("Tipo de conta inválido: " + tipoConta);
	}
}