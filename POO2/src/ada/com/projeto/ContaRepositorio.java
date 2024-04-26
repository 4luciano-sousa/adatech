package ada.com.projeto;

import java.util.List;

public class ContaRepositorio {

	void atualizar(Conta conta);

	List<Conta> buscarCliente(String id);

	Conta buscarPorNumero(String numero);

	void salvar(Conta conta);
}