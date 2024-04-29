package ada.com.projeto;

import java.util.List;

interface ContaRepositorio {

	void salvar(Conta conta);

	void atualizar(Conta conta);

	Conta buscarPorNumero(String numero);

	List<Conta> buscarPorCliente(Cliente cliente);
}