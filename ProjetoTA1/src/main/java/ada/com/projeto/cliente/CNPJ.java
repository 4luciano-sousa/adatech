package ada.com.projeto.cliente;

public class CNPJ implements Identificador<String> {
	private String valor;

	public CNPJ(String valor) {
		this.valor = valor;
		validar();
	}

	@Override
	public String getValor() {
		return valor;
	}

	@Override
	public void validar() {
		// Validação de CNPJ
		if (!valor.matches("\\d{14}")) {
			throw new IllegalArgumentException("CNPJ inválido");
		}
	}
}