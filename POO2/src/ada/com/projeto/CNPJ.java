package ada.com.projeto;

public class CNPJ implements Identificador {

	private String valor;

	public CNPJ(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public boolean validar() {
		// falta lógica de validação do CNPJ
		return true;
	}
}