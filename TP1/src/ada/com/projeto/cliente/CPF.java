package ada.com.projeto.cliente;

public class CPF implements Identificador<String> {
	private String valor;

	public CPF(String valor) {
		this.valor = valor;
		validar();
	}

	@Override
	public String getValor() {
		return valor;
	}

	@Override
	public void validar() {
		// Validação de CPF do cliente
		if (!valor.matches("\\d{11}")) {
			throw new IllegalArgumentException("CPF inválido");
		}
	}
}