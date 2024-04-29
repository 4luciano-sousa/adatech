package ada.com.projeto;

import java.util.*;

public class ContaRepositorioImpl implements ContaRepositorio {

	// Implementação dos métodos da interface
	private Map<IdentificadorConta, Conta> contas;

	public ContaRepositorioImpl() {
		this.contas = new HashMap<>();
	}

	@Override
	public void salvar(Conta conta) {
		contas.put(conta.getNumero(), conta);
	}

	@Override
	public void atualizar(Conta conta) {
		contas.put(conta.getNumero(), conta);
	}

	@Override
	public List<Conta> buscarPorCliente(Cliente cliente) {
		List<Conta> contasCliente = new ArrayList<>();
		for (Conta conta : contas.values()) {
			if (conta.getCliente().equals(cliente)) {
				contasCliente.add(conta);
			}
		}
		return contasCliente;
	}

	@Override
	public Conta buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return null;
	}
}
