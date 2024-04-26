package ada.com.projeto;

public class CPF implements Identificador {

	private String valor;

	public CPF(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public boolean validar() {
		// falta lógica de validação do CPF
		return true;
	}
}