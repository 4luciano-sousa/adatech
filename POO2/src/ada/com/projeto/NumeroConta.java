package ada.com.projeto;

public class NumeroConta implements IdentificadorConta {

	private String valor;

	public NumeroConta(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public boolean validar() {
		// aqui falta lógica de validação do número da conta
		return true;
	}
}