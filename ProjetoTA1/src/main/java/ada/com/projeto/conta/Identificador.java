package ada.com.projeto.conta;

public interface Identificador<T> {
	T getValor();

	void validar();
}