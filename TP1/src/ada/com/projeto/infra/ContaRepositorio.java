package ada.com.projeto.infra;

import ada.com.projeto.conta.Conta;
import java.util.List;

public interface ContaRepositorio {
	void atualizar(Conta conta);

	List<Conta> buscarCliente(String identificador);

	Conta buscarPorNumero(String numero);

	void salvar(Conta conta);
}