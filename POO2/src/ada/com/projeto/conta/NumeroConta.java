package ada.com.projeto.conta;

import java.util.UUID;

public class NumeroConta implements Identificador<String> {
	private String numero;

	public NumeroConta() {
		this.numero = UUID.randomUUID().toString();
	}

	@Override
	public String getValor() {
		return numero;
	}

	@Override
	public void validar() {
		if (numero == null || numero.isEmpty()) {
			throw new IllegalArgumentException("Número da conta inválido");
		}
	}
}